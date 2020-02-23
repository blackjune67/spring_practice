package kr.co.springFramePractice.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
//@Component
//@Named("a")
public class A {
    @Autowired private B b;
    @Autowired private ApplicationContext context;
    @Value("{systemPropertise['hello']}") String property;

    /*public A(B b) {
        this.b = b;
    }*/

    @PostConstruct
    void init() {
        log.info("A post construct" + b);
    }

    @PreDestroy
    void destory() {
        log.info("A pre 디스트로이");
    }


}
