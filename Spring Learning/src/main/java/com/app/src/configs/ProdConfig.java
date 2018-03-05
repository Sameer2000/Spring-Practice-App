package com.app.src.configs;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Profile("prod")
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class ProdConfig
{

   @Resource
   public Environment env;

   @Bean
   public DataSource dataSource()
   {
      BasicDataSource ds = new BasicDataSource();
      ds.setDriverClassName( env.getProperty( "spring.datasource.driverClassName" ) );
      ds.setUrl( env.getProperty( "spring.datasource.url" ) );
      ds.setUsername( env.getProperty( "spring.datasource.username" ) );
      ds.setPassword( env.getProperty( "spring.datasource.password" ) );
      return ds;
   }

   @Bean
   public LocalSessionFactoryBean sessionFactory()
   {
      LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
      sf.setDataSource( dataSource() );
      sf.setPackagesToScan( new String[] { "com.app.src.entities" } );
      sf.setHibernateProperties( getHibernateProps() );
      return sf;
   }

   private Properties getHibernateProps()
   {
      Properties properties = new Properties();
      properties.setProperty( "hibernate.hbm2ddl.auto", env.getProperty( "hibernate.ddl-auto" ) );
      properties.setProperty( "hibernate.dbcp.testWhileIdle", env.getProperty( "hibernate.test-while-idle" ) );
      properties.setProperty( "hibernate.dbcp.validationQuery", env.getProperty( "hibernate.validationQuery" ) );
      properties.setProperty( "hibernate.show_sql", env.getProperty( "hibernate.show-sql" ) );
      properties.setProperty( "hibernate.connection.pool_size", env.getProperty( "hibernate.pool-size" ) );
      properties.setProperty( "hibernate.dialect", env.getProperty( "hibernate.dialect" ) );
      properties.setProperty( "hibernate.connection.autocommit", "true" );
      return properties;
   }

   @Bean
   public HibernateTransactionManager txManager( SessionFactory sessionFactory )
   {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory( sessionFactory );
      return txManager;
   }

   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
   {
      return new PersistenceExceptionTranslationPostProcessor();
   }

}
