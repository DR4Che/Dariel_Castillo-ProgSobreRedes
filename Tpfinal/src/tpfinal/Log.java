/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dariel
 */
public class Log {

    public Log() {
    }

    public String Guardar(int tipo, String valor) {
        String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                .format(LocalDateTime.now());
        String texto = "";
        switch (tipo) {
            case 1:
                texto = "" + dateTime + ":-el usuario '"+valor+"' se a conectado";
                break;
            case 2:
                texto = "" + dateTime + ":-el usuario '"+valor+"' se a desconectado";
                break;
            case 5:
                texto = "" + dateTime + ":-el usuario '"+valor+"' escribio";
                break;
            case 3:
                texto = "" + dateTime + ":-Se inicio el servidor";
                break;
            case 4:
                texto = "" + dateTime + ":-Se Cerro el Servidor";
                break;
                default:
                    break;
        }
        return texto;
    }
}
