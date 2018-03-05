package com.app.src.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.H2Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Profile("dev")
@Configuration
@EnableTransactionManagement
public class DevConfig
{

   /** un-comment below if using datasource by using tag in spring-config.xml **/
   //   @Value("#{dataSource}")
   //   private DataSource dataSource;

   @Bean
   public DataSource dataSource()
   {
      EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
      return builder.setType( EmbeddedDatabaseType.H2 ).build();
   }

   @Bean
   public LocalSessionFactoryBean sessionFactoryBean()
   {
      Properties props = new Properties();
      props.put( "hibernate.dialect", H2Dialect.class.getName() );
      props.put( "hibernate.show_sql", "true" );
      props.put( "hibernate.connection.pool_size", "2" );
      props.put( "hibernate.hbm2ddl.auto", "create-drop" );

      LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
      bean.setHibernateProperties( props );
      bean.setDataSource( dataSource() );
      bean.setPackagesToScan( "com.app.src.entities" );
      return bean;
   }

   @Bean
   public HibernateTransactionManager transactionManager()
   {
      return new HibernateTransactionManager( sessionFactoryBean().getObject() );
   }

}
