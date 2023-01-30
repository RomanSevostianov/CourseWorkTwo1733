import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatable{
    public WeeklyTask(String title, String discription, LocalDateTime dateTime, boolean isWork) {
        super(title, discription, dateTime, isWork);
    }

    public boolean checkIfSuitable (LocalDate date){
        return date.getDayOfWeek()==getDateTime().getDayOfWeek();
    }

}
