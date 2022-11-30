/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Software-Notebook
 */
public class MainServidor {
    
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_MAGENTA = "\u0033[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    static String clave = "FooBar1234567890"; // 128 bit
    static ArrayList<Cliente> ClientesConectados = new ArrayList<Cliente>();
    
    public static void main(String[] args) {
        
        PrintStream ps = new PrintStream(System.out);
        
        ps.println("INICIANDO SERVIDOR");
        Servidor inicio = new Servidor();
        inicio.setName("SERVIDOR");
        
        inicio.start();
        
    }
    
} // fin class principal

class Cliente implements Runnable {
    
    String nickName = "";
    Socket sock;
    Thread hilo;
    
    final DataInputStream disCliente;
    final DataOutputStream dosCliente;
    boolean isConected;
    
    public Cliente(Socket sock, String nick, DataInputStream in, DataOutputStream out) {
        this.nickName = nick;
        this.sock = sock;
        this.disCliente = in;
        this.dosCliente = out;
        
        this.isConected = true;
        this.hilo = new Thread(this, nickName);
    }
    
    @Override
    public void run() {
        
        String msgRecibido = "";
        String msg = "";
        String cli = "";
        while (sock.isConnected() && this.isConected) {
            
            try {
                msgRecibido = disCliente.readUTF();
                //    mensaje#cliente
                if (msgRecibido.contains("#")) {
                    StringTokenizer token = new StringTokenizer(msgRecibido, "#");
                    msg = token.nextToken().trim();
                    cli = token.nextToken().trim().toLowerCase();
                } else {
                    msg = msgRecibido.trim();
                    cli = "";
                }
                
                System.out.println("\n"
                        + MainServidor.ANSI_PURPLE
                        + "El cliente " + this.nickName
                        + " envia:"
                        + msg + "\n\t"
                        + " al cliente =>"
                        + MainServidor.ANSI_CYAN
                        + (cli.equals("") ? " Todos" : cli.toUpperCase())
                        + "\n"
                        + MainServidor.ANSI_RESET
                );
                DAOHistorial si = new DAOHistorial(1, this.nickName, msg, MainServidor.ANSI_RED, Date.valueOf(LocalDate.now()));

                //comandos /dfhdkfjh
                if (msg.startsWith("/")) {
                    switch (msg.substring(1, msg.length()).toLowerCase().trim()) {
                        case "salir":
                            this.disCliente.close();
                            this.dosCliente.close();
                            this.isConected = false;
                            this.sock.close();
                            MainServidor.ClientesConectados.remove(this);
                            System.err.println(MainServidor.ANSI_RED
                                    + "\tCliente "
                                    + this.nickName
                                    + " se ah desconectado.\n"
                                    + MainServidor.ANSI_RESET
                            );
                            this.notificarClientes(false);
                            break;
                    }
                }
                
                for (Cliente c : MainServidor.ClientesConectados) {
                    // si exite el cliente en la lista  Y  si esta online
                    //mesnaje#""
                    if (msg.equals("")) {
                        break;
                    }
                    
                    if (c.nickName.toLowerCase().equals(cli.toLowerCase()) && this.isConected) {
                        c.dosCliente.writeUTF(
                                this.nickName
                                + ":"
                                + msg
                        );
                        break;
                    } else if (cli.equals("") && this.isConected && !c.nickName.toLowerCase().equals(this.nickName.toLowerCase())) {
                        c.dosCliente.writeUTF(this.nickName
                                + ":"
                                + msg
                        );
                    }
                }//fin for

            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }//fin while

    }// fin run

    void notificarClientes(boolean b) {
        for (Cliente cliente : MainServidor.ClientesConectados) {
            if (!cliente.nickName.equals(this.nickName) && cliente.isConected) {
                try {
                    if (b) {
                        cliente.dosCliente.writeUTF(MainServidor.ANSI_GREEN
                                + "\t---"
                                + this.nickName
                                + " se ah unido al chat---"
                                + MainServidor.ANSI_RESET
                        );
                    } else {
                        cliente.dosCliente.writeUTF(MainServidor.ANSI_RED
                                + "\t---"
                                + this.nickName
                                + " se ah desconectado---"
                                + MainServidor.ANSI_RESET
                        );
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                }
            }
        }
    }
    
}

class Servidor extends Thread {
    
    ServerSocket server;
    int PUERTO = 7777;
    Socket sockAux;
    PrintStream ps;
    
    DataInputStream disCliente;
    DataOutputStream dosCliente;
    
    public Servidor() {
        try {
            ps = new PrintStream(System.out);
            disCliente = null;
            dosCliente = null;
            
            server = new ServerSocket(PUERTO);
            
            Thread verificarLista = new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    
                    for (Cliente cli : MainServidor.ClientesConectados) {
                        if (!cli.sock.isConnected() || !cli.isConected) {
                            MainServidor.ClientesConectados.remove(cli);
                            cli.notificarClientes(false);
                        }
                    }
                    
                }
            }
            );
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                ps.println("Esperando conexion de un cliente...\n");
                sockAux = server.accept();
                
                ps.println(MainServidor.ANSI_BLUE
                        + "Cliente conectado: "
                        + sockAux.getInetAddress().getHostAddress()
                        + MainServidor.ANSI_RESET
                );
                DataInputStream disCliente = new DataInputStream(sockAux.getInputStream());
                DataOutputStream dosCliente = new DataOutputStream(sockAux.getOutputStream());
                
                System.out.println(MainServidor.ANSI_BLUE
                        + "Creando un cliente... Esperano NickName"
                        + MainServidor.ANSI_RESET
                );
                String nickname = disCliente.readUTF();
                
                Cliente cli = new Cliente(sockAux, nickname, disCliente, dosCliente);
                
                System.out.println(MainServidor.ANSI_RED
                        + "El cliente "
                        + cli.nickName
                        + " accedio al servidor.\n"
                        + MainServidor.ANSI_RESET
                );
                MainServidor.ClientesConectados.add(cli);
                cli.hilo.start();
                cli.notificarClientes(true);
                
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
