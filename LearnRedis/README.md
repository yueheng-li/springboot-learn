# redis作为缓存的例子

## pom 下面dependency追加
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

## application.properties 下面的redis连接信息配置
```
#REDIS (RedisProperties)
#Redis数据库索引（默认为0）
spring.redis.database=0  
#Redis服务器地址
spring.redis.host=127.0.0.1
#Redis服务器连接端口
spring.redis.port=6379  
#Redis服务器连接密码（默认为空）
spring.redis.password=  
#连接池最大连接数（使用负值表示没有限制）
spring.redis.pool.max-active=8  
#连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.pool.max-wait=-1  
#连接池中的最大空闲连接
spring.redis.pool.max-idle=8  
#连接池中的最小空闲连接
spring.redis.pool.min-idle=0  
#连接超时时间（毫秒）
spring.redis.timeout=0  
```
## 启动工程 
### 浏览器输入：http://127.0.0.1:8080/api/city/1

第一次请求和二次以后请求的log

2017-09-18 16:04:34.342  INFO 12576 --- [io-8080-exec-10] c.j.l.r.service.impl.CityServiceImpl     : CityServiceImpl.findCityById() : 城市插入缓存 >> City{id=4, provinceId=9, cityName='Dalian', description='org.springframework'}

2017-09-18 16:04:37.199  INFO 12576 --- [nio-8080-exec-2] c.j.l.r.service.impl.CityServiceImpl     : CityServiceImpl.findCityById() : 从缓存中获取了城市 >> City{id=4, provinceId=9, cityName='Dalian', description='org.springframework'}

### postman：http://127.0.0.1:8080/api/city/
headers：Content-Type=application/json

body：row:JSON
```json
{
    "id": 4,
    "provinceId": 9,
    "cityName": "Dalian",
    "description": "org.springframework"
}
```
