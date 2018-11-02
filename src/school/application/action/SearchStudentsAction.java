package school.application.action;

import school.application.search.ApplicationSearch;

public class SearchStudentsAction implements Action {
    private static final String NAME = "Поиск ученика";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        ApplicationSearch applicationSearch = new ApplicationSearch();
        applicationSearch.start();

    }
}
