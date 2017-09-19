package cn.java.learn.redis.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;

//String indexName();//索引库的名称，个人建议以项目的名称命名
//String type() default "";//类型，个人建议以实体的名称命名
//short shards() default 5;//默认分区数
//short replicas() default 1;//每个分区默认的备份数
//String refreshInterval() default "1s";//刷新间隔
//String indexStoreType() default "fs";//索引文件存储类型
//index –> DB 
//type –> Table 
//Document –> row 
@Document(indexName = "articlename", type = "article")
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	/** 标题 */
	private String title;
	/** 摘要 */
	private String abstracts;
	/** 内容 */
	private String content;
	/** 发表时间 */
	private Date postTime;
	/** 点击率 */
	private Long clickCount;
	/** 作者 */
	private Author author;
	/** 所属教程 */
	private Tutorial tutorial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Long getClickCount() {
		return clickCount;
	}

	public void setClickCount(Long clickCount) {
		this.clickCount = clickCount;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

}
