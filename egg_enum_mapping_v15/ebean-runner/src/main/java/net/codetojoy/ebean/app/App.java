package net.codetojoy.ebean.app;

import java.util.*;

import net.codetojoy.ebean.model.*;

import io.ebean.DB;
import io.ebean.Database;
import io.ebean.annotation.Transactional;

// for original, see https://github.com/eugenp/tutorials/tree/master/libraries-data-db/src/main/java/com/baeldung/libraries/ebean/app

public class App {
    
    void run() {
        queryLeague();
        queryRoster();
    }

    public static void main(String[] args) {
        try {
            App app = new App();
            app.run();
        } catch (Exception ex) {
            System.err.println("caught exception: " + ex.getMessage());
        }
    }

    void queryRoster() {
        List<Roster> roster = DB.find(Roster.class)
                                     .select("id, name, status")
                                     .findList();

        for (Roster rosterMember : roster) {
            System.out.println("TRACER rosterMember: " + rosterMember.toString());
        }
    }

    void queryLeague() {
        List<League> league = DB.find(League.class)
                                     .select("id, name, status")
                                     .findList();

        for (League leagueMember : league) {
            System.out.println("TRACER leagueMember: " + leagueMember.toString());
        }
    }
}
