package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<List<User>> {
    public List<User> mapRow(ResultSet rs, int rowNum)
    		throws SQLException {
        List<User> list = new ArrayList<>();
        do {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setNm_add(rs.getString("nm_add"));
            user.setNk_tel(rs.getString("nk_tel"));
            user.setBirthday(rs.getString("birthday"));
            list.add(user);
        } while (rs.next());
        return list;
    }
}
