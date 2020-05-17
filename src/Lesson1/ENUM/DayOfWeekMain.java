package Lesson1.ENUM;

public class DayOfWeekMain {
    static final int WORKING_DAYS = 5;
    static final int WORKING_HOURS = 8;
    public static void main(String[] args) {

        System.out.println(getWorkingHours(DayOfWeek.MONDAY) + " рабочих часов до конца недели");
    }
    public static int getWorkingHours(DayOfWeek day){
        if (day.ordinal() == 5 || day.ordinal() == 6){
            System.out.println("Сегодня выходной");
            return 0;
        }
        return (WORKING_DAYS - day.ordinal()) * WORKING_HOURS;
    }
}
