package com.example.demo.model;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * @author heqiang7
 */
@Data
@TableName("sys_log")
//@JsonIgnoreProperties({ "logData","handler","hibernateLazyInitializer" })
public class SysLog {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String level1Menu;

    @TableField(exist = false)
    private String level2Menu;

    private String level3Menu;

//    private String category;

//    private String item;

    private String api;

    private String visitor;

    private String message;

    private Date gmtCreate;

    private Integer status = 1;

    /**
     * 当前处理对象的json格式，
     */
    private JSONObject logData;
}
