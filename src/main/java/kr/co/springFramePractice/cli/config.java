package kr.co.springFramePractice.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class config {
    @Bean
    @Primary
    public B appBeanB1() {
        return new B();
    }

    /*@Bean
    public B b2() {
        return new B();
    }*/
}
