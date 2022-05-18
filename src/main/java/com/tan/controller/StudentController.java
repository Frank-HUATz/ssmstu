package com.tan.controller;

import com.tan.pojo.StudentDO;
import com.tan.pojo.StudentVO;
import com.tan.service.StudentService;
import com.tan.util.ResponseMessage;
import com.tan.util.ResponseMessageFactory;
import com.tan.util.ResultCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author Tan
 * @version 1.0.0
 * @ClassName StudentController.java
 * @Description TODO
 * @createTime 2022-05-08 10:16:00
 */

@RestController
@RequestMapping(value = "/api/")
public class StudentController {
    @Resource
    private StudentService studentService;

    @CrossOrigin
    @RequestMapping(value = "/get/student/all")
    public ResponseMessage<List<StudentVO>> listStudentsAll() {

        List<StudentVO> studentList = studentService.listStudentsAll();

        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, studentList);
    }

    @CrossOrigin
    @RequestMapping(value = "/get/students/sn")
    public ResponseMessage<List<StudentVO>> listStudentsBySn(String sn) {

        List<StudentVO> studentList = studentService.listStudentsBySn(sn);

        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, studentList);
    }

    @CrossOrigin
    @RequestMapping(value = "/get/students/cname")
    public ResponseMessage<List<StudentVO>> listStudentsByCname(String cname) {

        List<StudentVO> studentList = studentService.listStudentsByCname(cname);

        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, studentList);
    }

    @CrossOrigin
    @RequestMapping(value = "/get/students/name")
    public ResponseMessage<List<StudentVO>> listStudentsBySname(String sname) {

        List<StudentVO> studentList = studentService.listStudentsBySname(sname);

        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, studentList);
    }

    @CrossOrigin
    @RequestMapping(value = "/save/student")
    public ResponseMessage<String> saveStudent(
            @RequestParam(value = "file", required = false) MultipartFile file,
            StudentDO student,
            HttpServletRequest request)
            throws IOException {
        if (file != null && !file.isEmpty()) {
            String realPath = request.getSession().getServletContext().getRealPath("static");
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            String suffix = fileName.substring(fileName.indexOf("."));
            String newName = UUID.randomUUID() + suffix;
            File targetFile = new File(realPath, newName);
            if (!targetFile.exists()) {
                if (!targetFile.mkdirs()) {
                    System.out.println("mkdir failure");
                }
            }
            file.transferTo(targetFile);
            student.setImgurl("http://localhost:8080/studentmanager/static/" + newName);
        }
        int i = studentService.saveStudent(student);
        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, String.format("添加%d条记录", i));
    }

    @CrossOrigin
    @RequestMapping(value = "/update/student")
    public ResponseMessage<String> updateStudent(
            @RequestParam(value = "file", required = false) MultipartFile file,
            StudentDO student, HttpServletRequest request) throws IOException {
        if (file != null && !file.isEmpty()) {
            String realPath = request.getSession().getServletContext().getRealPath("static");
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            String suffix = fileName.substring(fileName.indexOf("."));
            String newName = UUID.randomUUID() + suffix;
            File targetFile = new File(realPath, newName);
            if (!targetFile.exists()) {
                if (!targetFile.mkdirs()) {
                    System.out.println("mkdir failure");
                }
            }
            file.transferTo(targetFile);
            student.setImgurl("http://localhost:8080/studentmanager/static/" + newName);
        }
        int i = studentService.updateStudent(student);
        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, String.format("修改%d条记录", i));
    }

    @CrossOrigin
    @RequestMapping(value = "/remove/student")
    public ResponseMessage<String> removeStudent(int sid) {
        int i = studentService.removeStudent(sid);
        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, String.format("删除%d条记录", i));
    }

    @CrossOrigin
    @RequestMapping(value = "/remove/students")
    public ResponseMessage<String> removeStudents(@RequestBody List<Integer> sids) {
        int i = studentService.removeStudents(sids);
        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, String.format("删除%d条记录", i));
    }

}
