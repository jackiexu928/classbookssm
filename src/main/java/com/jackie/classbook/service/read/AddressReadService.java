package com.jackie.classbook.service.read;

import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.response.AddressRespDTO;
import com.jackie.classbook.process.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/21
 */
public interface AddressReadService {
    /**
     * 根据上级地址id查询下级地址列表
     * @param reqDTO
     * @return
     */
    Context<BaseIdReqDTO, List<AddressRespDTO>> getAddressListByParentId(BaseIdReqDTO reqDTO);
}
