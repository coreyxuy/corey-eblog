package com.itcorey.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: corey
 * @Date: 2020/11/10 10:15
 * @Description:
 */
@Data
public class BaseEntity {

    private Long id;
    private Date created;
    private Date modified;

}
