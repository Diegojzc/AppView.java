package com.controlInforme;

import com.controlInforme.dao.InformeDao;
import javafx.application.Application;

import javafx.stage.Stage;

import java.sql.SQLException;

public class App extends Application {

   public AppView appView;
   public Controlador controlador;
   public  InformeDao informeDao;

   @Override
   public void init() throws Exception {
       super.init();
       informeDao = new InformeDao();
       informeDao.connectar();
   }
    @Override
    public void start(Stage stage) throws Exception {
        appView = new AppView(stage);
        controlador= new Controlador(appView);

    }
    @Override
    public  void stop() throws Exception{
       super.stop();
       informeDao.desconectar();
    }
    public static void main(String[] args){
        launch();
    }
}
