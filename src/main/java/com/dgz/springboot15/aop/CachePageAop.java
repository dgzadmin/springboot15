package com.dgz.springboot15.aop;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dgz.springboot15.annotation.QueryCachePage;
import com.dgz.springboot15.entity.Customer;
import com.dgz.springboot15.service.ICustomerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
public class CachePageAop {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ICustomerService iCustomerService;

    //切入点,拦截service层所有的方法
    @Pointcut(value = "within(com.dgz.springboot15.service.*.*)")
    public void CachePageAccess() {

    }


   /* @Around("CachePageAccess()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //返回的分页数据
        IPage result = new Page();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        //获取被拦截的方法
        Method method = signature.getMethod();
        //判断方法是否有@QueryCachePage注解
        if (method.isAnnotationPresent(QueryCachePage.class)) {
            //获取方法参数
            Object[] objects = pjp.getArgs();
            Page<Customer> page = (Page)objects[0];
            Long pageNum = page.getCurrent();  //获取当前页数
            Long limit = page.getSize();      //获取返回条数
            //获取缓存开头的的key
            String key = method.getAnnotation(QueryCachePage.class).key();
            //Class clazz = method.getAnnotation(QueryCachePage.class).clazz();
            *//*iCustomerService.list
            redisTemplate.opsForValue().get()*//*

            //当缓存中没有数据时,执行目标方法
            result = (IPage) pjp.proceed();



        }
        return result;
    }
*/




}
