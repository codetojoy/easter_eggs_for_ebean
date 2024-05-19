package net.codetojoy.ebean.app;

import java.util.*;

import net.codetojoy.ebean.model.*;
import net.codetojoy.ebean.model.Customer;

import io.ebean.DB;
import io.ebean.Database;
import io.ebean.annotation.Transactional;

// for original, see https://github.com/eugenp/tutorials/tree/master/libraries-data-db/src/main/java/com/baeldung/libraries/ebean/app

public class App {
    
    void run() {
        queryCustomers();
    }

    public static void main(String[] args) {
        try {
            App app = new App();
            app.run();
        } catch (Exception ex) {
            System.err.println("caught exception: " + ex.getMessage());
        }
    }

    void queryCustomers() {
        List<Customer> customers = DB.find(Customer.class)
                                     .select("name, id, email")
                                     .findList();

        for (Customer customer : customers) {
            System.out.println("TRACER VICTORY: " + customer.toString());
    
        }
    }
}
