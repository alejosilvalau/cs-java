package ejercicio6b.utils;

import java.time.format.DateTimeFormatter;

public class DateUtils {
  public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
  public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

  private DateUtils() {
  } // Prevent instantiation and creation of subclasses

}
