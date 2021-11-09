package com.jxzj.external.data.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jxzj.external.data.dao.dada.DadaCompanyMapper;
import com.jxzj.external.data.dao.users.UsersMapper;
import com.jxzj.external.data.entity.datacenter.DadaCompany;
import com.jxzj.external.data.entity.users.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private DadaCompanyMapper dadaCompanyMapper;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void usersText() throws Exception {

        // List<Long> ids = new ArrayList<Long>();
        // for (int i = 0; i < 50; i++) {
        // ids.add((long)i);
        // }
        List<Users> selectList = usersMapper.selectList(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        selectList.stream().forEach(e -> System.out.println(e.toString()));

    }

    @Test
    public void dataSourceTest() throws Exception {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testMybatis() {

        List<DadaCompany> selectList =
            dadaCompanyMapper.selectList(new LambdaQueryWrapper<DadaCompany>().like(DadaCompany::getCompanyName, "阿坝"));
        for (DadaCompany dadaCompany : selectList) {
            System.out.println(dadaCompany);
        }
    }

    @Test
    public void testName() {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<DadaCompany> selectList = dadaCompanyMapper.selectList(null);
        if (CollectionUtils.isNotEmpty(selectList)) {
            for (DadaCompany dadaCompany : selectList) {
                System.out.println(dadaCompany);
            }
        } else {
            System.out.println("数据为空");
        }
    }

}
