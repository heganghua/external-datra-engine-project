package com.jxzj.external.data.aes;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.xerces.impl.dv.util.Base64;

public class GenKeyUtils {

    static final String ALGORITHM = "AES";

    /**
     * 生成密钥KEY
     * 
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static SecretKey generateKey() {
        // key生成器
        SecretKey generateKey = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom secureRandom = new SecureRandom();
            System.out.println(secureRandom);
            keyGenerator.init(secureRandom);
            generateKey = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generateKey;

    }

    public static void main(String[] args) {
        SecretKey generateKey = generateKey();
        
        byte[] decode = Base64.decode(generateKey.toString());
        String string = decode.toString();
        System.out.println(string);
        
        
        System.out.println(generateKey);
        System.out.println(generateKey.toString());;
    }

}
