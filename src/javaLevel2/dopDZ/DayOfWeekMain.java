package javaLevel2.dopDZ;

public class DayOfWeekMain {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
    }

    private static int getWorkingHours(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                return 40;
            case TUSDAY:
                return 32;
            case WENSDEY:
                return 24;
            case THURSDAY:
                return 16;
            case FRIDAY:
                return 8;
            default:
                return 40;
        }
    }
}
