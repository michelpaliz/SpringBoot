package com.Lib;

import java.util.Scanner;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Util {

    public static Scanner myInput = new Scanner(System.in);
    public static Random r = new Random();
    private static boolean correct = true;

    public static void pause() {
        System.out.println("Press enter to continue ....");
        myInput.nextLine();
    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static double randomDouble(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static void clearScreen() {
        System.out.println("\u000C");
    }

    public static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * 
     * @param message
     * @param max
     * @param min
     * @return
     */

    public static int validateInt(String message, int min, int max) {
        int userInt = 0;
        do {
            try {
                System.out.println(message);
                userInt = myInput.nextInt();
                // userInt = Integer.parseInt(Util.myInput.nextLine());
                if (correct = userInt >= min && userInt <= max) {
                    correct = true;
                } else {
                    System.out.println("The number must be between" + min + " and " + max);
                    correct = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error");
                Util.pause();
            }

        } while (!correct);
        return userInt;
    }

    /**
     * 
     * @param userDb
     * @return DOUBLE
     */
    public static double validateDouble(String message) {
        double userDouble = 0;
        do {
            try {
                System.out.println(message);
                userDouble = myInput.nextDouble();
                // userDouble = Double.parseDouble(Util.myInput.nextLine());
                correct = true;
            } catch (NumberFormatException e) {
                System.out.println("Error");
                Util.pause();
            }

        } while (!correct);
        return userDouble;
    }

    public String validateString1(String userStr) {
        userStr = null;
        String compare = "";
        do {
            correct = userStr.equals(compare);
            System.out.println("Introduce un String ");
            try {
                userStr = Util.myInput.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: El input no es un String");
                correct = false;
            }

        } while (!correct);
        return userStr;
    }

    /**
     * 
     * @param message
     * @param minLenght
     * @param maxLenght
     * @return
     */

    public static String validateString2(String message, int minLenght, int maxLenght) {
        String userStr;
        // No se inicializa porque este
        // si data hubiera sido un atributo hubiese sido inicializado como null
        do {
            System.out.print(message);
            userStr = Util.myInput.nextLine();
            correct = userStr.length() >= minLenght && userStr.length() <= maxLenght;
            if (!correct) {
                System.out.printf("Longitud minima %d, maxima %d \n", minLenght, maxLenght);
                Util.pause();
            }

        } while (!correct);
        return userStr;
    }

    /**
     * 
     * @return
     */

    public static int[] validateArray() {
        System.out.println("***VALIDACION DE UN ARRAY DE ENTEROS***");
        System.out.println("Introduce la longitud  del array");
        int userInt;
        int array[] = new int[myInput.nextInt()];

        try {
            String message = ("Introduce un numero para el array ");
            for (int i = 0; i < array.length; i++) {
                int userInt1 = 0;
                do {
                    System.out.print(message);
                    try {
                        userInt1 = Integer.parseInt(Util.myInput.nextLine());
                        Util.correct = true;
                        Util.pause();
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El input no es un integer");
                        Util.pause();
                        Util.correct = false;
                    }

                } while (!Util.correct);
                userInt = userInt1;
                array[i] = (userInt + (i + 1));
            }

            // estos errores no tendrian que estar controlados porque son evitables

        } catch (Exception e) {
            System.out.println("El dato tiene que ser de tipo integer");
        }
        return array;
    }

    // min y max numeros aleatorios a generar
    public static void fillArrayRandom(int[] array, int min, int max) {

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(max - min + 1) + min;

        }

    }

    /**
     * 
     * @param date
     * @return date formated with hour minute and seconds
     */
    public String dateFrmTime(LocalDate date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(date);
    }

    /**
     * 
     * @param date
     * @return date formatted only with year
     */
    public static String dateFrmYear(LocalDate date) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dt.format(date);
    }

    /**
     * 
     * @param date
     * @return date formatted only with year
     */
    public static String dateFrmYear(Date date) {
        if (date != null) {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            return dt.format(date);
        }
        return null;
    }

    /**
     * 
     * @param Gregorian calendar
     * @return date formatted only with year
     */
    public static String dateFrmYear(GregorianCalendar date) {
        if (date != null) {
            try {
                SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
                dt.setCalendar(date);
                return dt.format(date.getTime());
            } catch (StackOverflowError sf) {
                sf.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 
     * @return a class that represents an immutable universally unique identifier
     *         (UUID). A UUID represents a 128-bit value.
     */

    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static String checkAnswer(String option1, String option2) {
        String user = "";
        do {
            System.out.println("Please write these two avaliable options " + (option1) + " " + option2);
            user = Util.myInput.nextLine();
            if (user.equalsIgnoreCase(option1)) {
                return option1;
            } else if (user.equalsIgnoreCase(option2)) {
                return option2;
            } else {
                System.out
                        .println("Your answer must match with the avaliable options.\nPlease write again your option.");
                correct = false;
            }
        } while (correct = true);
        return "Error";
    }

    public static char letraNIF(int dni) {
        String tabla = "TRWAGMYFPDXBNJZSQVHLCKE";
        int modulo = dni % 23;
        return tabla.charAt(modulo);
    }

    public static boolean validarNIF(String nif) {
        if (nif != null && nif.length() >= 2) {
            nif = nif.toUpperCase();
            StringBuilder dniString = new StringBuilder();
            // Cogemos como letra el último caracter del NIF
            char letra = nif.charAt(nif.length() - 1);
            char c;
            for (int i = 0; i < nif.length(); i++) {
                // Si es un dígito lo añadimos a dniString
                c = nif.charAt(i);
                if (Character.isDigit(c)) {
                    dniString.append(c);
                }
            }
            return !dniString.toString().equals("") && letra == letraNIF(Integer.parseInt(dniString.toString()));
        }
        return false;
    }

}
