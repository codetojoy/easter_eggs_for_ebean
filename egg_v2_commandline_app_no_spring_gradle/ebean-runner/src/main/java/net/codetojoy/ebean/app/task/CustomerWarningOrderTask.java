package net.codetojoy.ebean.app.task;

import java.util.*;

import net.codetojoy.ebean.model.*;

import io.ebean.*;

// in Ebean 15.3.0 `.order("name")` generates a deprecation warning
// prefer: `.orderBy("name")`

public class CustomerWarningOrderTask implements Task { 
    
    @Override
    public boolean run(Database database) {
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
