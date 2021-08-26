package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDate deadline;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String description, String by) {
        super(description);
        try {
            this.deadline = LocalDate.parse(by);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Bad date format. Please input as yyyy-mm-dd.");
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline.format(formatter) + ")";
    }

    public String saveData() {
        return "D | " + this.getStatusIcon() + " | " + description + " | " + deadline;
    }
}