package com.example.mybatis.testdb.mapper;

import com.example.mybatis.testdb.entity.Article;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoushiya
 * @since 2020-04-30
 */
public interface ArticleMapper {
    int insert(Article article);

    Article getById(long id);

    List<Article> getAll();
}
