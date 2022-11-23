package Turnos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Sistema que controla el manejo de turnos del Hospital Santa Lucia
 *
 */
public class Sistemita implements Serializable {

    private static final long serialVersionUID = -1000L;
    private BaseDatos db;
    private MedicoDAO medicoUI = new MedicoDAO();
    private PacienteDAO pacienteUI = new PacienteDAO();
    private TurnoDAO turnoUI = new TurnoDAO();

    /**
     * Metodo Contructor
     */
    public Sistemita() {
        db = new BaseDatos();
    }

    /**
     * Des-serializa el achivo binario para cargar los datos de la anterior
     * ejecucion
     *
     * @param archivo Nombre del archivo binario
     * @return {@link Sistemita}
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Sistemita deSerializar(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Sistemita s = (Sistemita) ois.readObject();
        return s;
    }

    /**
     * Serializa la ejecucion del programa en un archivo binario (realiza un DAM
     * de memoria)
     *
     * @param archivo Nombre del archivo binario
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void serializar(String archivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(archivo);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        }
    }

    /**
     * Ejecuta funciones para el inicio del sistema
     */
    public void creacion() {
        System.out.println("Sistema Nuevo");
    }

    /**
     * ESTE PASARIA A SER NUETRO MAIN
     */
    public void prender() {
        boolean corriendo = true;

        while (corriendo) {
            corriendo = mostrarMenu();
        }
        System.out.println("Vuelva prontos...");

    }

    /**
     * Muestra un menu de opciones disponibles
     *
     * @return {@link Boolean}
     */
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                System.out.println(
                        "MENÚ PRINCIPAL\n\n"
                        + "[1] Menu de Turnos\n"
                        + "[2] Menu de Pacientes\n"
                        + "[3] Menu de Medicos\n"
                        + "[4] Salir\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '4');

            switch (op) {
                case '1':
                    continuar = turnoUI.mostrarMenu(db);
                    break;
                case '2':
                    continuar = pacienteUI.mostrarMenu(db);
                    break;
                case '3':
                    continuar = medicoUI.mostrarMenu(db);
                    break;
                case '4':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }
}
