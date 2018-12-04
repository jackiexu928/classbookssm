package com.jackie.classbook.service.write.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.common.TeacherTypeEnum;
import com.jackie.classbook.dao.*;
import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.request.MateExportReqDTO;
import com.jackie.classbook.dto.response.ClassExportRespDTO;
import com.jackie.classbook.dto.response.ExportRespDTO;
import com.jackie.classbook.dto.response.MateExportRespDTO;
import com.jackie.classbook.dto.response.SchoolExportRespDTO;
import com.jackie.classbook.entity.*;
import com.jackie.classbook.entity.Class;
import com.jackie.classbook.entity.module.MateClassMapperFactory;
import com.jackie.classbook.entity.module.MateFactory;
import com.jackie.classbook.entity.module.SchoolFactory;
import com.jackie.classbook.process.AbstractService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.write.ExportService;
import com.jackie.classbook.util.ExcelUtil;
import com.jackie.classbook.util.ExportContentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/3
 */
@Service
public class ExportServiceImpl extends AbstractService implements ExportService {
    @Autowired
    private MateClassMapperDao mateClassMapperDao;
    @Autowired
    private TeacherClassMapperDao teacherClassMapperDao;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private MateDao mateDao;
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public Context<BaseIdReqDTO, Void> exportClass(BaseIdReqDTO reqDTO) {
        MateClassMapper mateClassMapper = new MateClassMapper();
        mateClassMapper.setAccountId(reqDTO.getId());
        List<MateClassMapper> list = mateClassMapperDao.queryClassListByAccountId(mateClassMapper);
        if (list == null){
            throw new ClassbookException(ClassbookCodeEnum.NO_RECORD);
        }
        Map<String, String> map = new HashMap<>();
        for (MateClassMapper clazz : list){
            Class c = classDao.queryById(clazz.getClassId());
            map.put(clazz.getClassId() + "", c.getYear() + "");
            TeacherClassMapper teacherClassMapper = new TeacherClassMapper();
            teacherClassMapper.setClassId(clazz.getClassId());
            teacherClassMapper.setTeacherType(TeacherTypeEnum.CLASSTEACHER.getKey());//班主任
            List<TeacherClassMapper> classTeacher = teacherClassMapperDao.queryListByClassIdAndType(teacherClassMapper);
            teacherClassMapper.setTeacherType(TeacherTypeEnum.SUBJECTSTEACHER.getKey());//任课老师
            List<TeacherClassMapper> subjectTeacher = teacherClassMapperDao.queryListByClassIdAndType(teacherClassMapper);
            if (classTeacher != null && classTeacher.size() > 0){
                map.put(clazz.getClassId() + "-classTeacher", classTeacher.get(0).getTeacherName());
            }
            if (subjectTeacher != null && subjectTeacher.size() > 0){
                String subTeacher = null;
                for (int i = 0; i < subjectTeacher.size(); i ++){
                    if (i > 0){
                        subTeacher += ",";
                    }
                    subTeacher += subjectTeacher.get(i).getTeacherName();
                }
                map.put(clazz.getClassId() + "-subjectTeacher", subTeacher);
            }
        }
        List<ClassExportRespDTO> exportList = MateClassMapperFactory.getClassExportRespDTO(list, map);
        Context<BaseIdReqDTO, Void> context = new Context<>();
        String[] title= {"序号","校名","届","班级","班主任","任课老师"};
        ExportRespDTO exportRespDTO = new ExportRespDTO();
        exportRespDTO.setFileName("班级信息");
        exportRespDTO.setTitle(title);
        exportRespDTO.setContent(ExportContentUtil.getContetn(exportList, title.length));
        try {
            ExcelUtil.export(exportRespDTO);
        } catch (Exception e){
            throw new ClassbookException("", e.getMessage());
        }
        return context;
    }

    @Override
    public Context<MateExportReqDTO, Void> exportMate(MateExportReqDTO reqDTO) {
        MateClassMapper mateClassMapper = new MateClassMapper();
        mateClassMapper.setAccountId(reqDTO.getAccountId());
        mateClassMapper.setSchoolId(reqDTO.getSchoolId());
        mateClassMapper.setClassId(reqDTO.getClassId());
        List<MateClassMapper> list = mateClassMapperDao.queryListByAccountIdAndSchoolIdClassId(mateClassMapper);
        if (list == null){
            throw new ClassbookException(ClassbookCodeEnum.NO_RECORD);
        }
        List<Long> idList = new ArrayList<>();
        for (MateClassMapper mate : list){
            idList.add(mate.getMateId());
        }
        List<Mate> mateList = mateDao.queryMatesByIdList(idList);
        Map<Long, Mate> mateMap = new HashMap<>();
        if (mateList != null && mateList.size() > 0){
            for (Mate mate : mateList){
                mateMap.put(mate.getId(), mate);
            }
        }
        List<MateExportRespDTO> exportList = MateFactory.getMateExportRespDTO(list, mateMap);
        Context<MateExportReqDTO, Void> context = new Context<>();
        String fileName = "";
        if (reqDTO.getSchoolId() != null){
            School school = schoolDao.querySchoolById(reqDTO.getSchoolId());
            if (school == null){
                throw new ClassbookException(ClassbookCodeEnum.NO_RECORD);
            }
            fileName += school.getSchoolName();
        }
        if (reqDTO.getClassId() != null){
            Class clazz = classDao.queryById(reqDTO.getClassId());
            if (clazz == null){
                throw new ClassbookException(ClassbookCodeEnum.NO_RECORD);
            }
            fileName += clazz.getClassName();
        }
        String[] title= {"序号","校名","班级","姓名","类型","手机","QQ","邮箱","民族","年龄","性别","省","城市",
                "县/区","镇/街道","村","居住城市","印象"};
        ExportRespDTO exportRespDTO = new ExportRespDTO();
        exportRespDTO.setFileName(fileName + "同学信息");
        exportRespDTO.setTitle(title);
        exportRespDTO.setContent(ExportContentUtil.getContetn(exportList, title.length));
        try {
            ExcelUtil.export(exportRespDTO);
        } catch (Exception e){
            throw new ClassbookException("", e.getMessage());
        }
        return context;
    }

    @Override
    public Context<BaseIdReqDTO, Void> exportSchool(BaseIdReqDTO reqDTO) {
        MateClassMapper mateClassMapper = new MateClassMapper();
        mateClassMapper.setAccountId(reqDTO.getId());
        List<MateClassMapper> list = mateClassMapperDao.querySchoolListByAccountId(mateClassMapper);
        if (list == null){
            throw new ClassbookException(ClassbookCodeEnum.NO_RECORD);
        }
        List<Long> idList = new ArrayList<>();
        for (MateClassMapper mate : list){
            idList.add(mate.getSchoolId());
        }
        List<School> schoolList = schoolDao.querySchoolByIdList(idList);
        List<SchoolExportRespDTO> exportList = SchoolFactory.getSchoolExportRespDTO(schoolList);
        Context<BaseIdReqDTO, Void> context = new Context<>();
        String[] title= {"序号","校名","类型","省","城市","县/区","校训"};
        ExportRespDTO exportRespDTO = new ExportRespDTO();
        exportRespDTO.setFileName("学校信息");
        exportRespDTO.setTitle(title);
        exportRespDTO.setContent(ExportContentUtil.getContetn(exportList, title.length));
        try {
            ExcelUtil.export(exportRespDTO);
        } catch (Exception e){
            throw new ClassbookException("", e.getMessage());
        }
        return context;
    }
}
