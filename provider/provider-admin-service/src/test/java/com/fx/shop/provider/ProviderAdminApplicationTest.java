package com.fx.shop.provider;

import com.fx.shop.provider.api.UmsAdminService;
import com.fx.shop.provider.domain.UmsAdmin;
import com.fx.shop.provider.mapper.UmsAdminMapper;
import com.fx.shop.provider.service.EchoServiceImpl;
import jakarta.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProviderAdminApplicationTest {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private EchoServiceImpl echoServiceImpl;

    @Resource
    private UmsAdminService umsAdminService;

    @Test
    public void testSelectAll() {
        System.out.println("==========");
        echoServiceImpl.echo("");
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectAll();
        umsAdmins.forEach(umsAdmin -> {
            System.out.println(umsAdmin);
        });
    }

    @Test
    public void testInsertAdmin(){

        UmsAdmin umsAdmin = new UmsAdmin();

        umsAdmin.setId(12345l);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());
        umsAdmin.setNickName("fx");
        umsAdmin.setPassword("123456");

        int i = umsAdminService.insertUmsAdmin(umsAdmin);

        Assert.assertEquals(i, 1);

    }

}
