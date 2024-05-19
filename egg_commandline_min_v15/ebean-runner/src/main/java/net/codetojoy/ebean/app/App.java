package net.codetojoy.ebean.app;

import java.util.*;
import java.util.concurrent.Callable;

// import net.codetojoy.ebean.model.*;

// import io.ebean.DB;
// import io.ebean.Database;
// import io.ebean.annotation.Transactional;

// for original, see https://github.com/eugenp/tutorials/tree/master/libraries-data-db/src/main/java/com/baeldung/libraries/ebean/app

public class App {
    
    void run(Callable<Boolean> task) {
        try {
            boolean result = task.call();
            
            System.out.println("TRACER App.run RESULT: " + result);
        } catch (Exception ex) {
            System.err.println("caught exception: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        App app = new App();
        Callable<Boolean> task = new CustomerTransactionalTask();
        app.run(task);
    }
}
