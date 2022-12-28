package dreamjob;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Go to http://localhost:8080/index");
    }

/*    @Bean
    public BasicDataSource loadPool() {
        Properties cfg = loadDbProperties();
        BasicDataSource pool = new BasicDataSource();
        pool.setDriverClassName(cfg.getProperty("driver-class-name"));
        pool.setUrl(cfg.getProperty("url"));
        pool.setUsername(cfg.getProperty("username"));
        pool.setPassword(cfg.getProperty("password"));
        pool.setMinIdle(5);
        pool.setMaxIdle(10);
        pool.setMaxOpenPreparedStatements(100);
        return pool;
    }*/

    @Bean
    public BasicDataSource loadPoolTest() {
        Properties cfg = loadDbPropertiesTest();
        BasicDataSource pool = new BasicDataSource();
        pool.setDriverClassName(cfg.getProperty("driver-class-name"));
        pool.setUrl(cfg.getProperty("url"));
        pool.setUsername(cfg.getProperty("username"));
        pool.setPassword(cfg.getProperty("password"));
        pool.setMinIdle(5);
        pool.setMaxIdle(10);
        pool.setMaxOpenPreparedStatements(100);
        return pool;
    }

/*    private Properties loadDbProperties() {
        Properties cfg = new Properties();
        try (InputStream io = new FileInputStream("db/liquibase.properties")) {
            cfg.load(io);
            Class.forName(cfg.getProperty("driver-class-name"));
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException();
        }
        return cfg;
    }*/

    private Properties loadDbPropertiesTest() {
        Properties cfg = new Properties();
        try (InputStream io = new FileInputStream("db/liquibase_test.properties")) {
            cfg.load(io);
            Class.forName(cfg.getProperty("driver-class-name"));
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException();
        }
        return cfg;
    }
}
