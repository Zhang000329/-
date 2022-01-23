package com.zyj.store.service;

import com.zyj.store.entity.District;

import java.util.List;

public interface IDistrictService {
    List<District> getByParent(String parent);
    String getNameByCode(String code);

}
