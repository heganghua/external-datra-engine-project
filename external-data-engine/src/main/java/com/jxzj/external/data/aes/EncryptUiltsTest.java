package com.jxzj.external.data.aes;

public class EncryptUiltsTest {
    public static void main(String[] args) {

        String key = "1715CA71396CEF1B8B0DC7C16F3521E2";

        String aeSencode = EncryptUtils.AESencode("Hello world!!!!!!!!!!!!!!!!@@@", key);
        System.out.println(aeSencode);
        System.out.println(EncryptUtils.AESdecode(aeSencode, key));

    }

}
