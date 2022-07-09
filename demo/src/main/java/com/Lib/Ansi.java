package com.Lib;

import java.util.IllegalFormatException;

public class Ansi {
    public enum Color {
        BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN, WHITE, NONE
    }

    public enum ColorType {
        FOREGROUND, BACKGROUND
    }

    public static final String ESC = "\u001b[";
    public static final String RESET = ESC + "0m";

    public static final String HIGH_INTENSITY = ESC + "[1m";
    public static final String LOW_INTESITY = ESC + "[2m";
    public static final String ITALIC = ESC + "[3m";
    public static final String UNDERLINE = ESC + "[4m";
    public static final String BLINK = ESC + "[5m";
    public static final String RAPID_BLINK = ESC + "[6m";
    public static final String REVERSE_VIDEO = ESC + "[7m";
    public static final String INVISIBLE_TEXT = ESC + "[8m";

    private Ansi() {
    }

    public static Color randomColor() {
        int min = 0;
        int max = Color.values().length - 1;
        int alea = Util.randBetween(min, max);
        return Color.values()[alea];
    }

    public static void print(char c, Color fg, Color bg) {
        printTo(c, -1, -1, false, fg, bg);
    }

    public static void printTo(char c, int col, int row) {
        printTo(c, col, row, false, Color.NONE, Color.NONE);
    }

    public static void printTo(char c, int col, int row, boolean bold, Color fg, Color bg) {
        String color = getColorStr(bold, fg, bg);
        if (row > 0 || col > 0)
            System.out.print(ESC + row + ";" + col + "f");
        System.out.print(color + c);
        if (!color.isEmpty())
            System.out.print(RESET);
        System.out.flush();
    }

    private static String getColorStr(boolean bold, Color fg, Color bg) {
        String fgColor = getColor(fg, ColorType.FOREGROUND);
        String bgColor = getColor(bg, ColorType.BACKGROUND);
        String negrita = (bold ? "1" : "0");
        String color = "";
        if (!fgColor.isEmpty() || !bgColor.isEmpty()) {
            color = ESC + negrita;
            color += (!fgColor.isEmpty() ? ";" + fgColor : "");
            color += (!bgColor.isEmpty() ? ";" + bgColor : "");
            color += "m";
        }
        return color;
    }

    public static String format(String s, boolean bold, Color fg, Color bg, Object... args)
            throws IllegalFormatException {
        String color = getColorStr(bold, fg, bg);
        return color + String.format(s, args) + RESET;
    }

    public static void printf(String s, boolean bold, Color fg, Color bg, Object... args)
            throws IllegalFormatException {
        String color = getColorStr(bold, fg, bg);
        // String text = String.format(s, args);
        System.out.printf(color + s, args);
        System.out.print(RESET);
        System.out.flush();
    }

    public static String getColor(Color c, ColorType ct) {
        String result = "";
        if (c != Color.NONE) {
            switch (ct) {
                case FOREGROUND:
                    result = "3" + c.ordinal();
                    break;
                case BACKGROUND:
                    result = "4" + c.ordinal();
                    break;
            }
        }
        return result;
    }

    public static void clearScreen() {
        System.out.print(ESC + "H");
        System.out.print(ESC + "2J");
        System.out.flush();
    }

    public static void hideCursor() {
        System.out.print(ESC + "?25l");
        System.out.flush();
    }

    public static void showCursor() {
        System.out.print(ESC + "?25h");
        System.out.flush();
    }

    public static void cleanScreen() {
    }

}
