/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal;

import utilidades.Encriptar_AES;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Software-Notebook
 */
public class MainCliente {

    static DataInputStream disServidor = null;
    static DataOutputStream dosServidor = null;
    static String clave = "FooBar1234567890"; // 128 bit
    static boolean nickEnviado = true;

    public static void main(String[] args) {

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(is);

        PrintStream ps = new PrintStream(System.out);

        utilidades.Encriptar_AES encriptar = new Encriptar_AES();

        ps.println("INICIANDO EL CLIENTE");

        try {
            InetAddress IP = InetAddress.getByName("localhost");
            int PUERTO = 7777;

            Socket sock = new Socket(IP, PUERTO);
            disServidor = new DataInputStream(sock.getInputStream());
            dosServidor = new DataOutputStream(sock.getOutputStream());

            if (sock.isConnected() && nickEnviado) {
                ps.println("Ingresa tu NICK: ");
                String nickname = buff.readLine();
                dosServidor.writeUTF(nickname);
                nickEnviado = false;

                ps.println("Bienvenido al chat " + nickname);
            }
            ps.print("\t-> ");
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        Thread enviarMensajes = new Thread(
                new Runnable() {
            @Override
            public void run() {
                String msg = "";
                while (true && !msg.equalsIgnoreCase("/salir")) {
                    try {
                        msg = buff.readLine();

                        byte[] iv = new byte[16];
                        encriptar.sr.nextBytes(iv);

                        String msgEnc = encriptar.encriptar(clave, iv, msg);
                        //System.out.println(String.format("encriptado: %s", msgEnc));

                        //dosServidor.writeUTF(iv.toString());
                        dosServidor.writeUTF(msg);
                        ps.print("\t-> ");
                    } catch (IOException ex) {
                        Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }//fin while        
            }//fin run
        }//fin Thread
                ,
                 "ENVIO");
        enviarMensajes.start();

        Thread recibirMensaje = new Thread(
                new Runnable() {
            @Override
            public void run() {
                String msg = "";
                while (true && enviarMensajes.isAlive()) {
                    try {
                        msg = disServidor.readUTF();
                        ps.println(MainServidor.ANSI_YELLOW
                                + msg
                                + MainServidor.ANSI_RESET
                        );
                        ps.print("\t-> ");
                    } catch (IOException ex) {
                        Logger.getLogger("Error en el hilo de recepcion de mensajes" + ex);
                    }
                }//fin while
            }//fin fin
        }//fin Thread
                ,
                 "RECIBO");
        recibirMensaje.start();
    }

}
