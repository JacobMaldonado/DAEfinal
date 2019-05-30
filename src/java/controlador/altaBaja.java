/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import persistencia.Conectar;
import java.sql.*;

/**
 *
 * @author CesarTu
 */
public class altaBaja {
    
    Connection conectame;
    Statement statement;
    ResultSet resulset;
    
    public void altaCliente(String unaDeclaracionSQL){
        String declaracionSQL = unaDeclaracionSQL;
        try{
            Conectar objCon = new Conectar();
            
            conectame=objCon.getConnection();
            statement=conectame.createStatement();
            statement.execute(declaracionSQL);
            
            conectame.close();
            }catch(Exception e){e.printStackTrace();}
    }
        public void modificaCliente(String unaDeclaracionSQL){
        String declaracionSQL = unaDeclaracionSQL;
        try{
            Conectar objCon = new Conectar();
            
            conectame=objCon.getConnection();
            statement=conectame.createStatement();
            statement.execute(declaracionSQL);
            
            conectame.close();
            }catch(Exception e){e.printStackTrace();}
    }
    
        public void bajaCliente(String unaDeclaracionSQL){
        String declaracionSQL = unaDeclaracionSQL;
        try{
            Conectar objCon = new Conectar();
            
            conectame=objCon.getConnection();
            statement=conectame.createStatement();
            statement.execute(declaracionSQL);
                                    
            conectame.close();
            }catch(Exception e){e.printStackTrace();}
       }
        public void altaProducto(String unaDeclaracionSQL){
             String declaracionSQL = unaDeclaracionSQL;
        try{
            Conectar objCon = new Conectar();
            
            conectame=objCon.getConnection();
            statement=conectame.createStatement();
            statement.execute(declaracionSQL);
            
            conectame.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        public void bajaProducto(String unaDeclaracionSQL){
            String declaracionSQL = unaDeclaracionSQL;
            try{
                Conectar objCon = new Conectar();

                conectame=objCon.getConnection();
                statement=conectame.createStatement();
                statement.execute(declaracionSQL);

                conectame.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        public void modificaProducto(String unaDeclaracionSQL){
            String declaracionSQL = unaDeclaracionSQL;
            try{
                Conectar objCon = new Conectar();

                conectame=objCon.getConnection();
                statement=conectame.createStatement();
                statement.execute(declaracionSQL);

                conectame.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        public void altaVenta(String unaDeclaracionSQL){
             String declaracionSQL = unaDeclaracionSQL;
        try{
            Conectar objCon = new Conectar();
            
            conectame=objCon.getConnection();
            statement=conectame.createStatement();
            statement.execute(declaracionSQL);
            
            conectame.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
}

