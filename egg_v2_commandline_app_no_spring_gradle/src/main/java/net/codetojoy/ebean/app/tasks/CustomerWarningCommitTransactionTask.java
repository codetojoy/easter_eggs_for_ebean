package net.codetojoy.ebean.app.tasks;

import java.util.*;

import net.codetojoy.ebean.models.*;

import io.ebean.*;

// in Ebean 13.25 `commitTransaction` is deprecated
// see https://javadoc.io/doc/io.ebean/ebean-api/13.25.0/io.ebean.api/io/ebean/DB.html
// this code illustrates the migration path: using try-resources

public class CustomerWarningCommitTransactionTask implements Task {
    
    @Override
    public boolean run(Database database) {
        Boolean result = false;

        try (Transaction transaction = DB.beginTransaction()) {
            Customer customer = buildCustomer();

            Database server = DB.getDefault();
            server.save(customer);

            throwPathogenicException();

            transaction.commit();
            System.out.println("TRACER txn commited");
            result = true;
        } catch (Exception ex) {
            // Ebean trace confirms that txn is rolled back here
            System.err.println("TRACER caught ex: " + ex.getMessage());
        }

        return result;
    }

    private void throwPathogenicException() {
        boolean doThrow = true;
    
        if (doThrow) {
            throw new IllegalStateException("mock error happened");
        }
    }

    private Customer buildCustomer() {
        Customer customer = new Customer();
        customer.setId(4140L);
        customer.setName("Wolfgang Van Halen");
        customer.setEmail("wolf@vh.com");

        return customer;
    }
}
