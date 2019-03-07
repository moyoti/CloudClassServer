package com.my.Service;

import com.my.pojo.Resource;
import com.my.pojo.ResourcesClass;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 16:56 2019/2/20
 */
public interface ResourceService {
    boolean uploadFile(int cid, Resource resource, MultipartFile file);//数据库插入和文件存储
    List<Resource> searchResources(int cid);
    Resource getResource(int rid);
}
