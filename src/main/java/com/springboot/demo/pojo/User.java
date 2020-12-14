package com.springboot.demo.pojo;

import lombok.Data;
import java.util.Date;

/**
 * @author Yang TanYing
 * @Description:
 * @create 2020-12-08 13:35
 */
@Data
public class User {
    private String userName;
    private String name;
    private String password;
    private String post;
    private String email;
    private String numberId;
    private Date updateTime;
    private String floor;

}
