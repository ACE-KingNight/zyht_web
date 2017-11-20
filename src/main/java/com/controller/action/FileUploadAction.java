package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-10-09 14:51
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseAction;
import com.domain.*;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FileService;
import com.service.FileServiceImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.File;

/**
 * @author wangzhenxin
 * @ClassName FileUploadAction
 * @Description 类描述
 * @date 2017-10-09
 */
@Action

@Results({
//        @Result(name = "testupload", location = "/page/work_10_09/testupload.jsp")
})
public class FileUploadAction extends BaseAction{

    private File file;
    private String fileFileName;
    private String fileContentType;
    private String imageId;


    @Resource
    private FileService fileService;



    public void upLoad(){
        //输出文件
        String filePath = "E:"+File.separator+"FileDownload"+File.separator+fileFileName;
        File fileOut=new File(filePath);
        com.domain.File fileInformation = new com.domain.File();
        fileInformation.setFileName(fileFileName);
        fileInformation.setFileLength(String.valueOf(file.length()));
        fileInformation.setFileType(fileContentType);
        fileInformation.setFilePath("E://FileDownload//"+fileFileName);

        fileService.insertFile(fileInformation);
        //判断输出文件是否存在
        if (!fileOut.exists()){
            try {
                fileOut.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //输入流
        InputStream inputStream=null;
        //输入缓冲流
        BufferedInputStream bufferedInputStream=null;
        //输出流
        OutputStream outputStream=null;
        //输出缓冲流
        BufferedOutputStream bufferedOutputStream=null;
        try {
            //设置输入流
            inputStream=new FileInputStream(file);
            //创建输入缓冲流
            bufferedInputStream=new BufferedInputStream(inputStream);
//            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"gbk");
//            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            //设置输出流
            outputStream=new FileOutputStream(fileOut);
            //设置输出缓冲流
            bufferedOutputStream=new BufferedOutputStream(outputStream);

            byte[] bytes=new byte[1024];
            int length=-1;
            while ((length=bufferedInputStream.read(bytes,0,bytes.length))!=-1){
                bufferedOutputStream.write(bytes,0,length);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                bufferedOutputStream.flush();
                inputStream.close();
                bufferedInputStream.close();
                outputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        return "testupload";
    }

    public void downLoad(){
        com.domain.File fileInformation = new com.domain.File();


        fileInformation = fileService.findFile(Long.valueOf(imageId));
        String filePath = fileInformation.getFilePath();
//        System.out.println(filePath);
        File fileOut=new File(filePath);
        byte[] fileByteOut = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream =null;
        try {
            inputStream = new FileInputStream(fileOut);
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] fileDown = new byte[1024];
            int length=-1;
            while ((length=inputStream.read(fileDown,0,fileDown.length))!= -1){
                byteArrayOutputStream.write(fileDown);
            }
            fileByteOut = byteArrayOutputStream.toByteArray();
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileOut.getName().getBytes("gb2312"), "iso-8859-1"));
            response.getOutputStream().write(fileByteOut);
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

}
