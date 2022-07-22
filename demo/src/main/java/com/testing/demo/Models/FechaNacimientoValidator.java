package com.testing.demo.Models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.testing.demo.Models.interfaces.IFechaNacimiento;

public class FechaNacimientoValidator implements ConstraintValidator<IFechaNacimiento, LocalDate> {

    private LocalDate date;

    public void initialize(IFechaNacimiento annotation) {
        date = LocalDate.parse(annotation.value());
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (value != null) {
            if (!value.isAfter(date)) {
                valid = false;
            }
        }
        return valid;

        // Calendar dateInCalendar = Calendar.getInstance();
        // dateInCalendar.setTime(value);
        // if (Calendar.getInstance().get(Calendar.YEAR) -
        // dateInCalendar.get(Calendar.YEAR) >= 18) {
        // // LocalDate date =
        // // dateInCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // return true;
        // }
        // return false;
    }

}
