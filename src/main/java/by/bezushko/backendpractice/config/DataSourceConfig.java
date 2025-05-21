package by.bezushko.backendpractice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@PropertySource("classpath:application-secrets.properties")
@Configuration
public class DataSourceConfig {
    @Value("${DATABASE_HOST}")
    private String databaseHost;

    @Value("${DATABASE_PORT}")
    private String databasePort;

    @Value("${DATABASE_NAME}")
    private String databaseName;

    @Value("${DATABASE_USERNAME}")
    private String databaseUsername;

    @Value("${DATABASE_PASSWORD}")
    private String databasePassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://" + databaseHost + ":" + databasePort + "/" + databaseName);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);
        return dataSource;
    }
}
