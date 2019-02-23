package org.ssh.product.util.impl;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.ssh.product.util.uploadUtil;

import java.io.File;
import java.io.IOException;

@Service
public class UploadUtilImpl  implements uploadUtil {


    @Override
    public String picUpload(File upload,String uploadFileName) {
        try {
            String realPath1 = ServletActionContext.getServletContext().getRealPath("/image");
            String realPath = "F:\\ssh-master\\src\\main\\webapp\\image";
            System.out.println(realPath);
            String typeString = getExtension(uploadFileName);
            System.out.println(typeString);
            String newFileName = String.valueOf(System.currentTimeMillis())+"."+typeString;
            // 创建一个文件
            File diskFile = new File(realPath + File.separator
                    + newFileName);
            File diskFile1 = new File(realPath1 + File.separator
                    + newFileName);
            // 文件上传,使用FileUtils工具类
            FileUtils.copyFile(upload, diskFile);//上传项目路径
            FileUtils.copyFile(upload, diskFile1);//上传localhost 路径
            System.out.println("h1111");

            return newFileName;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return  "";
        }

    }

    public static String getExtension(String fileName){
        int lastIndexOfDot = fileName.lastIndexOf(".");
        if(lastIndexOfDot < 0){
            return "";//没有拓展名
        }
        String extension = fileName.substring(lastIndexOfDot+1);
        return extension;
    }
}
