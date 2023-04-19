package com.controlInforme.componentes;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TablaEdificar extends VBox {

    public Label label;
    public TextField textField;
    public Button baceptar;
    public TablaEdificar(){

        iniciarComponentes();
    }
    public void iniciarComponentes()
    {
        label = new Label("Fecha a modificar (yyyy-mm-dd): ");
        textField = new TextField();
        baceptar = new Button("Aceptar");
        baceptar.setUserData("aceptar");
        getChildren().addAll(label, textField, baceptar);
        setSpacing(5);
        setPadding(new Insets(5,10,5,10));
        setPrefWidth(230);
        setPrefHeight(60);


    }

}
