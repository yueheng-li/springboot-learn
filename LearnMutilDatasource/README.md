多数据源使用，使用Druid和hikari作为数据源的连接池。

### Druid监控功能实现追加
```
application.properties
## 下面为连接池的补充设置，应用到上面所有数据源中
## 初始化大小，最小，最大
#master.datasource.initialSize=5
#master.datasource.minIdle=5
#master.datasource.maxActive=20
## 配置获取连接等待超时的时间
#master.datasource.maxWait=60000
## 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
#master.datasource.timeBetweenEvictionRunsMillis=60000
## 配置一个连接在池中最小生存的时间，单位是毫秒
#master.datasource.minEvictableIdleTimeMillis=300000
## 校验SQL，Oracle配置 master.datasource.validationQuery=SELECT 1 FROM DUAL，如果不配validationQuery项，则下面三项配置无用
#master.datasource.validationQuery=SELECT 'x'
#master.datasource.testWhileIdle=true
#master.datasource.testOnBorrow=false
#master.datasource.testOnReturn=false
## 打开PSCache，并且指定每个连接上PSCache的大小
#master.datasource.poolPreparedStatements=true
#master.datasource.maxPoolPreparedStatementPerConnectionSize=20
# 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
master.datasource.filters=stat,wall,log4j
# 通过connectProperties属性来打开mergeSql功能；慢SQL记录
master.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
# 合并多个DruidDataSource的监控数据
master.datasource.useGlobalDataSourceStat=true

	@Value("${master.datasource.filters}")
	private String filters;
	@Value("${master.datasource.connectionProperties}")
	private String connectionProperties;
	@Value("${master.datasource.useGlobalDataSourceStat}")
	private boolean useGlobalDataSourceStat;

MasterDataSourceConfig.java
    @Bean(name="masterDataSource")
    @Primary
    public DataSource masterDataSource() {
    	// Druid
    	DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        try {
        	dataSource.setFilters(filters);
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter: "+ e);
        }
        dataSource.setConnectionProperties(connectionProperties);
        
    	// hikari
//    	HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setDriverClassName(driverClass);
//        dataSource.setJdbcUrl(url);
//        dataSource.setUsername(user);
//        dataSource.setPassword(password);
        return dataSource;
    }


DruidConfiguration.java
package cn.learn.mutil.datasource.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * druid 配置. 这样的方式不需要添加注解：@ServletComponentScan
 */
@Configuration
public class DruidConfiguration {

	/**
	 * 注册一个StatViewServlet
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean DruidStatViewServle2() {

		// org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
				"/druid2/*");
		// 添加初始化参数：initParams

		// 白名单：
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
		// IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to
		// view this page.
		// servletRegistrationBean.addInitParameter("deny","192.168.1.73");

		// 登录查看信息的账号密码.
		servletRegistrationBean.addInitParameter("loginUsername", "admin2");
		servletRegistrationBean.addInitParameter("loginPassword", "123456");

		// 是否能够重置数据.
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}

	/**
	 * 
	 * 注册一个：filterRegistrationBean
	 * 
	 * @return
	 * 
	 */

	@Bean
	public FilterRegistrationBean druidStatFilter2() {

		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

		// 添加过滤规则.
		filterRegistrationBean.addUrlPatterns("/*");

		// 添加不需要忽略的格式信息.
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");

		return filterRegistrationBean;

	}
}

```
