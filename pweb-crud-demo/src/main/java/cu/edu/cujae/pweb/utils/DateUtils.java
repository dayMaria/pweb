package cu.edu.cujae.pweb.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Permite la conversion de objetos representados como fechas y horas.
 * <p>
 * La clase está compuesta por un conjunto de métodos estáticos utiles para la
 * conversión de objetos representados como calendarios, fechas-horas, lineas de
 * tiempo, etc..., en otros objetos relacionados con fechas y horas. También
 * contiene métodos de conversion de objetos relacionados con las fechas y las
 * horas en cadenas de caracteres y viceversa entendibles a los usuarios.</p>
 *
 * <p>
 * La clase funciona como una clase de utilidad para realizar conversiones,
 * permitiendo que sea mas facil el uso de objetos relacionados con fechas y
 * horas.
 * </p>
 * <pre>
 * Se incluyen los siguientes metodos de conversion:
 *
 * Conversion de LocalDateTime hacia Calendar
 * Conversion de LocalDateTime hacia Date
 * Conversion de Calendar hacia LocalDateTime
 * Conversion de Date hacia Calendar
 * Conversion de Date hacia LocalDateTime
 * </pre>
 * <p>
 * Los metodos de conversion de Calendar hacia Date y de LocalDateTime hacia
 * LocalDate y LocalTime no se incluyen en los metodos de conversion dado que
 * pueden ser obtenidos de manera directa a traves de los metodos de los
 * propios. Los metodos de convesion de LocalDate y LocalTime hacia
 * LocalDateTime no se incluyen dado que falta informacion para realizar una
 * conversion completa.
 * </p>
 * <p>
 * Se establecen todos los metodos necesarios para la conversion de objetos
 * relacionados con fechas y/o horas en cadenas de caracteres, mantienen la
 * nomenclatura <strong>format</strong>. Se establecen todos los metodos que
 * permiten la conversion de cadenas de caracteres en objetos relacionados con
 * las fechas y/o horas, con la nomenclatura <strong>parseTo...</strong>.</p>
 * <p>
 * Es necesario que a la hora de utilizar los metodos de conversion en cadenas
 * de caracteres y viceversa se utilice correctamente el patron de conversion
 * correcto, o sea para aquellos objetos que pueden almacenar tanto fechas como
 * horas, el patron debe incluirlo, de no ser asi es posible que se pierda
 * informacion durante la conversion o que no pueda ser realizada la
 * conversion.</p>
 *
 *
 * @author Lazaro Cesar del Pino Olivera
 * @since jdk-16.0.1
 * @version 1.0
 */
public class DateUtils {

    /**
     * El patron por defecto para la conversion de solo fechas en cadenas de
     * caracteres.
     */
    public static final String DEFAULT_DATE_PATTERN = "dd/MM/yyyy";

    /**
     * El patron por defecto para la conversion de solo horas en cadenas de
     * caracteres.
     */
    public static final String DEFAULT_TIME_PATTERN = "HH/mm/ss";

    /**
     * El patron por defecto para la conversion de fechas y horas en cadenas de
     * caracteres.
     */
    public static final String DEFAULT_DATE_TIME_PATTERN = "dd/MM/yyyy-HH/mm/ss";

    /**
     * El identificador de la zona horaria por defeto.
     */
    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    /**
     * Patron de conversion de fechas.
     */
    public static String date_pattern = DEFAULT_DATE_PATTERN;

    /**
     * Patron de conversion de horas.
     */
    public static String time_pattern = DEFAULT_TIME_PATTERN;

    /**
     * Patron de conversion de fechas y horas.
     */
    public static String date_time_pattern = DEFAULT_DATE_TIME_PATTERN;

    /**
     * La zona horaria a utilizar por defecto.
     */
    public static ZoneId zone_id = DEFAULT_ZONE_ID;

