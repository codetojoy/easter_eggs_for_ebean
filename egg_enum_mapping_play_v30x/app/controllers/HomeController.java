package controllers;

import models.Computer;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.libs.concurrent.ClassLoaderExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import repository.CompanyRepository;
import repository.ComputerRepository;

import javax.inject.Inject;
import jakarta.persistence.PersistenceException;
import java.util.Map;
import java.util.concurrent.CompletionStage;

/**
 * Manage a database of computers
 */
public class HomeController extends Controller {

    private final ComputerRepository computerRepository;
    private final CompanyRepository companyRepository;
    private final FormFactory formFactory;
    private final ClassLoaderExecutionContext classLoaderExecutionContext;
    private final MessagesApi messagesApi;

    @Inject
    public HomeController(FormFactory formFactory,
                          ComputerRepository computerRepository,
                          CompanyRepository companyRepository,
                          ClassLoaderExecutionContext classLoaderExecutionContext,
                          MessagesApi messagesApi) {
        this.computerRepository = computerRepository;
        this.formFactory = formFactory;
        this.companyRepository = companyRepository;
        this.classLoaderExecutionContext = classLoaderExecutionContext;
        this.messagesApi = messagesApi;
    }

    /**
     * This result directly redirect to application home.
     */
    private Result GO_HOME = Results.redirect(
        routes.HomeController.list(0, "name", "asc", "")
    );

    /**
     * Handle default path requests, redirect to computers list
     */
    public Result index() {
        return GO_HOME;
    }

    public CompletionStage<Result> list(Http.Request request, int page, String sortBy, String order, String filter) {
        // Run a db operation in another thread (using DatabaseExecutionContext)
        return computerRepository.page(page, 10, sortBy, order, filter).thenApplyAsync(list -> {
            // This is the HTTP rendering thread context
            return ok(views.html.list.render(list, sortBy, order, filter, request, messagesApi.preferred(request)));
        }, classLoaderExecutionContext.current());
    }
}
