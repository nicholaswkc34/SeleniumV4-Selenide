package com.nicholas.manager;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.apache.logging.log4j.Level;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


//===============================================================================================
//@Configuration
//@EnableTransactionManagement

public class DAOManager {

    private JdbcTemplate jdbcTpl;

    // ===============================================================================================
    public DAOManager() {
    }

    // ===============================================================================================
    public synchronized JdbcTemplate getJdbcTpl() {
        return jdbcTpl;
    }

    // ===============================================================================================
    public synchronized void setJdbcTpl(JdbcTemplate jdbcTpl) {
        this.jdbcTpl = jdbcTpl;
    }

    // ===============================================================================================
    public synchronized <T> List<T> executeQuery(final String sql, RowMapper<T> rowMapper) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                return conn.prepareStatement(sql);
            }
        };

        return jdbcTpl.query(psc, rowMapper);
    }
}