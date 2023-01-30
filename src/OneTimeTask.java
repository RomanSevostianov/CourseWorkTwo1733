import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task implements Repeatable{
    public OneTimeTask(String title, String discription, LocalDateTime dateTime, boolean isWork) {
        super(title, discription, dateTime, isWork);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return true;
    }
}