    /**
     * Establece el nuevo patron de fecha por defecto.
     *
     * @param newDatePattern el nuevo patron a establecer.
     * @throws IllegalArgumentException si el patron de fecha no es valido.
     */
    public static void setDefaultDatePattern(String newDatePattern) throws IllegalArgumentException {
        DateTimeFormatter.ofPattern(newDatePattern);
        date_pattern = newDatePattern;
    }

    /**
     * Establece el nuevo patron de horas por defecto.
     *
     * @param newTimePattern el nuevo patron a establecer.
     * @throws IllegalArgumentException si el patron de hora no es valido.
     */
    public static void setDefaultTimePattern(String newTimePattern) throws IllegalArgumentException {
        DateTimeFormatter.ofPattern(newTimePattern);
        time_pattern = newTimePattern;
    }

    /**
     * Establece el nuevo patron de horas por defecto.
     *
     * @param newDateTimePattern el nuevo patron a establecer.
     * @throws IllegalArgumentException si el patron de fecha-hora no es valido.
     */
    public static void setDefaultDateTimePattern(String newDateTimePattern) throws IllegalArgumentException {
        DateTimeFormatter.ofPattern(newDateTimePattern);
        date_time_pattern = newDateTimePattern;
    }

    /**
     * Establece el patron de zona horario por defecto.
     *
     * @param zoneId la zona horaria a utilizar por defecto.
     */
    public static void setDefaultZoneId(ZoneId zoneId) {
        zone_id = zoneId;
    }

