package net.codetojoy.ebean.app.tasks;

import io.ebean.Database;

public interface Task {
    boolean run(Database database);
}
