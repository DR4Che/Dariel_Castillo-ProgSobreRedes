package Turnos;

import java.io.Serializable;
import java.util.LinkedList;


public class BaseDatos implements Serializable {

    private static final long serialVersionUID = -1000L;

    protected LinkedList<PersonaDTO> BasePersonas;
    protected LinkedList<TurnoDTO> BaseTurnos;

    private MedicoDAO medicoUI = new MedicoDAO();
    private PacienteDAO pacienteUI = new PacienteDAO();
    private TurnoDAO turnoUI = new TurnoDAO();

    /**
     * Metodo Contructor
     */
    public BaseDatos() {
        BasePersonas = new LinkedList<>();
        BaseTurnos = new LinkedList<>();
    }

    /**
     * Agrega una {@link PersonaDTO} a la lista {@link BaseDatos#BasePersonas}
     *
     * @param p {@link PersonaDTO} a Agregar
     */
    public void agregar(PersonaDTO p) {
        if (p != null) {
            BasePersonas.add(p);
        }
    }

    /**
     * Agrega una {@link TurnoDTO} a la lista {@link #BaseTurnos}
     *
     * @param t {@link TurnoDTO} a Agregar
     */
    public void agregar(TurnoDTO t) {
        if (t != null) {
            BaseTurnos.add(t);
        }
    }

    /**
     * Remueve una {@link PersonaDTO} de la lista {@link #BasePersonas}
     *
     * @param p {@link PersonaDTO} a Quitar
     */
    public void quitar(PersonaDTO p) {
        if (p != null) {
            BasePersonas.remove(p);
        }
    }

    /**
     * Remueve una {@link TurnoDTO} de la lista {@link #BaseTurnos}
     *
     * @param t {@link TurnoDTO} a Quitars
     */
    public void quitar(TurnoDTO t) {
        if (t != null) {
            BaseTurnos.remove(t);
        }
    }

    /**
     * Modifica una {@link PersonaDTO} de la lista {@link #BasePersonas}
     *
     * @param p {@link PersonaDTO} a Cambiar
     * @param pNew nuevo {@link PersonaDTO}
     */
    public void modificar(PersonaDTO p, PersonaDTO pNew) {
        if (p != null && pNew != null) {
            BasePersonas.set(BasePersonas.indexOf(p), pNew);
        }
    }

    /**
     * Modifica una {@link TurnoDTO} de la lista {@link #BaseTurnos}
     *
     * @param t {@link TurnoDTO} a Cambiar
     * @param tNew nuevo {@link TurnoDTO}
     */
    public void modificar(TurnoDTO t, TurnoDTO tNew) {
        if (t != null && tNew != null) {
            BaseTurnos.set(BaseTurnos.indexOf(t), tNew);
        }
    }

    /**
     * Obtiene una {@link PersonaDTO} de la lista {@link #BasePersonas}
     *
     * @param i Posicion de la {@link PersonaDTO}
     * @return {@link PersonaDTO}
     */
    public PersonaDTO obtenerPersona(int i) {
        return BasePersonas.get(i);
    }

    /**
     * Obtiene un {@link TurnoDTO} de la lista {@link #BaseTurnos}
     *
     * @param i Posicion del {@link TurnoDTO}
     * @return {@link TurnoDTO}
     */
    public TurnoDTO obtenerTurno(int i) {
        return BaseTurnos.get(i);
    }

    /**
     * Devuelve el {@link TurnoDTO} elegido por el usuario
     *
     * @return {@link TurnoDTO} Elegido
     */
    public TurnoDTO elegirTurno() {
        int op;
        do {
            int i = 1;
            System.out.println("Seleccione un Turno: ");
            for (TurnoDTO t : BaseTurnos) {
                System.out.println("[" + i + "] Turno para el: " + t.getFecha() + "(Paciente: " + t.getPaciente().getNombre() + " " + t.getPaciente().getApellido() + " | Medico:" + t.getMedico().getNombre() + " " + t.getMedico().getApellido() + ")");
                i++;
            }
            op = Integer.parseInt(String.valueOf(Utilidades.obtenerOpcion()));
        } while (op < 1 || op > BaseTurnos.size());

        return BaseTurnos.get(op - 1);
    }

    /**
     * Devuelve el {@link PacienteDTO} elegido por el usuario
     *
     * @return {@link PacienteDTO} Elegido
     */
    public PacienteDTO elegirPaciente() {
        int cantPacientes = 0;
        for (PersonaDTO p : BasePersonas) {
            if (p instanceof PacienteDTO) {
                cantPacientes++;
            }
        }

        int op;
        int i = 1;

        do {
            System.out.println("Seleccione un Paciente: ");
            for (PersonaDTO p : BasePersonas) {
                if (p instanceof PacienteDTO) {
                    System.out.println("[" + i + "]" + p.getNombre() + " " + p.getApellido());
                    i++;
                }
            }
            op = Integer.parseInt(String.valueOf(Utilidades.obtenerOpcion()));
        } while (op < 1 || op > cantPacientes + 1);

        int aux = 1;
        for (PersonaDTO p : BasePersonas) {
            System.out.println(aux);
            if (p instanceof PacienteDTO) {
                if (aux == op) {
                    return (PacienteDTO) p;
                }
                aux++;
            }

        }
        return null;
    }

    /**
     * Devuelve el {@link MedicoDTO} elegido por el usuario
     *
     * @return {@link MedicoDTO} Elegido
     */
    public MedicoDTO elegirMedico() {
        int cantMedicos = 0;
        for (PersonaDTO m : BasePersonas) {
            if (m instanceof MedicoDTO) {
                cantMedicos++;
            }
        }

        int op;
        int i = 1;

        do {
            System.out.println("Seleccione un Medico: ");

            for (PersonaDTO p : BasePersonas) {
                if (p instanceof MedicoDTO) {
                    System.out.println("[" + i + "]" + p.getNombre() + " " + p.getApellido());
                    i++;
                }
            }

            op = Integer.parseInt(String.valueOf(Utilidades.obtenerOpcion()));
        } while (op < 1 || op > cantMedicos);

        int aux = 1;
        for (PersonaDTO p : BasePersonas) {
            if (p instanceof MedicoDTO) {
                if (aux == op) {
                    return (MedicoDTO) p;
                }
                aux++;
            }

        }
        return null;
    }

    /**
     * Muestra los datos de todos los {@link PacienteDTO}
     */
    public void mostrarPacientes() {
        for (PersonaDTO p : BasePersonas) {
            if (p instanceof PacienteDTO) {
                pacienteUI.mostrarDatos((PacienteDTO) p);
            }
        }
    }

    /**
     * Muestra los datos de todos los {@link MedicoDTO}
     */
    public void mostrarMedicos() {
        for (PersonaDTO m : BasePersonas) {
            if (m instanceof PacienteDTO) {
                medicoUI.mostrarDatos((MedicoDTO) m);
            }
        }
    }

    /**
     * Muestra todos los {@link TurnoDTO}
     */
    public void mostrarTurnos() {
        for (TurnoDTO t : BaseTurnos) {
            turnoUI.mostrarDatos(t);
        }
    }
}
