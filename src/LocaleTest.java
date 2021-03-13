import sun.util.resources.LocaleData;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocaleTest {

    public static void main(String[] args) throws ParseException {
        BigDecimal bg = BigDecimal.valueOf(2.99);
        Double d = 2.1;
        int quantity = 3;
        Locale locale = new Locale("en", "GB");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        NumberFormat percentageFormat = NumberFormat.getPercentInstance(locale);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        // Format Number to Locale
        String currency = currencyFormat.format(bg);
        String percentage = percentageFormat.format(d);
        String quantityPrimitve = numberFormat.format(quantity);
        System.out.printf("%s, %s, %s%n", currency, percentage, quantityPrimitve);

        //Format "Locale" back to Number
        Double bgBack = (Double) currencyFormat.parse(currency);
        Double dBack = (Double) percentageFormat.parse(percentage);
        int pBack = numberFormat.parse(quantityPrimitve).intValue();

        System.out.printf("%d, %f, %f%n", pBack, dBack, bgBack);

        //Formatting Date with Locale
        LocalDate localeDate = LocalDate.now();
        DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("EEEE dd MMM yyyy",locale);
        String result = localeDate.format(dFormatter);

        System.out.println(result);

        localeDate = LocalDate.parse("Tuesday 31 Mar 2020", dFormatter);
        locale = new Locale(Locale.JAPAN.getLanguage());
        dFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(locale);
        result = dFormatter.format(localeDate);
        System.out.println(result);

    }
}
