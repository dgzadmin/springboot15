package com.dgz.springboot15.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dgz.springboot15.annotation.QueryCachePage;
import com.dgz.springboot15.entity.Customer;
import com.dgz.springboot15.mapper.CustomerMapper;
import com.dgz.springboot15.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dgz.springboot15.utils.DateTime;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 李大狗
 * @since 2020-04-09
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    /**
     * 根据id查询一个客户
     *
     * @param customerId
     * @return
     */
    @Override
    @Cacheable(cacheNames = {"cus"}, condition = "#customerId>0", unless = "#result==null")
    public Customer queryCustomer(Integer customerId) {
        return this.baseMapper.selectById(customerId);
    }

    /**
     * 增加客户
     *
     * @param customer
     * @return
     */
    @Override
    public Integer addCustomer(Customer customer) {
        customer.setCreateTime(DateTime.getDateTime());
        customer.setUpdateTime(DateTime.getDateTime());
        return this.baseMapper.insert(customer);
    }

    /**
     * 删除客户:isDel=1
     *
     * @param customer
     * @return
     */
    @Override
    @CacheEvict(cacheNames = {"cus"}, key = "#customer.customerId", condition = "#result != null ")
    public Customer delCustomer(Customer customer) {
        customer.setUpdateTime(DateTime.getDateTime());
        return this.baseMapper.updateById(customer) > 0 ? customer : null;
    }

    /**
     * 修改客户
     *
     * @param customer
     * @return
     */
    @Override
    @CachePut(cacheNames = {"cus"}, key = "#customer.customerId", unless = "#result == null ")
    public Customer updCustomer(Customer customer) {
        customer.setUpdateTime(DateTime.getDateTime());
        return this.baseMapper.updateById(customer) > 0 ? customer : null;
    }

    /**
     * 分页查询客户
     *
     * @param page
     * @return
     */
    @Override
    @QueryCachePage(key = "cus",clazz = Customer.class)  //注解传入缓存的开头key值,并且方法第一个参数必须为IPage
    public IPage<Customer> queryCustomers(IPage<Customer> page) {
        return this.baseMapper.selectPage(page, new QueryWrapper<Customer>().lambda().eq(Customer::getIsDel, 0));
    }


}
