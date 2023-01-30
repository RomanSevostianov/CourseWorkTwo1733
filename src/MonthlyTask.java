import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatable {
    public MonthlyTask(String title, String discription, LocalDateTime dateTime, boolean isWork) {
        super(title, discription, dateTime, isWork);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return date.getDayOfMonth()==getDateTime().getDayOfMonth();
    }
}
