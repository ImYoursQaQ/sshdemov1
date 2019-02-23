package org.ssh.product.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface SafeUtil {

    boolean iscorrect(String str);
    boolean isPureDigital(String string);
    String strToMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException;
     boolean HasDigit(String content);
     int firstDigitalStrToInt(String str);
}
