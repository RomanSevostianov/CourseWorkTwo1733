import java.time.LocalDate;
import java.util.*;

public class CalendarService {
    Map<Integer, Task> map = new HashMap<>();


    public boolean addTask (Task task){
        map.put(task.getId(),task);
   return false;
    }
public void removeTask (int id){
        map.remove(id);
}

    public List<Task> getTaskDay(LocalDate date) {
        List<Task> result = new ArrayList<>();
        for (Map.Entry<Integer, Task> entry : map.entrySet()) {
            if (entry.getValue() instanceof Repeatable
                    && (((Repeatable) entry.getValue()).checkIfSuitable(date))
                    || entry.getValue().getDateTime().toLocalDate().equals(date)) {
                result.add(entry.getValue());

            }
        }
        result.sort(Comparator.comparing(Task -> Task.getDateTime()));
        return result;
    }
}
