package com.gaurav.authserverspringio.Keys;

import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.stereotype.Component;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

@Component
public class KeyManager {

    public RSAKey rsaKey(){
        try{
            KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
             keyPairGenerator.initialize(2048);
             var kp=keyPairGenerator.generateKeyPair();
            RSAPublicKey rsaPublicKey= (RSAPublicKey) kp.getPublic();
            RSAPrivateKey rsaPrivateKey= (RSAPrivateKey) kp.getPrivate();


            return new RSAKey.Builder(rsaPublicKey).privateKey(rsaPrivateKey).keyID(UUID.
                    randomUUID().toString()).build();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException){
           noSuchAlgorithmException.printStackTrace();
        }
        throw  new RuntimeException(" :( ");
    }
}
