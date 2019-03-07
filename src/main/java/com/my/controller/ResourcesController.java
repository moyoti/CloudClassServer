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
    @RequestMapping(value = "uploadfile",method = RequestMethod.POST)
    public boolean uploadFile(@RequestParam("file")MultipartFile file,@RequestParam("name")String name,
                              @RequestParam("status")String status,@RequestParam("cid")int cid){
        Resource resource=new Resource();
        resource.setName(name);
        resource.setStatus(status);
        resourceService.uploadFile(cid,resource,file);
        return false;
    }
}
