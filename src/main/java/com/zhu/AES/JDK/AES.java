package com.zhu.AES.JDK;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhugu
 * 2018/12/8 22:56
 */
public class AES {
    private static final String CHAR_ENCODING = "UTF-8";
    public static final String KEY = "zhu guolong!sdfgsdfgssdfg";

    /**
     * 生成key
     * @return
     */
    public static Key generatorKey(String key) {
        try {
            if (key.length() < 16) {
                throw new RuntimeException("Invalid AES key length! (must be 16 bytes)");
            } else {
                key = key.substring(0, 16);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CHAR_ENCODING), "AES");
            byte[] encoded = secretKeySpec.getEncoded();
            return new SecretKeySpec(encoded, "AES");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 加密
     * @param key 加密key
     * @param content 加密内容
     * @return
     */
    public static String encrypt(String key, String content) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, generatorKey(key));
            byte[] bytes = cipher.doFinal(content.getBytes());
            return Base64.encodeBase64String(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (BadPaddingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 揭秘
     * @param key 解密key
     * @param encrypt 解密内容（Base64编码的字符串）
     * @return
     */
    public static String decrypt(String key, String encrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, generatorKey(key));
            byte[] bytes = Base64.decodeBase64(encrypt);
            return new String(cipher.doFinal(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (BadPaddingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
