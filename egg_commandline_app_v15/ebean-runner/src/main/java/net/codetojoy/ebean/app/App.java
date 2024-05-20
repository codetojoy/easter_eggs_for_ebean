package net.codetojoy.ebean.app;

import net.codetojoy.ebean.app.task.*;

import java.util.*;

// for original, see https://github.com/eugenp/tutorials/tree/master/libraries-data-db/src/main/java/com/baeldung/libraries/ebean/app

public class App {
    
    void run(Task task) {
        try {
            boolean result = task.run();
            
            System.out.println("TRACER App.run RESULT: " + result);
        } catch (Exception ex) {
            System.err.println("caught exception: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // -------------------
        // change as desired:

        Task task = new CustomerBasicTask();

        // -------------------
        App app = new App();
        app.run(task);
    }
}