    /**
     * Devuelve un objeto de formato de conversion de fechas de tipo
     * {@link LocalDateTime}
     *
     * @return la instancia del objeto de formato.
     * @throws IllegalArgumentException si el formato no es valido.
     */
    public static DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofPattern(date_time_pattern);
    }

    /**
     * Devuelve un objeto de formato de conversion de fechas de tipo
     * {@link DateFormat} para objetos {@link Date}.
     *
     * @return la instancia del objeto de formato.
     * @throws IllegalArgumentException si el formato no es valido.
     */
    public static DateFormat getDateFormat() {
        return new SimpleDateFormat(date_time_pattern, getDateTimeFormatter().getLocale());
    }

    /**
     * Convierte un objeto de tipo {@link LocalDateTime} en una cadena
     * de caracteres a partir de un patron dado.
     *
     * @param localDateTime la fecha a convertir en cadena de carcateres.
     * @param dateTimePattern el patron de fecha-hora a partir del cual realizar
     * la conversion.
     * @return la cadena de caracteres convertida a partir del patron dado, de
     * lo contrario devuelve <strong>null</strong>.
     */
    public static String format(LocalDateTime localDateTime, String dateTimePattern) {
        if (localDateTime != null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
                return formatter.format(localDateTime);
            } catch (IllegalArgumentException ex) {
            }
        }
        return null;
    }

    /**
     * Convierte un objeto de tipo {@link LocalDateTime} en una cadena
     * de caracteres a partir del patron por defecto.
     *
     * @param localDateTime la fecha a convertir en cadena de caracteres.
     * @return la cadena de caracteres convertida a partir del patron por
     * defecto, de lo contrario devuelve <strong>null</strong>.
     */
    public static String format(LocalDateTime localDateTime) {
        return format(localDateTime, date_time_pattern);
    }

    /**
     * Convierte un objeto de tipo {@link Date} en una cadena de
     * caracteres a partir de un patron dado.
     *
     * @param date la fecha a convertir en cadena de caracteres.
     * @param dateTimePattern el patron a partir del cual realizar la
     * conversion.
     * @return la cadena de caracteres convertida a partir del patron dado, de
     * lo contrario devuelve <strong>null</strong>.
     */
    public static String format(Date date, String dateTimePattern) {
        if (date != null) {
            try {
                DateFormat format = getDateFormat();
                return format.format(date);
            } catch (IllegalArgumentException ex) {
            }
        }
        return null;
    }

    /**
     * Convierte un objeto de tipo {@link Date} en una cadena de
     * caracteres a partir del patron por defecto.
     *
     * @param date la fecha a convertir en cadena de caracteres.
     * @return la cadena de caracteres convertida a partir del patron por
     * defecto, de lo contrario devuelve <strong>null</strong>.
     */
    public static String format(Date date) {
        return format(date, date_time_pattern);
    }

    /**
     * Convierte un objeto de tipo {@link Calendar} en una cadena de
     * caracteres a partir de un patron dado.
     *
     * @param calendar la fecha a convertir en cadena de caracteres.
     * @param dateTimePattern el patron a partir del cual realizar la
     * conversion.
     * @return la cadena de caracteres convertida a partir del patron dado, de
     * lo contrario devuelve <strong>null</strong>.
     */
    public static String format(Calendar calendar, String dateTimePattern) {
        return format(calendar.getTime(), dateTimePattern);
    }

    /**
     * Convierte un objeto de tipo {@link Calendar} en una cadena de
     * caracteres a partir del patron por defecto.
     *
     * @param calendar la fecha a convertir en cadena de caracteres.
     * @return la cadena de caracteres convertida a partir del patron por
     * defecto, de lo contrario devuelve <strong>null</strong>.
     */
    public static String format(Calendar calendar) {
        return format(calendar, date_time_pattern);
    }

    /**
     * Convierte un objeto de tipo {@link LocalDate} en una cadena de
     * caracteres a partir de un patron dado.
     *
     * @param localDate la fecha a convertir en cadena de carcateres.
     * @param datePattern el patron de fecha a partir del cual realizar la
     * conversion.
     * @return la cadena de caracteres convertida a partir del patron dado, de
     * lo contrario devuelve <strong>null</strong>.
     */
    public static String format(LocalDate localDate, String datePattern) {
        if (localDate != null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
                return formatter.format(localDate);
            } catch (IllegalArgumentException ex) {
            }
        }
        return null;
    }

    /**
     * Convierte un objeto de tipo {@link LocalDate} en una cadena de
     * caracteres a partir del patron por defecto.
     *
     * @param localDate la fecha a convertir en cadena de caracteres.
     * @return la cadena de caracteres convertida a partir del patron por
     * defecto, de lo contrario devuelve <strong>null</strong>.
     */
    public static String format(LocalDate localDate) {
        return format(localDate, date_pattern);
    }

    /**
     * Convierte un objeto de tipo {@link LocalTime} en una cadena de
     * caracteres a partir de un patron dado.
     *
     * @param localTime la hora a convertir en cadena de carcateres.
     * @param timePattern el patron de hora a partir del cual realizar la
     * conversion.
     * @return la cadena de caracteres convertida a partir del patron dado, de
     * lo contrario devuelve <strong>null</strong>.
     */
    public static String format(LocalTime localTime, String timePattern) {
        if (localTime != null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timePattern);
                return formatter.format(localTime);
            } catch (IllegalArgumentException ex) {
            }
        }
        return null;
    }

    /**
     * Convierte un objeto de tipo {@link LocalTime} en una cadena de
     * caracteres a partir del patron por defecto.
     *
     * @param localTime la fecha a convertir en cadena de caracteres.
     * @return la cadena de caracteres convertida a partir del patron por
     * defecto, de lo contrario devuelve <strong>null</strong>.
     */
    public static String format(LocalTime localTime) {
        return format(localTime, time_pattern);
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link LocalDateTime} a partir de un patron dado.
     *
     * @param dateTimeString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron dado.
     * @param dateTimePattern el patron con el cual realizar la conversion.
     * @return el objeto de tipo {@link LocalDateTime} si fue
     * convertido, de lo contrario devuelve <strong>null</strong>.
     */
    public static LocalDateTime parseToLocalDateTime(String dateTimeString, String dateTimePattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
            return formatter.parse(dateTimeString, new TemporalQuery<LocalDateTime>() {
                @Override
                public LocalDateTime queryFrom(TemporalAccessor temporal) {
                    return LocalDateTime.from(temporal);
                }
            }
            );
        } catch (IllegalArgumentException ex) {
        }
        return null;
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link LocalDateTime} a partir del patron por defecto.
     *
     * @param dateTimeString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron por defecto.
     * @return el objeto de tipo {@link LocalDateTime} si fue
     * convertido, de lo contrario devuelve <strong>null</strong>.
     */
    public static LocalDateTime parseToLocalDateTime(String dateTimeString) {
        return parseToLocalDateTime(dateTimeString, date_time_pattern);
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link Date} a partir de un patron dado.
     *
     * @param dateTimeString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron dado.
     * @param dateTimePattern el patron con el cual realizar la conversion.
     * @return el objeto de tipo {@link Date} si fue convertido, de lo
     * contrario devuelve <strong>null</strong>.
     */
    public static Date parseToDate(String dateTimeString, String dateTimePattern) {
        try {
            DateFormat format = new SimpleDateFormat(dateTimePattern, getDateTimeFormatter().getLocale());
            return format.parse(dateTimeString);
        } catch (ParseException ex) {
            return null;
        }
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link Date} a partir del patron por defecto.
     *
     * @param dateTimeString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron por defecto.
     * @return el objeto de tipo {@link Date} si fue convertido, de lo
     * contrario devuelve <strong>null</strong>.
     */
    public static Date parseToDate(String dateTimeString) {
        return parseToDate(dateTimeString, date_time_pattern);
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link Calendar} a partir de un patron dado.
     *
     * @param dateTimeString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron dado.
     * @param dateTimePattern el patron con el cual realizar la conversion.
     * @return el objeto de tipo {@link Calendar} si fue convertido,
     * de lo contrario devuelve <strong>null</strong>.
     */
    public static Calendar parseToCalendar(String dateTimeString, String dateTimePattern) {
        return convertFromDateToCalendar(parseToDate(dateTimeString, dateTimePattern));
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link Calendar} a partir del patron por defecto.
     *
     * @param dateTimeString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron por defecto.
     * @return el objeto de tipo {@link Calendar} si fue convertido,
     * de lo contrario devuelve <strong>null</strong>.
     */
    public static Calendar parseToCalendar(String dateTimeString) {
        return parseToCalendar(dateTimeString, date_time_pattern);
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link LocalDate} a partir de un patron dado.
     *
     * @param dateString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron dado.
     * @param datePattern el patron con el cual realizar la conversion.
     * @return el objeto de tipo {@link LocalDate} si fue convertido,
     * de lo contrario devuelve <strong>null</strong>.
     */
    public static LocalDate parseToLocalDate(String dateString, String datePattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
            return formatter.parse(dateString, new TemporalQuery<LocalDate>() {
                @Override
                public LocalDate queryFrom(TemporalAccessor temporal) {
                    return LocalDate.from(temporal);
                }
            }
            );
        } catch (IllegalArgumentException ex) {
        }
        return null;
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link LocalDate} a partir del patron por defecto.
     *
     * @param dateString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron por defecto.
     * @return el objeto de tipo {@link LocalDate} si fue convertido,
     * de lo contrario devuelve <strong>null</strong>.
     */
    public static LocalDate parseToLocalDate(String dateString) {
        return parseToLocalDate(dateString, date_pattern);
    }

    /**
     * Convierte una cadena de caracteres que representa una hora en un objeto
     * de tipo {@link LocalTime} a partir de un patron dado.
     *
     * @param timeString la cadena de caracteres que representa una hora en
     * concreto, con el formato igual al patron dado.
     * @param timePattern el patron con el cual realizar la conversion.
     * @return el objeto de tipo {@link LocalTime} si fue convertido,
     * de lo contrario devuelve <strong>null</strong>.
     */
    public static LocalTime parseToLocalTime(String timeString, String timePattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timePattern);
            return formatter.parse(timeString, new TemporalQuery<LocalTime>() {
                @Override
                public LocalTime queryFrom(TemporalAccessor temporal) {
                    return LocalTime.from(temporal);
                }
            }
            );
        } catch (IllegalArgumentException ex) {
        }
        return null;
    }

    /**
     * Convierte una cadena de caracteres que representa una hora en un objeto
     * de tipo {@link LocalTime} a partir del patron por defecto.
     *
     * @param timeString la cadena de caracteres que representa una hora en
     * concreto, con el formato igual al patron por defecto.
     * @return el objeto de tipo {@link LocalTime} si fue convertido,
     * de lo contrario devuelve <strong>null</strong>.
     */
    public static LocalTime parseToLocalTime(String timeString) {
        return parseToLocalTime(timeString, time_pattern);
    }

    /**
     * Establece si una cadena de caracteres que representa una fecha, es valida
     * con un patron dado.
     *
     * @param dateTimeString la cadena de caracteres que representa una fecha.
     * @param dateTimePattern el patron a partir del cual esta organizada la
     * cadena de caracteres.
     * @return <strong>true</strong> si la cadena de carcateres es una cadena
     * valida a partir del patron dado, de lo contrario devuelve
     * <strong>false</strong>.
     */
    public static boolean validDate(String dateTimeString, String dateTimePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        if (formatter != null) {
            return formatter.parse(dateTimeString) != null;
        }
        return false;
    }

    /**
     * Establece si una cadena de caracteres que representa una fecha, es valida
     * a partir del patron por defecto.
     *
     * @param dateTimeString la cadena de caracteres que representa una fecha.
     * @return <strong>true</strong> si la cadena de carcateres es una cadena
     * valida a partir del patron por defecto, de lo contrario devuelve
     * <strong>false</strong>.
     */
    public static boolean validDate(String dateTimeString) {
        return validDate(dateTimeString, date_time_pattern);
    }

    /**
     * Convierte un objeto de tipo LocalDateTime a un objecto de tipo Calendar.
     *
     * @param localDateTime el objeto de tipo LocalDateTime a convertir.
     * @return la instancia del objeto Calendar convertida desde LocalDateTime.
     */
    public static Calendar convertFromLocalDateTimeToCalendar(LocalDateTime localDateTime) {
        return GregorianCalendar.from(localDateTime.atZone(zone_id));
    }

    /**
     * Convierte un objeto de tipo Calendar a un objeto de tipo LocalDateTime.
     *
     * @param calendar la instancia del objeto Calendar a convertir.
     * @return la instancia del objeto LocalDateTime convertido desde Calendar.
     */
    public static LocalDateTime convertFromCalendarToLocalDate(Calendar calendar) {
        return calendar.toInstant().atZone(zone_id).toLocalDateTime();
    }

    /**
     * Convierte un objeto de tipo LocalDateTime en un objeto de tipo Date.
     *
     * @param localDateTime el objeto LocalDateTime a convertir.
     * @return el objeto Date convertido.
     */
    public static Date convertFromLocalDateToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(zone_id).toInstant());
    }

    /**
     * Convierte un objeto de tipo Date en un objeto de tipo LocalDateTime.
     *
     * @param date el objeto de tipo Date a convertir.
     * @return el objeto de tipo LocalDateTime convertido.
     */
    public static LocalDateTime convertFromDateToLocalDate(Date date) {
        return date.toInstant().atZone(zone_id).toLocalDateTime();
    }

    /**
     * Convierte un objeto de tipo Date en un objeto de tipo Calendar.
     *
     * @param date el objeto de tipo Date a convertir.
     * @return la instancia del objeto de tipo Calendar convertida.
     */
    public static Calendar convertFromDateToCalendar(Date date) {
        return GregorianCalendar.from(date.toInstant().atZone(zone_id));
    }
}
