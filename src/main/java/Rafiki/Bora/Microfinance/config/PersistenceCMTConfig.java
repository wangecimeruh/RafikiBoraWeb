package Rafiki.Bora.Microfinance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//used to configure the parameters and initial settings for some computer programs
@EnableTransactionManagement
//reactive transaction management
@PropertySource("classpath:persistence-cmt.properties")
//environment-setup config
@ComponentScan("Rafiki.Bora.Microfinance.dao")
@ComponentScan("Rafiki.Bora.Microfinance.model")
//scan the annotated components
@EnableJpaRepositories(basePackages = "Rafiki.Bora.Microfinance.rbm.dao")
//scan class of the annotated class
public class PersistenceCMTConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("Rafiki.Bora.Microfinance.rbm.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() throws NamingException {
        return (DataSource) new JndiTemplate().lookup(env.getProperty("jdbc.url"));
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();

        //Database connection settings
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.integration.envers.enabled", env.getProperty("hibernate.integration.envers.enabled"));
        //hibernateProperties.setProperty("hibernate.archive.autodetection", env.getProperty("hibernate.archive.autodetection"));
        hibernateProperties.setProperty("hibernate.connection.max_allowed_packet", env.getProperty("hibernate.connection.max_allowed_packet"));
        hibernateProperties.setProperty("hibernate.connection.release_mode", env.getProperty("hibernate.connection.release_mode"));
        //hibernateProperties.setProperty("hibernate.connection.handling_mode", env.getProperty("hibernate.connection.handling_mode"));

        // Disable second-level cache.
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "false");

        // update schema on SessionFactory build
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

        // flush mysql to clear error connections
        hibernateProperties.setProperty("hibernate.flushMode",env.getProperty("hibernate.flushMode"));

        return hibernateProperties;
    }
}