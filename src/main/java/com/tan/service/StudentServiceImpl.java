package com.tan.service;

import com.tan.dao.StudentDao;
import com.tan.pojo.StudentDO;
import com.tan.pojo.StudentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public List<StudentVO> listStudentsAll() {
        return studentDao.listStudentsAll();
    }

    @Override
    public List<StudentVO> listStudentsByCname(String cname) {
        return studentDao.listStudentsByCname(cname);
    }

    @Override
    public List<StudentVO> listStudentsBySname(String sname) {
        return studentDao.listStudentsBySname(sname);
    }

    @Override
    public int removeStudent(int sid) {
        return studentDao.removeStudent(sid);
    }

    @Override
    public int updateStudent(StudentDO student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int saveStudent(StudentDO student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public List<StudentVO> listStudentsBySn(String sn) {
        return studentDao.listStudentsBySn(sn);
    }

    @Override
    public int removeStudents(List<Integer> sids) {
        return studentDao.removeStudents(sids);
    }
}
