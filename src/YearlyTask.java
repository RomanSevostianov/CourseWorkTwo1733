import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task implements Repeatable{
    public YearlyTask(String title, String discription, LocalDateTime dateTime, boolean isWork) {
        super(title, discription, dateTime, isWork);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return date.getDayOfYear()==getDateTime().getDayOfYear();
    }
}
