package com.controlInforme;

import com.controlInforme.componentes.TablaEdificar;
import com.controlInforme.componentes.VBoxDer;
import com.controlInforme.componentes.GridpaneIzq;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AppView {
    public HBox hbox;
    public GridpaneIzq gridpaneIzq;
    public VBoxDer gridpaneDer;

public  AppView(){

}

    public AppView (Stage stage){
        iniciarComponentes();
        Scene scene = new Scene(hbox,1080,570);
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);
        hbox.setBackground(Background.fill(Color.SLATEGRAY));
        stage.setScene(scene);
        stage.setTitle("INFORME DE HORAS 2022-2023");
        stage.show();

    }
    public void iniciarComponentes(){
        gridpaneDer = new VBoxDer();
        gridpaneIzq = new GridpaneIzq();

        hbox= new HBox(gridpaneIzq,gridpaneDer);

    }
}
