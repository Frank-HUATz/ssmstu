package com.tan.dao;

import com.tan.pojo.ClassDO;
import com.tan.pojo.ClassVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tan
 * @version 1.0.0
 * @ClassName ClassDao.java
 * @Description TODO
 * @createTime 2022-05-11 19:45:00
 */

@Repository
@Mapper
public interface ClassDao {
    List<ClassVO> listClassesAll();

    int updateClass(ClassDO clazz);

    int removeClass(int cid);

    int saveClass(ClassDO clazz);

    int countClassByCname(@Param("cname") String cname);
}
