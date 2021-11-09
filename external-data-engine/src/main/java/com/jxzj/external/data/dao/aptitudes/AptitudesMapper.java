package com.jxzj.external.data.dao.aptitudes;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jxzj.external.data.entity.aptitudes.Aptitudes;

public interface AptitudesMapper {

    List<Aptitudes> selectList(@Param("ids") List<String> ids);

    Aptitudes selectOneById(String id);

    int insert(@Param("aptitudesList") List<Aptitudes> aptitudesList);

    int updateById(String id);
}
