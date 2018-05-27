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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration //注册到springboot容器中
@MapperScan(basePackages = "com.xyz.zf.demo", sqlSessionFactoryRef = "demoSqlSessionFactory")
public class DemoDataSourceConfig {
    /**
     * 配置demo数据库
     * @return
     */
    @Bean(name = "demoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.demo")
    @Primary
    public DataSource demoDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * demo sql会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "demoSqlSessionFactory")
    @Primary
    public SqlSessionFactory demoSqlSessionFactory(@Qualifier("demoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //mybatis写配置文件
        /*bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/demo/*.xml")
        );*/
        return bean.getObject();
    }

    /**
     * demo事务管理
     * @param dataSource
     * @return
     */
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager demoTransactionManager(@Qualifier("demoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "demoSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate demoSqlSessionTemplate(@Qualifier("demoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
