package kr.co.springFramePractice.cli;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor //인자가 없는 생성자
@AllArgsConstructor //다 있는 생성자
@RequiredArgsConstructor
public class Member {
    private int id;
    @NonNull
    private String username;
    @NonNull
    private String password;

    public Member(ResultSet resultSet) {
            try {
                this.id = resultSet.getInt("id");
                this.username = resultSet.getString("username");
                this.password = resultSet.getString("password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
/*
    @ToString 어노테이션으로 인해 생략 가능.

    @Override
    public String toString() {
        return "sqlTest : /Debug MSG ==> ID : " + id + " userName : " + username + " passWord : " + pw;
    }*/
        }
    }

