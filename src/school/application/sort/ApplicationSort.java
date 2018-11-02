package school.application.sort;

import school.application.config.Config;
import school.application.exception.StopSortException;
import school.application.utils.UserInput;

import java.util.Map;

public class ApplicationSort {
    private Map<Integer,Sort> sorts;
    public void start(){
        sorts = Config.getSort();
        run();
    }
    private  void run(){
        while (true){
            try {
                Sort sort = getChoiseSort();
                sort.execute();
            } catch (StopSortException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
    private Sort getChoiseSort() throws StopSortException {
        System.out.println("Выберите сортировку из списка");
        showMenu();
        int index = UserInput.getInt();
        if (index==0) throw new StopSortException();
        Sort sort = sorts.get(index);
        if (sort != null) return sort;
        System.out.println("Нет такой сортировки");
        return getChoiseSort();
    }

    private void showMenu(){
        for (Map.Entry<Integer,Sort> item:sorts.entrySet()){
            System.out.println(item.getKey()+" - "+item.getValue().getName());
        }
        System.out.println("0 - Выход из меню сортировки");
    }
}
