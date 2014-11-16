package org.codingstyle.api.config;

import org.apache.log4j.Logger;
import org.codingstyle.api.exception.CodingStyleAPIException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "org.codingstyle.api.repository")
@EnableTransactionManagement
public class DatabaseConfig {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConfig.class);
    @Inject private Environment env;

    @Bean
    public DataSource dataSource() {
        String dbType = this.env.getProperty("database_type", "HSQL");
        if (!"HSQL".equals(dbType)) {
            LOGGER.info("Loading datasource with " + dbType);
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(this.env.getProperty("database_driver"));
            dataSource.setUrl(this.env.getProperty("database_url"));
            dataSource.setUsername(this.env.getProperty("database_username"));
            dataSource.setPassword(this.env.getProperty("database_password"));
            return dataSource;

        } else {
            LOGGER.info("Loading database with HSQL");
            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            return builder.setType(EmbeddedDatabaseType.HSQL).build();
        }
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        String dbType = this.env.getProperty("database_type", "HSQL");
        switch (dbType) {
            case "HSQL":
                vendorAdapter.setDatabase(Database.HSQL);
                vendorAdapter.setGenerateDdl(true);
                break;
            case "MYSQL":
                vendorAdapter.setDatabase(Database.MYSQL);
                vendorAdapter.setGenerateDdl(false);
                break;
            default:
                throw new CodingStyleAPIException("Unknown database type: " + dbType);
        }

        vendorAdapter.setShowSql(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("org.codingstyle.core.model");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PersistenceExceptionTranslator exceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }
}
