package Midterm2021;

import java.util.Arrays;

public class Exam {
    private String courseCode;
    private TimeSlot timeSlot;
    private String[] examHalls;
    private int numOfStudents;

    public Exam(String courseCode, TimeSlot timeSlot, String[] examHalls, int numOfStudents) {
        this.courseCode = courseCode;
        this.timeSlot = timeSlot;
        this.examHalls = examHalls;
        this.numOfStudents = numOfStudents;
    }

    public Exam(){
        this("Undefined", null, null, -1);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String[] getExamHalls() {
        return examHalls;
    }

    public void setExamHalls(String[] examHalls) {
        this.examHalls = examHalls;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public boolean isTooCrowded(){
        if(numOfStudents >= 50)
            return true;
        return false;
    }

    private boolean hasConflictWith(Exam e){
        if (this.courseCode != e.courseCode && this.timeSlot.equals(e.timeSlot))
            return true;
        return false;
    }

    public static  int countConflicts(Exam[] e){
        int conflicts = 0;
        for(int i = 0 ; i < e.length ; i++){

            for(int j = 0 ; j < e.length; j++){
                if(e[i].hasConflictWith(e[j]))
                    conflicts++;
            }

        }

        return conflicts/2;
    }

    public void print(){
        this.timeSlot.print();
        System.out.println("Course code: " + this.courseCode +",  Number of students: " + this.numOfStudents);
        System.out.println("Exam halls: " + Arrays.toString(examHalls));

    }


}
