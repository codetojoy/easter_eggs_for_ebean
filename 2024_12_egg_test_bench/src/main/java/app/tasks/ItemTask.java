package app.tasks;

import java.util.*;

import models.*;

import io.ebean.*;

public class ItemTask implements Task {
    
    @Override
    public boolean run(Database database) {
        Boolean result = false;

        List<Item> items = DB.find(Item.class)
                             .select("name, id, itemNumber")
                             .findList();

        for (Item item : items) {
            System.out.println("TRACER item: " + item.toString());
        }
        result = true;

        return result;
    }
}
