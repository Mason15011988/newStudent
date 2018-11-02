package school.application.exception;

public class StopSearchException extends Exception {
    public String getMessage(){
        return "-----Остановка приложения поиска------";
    }
}
