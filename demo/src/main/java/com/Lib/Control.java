package com.Lib;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

public class Control {

    private static String userStr;
    private static int usrInt;
    private static boolean correct;

    private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
    private static final Pattern REGEXP1 = Pattern.compile("[0-9]{8}");
    private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };

    /**
     * @param tittle     for your menu
     * @param sentence/s for your choices
     * @returns the value of your choice
     */

    public static int menuGenerator(String tittle, String[] sentence) {
        System.out.println("\n*****************");
        System.out.printf("** %S **\n", tittle);
        System.out.println("*****************\n");
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = String.format("%d %S\n", (i), sentence[i]);
            System.out.println(sentence[i]);
        }
        System.out.println("Choose one option");
        int option = Integer.parseInt(Util.myInput.nextLine());
        boolean correct = option > 0;
        do {
            if (option > sentence.length) {
                System.out.println("Please your answer must be between the range");
                option = -1;
            } else {
                Ansi.clearScreen();
                return option;
            }
        } while (!correct);

        return option;

    }

    /**
     * 
     * @param initializer
     * @param tittle
     * @param sentence
     * @return
     */

    public static int menuGenerator(int initializer, String tittle, String[] sentence) {
        System.out.println("\n*****************");
        System.out.printf("** %S **\n", tittle);
        System.out.println("*****************\n");
        for (int i = initializer; i < sentence.length; i++) {
            sentence[i] = String.format("%d %S\n", (i), sentence[i]);
            System.out.println(sentence[i]);
        }
        System.out.println("Choose one option");
        int option = Integer.parseInt(Util.myInput.nextLine());
        boolean correct = option > 0;
        do {
            if (option > sentence.length) {
                System.out.println("Please your answer must be between the range");
                option = -1;
            } else {
                Ansi.clearScreen();
                return option;
            }
        } while (!correct);

        return option;

    }

    public static int getEdad(GregorianCalendar edad) {
        int anyoNacimiento = edad.get(Calendar.YEAR);
        int mesNacimiento = edad.get(Calendar.MONTH) + 1; //
        int diaNacimiento = edad.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar fecha = new GregorianCalendar();
        int anyoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH) + 1;
        int diaActual = fecha.get(Calendar.DAY_OF_MONTH);

        int edad1 = anyoActual - anyoNacimiento;

        if (mesActual < mesNacimiento) {
            edad1--;
        } else if (mesActual == mesNacimiento) {
            if (diaActual < diaNacimiento) {
                edad1--;
            }
        }
        return edad1;
    }

    /**
     * 
     * @param min introduce the minimum date you want
     * @param max introduce the maximum date you want
     * @return
     */

    public static GregorianCalendar randBirth(int min, int max) {
        GregorianCalendar gc = new GregorianCalendar();

        // we create a date between these two years
        // int year = Lib.randBetween(1900, 2010);
        if (min < 1900) {
            System.out.println("The date needs to be greater than " + min);
        }
        int year = Util.randBetween(min, max);
        // we set the our own year to one gc YEAR
        gc.set(gc.YEAR, year);
        // get a random day of the year
        int dayOfYear = Util.randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        // then we obtain our last item
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        // print out an example(*we need to format this in order to print this
        // correctly)
        // System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" +
        // gc.get(gc.DAY_OF_MONTH));

        return gc;

    }

    /**
     * 
     * @return gregoriancalendar formated () that the user has introduced
     */

    // public static GregorianCalendar birthFormat() {
    // System.out.println(" Fecha (dd-mm-yyyy)");
    // userStr = Util.myInput.nextLine();
    // SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
    // // GregorianCalendar birth = null;
    // do {
    // try {
    // Date date = sdf.parse(userStr);
    // birth = new GregorianCalendar();
    // birth.setTime(date);
    // correct = true;
    // } catch (Exception e) {
    // correct = false;
    // System.out.println("The format that you've introduced is not correct");
    // }

    // } while (!correct);

    // return birth;

    // }

    /**
     * 
     * @return gregoriancalendar formated () that the user has introduced
     */

    public static String birthFormat(GregorianCalendar yourDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");

        String dateFormatted = sdf.format(
                yourDate.getTime());
        return dateFormatted;
    }

    /**
     * 
     * @param <T>
     * @param yourDate
     * @return the formatted date
     */
    public static <T> String dateFormated(T yourDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
        String dateFormatted = sdf.format(
                ((Calendar) yourDate).getTime());
        return dateFormatted;
    }

    /**
     * 
     * @param message  introduce the message you want to ask to the user
     * @param validate validate each one of your validated options
     * @return true if it matches any asnwers and false if it does not.
     */

    public static boolean one(String message, char[] validate) {
        int index = 0;
        System.out.printf(message);
        char c = Util.myInput.nextLine().toLowerCase().charAt(index);
        for (int i = 0; i < validate.length; i++) {
            if (validate[i] == c) {
                correct = true;
            } else {
                correct = false;
            }
        }
        return correct;

    }

    /**
     * 
     * @param message  introduce the message you want to ask to the user
     * @param validate validate the option you want to compare if it is equal to
     *                 other one.
     * @return true if it matches any asnwers and false if it does not.
     */

    public static boolean one(String message, char validate) {
        int index = 0;
        System.out.println(message);
        String validateStr = validate + "";
        validate = validateStr.toLowerCase().charAt(index);
        char c = Util.myInput.nextLine().toLowerCase().charAt(index);
        if (validate == c)
            return true;
        return false;

    }

    public static boolean one(char[] validate, char election) {
        for (int i = 0; i < validate.length; i++) {
            if (validate[i] == election) {
                correct = true;
            } else {
                correct = false;
            }
        }
        return correct;

    }

    /**
     * 
     * @param dni introduce 8 digits for your dni
     * @return the correct char for your dni (String)
     */

    public static String DNIgeneratorChar(int dni) {
        String str = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letra = 'a';
        int result = dni % str.length();
        String dniStr = null;
        dniStr = String.valueOf(dni);
        if (REGEXP1.matcher(dniStr).matches()) {
            letra = str.charAt(result);

        } else {
            System.out.print("Dni invalido\n");
            System.out.println("Presione enter para continuar...");
            Util.myInput.nextLine();
        }
        return dniStr + letra;
    }

    /**
     * 
     * @param dni introduce 8 digits for your dni
     * @return the correct char for your dni (String)
     */

    public static String DNIgeneratorChar(String dni) {
        String str = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letra = 'a';
        // parsing the dni String to int in order to give us the correct mod for the
        // calculation
        int intDni = Integer.parseInt(dni);
        int result = intDni % str.length();
        String dniStr = null;
        // parsing the dni int to String
        dniStr = String.valueOf(dni);
        if (REGEXP1.matcher(dniStr).matches()) {
            letra = str.charAt(result);
        } else {
            System.out.print("Dni invalido\n");
            System.out.println("Presione enter para continuar...");
            Util.myInput.nextLine();
        }
        return dniStr + letra;
    }

    /**
     * 
     * @param dni validates your dni
     * @return true if its correct and false otherwise
     */

    public boolean validateDNI(String dni) {
        return Arrays.binarySearch(INVALIDOS, dni) < 0 // (1)
                && REGEXP.matcher(dni).matches() // (2)
                && dni.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23); // (3)
    }

    /**
     * 
     * @param numStr
     * @returns only digits from the inserted String
     */

    public int strToInt(String numStr) {
        int num = 0;
        try {
            num = Integer.parseInt(numStr);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        return num;
    }

    /**
     * 
     * @return generate a random localDate
     */

    public static LocalDate rndLocalDate() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        LocalDate lt = LocalDate.now();
        int maxDay = lt.getYear();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    /**
     * 
     * @param min the year you wanna put
     * @return a random localDate
     */
    public static LocalDate rndLocalDate(LocalDate min) {
        // long minDay = min.toEpochDay();
        LocalDate lt = LocalDate.now();
        int maxDay = lt.getYear();
        int minDay = min.getYear();
        // long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    } // public static GregorianCalendar birthFormat() {
      // System.out.println(" Fecha (dd-mm-yyyy)");
      // userStr = Util.myInput.nextLine();
      // SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
      // // GregorianCalendar birth = null;
      // do {
      // try {
      // Date date = sdf.parse(userStr);
      // birth = new GregorianCalendar();
      // birth.setTime(date);
      // correct = true;
      // } catch (Exception e) {
      // correct = false;
      // System.out.println("The format that you've introduced is not correct");
      // }

    // } while (!correct);

    // return birth;

    // }
    /**
     * 
     * @param <T>
     * @param values the enum you would like to loop
     * @return the choice you made
     */
    public static <T extends Enum<T>> Enum<T> selectEnum(T[] values) {

        do {
            System.out.println("These are the options avaliable.\nPlease select one of these.");
            for (int i = 0; i < values.length; i++) {
                System.out.println(i + " " + values[i]);
            }
            String message = "Select a number ";
            int choice = Util.validateInt(message, 0, values.length);
            for (int i = 0; i < values.length; i++) {
                if (i == choice) {
                    return values[i];
                } else {
                    correct = false;
                }
            }
            System.out.println("Your choice must be between the range");
        } while (correct);

        return null;

    }

    /**
     * 
     * @param <T>
     * @param options you must to select
     * @return the data that has matched with the input of the user; or null if it
     *         doens't
     */

    public static <T> T checkOptions(String[] option) {
        do {
            System.out.println("Introduce one answer for the avaliable options " + Arrays.toString(option));
            String usr = Util.myInput.nextLine();
            for (int i = 0; i < option.length; i++) {
                if (option[i].equalsIgnoreCase(usr)) {
                    return (T) usr;
                } else {
                    correct = false;
                }
            }
            System.out.println("Please insert a valid option");
        } while (!correct);
        return null;
    }

    /**
     * 
     * @param min LocalDate you want to insert
     * @param max LocalDate youw ant to insert
     * @return random Date between the range
     */

    public static LocalDate rndLD(LocalDate min, LocalDate max) {
        long minDay = LocalDate.of(min.getYear(), min.getMonth(), min.getDayOfMonth()).toEpochDay();
        long maxDay = LocalDate.of(max.getYear(), max.getMonth(), max.getDayOfMonth()).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate rnDate = LocalDate.ofEpochDay(randomDay);
        return rnDate;
    }

    /**
     * 
     * @param dni
     * @return el dni
     */
    public static char letraNIF(int dni) {
        String tabla = "TRWAGMYFPDXBNJZSQVHLCKE";
        int modulo = dni % 23;
        return tabla.charAt(modulo);
    }

}
