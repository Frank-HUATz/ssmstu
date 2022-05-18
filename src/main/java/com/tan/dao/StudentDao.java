package com.tan.dao;

import com.tan.pojo.StudentDO;
import com.tan.pojo.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tan
 * @version 1.0.0
 * @ClassName StudentDao.java
 * @Description TODO
 * @createTime 2022-05-08 08:56:00
 */

@Repository
@Mapper
public interface StudentDao {
    List<StudentVO> listStudentsAll();

    List<StudentVO> listStudentsByCname(@Param("cname") String cname);

    List<StudentVO> listStudentsBySname(@Param("sname") String sname);

    List<StudentVO> listStudentsBySn(@Param("sn") String sn);


    int saveStudent(StudentDO studentDO);

    int removeStudent(int sid);

    int removeStudents(List<Integer> sids);

    int updateStudent(StudentDO student);
}
