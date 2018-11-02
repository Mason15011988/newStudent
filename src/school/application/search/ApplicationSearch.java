package school.application.search;

import school.application.config.Config;
import school.application.exception.StopSearchException;
import school.application.utils.UserInput;
import java.util.Map;

public class ApplicationSearch {
    private Map<Integer,Search> searchs;
    public void start(){
        searchs = Config.getSearch();
        run();
    }
    private  void run(){
        while (true){
            try {
                Search search = getChoiseSearch();
                search.execute();
            } catch (StopSearchException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
    private Search getChoiseSearch() throws StopSearchException {
        System.out.println("Выберите вариант поиска из списка");
        showMenu();
        int index = UserInput.getInt();
        if (index==0) throw new StopSearchException();
        Search search = searchs.get(index);
        if (search != null) return search;
        System.out.println("Нет такого варианта поиска");
        return getChoiseSearch();
    }

    private void showMenu(){
        for (Map.Entry<Integer,Search> item:searchs.entrySet()){
            System.out.println(item.getKey()+" - "+item.getValue().getName());
        }
        System.out.println("0 - Выход из меню поиска");
    }
}

