/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TextoDAO;
import Model.Texto;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vapstor
 */
public class appController {

    public appController() {
        
    }
    
    public static String inverteString(String texto) {
        Texto textRecord = new Texto(texto, "");
        char[] arrayChar = texto.toCharArray();
        char[] arrayCharInvertido = new char[texto.toCharArray().length];
        int j = 0;
        
        
        for (int i = arrayChar.length - 1; i >= 0; i--) {
            arrayCharInvertido[j] = arrayChar[i];
            j++;
        }
        
        textRecord.setTexto(texto);
        textRecord.setTextoInvertido(new String(arrayCharInvertido));
        return textRecord.getTextoInvertido();
    }
    
    public static void salvaTextoBD(String texto, String textoInvertido) throws SQLException, ClassNotFoundException {
        TextoDAO p = new TextoDAO();
        p.salvaTexto(texto, textoInvertido);
    }
    
    public static List todosOsTextos() throws SQLException, ClassNotFoundException {
        TextoDAO p = new TextoDAO();
        return p.retornaTextos();
    }
    
}
