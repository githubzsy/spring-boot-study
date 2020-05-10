package com.example.mybatis.testdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Article实体类
 * </p>
 *
 * @author zhoushiya
 * @since 2020-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Article implements Serializable {

    private Long id;

    private String author;

    private String content;

    private Date createTime;

    private String title;


}
