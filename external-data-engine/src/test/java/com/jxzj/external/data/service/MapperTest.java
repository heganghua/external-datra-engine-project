package com.jxzj.external.data.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxzj.external.data.dao.aptitudes.AptitudesMapper;
import com.jxzj.external.data.dao.dada.DadaCompanyMapper;
import com.jxzj.external.data.dao.users.UsersMapper;
import com.jxzj.external.data.dto.StudentCourse;
import com.jxzj.external.data.entity.aptitudes.Aptitudes;
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

    @Autowired
    private AptitudesMapper aptitudesMapper;

    @Test
    public void jointest() throws Exception {
        List<StudentCourse> selectListStudentCourse = usersMapper.selectListStudentCourse(2L);
        selectListStudentCourse.stream().forEach(System.out::println);
    }

    @Test
    public void pageTest() throws Exception {

        for (int i = 1; i < 4; i++) {
            Page<Users> page = new Page<>(i, 10);
            IPage<Users> selectPage = usersMapper.selectPage(page, null);
            // selectPage.getRecords().forEach(u -> System.out.println(u.toString()));
            selectPage.getRecords().forEach(System.out::println);
            System.out.println(selectPage.getPages());
            System.out.println(selectPage.getTotal());
            System.out.println("==========================");
        }

    }

    @Test
    public void insertTest() throws Exception {

        List<Aptitudes> arrayList = new ArrayList<Aptitudes>();

        for (int i = 0; i < 4; i++) {
            Aptitudes aptitudes = new Aptitudes();
            aptitudes.setId(String.valueOf(i));
            aptitudes.setCorpName("haha + " + String.valueOf(i));
            arrayList.add(aptitudes);
        }

        int insert = aptitudesMapper.insert(arrayList);
        System.out.println(insert);
    }

    @Test
    public void aptitudesTest() throws Exception {

        List<Aptitudes> selectList = aptitudesMapper
            .selectList(Arrays.asList("5dadcd6f90d5461fa2d2c37dcefe6426", "5dadcd6f90d5461fa2d2c37dcefe6426"));
        selectList.stream().forEach(a -> System.out.println(a.toString()));
    }

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
