package by.itacademy.laboratory.week.first.task2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clerk {

    private int amount100;
    private int amount50;
    private int amount25;

    public boolean sellTicket(Note note) {
        boolean result = true;
        switch (note) {
            case NOTE_25:
                amount25++;
                break;
            case NOTE_50:
                if (amount25 > 0) {
                    amount25--;
                    amount50++;
                } else {
                    result = false;
                }
                break;
            case NOTE_100:
                if (amount25 > 0 && amount50 > 0) {
                    amount25--;
                    amount50--;
                    amount100++;
                } else if (amount25 > 3) {
                    amount25 -= 3;
                    amount100++;
                } else {
                    result = false;
                }
                break;
            default:
                throw new IllegalArgumentException("Can not handle note: " + note);
        }

        return result;
    }
}
