package cn.java.learn.redis;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.java.learn.redis.entity.Article;
import cn.java.learn.redis.entity.Author;
import cn.java.learn.redis.entity.Tutorial;
import cn.java.learn.redis.repository.ArticleESRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchTest {

	@Autowired
	private ArticleESRepository articleSearchRepository;
	
	@Test
	public void testSaveArticleIndex(){
		Author author=new Author();
		author.setId(1L);
		author.setName("lichunhui");
		author.setRemark("java developer");
		
		Tutorial tutorial=new Tutorial();
		tutorial.setId(1L);
		tutorial.setName("elastic search");
		
		Article article =new Article();
		article.setId(1L);
		article.setTitle("springboot integreate elasticsearch");
		article.setAbstracts("springboot integreate elasticsearch is very easy");
		article.setTutorial(tutorial);
		article.setAuthor(author);
		article.setContent("elasticsearch based on lucene,"
				+ "spring-data-elastichsearch based on elaticsearch"
				+ ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
		article.setPostTime(new Date());
		article.setClickCount(1L);
		
		articleSearchRepository.save(article);
	}
}
