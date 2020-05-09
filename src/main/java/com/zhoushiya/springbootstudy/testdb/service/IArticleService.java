package com.zhoushiya.springbootstudy.testdb.service;

import com.zhoushiya.springbootstudy.testdb.vo.ArticleVO;

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
