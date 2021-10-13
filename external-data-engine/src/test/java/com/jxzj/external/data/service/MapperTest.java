package com.jxzj.external.data.service;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jxzj.external.data.dao.DadaCompanyMapper;
import com.jxzj.external.data.entity.datacenter.DadaCompany;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private DadaCompanyMapper dadaCompanyMapper;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testMybatis() {

        List<DadaCompany> selectList =
            dadaCompanyMapper.selectList(new LambdaQueryWrapper<DadaCompany>().eq(DadaCompany::getCompanyName, "铁甲"));
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
