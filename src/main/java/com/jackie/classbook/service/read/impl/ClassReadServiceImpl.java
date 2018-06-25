package com.jackie.classbook.service.read.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dao.ClassDao;
import com.jackie.classbook.dto.request.ClassQueryReqDTO;
import com.jackie.classbook.dto.response.ClassRespDTO;
import com.jackie.classbook.entity.Class;
import com.jackie.classbook.entity.module.ClassFactory;
import com.jackie.classbook.process.AbstractQueryService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.read.ClassReadService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
@Service
public class ClassReadServiceImpl extends AbstractQueryService implements ClassReadService{

    @Autowired
    private ClassDao classDao;

    @Override
    public Context<ClassQueryReqDTO, List<ClassRespDTO>> getClasses(ClassQueryReqDTO reqDTO) {
        Class clazz = JSON.parseObject(JSON.toJSONString(reqDTO), Class.class);
        List<Class> list = classDao.getClasses(clazz);
        List<ClassRespDTO> resultList = ClassFactory.convertToDTO(list);
        Context<ClassQueryReqDTO, List<ClassRespDTO>> context = new Context<>();
        context.setResult(resultList);
        return context;
    }
}
