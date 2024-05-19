package controllers;

import io.ebean.DB;

import models.*;
import play.mvc.*;

import javax.inject.Inject;
import jakarta.persistence.PersistenceException;
import java.util.*;

public class RosterController extends Controller {

    @Inject
    public RosterController() {
    }

    // This is not the "Play ethos" but we just want to test Ebean.
    // (In Play, we want to be async and query the DB on a different thread.)
    public Result list(Http.Request request) {
        List<Roster> rosterList = DB.find(Roster.class).orderBy("id").findList();
        return ok(views.html.roster.render(rosterList));
    }
}
