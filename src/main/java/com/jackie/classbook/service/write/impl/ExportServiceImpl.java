package com.jackie.classbook.service.write.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.common.TeacherTypeEnum;
import com.jackie.classbook.dao.ClassDao;
import com.jackie.classbook.dao.MateClassMapperDao;
import com.jackie.classbook.dao.TeacherClassMapperDao;
import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.response.ClassExportRespDTO;
import com.jackie.classbook.dto.response.ExportRespDTO;
import com.jackie.classbook.entity.Class;
import com.jackie.classbook.entity.MateClassMapper;
import com.jackie.classbook.entity.TeacherClassMapper;
import com.jackie.classbook.entity.module.MateClassMapperFactory;
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
}
