package com.controlInforme.componentes;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VBoxEditar extends VBox {
    public Label ldia,lpublicaciones, lhoras, lrevisitas,lcursos;
    public TextField tdia,tpublicaciones, thoras,trevisitas,tcursos;
    public Button bprueba;

    public VBoxEditar(){
        iniciarComponentes();
        setPadding(new Insets(5,15,5,15));
        setPrefWidth(160);
        setPrefHeight(80);

    }
    public void iniciarComponentes(){

        ldia = new Label("Fecha (yyyy/mm/dd):");
        lpublicaciones= new Label("Publicaciones: ");
        lhoras= new Label("Horas: ");
        lrevisitas= new Label("Revisitas: ");
        lcursos = new Label("Cursos: ");
        tdia = new TextField();
        tpublicaciones= new TextField();
        thoras= new TextField();
        trevisitas = new TextField();
        tcursos= new TextField();
        bprueba= new Button("Guardar cambios");
        bprueba.setUserData("g");

        getChildren().addAll(ldia, tdia,lpublicaciones, tpublicaciones, lhoras, thoras, lrevisitas, trevisitas, lcursos, tcursos,bprueba);
    }



}
