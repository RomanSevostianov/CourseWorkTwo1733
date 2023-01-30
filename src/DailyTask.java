import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task implements Repeatable{
    public DailyTask(String title, String discription, LocalDateTime dateTime, boolean isWork) {
        super(title, discription, dateTime, isWork);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return true;
    }
}
