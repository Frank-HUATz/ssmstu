package com.tan.service;

import com.tan.pojo.ClassDO;
import com.tan.pojo.ClassVO;

import java.util.List;

public interface ClassService {
    List<ClassVO> listClassesAll();

    int updateClass(ClassDO clazz);

    int removeClass(int cid);

    int saveClass(ClassDO clazz);
}
