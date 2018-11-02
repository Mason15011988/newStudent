package school.application.action;

public class SaveStudentsInFileAction extends BazeAction implements Action {
    private static final String NAME = "Сохранения ученикок в файл";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        controller.saveStudentsInFile();

    }
}
