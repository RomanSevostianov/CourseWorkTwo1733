import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Task {


    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static int counter;
    private String title;
    private String discription;
    private LocalDateTime dateTime;
    private int id;

    private boolean isWork;

    public Task(String title, String discription, LocalDateTime dateTime, boolean isWork) {
        this.title = title;
        this.discription = discription;
        this.dateTime = dateTime;
        this.id=++counter;
        this.isWork=isWork;
    }


    public String getTitle() {
        return title;
    }

    public String getDiscription() {
        return discription;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getId() {
        return id;
    }

    public boolean isWork() {
        return isWork;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public void setWork(boolean work) {
        isWork = work;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", dateTime=" + dateTime +
                ", id=" + id +
                ", isWork=" + isWork +
                '}';
    }
}
