# spring boot 整合ElasticSearch

## [Elasticsearch windows 安装](https://github.com/yueheng-li/learn/wiki/Elasticsearch-windows-%E5%AE%89%E8%A3%85)

## pom
```
<!-- Spring Boot Elasticsearch 依赖 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-elasticsearch</artifactId>
</dependency>
```
## application.properties
```
# ES
spring.data.elasticsearch.repositories.enabled = true
spring.data.elasticsearch.cluster-nodes = 127.0.0.1:9200
```

### @Document注解里面的几个属性，类比mysql的话是这样： 
```
index –> DB 
type –> Table 
Document –> row 
@Persistent
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Document {

String indexName();//索引库的名称，个人建议以项目的名称命名

String type() default "";//类型，个人建议以实体的名称命名

short shards() default 5;//默认分区数

short replicas() default 1;//每个分区默认的备份数

String refreshInterval() default "1s";//刷新间隔

String indexStoreType() default "fs";//索引文件存储类型
}
```

## 通过ElasticSearchTest添加一条索引数据。

http://127.0.0.1:8080//api/art/and/find?title=springboot&abstracts=springboot
```json
[{"id":1,"title":"springboot integreate elasticsearch","abstracts":"springboot integreate elasticsearch is very easy","content":"elasticsearch based on lucene,spring-data-elastichsearch based on elaticsearch,this tutorial tell you how to integrete springboot with spring-data-elasticsearch","postTime":1505801353524,"clickCount":1,"author":{"id":1,"name":"lichunhui","remark":"java developer"},"tutorial":{"id":1,"name":"elastic search"}}]
```
