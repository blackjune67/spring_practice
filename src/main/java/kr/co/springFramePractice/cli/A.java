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
    private B b;
    /*@Autowired private ApplicationContext context;
    @Value("{systemPropertise['hello']}") String property;*/

    public A(B b) {
        this.b = b;
    }

    void init() {
        log.error("A post construct" + b);
    }

    void destory() {
        log.error("A pre 디스트로이");
    }


}
