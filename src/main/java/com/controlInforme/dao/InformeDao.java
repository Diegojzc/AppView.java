package com.controlInforme.dao;

import com.controlInforme.Informe;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InformeDao{

    private Connection coneccion;


    public InformeDao()throws SQLException{
        connectar();
    }
    public void connectar()throws SQLException {
        String url = "jdbc:sqlite:info.db";
        coneccion = DriverManager.getConnection(url);
        System.out.println("conectado con base de datos");
    }
    public void desconectar()throws SQLException{
        coneccion.close();
    }
    public void addinforme(Informe informe)throws SQLException{
       String sql= "INSERT INTO info(dia, publicaciones, horas, revisitas, cursos) VALUES" +
               "(?,?,?,?,?)";
        PreparedStatement statement= coneccion.prepareStatement(sql);

        statement.setString(1,informe.getTiempo());
        statement.setInt(2, informe.getPublicaciones());
        statement.setDouble(3,informe.getHoras());
        statement.setInt(4,informe.getRevisitas());
        statement.setInt(5,informe.getCursos());
        statement.executeUpdate();
    }
    public List<Informe> verTotales()throws SQLException{
        String sql= "SELECT dia, publicaciones, horas, revisitas, cursos FROM info";
        PreparedStatement statement = coneccion.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();
        List<Informe>informe = new ArrayList<>();
        while (resultado.next()){
            Informe informe1 = new Informe(
                    resultado.getString(1),
                    resultado.getInt(2),
                    resultado.getDouble(3),
                    resultado.getInt(4),
                    resultado.getInt(5)
            );
            informe.add(informe1);

        }
        return informe;
    }
    public List<Informe>datos()throws SQLException{
        String sql= "SELECT publicaciones,horas, revisitas,cursos FROM info";
        PreparedStatement statement = coneccion.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();
        List<Informe> horasInforme= new ArrayList<>();
        while (resultado.next()){
            Informe informe = new Informe(
                    resultado.getInt(1),
                    resultado.getDouble(2),
                    resultado.getInt(3),
                    resultado.getInt(4)


            );
            horasInforme.add(informe);


        }
    return horasInforme;
    }

    public void borrar()throws SQLException{
        String sql= "DELETE FROM info";
        PreparedStatement statement = coneccion.prepareStatement(sql);
       statement.executeUpdate();


    }
    public void modificar(String dia)throws SQLException{

        String sql= "DELETE FROM info WHERE dia = ?";
        PreparedStatement statement = coneccion.prepareStatement(sql);
        statement.setString(1,dia);
        statement.executeUpdate();


    }


}

