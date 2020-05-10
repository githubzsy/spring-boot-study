package com.example.mybatis.testdb.service;

import com.example.mybatis.testdb.vo.ArticleVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoushiya
 * @since 2020-04-30
 */
public interface IArticleService{
    /**
     * 更新或者插入数据
     * @param articleVO
     * @return
     */
    ArticleVO insert(ArticleVO articleVO);

    ArticleVO getById(long id);

    List<ArticleVO> getAll();
}
