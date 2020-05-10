package com.zhoushiya.springbootstudy;

import com.zhoushiya.springbootstudy.testdb.service.IArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleTest {
    @Resource
    IArticleService articleService;

    @Test
    public void getAll(){
        articleService.getAll().forEach(System.out::println);
    }
}
