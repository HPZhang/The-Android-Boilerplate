package com.orcanote.boilerplate.data.util;

import java.security.NoSuchAlgorithmException;

import se.simbio.encryption.Encryption;
import third.part.android.util.Base64;

public class StringEncryption {

    private StringEncryption() {
    }

    private static Encryption getEncryption() throws NoSuchAlgorithmException {
        return new Encryption.Builder()
            .setKeyLength(128)
            .setKeyAlgorithm("AES")
            .setKey("token")
            .setSalt("0674c9aa33675376506045de9332c971d5b5ec1a5d00e7ccbe6ef6e5132bec213022ac940e2f920c3235dc4ca04efebacf9ab302ab0b10ffd63b44d1692ad02f")
            .setIv(new byte[]{-1, -9, -8, -7, 1, 1, 2, 5, -1, -9, -8, -4, 0, 2, 1, 7})
            .setCharsetName("UTF8")
            .setIterationCount(10)
            .setDigestAlgorithm("SHA1")
            .setBase64Mode(Base64.DEFAULT)
            .setAlgorithm("AES/CBC/PKCS5Padding")
            .setSecureRandomAlgorithm("SHA1PRNG")
            .setSecretKeyType("PBKDF2WithHmacSHA1")
            .build();
    }

    public static String encrypt(String data) {
        try {
            return getEncryption().encryptOrNull(data);
        } catch (NoSuchAlgorithmException e) {
            return data;
        }
    }

    public static String decrypt(String data) {
        try {
            return getEncryption().decryptOrNull(data);
        } catch (NoSuchAlgorithmException e) {
            return data;
        }
    }
}
