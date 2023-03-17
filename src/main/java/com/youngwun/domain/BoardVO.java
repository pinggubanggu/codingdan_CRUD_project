package com.youngwun.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

// Lombok - @Data 어노테이션을 이용해서 생성자와 getter/setter, toString() 만들어 낸다.
@Data
public class BoardVO {

    private Long bno;
    private String title;
    private String content;
    private String writer;

    private Date regdate;

    private Date updateDate;

}
