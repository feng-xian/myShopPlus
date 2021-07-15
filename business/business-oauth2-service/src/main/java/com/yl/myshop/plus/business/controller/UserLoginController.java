package com.yl.myshop.plus.business.controller;

import com.google.common.collect.Maps;
import com.yl.myshop.plus.business.entity.LoginParam;
import com.yl.myshop.plus.business.entity.UserInfo;
import com.yl.myshop.plus.commons.dto.ResponseResult;
import com.yl.myshop.plus.commons.utils.okhttp3.MapperUtils;
import com.yl.myshop.plus.commons.utils.okhttp3.OkHttpClientUtil;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author : 凤仙
 * @Date : 2021/5/6 20:43
 * @Version : 1.0
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserLoginController {

    private static final String URL = "http://localhost:9001/oauth/token";

    @Value("${business.oauth2.access_client_grant_type}")
    private String grant_type;

    @Value("${business.oauth2.access_client_client_id}")
    private String client_id;

    @Value("${business.oauth2.access_client_client_secret}")
    private String client_secret;

    @Resource(name = "userDetailsServiceBean")
    private UserDetailsService userDetailsService;

    @Resource(name = "passwordEncoder")
    private BCryptPasswordEncoder passwordEncoder;

    @Resource(name = "tokenStore")
    private TokenStore tokenStore;

    @PostMapping(value = "/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam){
        Map<String, Object> map = new HashMap<String, Object>(2);
        System.out.println("password-------------->"+loginParam.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (null == userDetails
           || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())){
            return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.FAIL, "账号或密码错误", null);
        }

        HashMap<String, String> hashMap = Maps.newHashMap();
        hashMap.put("username", loginParam.getUsername());
        hashMap.put("password", loginParam.getPassword());
        hashMap.put("grant_type", grant_type);
        hashMap.put("client_id", client_id);
        hashMap.put("client_secret", client_secret);
        Response response = OkHttpClientUtil.getInstance().postData(URL, hashMap);
        try {
            String resp = Objects.requireNonNull(response.body()).string();
            Map<String, Object> json2map = MapperUtils.json2map(resp);
            String accessToke = String.valueOf(json2map.get("access_token"));
            System.out.println("access toke is : " + accessToke);
            map.put("token", accessToke);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.OK, HttpStatus.OK.toString(), map);
    }

    /**
     * 获取用户基本信息
     * @return
     */
    @GetMapping("/info")
    public ResponseResult<UserInfo> info(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = new UserInfo().setName(authentication.getName())
                .setAvatar("https://tse1-mm.cn.bing.net/th/id/R-C.2200f336cb7cc8f21798e7d9fe9b24f5?rik=6HjanVulzGkvpA&riu=http%3a%2f%2fwww.desktx.com%2fd%2ffile%2fwallpaper%2fscenery%2f20170107%2f080145c3a7460e7fa0369052a11467db.jpg&ehk=ffhPqQk04pZ18gOXu3OrPfkEIoQW046d4EfbUzji9yI%3d&risl=&pid=ImgRaw");
        return new ResponseResult<UserInfo>(ResponseResult.CodeStatus.OK
                                            , "获取用户信息", userInfo);
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public ResponseResult<Void> logout(HttpServletRequest request){
        String access_token = request.getParameter("access_token");
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(access_token);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "用户注销", null);
    }

}
