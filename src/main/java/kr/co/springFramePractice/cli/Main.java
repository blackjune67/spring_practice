package kr.co.springFramePractice.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        logger.info("로그를 찍어봅니다.");

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");

        System.out.println(context);

        Dao dao = context.getBean("dao",Dao.class);
        //Dao new_dao = context.getBean("new_dao", Dao.class);
        dao.run();
    }

}
