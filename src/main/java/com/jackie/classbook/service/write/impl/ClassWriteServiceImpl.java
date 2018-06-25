package com.jackie.classbook.service.write.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dao.ClassDao;
import com.jackie.classbook.dto.request.ClassAddReqDTO;
import com.jackie.classbook.entity.Class;
import com.jackie.classbook.process.AbstractService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.write.ClassWriteService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
@Service
public class ClassWriteServiceImpl extends AbstractService implements ClassWriteService{

    @Autowired
    private ClassDao classDao;

    @Override
    public Context<ClassAddReqDTO, Void> insert(ClassAddReqDTO reqDTO) {
        Context<ClassAddReqDTO, Void> context = new Context<>();
        Class clazz = JSON.parseObject(JSON.toJSONString(reqDTO), Class.class);
        clazz.setValidFlag((byte)1);
        classDao.insert(clazz);
        return context;
    }
}
