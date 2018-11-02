package school.application.exception;

public class StopApplicationException extends Exception {
    public String getMessage(){
        return "-----Остановка приложения------";
    }
}
