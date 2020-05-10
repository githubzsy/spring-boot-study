package com.example.mybatis.testdb.controller;

import com.example.mybatis.testdb.service.IArticleService;
import com.example.mybatis.testdb.vo.ArticleVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleController {

    @Resource
    IArticleService articleService;

    /**
     * 增加一篇文章
     *
     * @param article
     * @return
     */
    @ApiOperation(value = "添加文章", notes = "添加新文章", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = ArticleVO.class),
            @ApiResponse(code = 400, message = "用户输入错误", response = ArticleVO.class),
            @ApiResponse(code = 500, message = "系统内部错误", response = ArticleVO.class),
    })
    // @RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json")
    @PostMapping("/article")
    public ArticleVO insertArticle(@RequestBody ArticleVO article) {
        articleService.insert(article);
        return article;
    }

    /**
     * 获取一篇Article，使用GET方法
     */
    // @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @GetMapping("/article/{id}")
    public ArticleVO getById(@PathVariable Long id) {
        ArticleVO articleVO = articleService.getById(id);
        return articleVO;
    }

    @GetMapping("/article")
    public List<ArticleVO> getAll() {
        return articleService.getAll();
    }
}
