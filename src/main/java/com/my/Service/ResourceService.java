package com.my.Service;

import com.my.pojo.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: dongqihang
 * @Date: Created in 16:56 2019/2/20
 */
public interface ResourceService {
    boolean uploadFile(Resource resource, MultipartFile file);//数据库插入和文件存储
}
