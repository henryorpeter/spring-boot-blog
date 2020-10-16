package com.yjj.blog.uilt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: JKing
 * \* Date: 2020/10/16
 * \* Time: 20:08
 * \
 */
public class MD5Utils {
    public static String md5(String buffer)
    {
        String string       = null;
        char hexDigist[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(buffer.getBytes());
            byte[] datas = md.digest(); //16个字节的长整数

            char[] str = new char[2*16];
            int k = 0;

            for(int i=0;i<16;i++)
            {
                byte b   = datas[i];
                str[k++] = hexDigist[b>>>4 & 0xf];//高4位
                str[k++] = hexDigist[b & 0xf];//低4位
            }
            string = new String(str);
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return string;
    }
    public static void main(String[] args){
        System.out.println(md5("123456789"));
    }
}