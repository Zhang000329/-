package com.zyj.store.cotroller;

import com.zyj.store.entity.District;
import com.zyj.store.service.IDistrictService;
import com.zyj.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("districts")
@RestController
public class DistrictController extends BaseController{
    @Autowired
    private IDistrictService districtService;
    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> list = districtService.getByParent(parent);
        return new JsonResult<>(OK, list);
    }
}