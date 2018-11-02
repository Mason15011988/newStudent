package school.application.config;

import school.application.action.*;
import school.application.search.*;
import school.application.sort.*;

import java.util.HashMap;
import java.util.Map;

public class Config {
    public static Map<Integer,Action> getActions(){
        Map<Integer,Action> action =new HashMap<Integer,Action>();
        action.put(1,new ShowStudentsAction());
        action.put(2, new AddStudentAction());
        action.put(3,new AddMarksStudentAction());
        action.put(4,new RemoveStudentAction());
        action.put(5,new SortStudentsAction());
        action.put(6,new SearchStudentsAction());
        action.put(7,new SaveStudentsInFileAction());
        return action;
    }
    public static Map<Integer, Sort> getSort(){
        Map<Integer,Sort> sort =new HashMap<Integer,Sort>();
        sort.put(1,new SortedId());
        sort.put(2,new SortedName());
        sort.put(3,new SortedAge());
        sort.put(4,new SortedMarks());
        return sort;
    }
    public static Map<Integer, Search> getSearch(){
        Map<Integer,Search> sort =new HashMap<Integer,Search>();
        sort.put(1,new SearchStudentForId());
        sort.put(2,new SearchStudentsForName());
        sort.put(3,new SearchStudentsForAge());
        sort.put(4,new SearchOldStudents());
        sort.put(5,new SearchBestStudents());

        return sort;
    }
}
