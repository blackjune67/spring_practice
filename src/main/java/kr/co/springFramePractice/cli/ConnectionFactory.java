package kr.co.springFramePractice.cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    /*public Dao createDao() {
        return new Dao();
    }*/
    private String driverClass;
    private String url;
    private String user;
    private String password;

    public ConnectionFactory(String driverClass, String url, String user, String password) {
        this.driverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection createConnection() throws SQLException {
        //String url = this.url;
        return DriverManager.getConnection(this.url, this.user, this.password);
    }



}
