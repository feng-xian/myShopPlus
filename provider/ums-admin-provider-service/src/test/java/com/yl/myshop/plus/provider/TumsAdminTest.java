package com.yl.myshop.plus.provider;

import com.yl.myshop.plus.provider.entity.TUmsAdmin;
import com.yl.myshop.plus.provider.mapper.TUmsAdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author : 凤仙
 * @Date : 2021/5/3 11:21
 * @Version : 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TumsAdminTest {

    @Autowired
    private TUmsAdminMapper tUmsAdminMapper;

    @Test
    public void testDBlink(){
       List<TUmsAdmin> list = tUmsAdminMapper.selectAll();
        for (TUmsAdmin ta : list) {
            System.out.println(ta);
        }
    }

    public void testInsert(){
        TUmsAdmin admin = new TUmsAdmin();
        admin.setAddress("");

    }

}
