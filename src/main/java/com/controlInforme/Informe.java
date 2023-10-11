package com.controlInforme;


public class Informe {
    public String tiempo;
    public int publicaciones;
    public double horas;
    public int revisitas;
    public int cursos;


    public Informe( String tiempo, int publicaciones, double horas, int revisitas, int cursos) {
        this.tiempo = tiempo;
        this.publicaciones = publicaciones;
        this.horas = horas;
        this.revisitas = revisitas;
        this.cursos = cursos;


    }
    public Informe(int publicaciones, double horas, int revisitas, int cursos ){
        this.publicaciones = publicaciones;
        this.horas=horas;
        this.revisitas= revisitas;
        this.cursos = cursos;
    }
    public Informe(double horas ){

        this.horas=horas;

    }

    public int getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(int publicaciones) {
        this.publicaciones = publicaciones;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public int getRevisitas() {
        return revisitas;
    }

    public void setRevisitas(int revisitas) {
        this.revisitas = revisitas;
    }

    public int getCursos() {
        return cursos;
    }

    public void setCursos(int cursos) {
        this.cursos = cursos;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "\n INFORME:" +
                "\n Dia: " + tiempo  +
                "\n Publicaciones: " + publicaciones  +
                "\n Horas: " + horas +
                "\n Revisita: " + revisitas  +
                "\n Cursos: " + cursos +
                "\n";
    }
}
