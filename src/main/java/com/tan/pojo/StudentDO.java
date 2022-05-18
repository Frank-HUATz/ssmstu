package com.tan.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentDO {
    private Integer sid;
    private Integer cid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate sbirth;
    private String sn;
    private String sname;
    private String phone;
    private String imgurl;
    private String ssex;

}
