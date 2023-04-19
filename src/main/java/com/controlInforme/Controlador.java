package com.controlInforme;

import com.controlInforme.componentes.TablaEdificar;
import com.controlInforme.componentes.VBoxEditar;
import com.controlInforme.dao.InformeDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class Controlador implements EventHandler<ActionEvent> {
    public AppView appView;
    TablaEdificar tablaEdificar ;
    VBoxEditar vBoxEditar;

    public Controlador(AppView appView) {
        this.appView = appView;
        tablaEdificar = new TablaEdificar();
        vBoxEditar= new VBoxEditar();
        acciones();

    }

    public void acciones() {
        appView.gridpaneIzq.sumapub.setOnAction(this);
        appView.gridpaneIzq.restapub.setOnAction(this);
        appView.gridpaneIzq.sumahoras.setOnAction(this);
        appView.gridpaneIzq.restahoras.setOnAction(this);
        appView.gridpaneIzq.sumarev.setOnAction(this);
        appView.gridpaneIzq.restarev.setOnAction(this);
        appView.gridpaneIzq.sumacur.setOnAction(this);
        appView.gridpaneIzq.restacur.setOnAction(this);
        appView.gridpaneDer.bcalendario.setOnAction(this);
        appView.gridpaneDer.bmes.setOnAction(this);
        appView.gridpaneDer.bnotas.setOnAction(this);
        appView.gridpaneDer.btotales.setOnAction(this);
        appView.gridpaneIzq.bguardar.setOnAction(this);
        appView.gridpaneDer.bnotas.setOnAction(this);
        appView.gridpaneIzq.beditar.setOnAction(this);
        tablaEdificar.baceptar.setOnAction(this);
        tablaEdificar.baceptar.setOnAction(this);
        appView.gridpaneIzq.bAnadirDia.setOnAction(this);
        vBoxEditar.bprueba.setOnAction(this);

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        String userData = node.getUserData().toString();
        switch (userData) {


            case "sumapub":

                int pub = parseInt(appView.gridpaneIzq.lpnum.getText());
                int pubtotal = pub + 1;

                appView.gridpaneIzq.lpnum.setText(String.valueOf(pubtotal));
                break;

            case "restapub":
                int pub1 = parseInt(appView.gridpaneIzq.lpnum.getText());
                if (pub1 > 0) {
                    int pubtotal1 = pub1 - 1;
                    appView.gridpaneIzq.lpnum.setText(String.valueOf(pubtotal1));
                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR, "Las publicaciones introducidas no pueden ser negativas");
                    alerta.show();
                }

                break;

            case "sumahor":

                double horas1 = Double.parseDouble(appView.gridpaneIzq.lhnum.getText());
                double horasTotal = horas1 + 0.5;
                if (horasTotal > 5) {
                    Alert alerta1 = new Alert(Alert.AlertType.CONFIRMATION, "seguro que tienes mas de " + horasTotal + " de predicacion?");
                    alerta1.show();
                }
                appView.gridpaneIzq.lhnum.setText(String.valueOf(horasTotal));
                break;
            case "restahor":
                double restah = Double.parseDouble(appView.gridpaneIzq.lhnum.getText());
                if (restah > 0) {
                    double restotal = restah - 0.5;
                    appView.gridpaneIzq.lhnum.setText(String.valueOf(restotal));
                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR, "Las horas introducidas no pueden ser negativas");
                    alerta.show();
                }
                break;

            case "sumarev":
                int rev = parseInt(appView.gridpaneIzq.lrenum.getText());
                int revTotal = rev + 1;

                appView.gridpaneIzq.lrenum.setText(String.valueOf(revTotal));
                break;

            case "restarev":
                int resrev = parseInt(appView.gridpaneIzq.lrenum.getText());
                if (resrev > 0) {
                    int resrevTotal = resrev - 1;
                    appView.gridpaneIzq.lrenum.setText(String.valueOf(resrevTotal));
                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR, "Las revisitas introducidas no pueden ser negativas");
                    alerta.show();
                }
                break;

            case "sumacur":
                int cur = parseInt(appView.gridpaneIzq.lcurnum.getText());
                int curTotal = cur + 1;

                appView.gridpaneIzq.lcurnum.setText(String.valueOf(curTotal));
                break;

            case "restacur":
                int rescur = parseInt((appView.gridpaneIzq.lcurnum.getText()));
                if (rescur > 0) {
                    int rescurtotal = rescur - 1;
                    appView.gridpaneIzq.lcurnum.setText(String.valueOf(rescurtotal));
                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR, "Los cursos introducidas no pueden ser negativos");
                    alerta.show();
                    break;

                }
            case "guardar":

                if (appView.gridpaneIzq.lpnum.getText().contains("0") || appView.gridpaneIzq.lhnum.getText().contains("0:0") &&
                        appView.gridpaneIzq.lrenum.getText().contains("0") && appView.gridpaneIzq.lcurnum.getText().contains("0")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "No hay datos registradas para guardar");
                    alert.show();
                } else {
                    LocalDate localDate = LocalDate.now();
                    String tiempo = String.valueOf(localDate);
                    int publicaciones = parseInt(appView.gridpaneIzq.lpnum.getText());
                    double horas = Double.parseDouble(appView.gridpaneIzq.lhnum.getText());
                    int revisitas = parseInt(appView.gridpaneIzq.lrenum.getText());
                    int cursos = parseInt(appView.gridpaneIzq.lcurnum.getText());

                    Informe informe = new Informe(tiempo, publicaciones, horas, revisitas, cursos);

                    try {
                        InformeDao informeDao = new InformeDao();
                        informeDao.addinforme(informe);
                        appView.gridpaneIzq.textos.setText("Datos guardados");
                        appView.gridpaneIzq.lpnum.setText("0");
                        appView.gridpaneIzq.lhnum.setText("0");
                        appView.gridpaneIzq.lrenum.setText("0");
                        appView.gridpaneIzq.lcurnum.setText("0");


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                break;


            case "notas":

                TextArea textos = new TextArea();
                textos.setPrefWidth(455);
                textos.setPrefHeight(250);
                Stage stage = new Stage();
                stage.setTitle("Notas");
                stage.setScene(new Scene(textos));
                stage.show();

                String linea;
                String nuevo = "";
                try {
                    BufferedReader leer = new BufferedReader(new FileReader("notas.txt"));

                    while ((linea = leer.readLine()) != null) {
                        nuevo = nuevo + linea + "\n";
                    }
                    System.getProperty("java.classpath");
                    textos.setText(nuevo);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case "calendario":
                TextArea calendario = new TextArea();
                calendario.setPrefWidth(555);
                calendario.setPrefHeight(250);
                Stage stage1 = new Stage();
                stage1.setTitle("Calendario informe");
                stage1.setScene(new Scene(calendario));
                stage1.show();
                try {
                    InformeDao informeDao = new InformeDao();
                    calendario.setText(String.valueOf(informeDao.verTotales()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "totales":
                TextArea totales = new TextArea();
                totales.setPrefWidth(555);
                totales.setPrefHeight(250);
                LocalDate mes = LocalDate.now();

                Stage stage2 = new Stage();
                stage2.setTitle("Totales informe");
                stage2.setScene(new Scene(totales));
                stage2.show();
                Operaciones operaciones = new Operaciones();
                operaciones.sumaDatos();

                totales.setText("-" + mes.getMonth() + "-" + "\n" + operaciones.sumaDatos());

                break;

            case "mes":
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, " Estas seguro que es nuevo mes?");
                alert.setTitle("Confirmación");

                Optional<ButtonType> opcion = alert.showAndWait();

                if (opcion.get() == ButtonType.OK) {

                    try {
                        InformeDao informeDao = new InformeDao();
                        informeDao.borrar();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else if (opcion.get() == ButtonType.CANCEL) {
                    alert.close();
                }
                break;

            case "eliminarDia":

                Stage stage3 = new Stage();
                stage3.setTitle("Editar informe");
                stage3.setScene(new Scene(tablaEdificar));
                stage3.show();
                appView.gridpaneIzq.setEditModel(true);
                break;

            case "aceptar":
                try {

                    String fecha = tablaEdificar.textField.getText();
                    InformeDao informeDao = new InformeDao();
                    informeDao.modificar(fecha);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION,"Infome eliminado");
                    alert1.setTitle("Confirmar cambio?");
                    alert1.show();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;


            case "anadirDia":


                Stage stage4 = new Stage();
                stage4.setTitle("Añadir dia");
                stage4.setScene(new Scene(vBoxEditar));
                stage4.show();

                break;

            case "g":

                String tiempo = vBoxEditar.tdia.getText();
                int publicaciones = parseInt(vBoxEditar.tpublicaciones.getText());
                double horas = Double.parseDouble(vBoxEditar.thoras.getText());
                int revisitas = parseInt(vBoxEditar.trevisitas.getText());
                int cursos = parseInt(vBoxEditar.tcursos.getText());

                Informe informe = new Informe(tiempo, publicaciones, horas, revisitas, cursos);

                try {

                    vBoxEditar.bprueba.setOnAction(this);
                    InformeDao informeDao = new InformeDao();
                    informeDao.addinforme(informe);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION,"Horas guardadas");
                    alert1.setTitle("Modificar horas");
                    alert1.show();
                    appView.gridpaneIzq.setEditModel1(true);

                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
        }
    }
}
