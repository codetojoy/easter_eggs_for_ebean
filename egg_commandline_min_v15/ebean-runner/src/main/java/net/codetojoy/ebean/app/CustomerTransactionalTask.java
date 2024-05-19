package net.codetojoy.ebean.app;

import java.util.*;
import java.util.concurrent.Callable;

import net.codetojoy.ebean.model.*;

import io.ebean.DB;
import io.ebean.Database;
import io.ebean.annotation.Transactional;

class CustomerTransactionalTask implements Callable<Boolean> {
    
    public Boolean call() {
        Boolean result = false;

        Customer customer = new Customer();
        customer.setName("Joe Satriani");
        customer.setEmail("satch@boogie.com");

        Database server = DB.getDefault();
        server.save(customer);
        Customer foundCustomer = server.find(Customer.class, customer.getId());

        if (foundCustomer != null) {
            System.out.println("TRACER found customer: " + foundCustomer.toString());
            server.delete(foundCustomer);
            result = true;
        }

        return result;
    }
}
