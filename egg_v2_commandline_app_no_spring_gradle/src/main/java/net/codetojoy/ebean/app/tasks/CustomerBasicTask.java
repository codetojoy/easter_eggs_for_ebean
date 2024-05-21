package net.codetojoy.ebean.app.tasks;

import java.util.*;

import net.codetojoy.ebean.models.*;

import io.ebean.*;

public class CustomerBasicTask implements Task {
    
    @Override
    public boolean run(Database database) {
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
