/*
 * package com.bbit.app.bbithotelbooking.config;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.boot.jdbc.DataSourceBuilder; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.Primary; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * import com.zaxxer.hikari.HikariDataSource;
 * 
 * @EnableTransactionManagement
 * 
 * @EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
 * basePackages = { "com.bbit.app.bbithotelbooking.repository" })
 * //@Configuration public class HibernateConfig {
 * 
 * @Value("${spring.datasource.username: root}") private String userName;
 * 
 * @Value("${spring.datasource.password: root}") private String password;
 * 
 * @Value("${spring.datasource.url: jdbc:mysql://localhost:3306/myDb}") private
 * String url;
 * 
 * @Value("${spring.jpa.properties.hibernate.dialect: org.hibernate.dialect.MySQL8Dialect}"
 * ) private String hibernateDialect;
 * 
 * @Bean(name = "getDataSource")
 * 
 * @Primary public DataSource getDataSource() { HikariDataSource dataSource =
 * (HikariDataSource) DataSourceBuilder.create().username(userName)
 * .password(password).url(url).build(); return dataSource; }
 * 
 * @Bean
 * 
 * @Primary public LocalContainerEntityManagerFactoryBean
 * entityManagerFactory(DataSource dataSource) {
 * LocalContainerEntityManagerFactoryBean em =
 * createEntityManagerFactory(dataSource, new String[] {
 * "com.bbit.app.bbithotelbooking.entity" }); return em; }
 * 
 * private LocalContainerEntityManagerFactoryBean
 * createEntityManagerFactory(DataSource dataSource, String[] entityPackages) {
 * LocalContainerEntityManagerFactoryBean em = new
 * LocalContainerEntityManagerFactoryBean(); em.setDataSource(dataSource);
 * em.setPersistenceUnitName("default"); em.setPackagesToScan(entityPackages);
 * 
 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
 * vendorAdapter.setDatabasePlatform(hibernateDialect);
 * em.setJpaVendorAdapter(vendorAdapter); return em; }
 * 
 * }
 */