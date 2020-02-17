package kr.co.springFramePractice.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class Dao2 {
    private Connection connection;

    public Dao2(Connection connection) {
        this.connection = connection;
    }

    public void run() throws SQLException {
        //JDK10 이상은 var 지원,  Connection => var
        var statement = connection.createStatement();

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
            var resultSet = statement.executeQuery("select id, username, password from member;");
            while (resultSet.next()) {
                Member member = new Member(resultSet); //Member => var
                //기존의 로그로 찍었던 것을 Member 에서 메소드로 정의해서 출력하도록 변경.
                /*logger.info("sqlTest : /Debug MSG ==> ID : " + id + " userName : " + username + " passWord : " + pw);*/
                log.info(member.toString());
            }
        }
    }
