package com.example.mybatis.testdb.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Article展示类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder(value={"content","title"})
public class ArticleVO {

    @JsonIgnore
    private Long id;

    private String author;

    private String title;
    private String content;

    private Date createTime;
}
