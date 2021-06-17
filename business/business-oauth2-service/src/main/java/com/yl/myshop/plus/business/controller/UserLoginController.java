package com.yl.myshop.plus.business.controller;

import com.yl.myshop.plus.business.entity.LoginParam;
import com.yl.myshop.plus.commons.dto.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : 凤仙
 * @Date : 2021/5/6 20:43
 * @Version : 1.0
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserLoginController {


    @PostMapping(value = "/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam){
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put("token","132456");
        return new ResponseResult<Map<String, Object>>(20000, HttpStatus.OK.toString(), map);
    }

}
