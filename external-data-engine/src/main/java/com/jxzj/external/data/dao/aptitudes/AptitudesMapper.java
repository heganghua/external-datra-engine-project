package com.jxzj.external.data.dao.aptitudes;

import java.util.List;

import com.jxzj.external.data.entity.aptitudes.Aptitudes;

public interface AptitudesMapper {
    List<Aptitudes> selectList(List<Long> ids);

    Aptitudes selectOneById(Long id);

    int insert(List<Aptitudes> AptitudesList);

    int updateById(Long id);
}
