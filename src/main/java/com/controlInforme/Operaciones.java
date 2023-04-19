package com.controlInforme;

import com.controlInforme.dao.InformeDao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Operaciones {


    public String sumaDatos() {
        double sumas=0;
        int sumaP = 0;
        int sumaR = 0;
        int sumaC = 0;

        try {
            InformeDao informeDao = new InformeDao();
            List<Informe> horas = informeDao.datos();

            for (Informe n : horas) {

                List<Double> hor = Collections.singletonList(n.getHoras());
                for (int i = 0; i < hor.size(); i++) {
                    sumas += hor.get(i);
                    System.out.println( hor.get(i));
                }

                List<Integer> horpub = Collections.singletonList(n.getPublicaciones());
                for (int j = 0; j < horpub.size(); j++) {
                    sumaP += horpub.get(j);
                }

                List<Integer> horrev = Collections.singletonList(n.getRevisitas());
                for (int h = 0; h < horrev.size(); h++) {
                    sumaR += horrev.get(h);
                }
                List<Integer> horcur = Collections.singletonList(n.getCursos());
                for (int k = 0; k < horcur.size(); k++) {
                    sumaC+= horcur.get(k);
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Horas: " + sumas+"\n"+ "Publicaciones: "+ sumaP+ "\n" + "Revisitas: " + sumaR+"\n" + "Cursos: "+ sumaC;
    }
    }



