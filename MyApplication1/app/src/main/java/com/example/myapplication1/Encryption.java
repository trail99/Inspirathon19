package com.example.myapplication1;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encryption {
    static Cipher cipher;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws Exception {

        String Data="";
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        cipher = Cipher.getInstance("AES");

        String encryptedText = encrypt(Data, secretKey);
        String decryptedText = decrypt(encryptedText, secretKey);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String encrypt(String Data, SecretKey Key)throws Exception {

        byte[] Byte_Data = Data.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, Key);
        byte[] Enc_ByteData = cipher.doFinal(Byte_Data);
        Base64.Encoder encoder = Base64.getEncoder();
        String Enc_Data = encoder.encodeToString(Enc_ByteData);
        return Enc_Data;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String decrypt(String Enc_Data, SecretKey Key)throws Exception {

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] Enc_ByteData = decoder.decode(Enc_Data);
        cipher.init(Cipher.DECRYPT_MODE, Key);
        byte[] Dec_ByteData = cipher.doFinal(Enc_ByteData);
        String Dec_Data = new String(Dec_ByteData);
        return Dec_Data;
    }
}
