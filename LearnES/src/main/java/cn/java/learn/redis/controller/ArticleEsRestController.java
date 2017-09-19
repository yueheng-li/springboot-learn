package cn.java.learn.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.java.learn.redis.entity.Article;
import cn.java.learn.redis.service.ArticleESService;

@RestController
public class ArticleEsRestController {

    @Autowired
    private ArticleESService service;

    /**
     * 插入 ES 论文
     *
     * @param city
     * @return
     */
    @RequestMapping(value = "/api/art", method = RequestMethod.POST)
    public Long createArticle(@RequestBody Article article) {
        return service.saveArticle(article);
    }

    /**
     * AND 语句查询
     *
     * @param description
     * @param score
     * @return
     */
    @RequestMapping(value = "/api/art/and/find", method = RequestMethod.GET)
    public List<Article> findByTitleAndAbstracts(@RequestParam(value = "title") String title,
                                                @RequestParam(value = "abstracts") String abstracts) {
        return service.findByTitleAndAbstracts(title, abstracts);
    }

    /**
     * 搜索返回分页结果
     *
     * @param pageNumber 当前页码
     * @param pageSize 每页大小
     * @param searchContent 搜索内容
     * @return
     */
    @RequestMapping(value = "/api/art/search", method = RequestMethod.GET)
    public List<Article> searchCity(@RequestParam(value = "pageNumber") Integer pageNumber,
                                                @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                @RequestParam(value = "searchContent") String searchContent) {
        return service.searchArticle(pageNumber, pageSize,searchContent);
    }

}
