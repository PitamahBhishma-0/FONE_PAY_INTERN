package com.gaurav.quoraapp.utils;

import com.gaurav.quoraapp.error.QuoraException;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


@Component
public class AES {
    private final String quAESSecretKey = "1234567890123456";

    public String encryptText(String algorithm, String inputString) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            SecretKey secretKey = this.convertKeyToSecretKey();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] cipherText = cipher.doFinal(inputString.getBytes());
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new QuoraException("Cant run AES");
        }
    }

    public String decryptText(String algorithm, String inputString) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            SecretKey secretKey = this.convertKeyToSecretKey();
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(inputString));
            return new String(plainText);
        } catch (Exception e) {
            throw new QuoraException("Cant run AES");
        }
    }

    private SecretKey convertKeyToSecretKey() {
        return new SecretKeySpec(this.quAESSecretKey.getBytes(), "AES");
    }
}
