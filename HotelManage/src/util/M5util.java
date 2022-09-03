package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class M5util {

    public  static String md5(String plainText) throws NoSuchAlgorithmException {
        String result = "";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(plainText.getBytes());
        byte[] s= md.digest();
        for(int i=0; i<s.length; i++) {
            result += Integer.toHexString((0x000000FF & s[i])| 0xFFFFFF00).substring(6);
        }

        return result.toUpperCase();
    }
}
