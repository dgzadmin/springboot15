package com.dgz.springboot15.controller;


import com.dgz.springboot15.entity.Customer;
import com.dgz.springboot15.service.ICustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 李大狗
 * @since 2020-04-09
 */
@RestController
@Api(tags = "客户相关接口")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/customer/{customerId}")
    @ApiOperation("根据id查询客户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "客户id", required = true),
    })
    public Map<String,Object> queryCustomer(@PathVariable Integer customerId){
        Map<String,Object> map=new HashMap<>();
        Customer customer = iCustomerService.queryCustomer(customerId);
        map.put("code",0);
        map.put("data",customer==null?"":customer);
        return map;
    }


    @PutMapping("/customer")
    @ApiOperation("添加一个客户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerName", value = "客户名", required = true),
            @ApiImplicitParam(name = "customerSex", value = "客户性别", required = true),
            @ApiImplicitParam(name = "customerAge", value = "客户年龄", required = true),
            @ApiImplicitParam(name = "customerPhone", value = "客户手机号", required = true),
            @ApiImplicitParam(name = "customerCompany", value = "客户公司", required = true),
            @ApiImplicitParam(name = "customerAddress", value = "客户公司地址", required = true)
    })
     public Map<String,Object> addCustomer(Customer customer){
        Map<String,Object> map=new HashMap<>();
        Integer result = iCustomerService.addCustomer(customer);
        if (result>0){
            map.put("code",0);
            map.put("msg","success");
            map.put("data",customer);
        }else {
            map.put("code",100);
            map.put("msg","defeated");
            map.put("data","");
        }
        return map;
    }



    @DeleteMapping("/customer/{customerId}")
    @ApiOperation("根据id删除客户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "客户id", required = true)
    })
     public Map<String,Object> delCustomer(@PathVariable Integer customerId){
        Map<String,Object> map=new HashMap<>();
        Customer customer = new Customer();
        customer.setCustomerId(customerId).setIsDel(1);
        Customer result = iCustomerService.delCustomer(customer);
        if (result!=null){
            map.put("code",0);
            map.put("msg","success");
        }else {
            map.put("code",100);
            map.put("msg","defeated");
        }
        return map;
    }

    @PostMapping("/customer")
    @ApiOperation("根据id修改客户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "客户id", required = true),
            @ApiImplicitParam(name = "customerName", value = "客户名", required = true),
            @ApiImplicitParam(name = "customerSex", value = "客户性别", required = true),
            @ApiImplicitParam(name = "customerAge", value = "客户年龄", required = true),
            @ApiImplicitParam(name = "customerPhone", value = "客户手机号", required = true),
            @ApiImplicitParam(name = "customerCompany", value = "客户公司", required = true),
            @ApiImplicitParam(name = "customerAddress", value = "客户公司地址", required = true),
    })
     public Map<String,Object> updCustomer(Customer customer){
        Map<String,Object> map=new HashMap<>();
        Customer result = iCustomerService.updCustomer(customer);
        if (result!=null){
            map.put("code",0);
            map.put("msg","success");
            map.put("data",customer);
        }else {
            map.put("code",100);
            map.put("msg","defeated");
            map.put("data","");
        }
        return map;
    }




}
