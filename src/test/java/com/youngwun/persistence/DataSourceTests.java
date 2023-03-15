package com.youngwun.persistence;

import jdk.internal.instrumentation.Logger;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/springroot/root-context.xml")
public class DataSourceTests {

    private static final org.apache.log4j.Logger log
            = org.apache.log4j.Logger.getLogger(DataSourceTests.class);

    @Setter(onMethod_ = { @Autowired})
    private DataSource dataSource;

    @Setter(onMethod_ = { @Autowired})
    private SqlSessionFactory sqlSessionFactory;


    @Test
    public void testConnection() {
        try (Connection con = dataSource.getConnection()) {
            log.info(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void sqlSessiontest() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            Connection con = session.getConnection();

            log.info(session);
            log.info(con);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
