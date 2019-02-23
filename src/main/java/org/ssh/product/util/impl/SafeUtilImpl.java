package org.ssh.product.util.impl;

import org.springframework.stereotype.Service;
import org.ssh.product.util.SafeUtil;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.*;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class SafeUtilImpl implements SafeUtil {
    private String CHECKSQL = "^(.+)\\sand\\s(.+)|(.+)\\sor(.+)\\s$";

   //输入校验
    @Override
    public boolean iscorrect(String str) {

        if ("".equals(str)||str.length()==0||str==null||str.indexOf("'") != -1) {
            return false;
        }
        else if(Pattern.matches(CHECKSQL,str)){
            return false;
        }
        else return true;
    }

    @Override
    public boolean isPureDigital(String string) {
        if (isBlank(string))
            return false;
        String regEx1 = "\\d+";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches())
            return true;
        else
            return false;
    }

    @Override
    //MD5加密实现
    public String strToMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5= MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        System.out.println(md5.digest(str.getBytes("utf-8")));
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
    @Override
    public boolean HasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public int firstDigitalStrToInt(String str) {
        char[] c=str.toCharArray();
        String newDigital = "";
        for (char c1 : c) {

            if (c1>='0'&&c1<='9'){
                newDigital=newDigital+c1;
            }

           else if (((c1>='a'&&c1<='z')   ||   (c1>='A'&&c1<='Z'))&&(newDigital.length()!=0)){
                    break;
            }
        }
        return Integer.parseInt(newDigital);
    }

}
