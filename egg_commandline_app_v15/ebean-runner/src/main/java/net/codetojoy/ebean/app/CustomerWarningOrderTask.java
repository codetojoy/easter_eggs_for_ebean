package net.codetojoy.ebean.app;

import java.util.*;
import java.util.concurrent.Callable;

import net.codetojoy.ebean.model.*;

import io.ebean.DB;

// in Ebean 15.3.0 `.order("name")` generates a deprecation warning
// prefer: `.orderBy("name")`

class CustomerWarningOrderTask implements Callable<Boolean> {
    
    public Boolean call() {
        Boolean result = false;
        List<Customer> customers = DB.find(Customer.class)
                                     .select("name, id, email")
                                     .order("name")
                                     // .orderBy("name")
                                     .findList();

        for (Customer customer : customers) {
            System.out.println("TRACER customer: " + customer.getName());
        }
        result = true;

        return result;
    }
}
