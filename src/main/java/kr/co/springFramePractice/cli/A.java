package kr.co.springFramePractice.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Slf4j
@Component
public class A {
    @Resource private B b;
    @Autowired private ApplicationContext context;
    @Value("{systemPropertise['hello']}") String property;

    @PostConstruct
    void init() {
        log.info("A post construct");
    }

    @PreDestroy
    void destory() {
        log.info("A pre 디스트로이");
    }


}
