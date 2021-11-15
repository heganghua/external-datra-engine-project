package com.jxzj.external.data.dao.users;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxzj.external.data.dto.StudentCourse;
import com.jxzj.external.data.entity.users.Users;

public interface UsersMapper extends BaseMapper<Users> {

    List<Users> selectList(@Param("ids") List<Long> ids);

    Users selectOneById(Long id);

    int insert(List<Users> usersList);

    int updateById(Long id);

    List<StudentCourse> selectListStudentCourse(@Param("userId") Long userId);

}
