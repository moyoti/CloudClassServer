package com.my.Service;

import com.my.dao.ResourceMapper;
import com.my.dao.ResourcesClassMapper;
import com.my.pojo.Resource;
import com.my.pojo.ResourcesClass;
import com.my.pojo.ResourcesClassExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 9:33 2019/3/7
 */
@Service
@MapperScan("com.my.dao")
public class ResourcesServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourcesClassMapper resourcesClassMapper;
    @Override
    //todo 文件上传
    public boolean uploadFile(int cid,Resource resource, MultipartFile file) {
        resourceMapper.insert(resource);
        ResourcesClass resourcesClass=new ResourcesClass();
        resourcesClass.setCid(cid);
        resourcesClass.setCid(resource.getRid());
        String targetURL = "D:\\upload\\video";
        if(file.isEmpty()){
            return false;
        }
        File tarFile = new File(targetURL, file.getOriginalFilename());
        try {
            file.transferTo(tarFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    //todo 文件上传
    public boolean uploadpic(String url, MultipartFile file) {
        String targetURL = "C:\\resource\\img"+url;
        if(file.isEmpty()){
            return false;
        }
        File tarFile = new File(targetURL, file.getOriginalFilename());
        try {
            file.transferTo(tarFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Resource> searchResources(int cid) {
        ResourcesClassExample resourcesClassExample=new ResourcesClassExample();
        resourcesClassExample.or().andCidEqualTo(cid);
        List<ResourcesClass> resourcesClassList=resourcesClassMapper.selectByExample(resourcesClassExample);
        List<Resource> resources=new ArrayList<>();
        for(ResourcesClass item:resourcesClassList){
            resources.add(resourceMapper.selectByPrimaryKey(item.getRid()));
        }
        return resources;
    }

    @Override
    public Resource getResource(int rid) {
        return resourceMapper.selectByPrimaryKey(rid);
    }
}
