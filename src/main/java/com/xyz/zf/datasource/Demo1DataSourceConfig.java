package com.xyz.zf.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration //注册到springboot容器中
@MapperScan(basePackages = "com.xyz.zf.demo1", sqlSessionFactoryRef = "demo1SqlSessionFactory")
public class Demo1DataSourceConfig {
    /**
     * 配置demo1数据库
     * @return
     */
    @Bean(name = "demo1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.demo1")
    public DataSource demo1DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * demo1 sql会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "demo1SqlSessionFactory")
    public SqlSessionFactory demo1SqlSessionFactory(@Qualifier("demo1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //mybatis写配置文件
        /*bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/demo1/*.xml")
        );*/
        return bean.getObject();
    }

    /**
     * demo1事务管理
     * @param dataSource
     * @return
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager demoTransactionManager(@Qualifier("demo1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "demo1SqlSessionTemplate")
    public SqlSessionTemplate demo1SqlSessionTemplate(@Qualifier("demo1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
