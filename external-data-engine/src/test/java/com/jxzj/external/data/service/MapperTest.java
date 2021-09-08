package com.jxzj.external.data.service;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jxzj.external.data.dao.DadaCompanyMapper;

@SpringBootTest
public class MapperTest {

    @Autowired
    private DadaCompanyMapper dadaCompanyMapper;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testName() {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // List<DadaCompany> selectList = dadaCompanyMapper.selectList(null);
        // if (selectList.isEmpty()) {
        // for (DadaCompany dadaCompany : selectList) {
        // System.out.println(dadaCompany);
        // }
        // } else {
        // System.out.println("数据为空");
        // }
    }

}
