package com.tan.service;

import com.tan.dao.ClassDao;
import com.tan.pojo.ClassDO;
import com.tan.pojo.ClassVO;
import com.tan.util.exeption.ClassNameDuplicateException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tan
 * @version 1.0.0
 * @ClassName ClassServiceImpl.java
 * @Description TODO
 * @createTime 2022-05-11 19:43:00
 */

@Service
public class ClassServiceImpl implements ClassService {

    @Resource
    ClassDao classDao;

    @Override
    public List<ClassVO> listClassesAll() {
        return classDao.listClassesAll();
    }

    @Override
    public int updateClass(ClassDO clazz) {
        if(classDao.countClassByCname(clazz.getCname())!=0){
            throw new ClassNameDuplicateException("班级名已存在");
        }
        return classDao.updateClass(clazz);
    }
    @Override
    public int removeClass(int cid) {
        return classDao.removeClass(cid);
    }

    @Override
    public int saveClass(ClassDO clazz) {
        if(classDao.countClassByCname(clazz.getCname())!=0){
            throw new ClassNameDuplicateException("班级名已存在");
        }
        return classDao.saveClass(clazz);
    }
}
