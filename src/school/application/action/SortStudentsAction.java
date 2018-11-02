package school.application.action;

import school.application.sort.ApplicationSort;

public class SortStudentsAction implements Action {
    private static final String NAME = "Сортировка учеников";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
            ApplicationSort applicationSort = new ApplicationSort();
            applicationSort.start();
    }
}
