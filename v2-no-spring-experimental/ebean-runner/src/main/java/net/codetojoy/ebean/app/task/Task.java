package net.codetojoy.ebean.app.task;

import io.ebean.Database;

public interface Task {
    boolean run(Database database);
}
