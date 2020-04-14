package com.dgz.springboot15.service.impl;

import com.dgz.springboot15.entity.Orders;
import com.dgz.springboot15.mapper.OrdersMapper;
import com.dgz.springboot15.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李大狗
 * @since 2020-04-09
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
