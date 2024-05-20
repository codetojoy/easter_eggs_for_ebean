package net.codetojoy.ebean.app.task;

import java.util.*;

import net.codetojoy.ebean.model.*;

import io.ebean.DB;
import io.ebean.Database;
import io.ebean.annotation.Transactional;

public class CustomerTransactionalTask implements Task {
    
    @Override
    @Transactional
    public boolean run(Database database) {
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
