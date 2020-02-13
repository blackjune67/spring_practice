package kr.co.springFramePractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        System.out.println("안녕하세요 테스트입니다.");
        logger.info("로그를 찍어봅니다.");

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:mem:test;MODE=MySQL;";
            connection = DriverManager.getConnection(url, "sa", "");
            statement = connection.createStatement();

            //connection.setAutoCommit(false);

            statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
            statement.executeUpdate("insert into member(username, password) values('DanB', '1234')");

            ResultSet resultSet = statement.executeQuery("select id, username, password from member;");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String username = resultSet.getString("USERNAME");
                String pw = resultSet.getString("PASSWORD");

                logger.info("sqlTest : /Debug MSG ==> ID : " + id + " userName : " + username + " passWord : " + pw);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
