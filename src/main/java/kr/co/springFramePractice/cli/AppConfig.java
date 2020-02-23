package kr.co.springFramePractice.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Connection;

@Configuration
//@ComponentScan(basePackageClasses = AppConfig.class)
//@PropertySource("classpath:application-${spring.protiles.active}.properties")
@Profile("default")
public class AppConfig {

    @Bean
    public B bo() {
        return new B();
    }

    @Bean(initMethod = "init", destroyMethod = "destory")
    public A a(B b) {
        return new A(b);
    }

    @Bean(initMethod = "init", destroyMethod = "destory")
    public ConnectionFactory connectionFactory() {
        return new ConnectionFactory("org.h2.Driver", "jdbc:h2:mem:test", "sa", "");
    }

    @Bean
    public Connection connection(ConnectionFactory connectionFactory) {
        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection) {
        return new Dao(connection);
    }


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