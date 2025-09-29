import java.util.ArrayList;
import java.util.List;

/**
 * Juego "Gánale a los Dados de la Curlys" compatible con
 * Single Player y Multi Player.
 * 
 * @author 
 * @version septiembre 2025
 */
public class GanaleAlDadoMultiplayer {
    private DadoLCR dado1, dado2;

    private List<Jugador> jugadores; // Lista de objetos Jugador
    private int jugadorActual;       // Índice del jugador actual

    public GanaleAlDadoMultiplayer() {
        dado1 = new DadoLCR();
        dado2 = new DadoLCR();
        jugadores = new ArrayList<>();
        jugadorActual = 0;
    }

    public GanaleAlDadoMultiplayer(List<String> nombres) {
        this();
        for (String nombre : nombres) {
            agregarJugador(nombre);
        }
    }

    // ==== Manejo de jugadores ====
    public void agregarJugador(String nombre) {
        jugadores.add(new Jugador(nombre));
    }

    public int getNumeroJugadores() {
        return jugadores.size();
    }

    public String getNombreJugador(int index) {
        return jugadores.get(index).getNombre();
    }

    public int getTirosJugador(int index) {
        return jugadores.get(index).getTiros();
    }

    public int getFichasJugador(int index) {
        return jugadores.get(index).getFichas();
    }

    public int getJugadorActualIndex() {
        return jugadorActual;
    }

    public String getJugadorActualNombre() {
        return jugadores.get(jugadorActual).getNombre();
    }

    // ==== Lógica del juego ====
    /**
     * Devuelve true si el juego debe terminar
     */
    public boolean finDelJuego() {
        // Caso 1: el jugador actual llegó a 6 fichas
        if (jugadores.get(jugadorActual).getFichas() >= 6) {
            return true;
        }

        // Caso 2: todos los jugadores hicieron 10 tiros
        boolean todosLlegaronAlLimite = true;
        for (Jugador j : jugadores) {
            if (j.getTiros() < 10) {
                todosLlegaronAlLimite = false;
                break;
            }
        }

        return todosLlegaronAlLimite;
    }

    /**
     * Lanza los dados y aplica reglas del turno. No cambia el turno automáticamente.
     */
    public void lanzar() {
        char c1 = dado1.lanzar();
        char c2 = dado2.lanzar();

        Jugador j = jugadores.get(jugadorActual);
        j.incrementarTiros();

        int delta = deltaPorCara(c1) + deltaPorCara(c2);

        // duplicar solo lo ganado en este tiro si sale 'C'
        if (c1 == 'C' || c2 == 'C') {
            delta *= 2;
        }

        j.agregarFichas(delta);
    }

    private int deltaPorCara(char cara) {
        switch (cara) {
            case '*': return 1;
            case 'L': return -1;
            case 'R': return -2;
            case 'C': return 0;
            default:  return 0;
        }
    }

    // ==== Métodos de consulta ====
    public int getFichasObtenidas() {
        return jugadores.get(jugadorActual).getFichas();
    }

    public int getTirosRealizados() {
        return jugadores.get(jugadorActual).getTiros();
    }

    public char getCaraDado1() {
        return dado1.getValor();
    }

    public char getCaraDado2() {
        return dado2.getValor();
    }

    /**
     * Cambia el turno al siguiente jugador.
     */
    public void siguienteJugador() {
        if (jugadores.size() > 1) {
            jugadorActual = (jugadorActual + 1) % jugadores.size();
        }
    }
}
