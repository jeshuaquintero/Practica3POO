import java.util.Scanner;

public class JuegoMultiPlayer {

    private GanaleAlDadoMultiplayer juego;

    public JuegoMultiPlayer() {
        juego = new GanaleAlDadoMultiplayer();
    }

    public void iniciarJuego() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Gánale a los Dados de la Curlys (Multijugador) ===");

        // Solicitar número de jugadores
        int numJugadores = 0;
        while (numJugadores <= 0) {
            System.out.print("¿Cuántos jugadores van a participar? ");
            if (sc.hasNextInt()) {
                numJugadores = sc.nextInt();
                if (numJugadores <= 0) {
                    System.out.println("Ingresa un número válido.");
                }
            } else {
                sc.next();
                System.out.println("Ingresa un número válido.");
            }
        }
        sc.nextLine(); // limpiar buffer

        // Pedir nombres y agregarlos
        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Nombre del jugador " + (i + 1) + ": ");
            String nombre = sc.nextLine();
            juego.agregarJugador(nombre);
        }

        System.out.println("\n=== Comienza el juego automático ===");

        int tirosPorJugador = 10;
        boolean ganadorTemprano = false;
        String ganador = "";

        for (int tiro = 1; tiro <= tirosPorJugador && !ganadorTemprano; tiro++) {
            for (int i = 0; i < juego.getNumeroJugadores(); i++) {

                // Asegurar que el jugador actual sea el correcto
                while (!juego.getJugadorActualNombre().equals(juego.getNombreJugador(i))) {
                    juego.siguienteJugador();
                }

                juego.lanzar();

                // Mostrar resultados del turno
                System.out.println("\nTurno de " + juego.getJugadorActualNombre());
                System.out.println("Resultado dado 1: " + juego.getCaraDado1());
                System.out.println("Resultado dado 2: " + juego.getCaraDado2());
                System.out.println("Tiros realizados: " + juego.getTirosRealizados());
                System.out.println("Fichas obtenidas: " + juego.getFichasObtenidas());
                System.out.println("-----------------------------------");

                // Verificar si alcanzó 6 fichas
                if (juego.getFichasObtenidas() >= 6) {
                    ganadorTemprano = true;
                    ganador = juego.getJugadorActualNombre();
                    break;
                }

                juego.siguienteJugador();
            }
        }

        // Mostrar resultados finales
        System.out.println("\n=== Juego terminado ===");
        for (int i = 0; i < juego.getNumeroJugadores(); i++) {
            System.out.println(juego.getNombreJugador(i) +
                    " - Tiros: " + juego.getTirosJugador(i) +
                    ", Fichas: " + juego.getFichasJugador(i));
        }

        // Determinar ganador
        if (ganadorTemprano) {
            System.out.println("Ganador: " + ganador);
        } else {
            System.out.println("No hay ganador. Ningún jugador obtuvo 6 fichas.");
        }

        sc.close();
    }

    public static void main(String[] args) {
        new JuegoMultiPlayer().iniciarJuego();
    }
}
