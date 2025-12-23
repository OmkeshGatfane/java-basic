package org.example.core;


import java.util.EnumMap;
import java.util.EnumSet;

enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}
public class EnumSetExample {

    public static void main(String[] args) {
        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend Days: " + weekend);

        EnumSet<Day> weekdays = EnumSet.complementOf(weekend);
        System.out.println("Weekdays: " + weekdays);

        EnumSet<Day> weekdaysRange = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println("Weekdays using range: " + weekdaysRange);

        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All Days: " + allDays);

        EnumMap<Day, String> dayDescriptions = new EnumMap<>(Day.class);
        dayDescriptions.put(Day.MONDAY, "Start of the work week");
        dayDescriptions.put(Day.FRIDAY, "End of the work week");
        System.out.println("Day Descriptions: " + dayDescriptions);
    }

}
