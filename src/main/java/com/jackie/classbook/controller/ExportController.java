package com.jackie.classbook.controller;

import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.service.write.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/3
 */
@RestController
@RequestMapping("export")
public class ExportController extends BaseController {
    @Autowired
    private ExportService exportService;
    /**
     * 导出用户班级
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/class",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    public String Export(BaseIdReqDTO reqDTO){
        return toJSON(exportService.exportClass(reqDTO));
    }
}
