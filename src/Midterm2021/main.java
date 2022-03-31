package Midterm2021;

import java.util.Arrays.*;

public class main {
    public static void main(String[] args) {
        Exam[] es = new Exam[]{
                new Exam("cse126", new TimeSlot(1, 4, 5), new
                        String[]{"911", "912"}, 32),
                new Exam("cse116", new TimeSlot(2, 4, 1), new
                        String[]{"912", "942A"}, 40),
                new Exam("hum212", new TimeSlot(1, 4, 5), new
                        String[]{"931", "912"}, 340)
        };

        for (int i = 0; i < es.length; i++) {
            es[i].print();
            System.out.println("IsCrowded:" + es[i].isTooCrowded());
        }
        System.out.println("Number of Conflicts:" + Exam.countConflicts(es));
    }
}
