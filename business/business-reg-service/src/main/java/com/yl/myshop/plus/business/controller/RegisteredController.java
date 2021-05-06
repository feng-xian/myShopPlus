package com.yl.myshop.plus.business.controller;

import com.yl.myshop.plus.commons.dto.ResponseResult;
import com.yl.myshop.plus.provider.api.UmsAdminService;
import com.yl.myshop.plus.provider.entity.TUmsAdmin;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : 凤仙
 * @Date : 2021/5/3 13:40
 * @Version : 1.0
 */
@RestController
@RequestMapping(value = "reg")
public class RegisteredController {

    @DubboReference
    private UmsAdminService umsAdminService;

    /**
     * 测试接口
     * @param str
     * @return
     */
    @GetMapping("/say")
    public String testController(String str){
        String say = umsAdminService.helloTest(str);
        return say;
    }


    /**
     * 用户注册
     * @param tUmsAdmin {@link TUmsAdmin}
     * @return {@link ResponseResult}
     */
    @PostMapping("/register")
    public ResponseResult<TUmsAdmin> registerAdmin(@RequestBody TUmsAdmin tUmsAdmin){
        String message = verificationAdmin(tUmsAdmin);
        if (null == message){
            int row = umsAdminService.registeredUmsAdmin(tUmsAdmin);
            if (row == 1){
                TUmsAdmin admin = umsAdminService.getAdmin(tUmsAdmin.getUsername());
                return new ResponseResult<TUmsAdmin>(HttpStatus.SC_OK,"注册成功！",admin);
            }
            message = "用户注册失败!";
        }
        return new ResponseResult<TUmsAdmin>(HttpStatus.SC_METHOD_NOT_ALLOWED, message);
    }

    public String verificationAdmin(TUmsAdmin tUmsAdmin){

        if (null ==  tUmsAdmin){
            return "用户信息不能为空！";
        }
        String username = tUmsAdmin.getUsername();
        if (null == username){
            return "用户不能为空！";
        }
        TUmsAdmin admin = umsAdminService.getAdmin(username);
        if (null != admin){
            return "该用户名已存在，请重新输入用户名!";
        }
        return null;
    }

}
