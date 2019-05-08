package com.facebook.jdt.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryMysql",
        transactionManagerRef = "transactionManagerMySql",
        basePackages = { "com.facebook.jdt.repository" }
)
public class JpaConfig {

    @Resource
    @Qualifier("myDataSource")
    private DataSource ds;

    @Bean(name = "entityManagerMysql")
    public EntityManager entityManagerMysql(EntityManagerFactoryBuilder entityManagerFactoryBuilder){
        return entityManagerFactoryBean(entityManagerFactoryBuilder).getObject().createEntityManager();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(ds)
                .properties(getVendorProperties())
                .packages("com.facebook.jdt.po")
                .persistenceUnit("persistenceUnit")
                .build();
    }

    @Resource
    private JpaProperties jpaProperties;

    @Resource
    private HibernateProperties hibernateProperties;

    private Map<String,Object> getVendorProperties(){
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
    }

}
