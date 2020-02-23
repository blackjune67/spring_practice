package kr.co.springFramePractice.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;

@Slf4j
//@Configuration
//@ComponentScan(basePackages = "kr.co.springFramePractice.cli")
//@ComponentScan(basePackageClasses = Main.class, excludeFilters = @Filter(type = FilterType.REGEX, pattern = "kr.co.springFramePractice.cli"))
public class Main {
    //private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        log.info("[MAIN] 로그!");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        //ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("kr.co.springFramePractice.cli");
        //ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.register(AppConfig.class);
        context.refresh();
        //context.scan("kr.co.springFramePractice.cli");
        Dao dao = context.getBean(Dao.class);
        dao.run();
        //context.register(AppConfig.class);
        //B b = context.getBean(B.class);
        //log.info("" + b);
        log.info(">>>>>> 데이터 Accept Opp : " + dao);
    }
}