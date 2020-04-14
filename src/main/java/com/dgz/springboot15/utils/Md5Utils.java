package com.dgz.springboot15.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class Md5Utils {

     /**
     * 根据用户名，密码，盐 去加密
     */
    public static String encryptPassword(String username, String password, String salt){
       return new SimpleHash("md5",username+password,salt,24).toHex().toString();
    }

    /**
     * 生成随机盐  (插入记录的时候，可以调用)
     */
    public static String randomSalt(){
        // 一个Byte占两个字节，此处生成的6字节，字符串长度为12
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(6).toHex();
        return hex;
    }

}
