package app.tasks;

import java.util.*;

import models.*;

import io.ebean.*;
import io.ebean.annotation.Transactional;

public class ItemTask implements Task {
    private static final long CHECKPOINT_ID = 5150L;

    private void cleanPrevious() {
        List<Item> items = null;
        Database server = DB.getDefault();

        items = DB.find(Item.class)
                  .select("name, id, itemNumber")
                  .findList();

        for (Item item : items) {
            if (item.getId() >= CHECKPOINT_ID) {
                server.delete(item);
            }
        }
    }

    private void createNew() {
        int numNewItems = 10;

        for (int i = 0; i < numNewItems; i++) {
            Item item = new Item();
            item.setId(CHECKPOINT_ID + i);
            item.setName("new-item-" + i + " " + new Date().toString());
            String sql = "insert into item (id, name) values (:id, :name)";

            DB.sqlUpdate(sql)
            .setParameter("id", item.getId())
            .setParameter("name", item.getName())
            .executeNow();
        }
    }

    private void readAll() {
        var items = DB.find(Item.class)
                  .select("name, id, itemNumber")
                  .findList();

        for (Item item : items) {
            System.out.println("TRACER item: " + item.toString());
        }
    }

    @Override
    @Transactional
    public boolean run(Database database) {
        Boolean result = false;

        cleanPrevious();
        createNew();
        readAll();

        result = true;

        return result;
    }
}
