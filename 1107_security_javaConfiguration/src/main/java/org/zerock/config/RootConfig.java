package org.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages= {"org.zerock.service","org.zerock.aop"})
@MapperScan(basePackages= {"org.zerock.mapper"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableScheduling
@PropertySource("classpath:config.properties")
public class RootConfig {
	
	@Value("${db.driverClassName}")
	private String dName;
	
	@Value("${db.jdbcUrl}")
	private String url;
	
	@Value("${db.username}")
	private String userName;
	
	@Value("${db.password}")
	private String pw;
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource());
		
		return factory.getObject();
	}
	
	@Bean
	public DataSource dataSource() {
		
		HikariConfig config = new HikariConfig();
		
		config.setDriverClassName(dName);
		config.setJdbcUrl(url);
		config.setUsername(userName);
		config.setPassword(pw);
		
		HikariDataSource ds = new HikariDataSource(config);
		
		return ds;
	}
	
	
}
