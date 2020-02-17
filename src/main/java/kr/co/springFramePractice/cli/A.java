package kr.co.springFramePractice.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;

@Slf4j
public class A {
 @Autowired private B b;
 @Autowired private ApplicationContext context;


    @Primary
    void init(){
        log.info("매ㅗㄴ이몬어ㅣ", context);
    }



    /*@Autowired
    public A(B b){
        this.b = b;
    }*/

}
