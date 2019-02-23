package org.ssh.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.ssh.product.model.Poster;
import org.ssh.product.service.GoodsService;
import org.ssh.product.util.uploadUtil;

import java.io.File;
import java.io.IOException;
import java.util.Map;


@Controller
public class PosterAction extends ActionSupport {

    @Autowired
    private uploadUtil uploadUtil;
    @Autowired
    private GoodsService goodsService;

    private int posterGoodsid;

    public int getPosterGoodsid() {
        return posterGoodsid;
    }

    public void setPosterGoodsid(int posterGoodsid) {
        this.posterGoodsid = posterGoodsid;
    }

    private File upload;// 上传的文件
    private String uploadFileName;//上传的文件名陈
    private String uploadContentType;// 接收文件上传的MIME类型

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }




    public String changePoster(){
        Map session = ActionContext.getContext().getSession();
        Poster poster = (Poster) session.get("currentposter");
        int postid = poster.getIdposterTable();
        System.out.println();
        System.out.println(upload.toURI());
        if (upload != null) {
            String picname1 = uploadUtil.picUpload(upload,uploadFileName);
            if (picname1==""){
                System.out.println("海报1");
                return ERROR;
            }
            else{
                goodsService.changePoster(postid,posterGoodsid,picname1);
                System.out.println("海报2");
                return SUCCESS;
            }

        }
        else {
            System.out.println("海报3");
            return ERROR;
        }

    }
}
