package com.jackie.classbook.util;


import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * 签名工具类
 */
public class SignUtil {


    public static void main(String[] args) throws Exception {
        String s1="123456";
        String s2=getMD5(s1);  //前端第一次加密，送上来的值
        System.out.println(s2);
        System.out.println(md5Encrypt(s2));  //后端再次加密后的值
    }

    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            String md5=new BigInteger(1, md.digest()).toString(16);
            //BigInteger会把0省略掉，需补全至32位
            return fillMD5(md5);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:"+e.getMessage(),e);
        }
    }

    public static String fillMD5(String md5){
        return md5.length()==32?md5:fillMD5("0"+md5);
    }

    /**
     * 将byte[]转为各种进制的字符串
     * @param bytes byte[]
     * @param radix 可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
     * @return 转换后的字符串
     */
    public static String binary(byte[] bytes, int radix){
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }

    /**
     * base 64 encode
     * @param bytes 待编码的byte[]
     * @return 编码后的base 64 code
     */
    public static String base64Encode(byte[] bytes){
        return new BASE64Encoder().encode(bytes);
    }

    /**
     * base 64 decode
     * @param base64Code 待解码的base 64 code
     * @return 解码后的byte[]
     * @throws Exception
     */
    public static byte[] base64Decode(String base64Code) throws Exception{
        return isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }

    /**
     * 获取byte[]的md5值
     * @param bytes byte[]
     * @return md5
     * @throws Exception
     */
    public static byte[] md5(byte[] bytes) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(bytes);

        return md.digest();
    }

    /**
     * 获取字符串md5值
     * @param msg
     * @return md5
     * @throws Exception
     */
    public static byte[] md5(String msg) throws Exception {
        return isEmpty(msg) ? null : md5(msg.getBytes());
    }

    /**
     * 结合base64实现md5加密
     * @param msg 待加密字符串
     * @return 获取md5后转为base64
     * @throws Exception
     */
    public static String md5Encrypt(String msg) throws Exception{
        return isEmpty(msg) ? null : base64Encode(md5(msg));
    }





    /**
     * AES加密
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     * @throws Exception
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey,String code) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");


        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(encryptKey.getBytes());
        kgen.init(128,random);


        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));

        return cipher.doFinal(content.getBytes(code));
    }

    /**
     * AES加密为base 64 code
     * @param content 待加密的内容
     *
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String aesEncrypt(String content, String code,String key) throws Exception {

        if(StringUtils.isEmpty(key)){
            return null;
        }


        if(StringUtils.isEmpty(code)){
            code="UTF-8";
        }

        return base64Encode(aesEncryptToBytes(content, key,code));
    }

    /**
     * AES解密
     * @param encryptBytes 待解密的byte[]
     * @param decryptKey 解密密钥
     * @return 解密后的String
     * @throws Exception
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey,String code) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");

        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(decryptKey.getBytes());



        //kgen.init(128, new SecureRandom(decryptKey.getBytes())); //  WINDOWS
        kgen.init(128,random);

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes,code);
    }

    /**
     * 将base 64 code AES解密
     * @param encryptStr 待解密的base 64 code
     * @return 解密后的string
     * @throws Exception
     */
    public static String aesDecrypt(String encryptStr,String code,String key) throws Exception {

        if(StringUtils.isEmpty(key)){
            return null;
        }


        if(StringUtils.isEmpty(code)){
            code="UTF-8";
        }

        return isEmpty(encryptStr)? null : aesDecryptByBytes(base64Decode(encryptStr), key,code);
    }

    private static boolean isEmpty(String encryptStr){
        return  encryptStr==null || "".equals(encryptStr);
    }
}
