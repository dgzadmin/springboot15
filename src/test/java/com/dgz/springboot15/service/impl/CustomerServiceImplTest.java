package com.dgz.springboot15.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dgz.springboot15.entity.Customer;
import com.dgz.springboot15.service.ICustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

    @Autowired
    private ICustomerService iCustomerService;

    @Test
    public void queryCustomer() {
        System.out.println(iCustomerService.queryCustomer(1));
    }


    @Test
    public void queryCustomers() {
        IPage<Customer> customerIPage = iCustomerService.queryCustomers(new Page<Customer>().setCurrent(2).setSize(4));
        for (Customer record : customerIPage.getRecords()) {
            System.out.println(record);
        }
        System.out.println(customerIPage.getTotal());
    }
}