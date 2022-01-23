package com.zyj.store.mapper;

import com.zyj.store.entity.District;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DistrictMapper {
    /**
     * 根据父代号查询区域信息
     * @param parent
     * @return
     */
    List<District> findByParent(String parent);
    String findNameByCode(String code);
}
