package com.fx.shop.provider.controller;

import com.fx.shop.commons.dto.ResponseResult;
import com.fx.shop.provider.api.UmsAdminService;
import com.fx.shop.provider.domain.UmsAdmin;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @DubboReference(version = "umsAdminImpl")
    public UmsAdminService umsAdminService;

    /**
     * 人员注册
     * @param umsAdmin
     * @return
     */
    @PostMapping("/register")
    public ResponseResult<UmsAdmin> registerUser(@RequestBody UmsAdmin umsAdmin){

        String errorMsg = validatedRegParam(umsAdmin);

        if (StringUtils.isEmpty(errorMsg)){
            int row = umsAdminService.insertUmsAdmin(umsAdmin);
            if (row > 0){
                return new ResponseResult<>(ResponseResult.CodeStatus.OK, "用户注册成功！", umsAdmin);
            }
        }

        return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, StringUtils.isEmpty(errorMsg) ? "用户注册失败！" : errorMsg);
    }

    private String validatedRegParam(UmsAdmin umsAdmin){

        UmsAdmin byUserName = umsAdminService.getByUserName(umsAdmin.getUsername());
        if (!Objects.isNull(byUserName)){
            return "用户名称重复！";
        }

        return null;
    }


}
