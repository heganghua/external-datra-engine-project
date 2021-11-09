package com.jxzj.external.data.dao.users;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jxzj.external.data.entity.users.Users;

public interface UsersMapper {

    List<Users> selectList(@Param("ids") List<Long> ids);

    Users selectOneById(Long id);

    int insert(List<Users> usersList);

    int updateById(Long id);

}
