package com.tan.controller;

import com.tan.pojo.ClassDO;
import com.tan.pojo.ClassVO;
import com.tan.service.ClassService;
import com.tan.util.ResponseMessage;
import com.tan.util.ResponseMessageFactory;
import com.tan.util.ResultCode;
import com.tan.util.exeption.ClassNameDuplicateException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tan
 * @version 1.0.0
 * @ClassName ClazzController.java
 * @Description TODO
 * @createTime 2022-05-11 19:37:00
 */

@RestController
@RequestMapping(value = "/api")
public class ClazzController {

    @Resource
    private ClassService classService;

    @CrossOrigin
    @RequestMapping("/get/class/all")
    public ResponseMessage<List<ClassVO>> listClassesAll() {
        System.out.println("test");
        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, classService.listClassesAll());
    }

    @CrossOrigin
    @RequestMapping("/remove/class")
    public ResponseMessage<String> removeClass(int cid) {
        int i = classService.removeClass(cid);
        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, String.format("删除%d条记录", i));
    }

    @CrossOrigin
    @RequestMapping("/save/class")
    public ResponseMessage<String> saveClass(ClassDO clazz) {
        int i;
        try {
            i = classService.saveClass(clazz);
        } catch (ClassNameDuplicateException e) {
            return ResponseMessageFactory.getResResponseMessage(ResultCode.FAILURE_DUPLICATE_CLASSNAME, "erro");
        }
        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, String.format("保存%d条记录", i));
    }

    @CrossOrigin
    @RequestMapping("/update/class")
    public ResponseMessage<String> updateClass(ClassDO clazz) {
        int i;
        try {
            i = classService.updateClass(clazz);
        } catch (ClassNameDuplicateException e) {
            return ResponseMessageFactory.getResResponseMessage(ResultCode.FAILURE_DUPLICATE_CLASSNAME, "erro");
        }
        return ResponseMessageFactory.getResResponseMessage(ResultCode.SUCCESS, String.format("保存%d条记录", i));
    }

}
