/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Texto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vapstor
 */
public class TextoDAO extends GenericDAO {

    public TextoDAO() throws ClassNotFoundException {
    }
    
    public void salvaTexto(String texto, String textoInvertido) throws SQLException {
        String insert = "INSERT INTO Palavras(Texto, TextoInvertido) VALUES (?, ?)";
        save(insert, texto, textoInvertido);
    }
    
    public List retornaTextos() throws SQLException {
        List listaTextos = new ArrayList();
        String select = "SELECT PalavraInserida FROM Palavras";
        
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Texto texto = new Texto(
                        rs.getString("PalavraInserida")
                );
                listaTextos.add(texto);
            }
            rs.close();
            stmt.close();
        }
        return listaTextos;    
    }
    
    public List retornaTextosInvertidos() throws SQLException {
        List listaTextosInvertidos = new ArrayList();
        String select = "SELECT PalavraInvertida FROM Palavras";
        
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Texto texto = new Texto(
                        rs.getString("PalavraInvertida")
                );
                listaTextosInvertidos.add(texto);
            }
            rs.close();
            stmt.close();
        }
        return listaTextosInvertidos;   
    }
    
}
