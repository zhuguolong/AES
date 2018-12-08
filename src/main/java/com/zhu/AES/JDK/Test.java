package com.zhu.AES.JDK;

import static com.zhu.AES.JDK.AES.decrypt;
import static com.zhu.AES.JDK.AES.encrypt;

/**
 * @author zhugu
 * 2018/12/8 23:44
 */
public class Test {
    public static void main(String[] args) {
        String content = "hello world!";

        String encrypt = encrypt(AES.KEY, content);
        System.out.println("JDK AES ENCRYPT: " + encrypt);

        String decrypt = decrypt(AES.KEY, encrypt);
        System.out.println("JDK AES DECRYPT: " + decrypt);
    }
}
