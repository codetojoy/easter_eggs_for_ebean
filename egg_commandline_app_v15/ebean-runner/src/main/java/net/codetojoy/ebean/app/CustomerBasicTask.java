package net.codetojoy.ebean.app;

import java.util.*;
import java.util.concurrent.Callable;

import net.codetojoy.ebean.model.*;

import io.ebean.DB;

class CustomerBasicTask implements Callable<Boolean> {
    
    public Boolean call() {
        Boolean result = false;
        List<Customer> customers = DB.find(Customer.class)
                                     .select("name, id, email")
                                     .findList();

        for (Customer customer : customers) {
            System.out.println("TRACER VICTORY: " + customer.toString());
        }
        result = true;

        return result;
    }
}
