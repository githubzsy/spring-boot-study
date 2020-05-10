package com.example.mybatis.testdb.service.impl;

import com.example.mybatis.testdb.entity.Article;
import com.example.mybatis.testdb.service.IArticleService;
import com.example.mybatis.testdb.vo.ArticleVO;
import com.example.mybatis.testdb.mapper.ArticleMapper;
import com.example.mybatis.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类,使用@Service(value = "articleService")让其作为IArticleService注入的默认类
 * </p>
 *
 * @author zhoushiya
 * @since 2020-04-30
 */
@Service(value = "articleService")
public class ArticleServiceImpl implements IArticleService {

    @Resource
    ArticleMapper articleMapper;

    @Resource
    private Mapper mapper;

    public ArticleVO insert(ArticleVO articleVO) {
        Article article= mapper.map(articleVO,Article.class);
        articleMapper.insert(article);
        return articleVO;
    }

    @Override
    public ArticleVO getById(long id) {
        Article article = articleMapper.getById(id);
        ArticleVO articleVO= mapper.map(article,ArticleVO.class);
        return articleVO;
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.getAll();
        List<ArticleVO> articleVOS= DozerUtils.mapList(articles,ArticleVO.class);
        return articleVOS;
    }
}
