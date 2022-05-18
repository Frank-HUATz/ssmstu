package com.tan.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class StudentVO extends StudentDO{
    private String cname;
    @Override
    public String toString() {
        return "StudentVO{" + super.toString()+
                "cname='" + cname + '\'' +
                '}';
    }
}
