package cn.zhanx.test3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@TableName("student")
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Student implements Serializable {

    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;
    private String uid;
    private String name;
    private String pwd;
    private Integer gender;
    @TableField(value = "class")
    private String classx;
    private String bk;
    private Integer status;
    @TableField(value = "insert_time")
    private Date insertTime;
}