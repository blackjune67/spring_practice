package kr.co.springFramePractice.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("로그를 찍어봅니다.");

        //Dao dao = new Dao();
        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        //Dao dao = context.getBean("dao",Dao.class); //Dao.class 앞에 "dao" 가 id에 해당.
        //Dao new_dao = context.getBean("new_dao", Dao.class);
        Dao2 dao2 = context.getBean("dao2", Dao2.class);
        //dao.run();
        dao2.run();
    }
}
