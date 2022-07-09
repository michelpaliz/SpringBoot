package com.Lib;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Conversion {

    static ArrayList<Object> arrayListObj = new ArrayList<Object>();
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private ArrayList<Object> maxSpeed;

    public static <T> ArrayList<Object> arrToArrListObj(T[] SPEEDARRAY) {

        for (T t : SPEEDARRAY) {
            arrayListObj.add(t);
        }
        return arrayListObj;

    }

    /**
     * 
     * @param <T>
     * @param SPEEDARRAY recieves a Generic array
     * @returns an Integer arrayList
     */

    public static <T> ArrayList<Integer> arrToArrList(T[] SPEEDARRAY) {

        for (T t : SPEEDARRAY) {
            arrayList.add((Integer) t);
        }
        return arrayList;

    }

    public String showAll() {
        String concate = "";
        for (Object integer : maxSpeed) {
            concate += (integer + ",");
        }
        return concate;
    }

    /**
     * 
     * @param LocalDate
     * @return gregorianCalendar
     */
    public static GregorianCalendar convertLDtoGre(LocalDate date) {
        GregorianCalendar gc = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        return gc;
    }

}
