package com.zyj.store.cotroller;

import com.zyj.store.entity.Order;
import com.zyj.store.service.IOrderService;
import com.zyj.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("orders")
public class OrderController extends BaseController{
    @Autowired
    private IOrderService orderService;
     @RequestMapping("create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session){
         Order data = orderService.create(aid, cids, getuidFromSession(session), getUsernameFromSession(session));
         return new JsonResult<>(OK, data);
     }
}
