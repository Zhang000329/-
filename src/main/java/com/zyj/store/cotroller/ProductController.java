package com.zyj.store.cotroller;

import com.zyj.store.entity.Product;
import com.zyj.store.service.IProductService;
import com.zyj.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController{
    @Autowired
    private IProductService productService;
    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList(){
        List<Product> list = productService.findHotList();
        return new JsonResult<>(OK, list);
    }
    @GetMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id){
        Product product = productService.findById(id);
        return new JsonResult<>(OK, product);
    }
}
