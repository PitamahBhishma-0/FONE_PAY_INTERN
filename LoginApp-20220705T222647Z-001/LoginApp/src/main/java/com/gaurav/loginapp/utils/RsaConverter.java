package com.gaurav.loginapp.utils;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;
@Component
public class RsaConverter {
    private PrivateKey privateKey;
    private PublicKey publicKey;
    public RsaConverter(){
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            privateKey=keyPair.getPrivate();
            publicKey=keyPair.getPublic();
        }
        catch (Exception ignored){

        }

    }
    public String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }
    public byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }

    public  String  encrypt(String message) throws Exception{
        byte [] messageToBytes=message.getBytes();
        Cipher cipher= Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte [] encryptedByte=cipher.doFinal(messageToBytes);
        return encode(encryptedByte);
    }
    public String decrypt(String encryptedMessage) throws Exception{
        byte[] encryptedByte =decode(encryptedMessage);
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedMessage=cipher.doFinal(encryptedByte);
        return  new String(decryptedMessage,"UTF8");

    }
}
