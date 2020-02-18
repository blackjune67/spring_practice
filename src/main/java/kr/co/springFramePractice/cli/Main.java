package kr.co.springFramePractice.cli;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

@Slf4j
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("[MAIN] 로그!");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //context.register(AppConfig.class);
        context.scan("kr.co.springFramePractice.cli");
        context.refresh();
        B b = context.getBean(B.class);
        log.info("" + b);
        context.close();
    }
}