package com.tan.service;

import com.tan.pojo.StudentDO;
import com.tan.pojo.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<StudentVO> listStudentsAll();

    List<StudentVO> listStudentsByCname(String cname);

    List<StudentVO> listStudentsBySname(String sname);

    List<StudentVO> listStudentsBySn(String sn);

    int saveStudent(StudentDO studentDO);

    int removeStudent(int sid);

    int removeStudents(List<Integer> sids);

    int updateStudent(StudentDO student);
}
