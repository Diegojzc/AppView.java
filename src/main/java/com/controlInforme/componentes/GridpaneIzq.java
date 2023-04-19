package com.controlInforme.componentes;

import com.controlInforme.util.Imagenes;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GridpaneIzq extends GridPane {

    public Label lpublicaciones, lhoras, lrevisitas, lcursos,lfecha;
    public Label lpnum, lhnum, lrenum, lcurnum;
    public Button sumapub ,restapub, sumahoras, restahoras, sumarev, restarev, sumacur, restacur, bguardar,beditar,bAnadirDia;
    public Time tiempo;
    public Label textos;
    public GridpaneIzq() {
        iniciarComponentes();
    }
    public void iniciarComponentes(){

        lpnum = new Label("0");
        lpnum.setStyle("-fx-text-fill: khaki ;");
        lpnum.setFont(new Font(25));
        lpublicaciones = new Label("Publicaciones: ");
        lpublicaciones.setStyle("-fx-text-fill: lightblue ;");
        lpublicaciones.setFont(new Font(25));
        sumapub = new Button();
        sumapub.setBackground(Background.fill(Color.CORNSILK));
        sumapub.setUserData("sumapub");
        sumapub.setGraphic(Imagenes.getImagen("mas2"));
        restapub = new Button();
        restapub.setBackground(Background.fill(Color.CORNSILK));
        restapub.setUserData("restapub");
        restapub.setGraphic(Imagenes.getImagen("menos1"));

        lhnum = new Label("0.0");
        lhnum.setStyle("-fx-text-fill: khaki ;");
        lhnum.setFont(new Font(25));
        lhoras = new Label("Horas: ");
        lhoras.setStyle("-fx-text-fill: lightblue ;");
        lhoras.setFont(new Font(25));
        sumahoras = new Button();
        sumahoras.setBackground(Background.fill(Color.CORNSILK));
        sumahoras.setUserData("sumahor");
        sumahoras.setGraphic(Imagenes.getImagen("mas2"));
        restahoras= new Button();
        restahoras.setBackground(Background.fill(Color.CORNSILK));
        restahoras.setUserData("restahor");
        restahoras.setGraphic(Imagenes.getImagen("menos1"));

        lrenum = new Label("0");
        lrenum.setStyle("-fx-text-fill: khaki ;");
        lrenum.setFont(new Font(25));
        lrevisitas = new Label("Revisitas: " );
        lrevisitas.setStyle("-fx-text-fill: lightblue ;");
        lrevisitas.setFont(new Font(25));
        sumarev= new Button();
        sumarev.setBackground(Background.fill(Color.CORNSILK));
        sumarev.setUserData("sumarev");
        sumarev.setGraphic(Imagenes.getImagen("mas2"));
        restarev = new Button();
        restarev.setBackground(Background.fill(Color.CORNSILK));
        restarev.setUserData("restarev");
        restarev.setGraphic(Imagenes.getImagen("menos1"));

        lcurnum = new Label("0");
        lcurnum.setStyle("-fx-text-fill: khaki ;");
        lcurnum.setFont(new Font(25));
        lcursos = new Label("Cursos: " );
        lcursos.setStyle("-fx-text-fill:  lightblue ;");
        lcursos.setFont(new Font(25));
        sumacur = new Button();
        sumacur.setBackground(Background.fill(Color.CORNSILK));
        sumacur.setUserData("sumacur");
        sumacur.setGraphic(Imagenes.getImagen("mas2"));
        restacur = new Button();
        restacur.setBackground(Background.fill(Color.CORNSILK));
        restacur.setUserData("restacur");
        restacur.setGraphic(Imagenes.getImagen("menos1"));


        tiempo = new Time();
        lfecha= new Label(tiempo.tiempo());
        lfecha.setFont(new Font(45));
        lfecha.setStyle("-fx-text-fill: darkseagreen ;");

        bguardar = new Button("Guardar");
        bguardar.setFont(new Font(24));
        bguardar.setTextFill(Color.DARKSEAGREEN);
        bguardar.setGraphic(Imagenes.getImagen("guardar"));
        bguardar.setBackground(Background.fill(Color.LIGHTGRAY));
        bguardar.setUserData("guardar");

        beditar = new Button("Eliminar dia");
        beditar.setFont(new Font(24));
        beditar.setTextFill(Color.DARKSEAGREEN);
        beditar.setGraphic(Imagenes.getImagen("eliminar2"));
        beditar.setBackground(Background.fill(Color.LIGHTGRAY));
        beditar.setUserData("eliminarDia");

        bAnadirDia = new Button("Añadir dia");
        bAnadirDia.setFont(new Font(24));
        bAnadirDia.setTextFill(Color.DARKSEAGREEN);
        bAnadirDia.setGraphic(Imagenes.getImagen("editar5"));
        bAnadirDia.setBackground(Background.fill(Color.LIGHTGRAY));
        bAnadirDia.setUserData("anadirDia");

        textos = new Label();
        textos.setFont(new Font(25));
        textos.setStyle("-fx-text-fill: chartreuse ;");


        setVgap(25);
        setHgap(15);
        setPadding(new Insets(25, 5, 5, 5));


        setConstraints(lfecha,0,0);

        setConstraints(lpublicaciones,0,1);
        setConstraints(lpnum,1,1);
        setConstraints(sumapub,2,1);
        setConstraints(restapub,3,1);

        setConstraints(lhoras,0,2);
        setConstraints(lhnum,1,2);
        setConstraints(sumahoras,2,2);
        setConstraints(restahoras,3,2);

        setConstraints(lrevisitas,0,3);
        setConstraints(lrenum,1,3);
        setConstraints(sumarev,2,3);
        setConstraints(restarev, 3,3);

        setConstraints(lcursos,0,4);
        setConstraints(lcurnum,1,4);
        setConstraints(sumacur,2,4);
        setConstraints(restacur,3,4);

        setConstraints(bguardar,0,5);
        setHgrow(bguardar, Priority.NEVER);
        setHgrow(bguardar, Priority.NEVER);

        setConstraints(beditar,1,5);
        setHgrow(beditar, Priority.NEVER);
        setHgrow(beditar, Priority.NEVER);

        setConstraints(bAnadirDia,0,6);
        setHgrow(bAnadirDia, Priority.NEVER);
        setHgrow(bAnadirDia, Priority.NEVER);


        setConstraints(textos,0,7);


        dimension(sumapub);
        dimension(restapub);

        dimension(sumahoras);
        dimension(restahoras);

        dimension(sumarev);
        dimension(restarev);

        dimension(sumacur);
        dimension(restacur);

        setVgrow(lpublicaciones,Priority.NEVER);
        setVgrow(lhoras, Priority.NEVER);
        setVgrow(lrevisitas, Priority.NEVER);
        setVgrow(lcursos, Priority.NEVER);


        setHgrow(lpublicaciones, Priority.NEVER);
        setHgrow(lpnum, Priority.NEVER);
        setHgrow(sumapub, Priority.NEVER);
        setHgrow(restapub, Priority.NEVER);



        getChildren().addAll(lpublicaciones, lpnum, lhoras, lhnum, lrevisitas, lrenum, lcursos, lcurnum,sumapub,restapub,
                sumahoras,restahoras,sumarev,restarev,sumacur,restacur,bguardar,lfecha, textos,beditar,bAnadirDia);

    }

    public void dimension(Button bt) {
        bt.setMaxHeight(Double.MAX_VALUE);
        bt.setMaxWidth(Double.MAX_VALUE);

    }
    public void setEditModel(boolean editModel){
        beditar.setDisable(editModel);

    }
    public void setEditModel1(boolean editModel){

        bAnadirDia.setDisable(editModel);
    }
}
