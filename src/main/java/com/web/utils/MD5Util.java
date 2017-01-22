package com.web.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * @Date Created on 2017/1/6.
 * @Author SongJiuHua.
 * @description
 */
public class MD5Util {

    private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);
    /**
     * 生成MD5
     * @param target
     * @return
     * @throws Exception
     */
    public static String getMD5String(String target){
        String md5String = "";
        try {
            //1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //2 将消息变成byte数组
            byte[] targetBytes = target.getBytes();
            //3 计算后获得字节数组,这就是那128位了
            byte[] buff = messageDigest.digest(targetBytes);
            md5String = bytesToHex(buff);
        } catch (Exception e) {
            logger.error("md5密码加密错误", e);
        }
        return md5String;
    }

    /**
     * 二进制转十六进制
     * @param bytes
     * @return
     */
    private static String bytesToHex(byte[] bytes){
        StringBuffer md5Str = new StringBuffer();
        int digital;
        for (int i = 0; i < bytes.length; i++){
            digital = bytes[i];
            if(digital < 0){
                digital += 256;
            }
            if(digital < 16){
                md5Str.append("0");
            }
            md5Str.append(Integer.toHexString(digital));
        }
        return md5Str.toString().toUpperCase();
    }




}
