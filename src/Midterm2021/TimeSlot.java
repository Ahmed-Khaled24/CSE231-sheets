package Midterm2021;

public class TimeSlot {
    private int day;
    private int month;
    private int slotNumber;

    public TimeSlot(int day, int month, int slotNumber) {
        this.day = day;
        this.month = month;
        this.slotNumber = slotNumber;
    }

    public TimeSlot(){
        this(0, 0, 0);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean equals(TimeSlot t) {
        return this.day == t.day && this.month == t.month && this.slotNumber == t.slotNumber;
    }

    public void print(){
        System.out.println("Slot number: " + this.slotNumber + ",  Day: " + this.day + ",  Month: " + this.month);
    }
}


