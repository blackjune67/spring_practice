package kr.co.springFramePractice.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        logger.info("로그를 찍어봅니다.");

        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:mem:test;MODE=MySQL;";

        //JDK10 이상은 var 지원,  Connection => var
        try (Connection connection = DriverManager.getConnection(url, "sa", "");
             Statement statement = connection.createStatement()) {

            connection.setAutoCommit(false);
            statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");

            try {
                statement.executeUpdate("insert into member(username, password) values('DanB', '1234')");
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
            }

            //JDK10 이상은 var 지원,  ResultSet => var
            ResultSet resultSet = statement.executeQuery("select id, username, password from member;");
            while (resultSet.next()) {
                Member member = new Member(resultSet); //Member => var
                //기존의 로그로 찍었던 것을 Member 에서 메소드로 정의해서 출력하도록 변경.
                /*logger.info("sqlTest : /Debug MSG ==> ID : " + id + " userName : " + username + " passWord : " + pw);*/
                logger.info(member.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
