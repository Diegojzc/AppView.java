package com.controlInforme.componentes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Time {

    public String tiempo() {

        LocalDate time = LocalDate.now();
        String tiempo1 = String.valueOf(time.format(DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy")));

        char letras = tiempo1.charAt(0);
        tiempo1 = Character.toUpperCase(letras)+ tiempo1.substring(1,tiempo1.length());

        return tiempo1 ;
    }
}
