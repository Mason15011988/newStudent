package school.application;

import school.application.action.Action;
import school.application.config.Config;
import school.application.exception.StopApplicationException;
import school.application.utils.UserInput;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private Map<Integer,Action> actions;

    public void start(){
        System.out.println("-----Старт приложения------");
        actions = Config.getActions();
        run();

    }
    private void run(){
        while (true){
            try {
                Action action = getChoiseUser();
                action.execute();
            } catch (StopApplicationException e) {
                System.out.println(e.getMessage());
                break;
            }

        }
    }
    private Action getChoiseUser() throws StopApplicationException {
        System.out.println("Выберите действие из списка");
        showMenu();
        int index = UserInput.getInt();
        if (index==0) throw new StopApplicationException();
        Action action = actions.get(index);
        if (action != null) return action;
        System.out.println("Нет такого действия");
        return getChoiseUser();
    }

    private void showMenu(){
        for (Map.Entry<Integer,Action> item:actions.entrySet()){
            System.out.println(item.getKey()+" - "+item.getValue().getName());
        }
        System.out.println("0 - Выход");
    }

}
