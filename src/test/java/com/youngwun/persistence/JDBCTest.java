package com.youngwun.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.fail;

@Log4j
public class JDBCTest {
    static {
        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try {
            Connection con = DriverManager.getConnection
            (
                    // "jdbc:oracle:thin:@localhost:1521:xe",
                    "jdbc:log4jdbc:oracle:thin:@localhost:1521:xe",
                    "book_ex",
                    "12345"
            );
            log.info(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
