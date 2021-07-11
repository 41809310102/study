package com.example.myblog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//md5加密工具
public class md5Util {
    public static String code(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigst = md.digest();
            int i;
            StringBuffer buffer = new StringBuffer("");
            for(int offest = 0;offest<byteDigst.length;offest++){
                i = byteDigst[offest];
                if(i<0)
                    i+=256;
                if(i<16)
                    buffer.append("0");
                    buffer.append(Integer.toHexString(i));
            }
            //32位加密
            return buffer.toString();
            //16位加密
            //return buffer.toString().subString(8,24);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(code("123456"));
    }
}
