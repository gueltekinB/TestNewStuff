import java.time.*;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        // Create Date Object Java 8 Local Date and LocalTime is immutable
        LocalDate current = LocalDate.now();
        LocalTime thisTime = LocalTime.now();
        LocalDateTime currentDatetime = LocalDateTime.now();

        //Set Date
        LocalDate someDay = LocalDate.of(2021, Month.MAY, 17);

        //Set time
        LocalTime setTime = LocalTime.of(17,17);

        //Set time and Date
        LocalDateTime dateAndTime = LocalDateTime.of(2021, Month.MAY,17, 17, 17 ,17);

        // With operation sets for example the month and plus operation is adding value.
        LocalDateTime ldt = currentDatetime.withMinute(14).withDayOfMonth(3).plusHours(1);
        System.out.println(ldt);
        int year = ldt.getYear();

        //Duration represents nano seconds for precice stuff

        Duration d = Duration.ofDays(1);
        Duration d1 = Duration.ofDays(10);
        long second = d.getNano();
        long modify = d1.minusDays(2).getNano();

        //Period the between function calculates against LocaleDate day against the other that means if first LocaleDate
        // is 12 and the other is 15 then it returns 3, it doesn't matter how the year nor the month is.
        Period p = Period.between(current,someDay);
        System.out.printf("In order to reach 17.05.2021 we need %s year and %s month and %s days", p.getYears(), p.getMonths(), p.getDays());

        //Instant for timestamps
        Instant i = Instant.now();
        long nano = i.getNano();

        //Zone Date and Time the withZoneSameInstant returns the time from zürich converted in LA

        ZoneId basel = ZoneId.of("Europe/Zurich");
        ZoneId la = ZoneId.of("America/Los_Angeles");
        LocalDateTime nowTime = LocalDateTime.now();
        ZonedDateTime baselTime = ZonedDateTime.of(nowTime, basel);
        ZonedDateTime laTime = baselTime.withZoneSameInstant(la);
        System.out.println(laTime);

    }
}
