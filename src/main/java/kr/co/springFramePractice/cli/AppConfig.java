package kr.co.springFramePractice.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)
//@PropertySource("classpath:application-${spring.protiles.active}.properties")
public class AppConfig {

    @Bean
    public B bo() {
        return new B();
    }

/*    @Bean
    public Connection connection(ConnectionFactory connectionFactory) {
        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection) {
        return new Dao(connection);
    }*/


/*    public ConnectionFactory connectionFactory(
            @Value("${jdbc.driver-class}") String driverClass,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password
    ) {

        return new ConnectionFactory(driverClass, url, username, password);
    }*/

    /*@Bean
    public LocalValidationFactoryBean localValidationFactoryBean() {
        return new LocalValidatorFactoryBean();
    }*/
}