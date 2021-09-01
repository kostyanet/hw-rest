package pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Statistic {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public final int requests;
    public final String date;

    public Statistic(int requests) {
        this.requests = requests;
        this.date = LocalDateTime.now().format(FORMATTER);
    }
}
