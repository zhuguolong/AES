package com.zhu.AES.BC;

/**
 * @author zhugu
 * 2018/12/8 23:47
 *
 * 介于java不支持PKCS7Padding，只支持PKCS5Padding；但是PKCS7Padding
 * 和PKCS5Padding没有什么区别。要实现在java端用PKCS7Padding填充，需要
 * 用到bouncycastle组件来实现；所以需要一个jar 来支持。bcprov-jdk16-146.jar。
 * 引入依赖：
 * <dependency>
 *     <groupId>org.bouncycastle</groupId>
 *     <artifactId>bcprov-jdk16</artifactId>
 *     <version>1.46</version>
 * </dependency>
 */
public class AES {
    // 加密算法名称
    final String KEY_ALGORITHM = "AES";
    // 加密算法/模式/填充方式
    final String ALGORITHM_STR = "AES/CBC/PKCS7Padding";

}
