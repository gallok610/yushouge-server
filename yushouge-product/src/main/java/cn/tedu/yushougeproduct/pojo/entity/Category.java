package cn.tedu.yushougeproduct.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("category")
public class Category implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String categoryName;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
