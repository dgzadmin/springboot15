package com.dgz.springboot15.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dgz.springboot15.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 李大狗
 * @since 2020-04-09
 */
public interface ICustomerService extends IService<Customer> {

    Customer queryCustomer(Integer customerId);

    Integer addCustomer(Customer customer);

    Customer delCustomer(Customer customer);

    Customer updCustomer(Customer customer);

    IPage<Customer> queryCustomers(IPage<Customer> page);

}
