package com.my.controller;

import com.my.Service.ResourceService;
import com.my.pojo.Resource;
import com.my.pojo.ResourcesClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 9:39 2019/3/7
 */
@RequestMapping(value = "/resource")
@RestController
public class ResourcesController {
    @Autowired
    private ResourceService resourceService;
    @RequestMapping(value = "/getclassresources",method = RequestMethod.POST)
    public List<Resource> getClassResources(@RequestParam(value = "cid")int cid){
        return resourceService.searchResources(cid);
    }
    @RequestMapping(value = "/getresourcebyid",method = RequestMethod.POST)
    public Resource getResourceById(@RequestParam(value = "rid")int rid){
        return resourceService.getResource(rid);
    }
    //todo 文件上传
    @RequestMapping(value = "/uploadfile",method = RequestMethod.POST)
    public boolean uploadFile(@RequestParam(value = "files",required=false)MultipartFile[] files,@RequestParam(value = "name",required=false)String name,
                              @RequestParam(value = "status",required=false)String status,@RequestParam(value = "cid",required=false)String cid){
        Resource resource=new Resource();
        resource.setName(name);
        resource.setStatus(status);
        try{
            for (MultipartFile file:files) {
                resourceService.uploadFile(Integer.valueOf(cid),resource,file);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //头像/班课cover上传/更新
    @RequestMapping(value = "/uploadpic",method = RequestMethod.POST)
    public boolean uploadpic(@RequestParam("file")MultipartFile file,@RequestParam("path")String path){
        resourceService.uploadpic(path ,file);

        return true;
    }

    @RequestMapping(value = "/createdefaultcover",method = RequestMethod.POST)
    public boolean createdefaultcover(@RequestParam("cid")String cid){
        createcover(cid);
        return true;
    }

    public void createcover(String cid){
        File originalFile = new File("C:\\resource\\img\\cover\\default.jpg");//指定要读取的图片
        try {
            File result = new File("C:\\resource\\img\\cover\\"+cid+".jpg");//要写入的图片
            if (result.exists()) {//校验该文件是否已存在
                result.delete();//删除对应的文件，从磁盘中删除
                result = new File("C:\\resource\\img\\cover\\"+cid+".jpg");//只是创建了一个File对象，并没有在磁盘下创建文件
            }
            if (!result.exists()) {//如果文件不存在
                result.createNewFile();//会在磁盘下创建文件，但此时大小为0K
            }
            FileInputStream in = new FileInputStream(originalFile);
            FileOutputStream out = new FileOutputStream(result);// 指定要写入的图片
            int n = 0;// 每次读取的字节长度
            byte[] bb = new byte[1024];// 存储每次读取的内容
            while ((n = in.read(bb)) != -1) {
                out.write(bb, 0, n);// 将读取的内容，写入到输出流当中
            }
            //执行完以上后，磁盘下的该文件才完整，大小是实际大小
            out.close();// 关闭输入输出流
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
