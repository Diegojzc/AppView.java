package com.controlInforme.componentes;
import com.controlInforme.util.Imagenes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VBoxDer extends VBox {

    public Button bcalendario, bmes,bnotas,btotales;


    public VBoxDer(){
        iniciarComponentes();

    }
    public void iniciarComponentes(){
        bcalendario = new Button("Calendario");
        bcalendario.setUserData("calendario");
        bcalendario.setAlignment(Pos.CENTER_LEFT);
        bcalendario.setBackground(Background.fill(Color.LIGHTBLUE));
        bcalendario.setTextFill(Color.WHITE);
        bcalendario.setGraphic(Imagenes.getImagen("calendario"));
        bcalendario.setFont(new Font(24));
        tamano(bcalendario);

        bmes = new Button("Nuevo mes");
        bmes.setUserData("mes");
        bmes.setAlignment(Pos.CENTER_LEFT);
        bmes.setBackground(Background.fill(Color.LIGHTBLUE));
        bmes.setTextFill(Color.WHITE);
        bmes.setGraphic(Imagenes.getImagen("mes"));
        bmes.setFont(new Font(24));
        tamano(bmes);


        bnotas = new Button("Notas");
        bnotas.setUserData("notas");
        bnotas.setAlignment(Pos.CENTER_LEFT);
        bnotas.setBackground(Background.fill(Color.LIGHTBLUE));
        bnotas.setTextFill(Color.WHITE);
        bnotas.setGraphic(Imagenes.getImagen("notas"));
        bnotas.setFont(new Font(24));
        tamano(bnotas);

        btotales = new Button("Totales");
        btotales.setUserData("totales");
        btotales.setAlignment(Pos.CENTER_LEFT);
        btotales.setBackground(Background.fill(Color.LIGHTBLUE));
        btotales.setTextFill(Color.WHITE);
        btotales.setGraphic(Imagenes.getImagen("total"));
        btotales.setFont(new Font(24));
        tamano(btotales);


        setSpacing(18);
        setPadding(new Insets(5,0,0,25));



        getChildren().addAll(bcalendario, bmes,bnotas,btotales);

    }
    public void tamano(Button bt){
        bt.setPrefWidth(250);
        bt.setPrefHeight(60);
    }

}
