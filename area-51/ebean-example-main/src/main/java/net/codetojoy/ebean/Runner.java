package net.codetojoy.ebean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.ebean.Database;
import io.ebean.config.UnderscoreNamingConvention;

import net.codetojoy.ebean.models.*;

import javax.sql.DataSource;

public class Runner {

    public static void main(String[] args) {
        DataSource ds = buildDataSource();
        Database ebean = Database.builder().dataSource(ds).namingConvention(new UnderscoreNamingConvention()).build();

        Customer customer = ebean.find(Customer.class).where().eq("id", 5150L).findOne();
        System.out.println("Found c: " + customer.toString());

        System.out.println("ebean shutdown...");
        ebean.shutdown();
        System.out.println("datasource close...");
        ((HikariDataSource) ds).close();
        System.out.println("QED.");
    }

    private static DataSource buildDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(System.getenv("DB_URL"));
        hikariConfig.setUsername(System.getenv("DB_USERNAME"));
        hikariConfig.setPassword(System.getenv("DB_PASSWORD"));
        hikariConfig.setMaximumPoolSize(1);
        hikariConfig.setDriverClassName("org.postgresql.Driver");

        hikariConfig.setAutoCommit(false);

        return new HikariDataSource(hikariConfig);
    }
}
