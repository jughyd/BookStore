/*
 * Copyright 2016 rohit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mvc.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.h2.tools.Server;
import static org.junit.Assert.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * JUnit which tests H2 Database connection
 * This test ensures working H2 database connection and should always pass.   
 * @author rohit
 */
public class TestH2DB {

    private Server server;
    private final String jdbcDriver = "org.h2.Driver";
    private final String URL = "jdbc:h2:tcp://localhost/~/test";
    private final String userName = "sa";
    private Connection conn;
    private final static Logger logger = Logger.getLogger(TestH2DB.class.getName());

    /*
     Setup h2 database
     */
    @Before
    public void setUp() {
        try {
            logger.log(Level.INFO, "Starting up database");
            server = Server.createTcpServer().start();
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(URL, userName, "");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getLocalizedMessage());
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, ex.getLocalizedMessage());
        }
    }

    @After
    public void tearDown() {
        logger.log(Level.INFO, "Shutting down database");
        server.stop();
    }

    @Test
    public void testDB() {
        assertTrue("DB Failed", server != null);
        assertTrue("Connection is null", conn != null);
    }
}
