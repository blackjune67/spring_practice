package kr.co.springFramePractice.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)
public class AppConfig {

    @Bean
    public B b() {
        return new B();
    }

    @Bean
    public A a(B b) {
        return new A(b);
    }
}
