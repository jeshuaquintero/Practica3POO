import java.util.Scanner;

/**
 * Clase que provee una interfaz de usuario en consola
 * para el juego "Gánale a los Dados de la Curlys" en modo
 * de un solo jugador.
 * 
 * No modifica la lógica del juego, únicamente muestra la
 * información al usuario y recibe datos del teclado.
 * 
 * @author 
 * @version septiembre 2025
 */
public class JuegoSinglePlayer {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        GanaleAlDado juego = new GanaleAlDado();

        System.out.println("=== Gánale a los Dados de la Curlys (Single Player) ===");
        System.out.println("Reglas:");
        System.out.println(" - Tienes como máximo 10 tiros.");
        System.out.println(" - Si logras reunir 6 o más fichas, ganas.");
        System.out.println("Presiona ENTER para comenzar.");
        scn.nextLine();

        while (!juego.finDelJuego()) {
            System.out.println("Presiona ENTER para lanzar los dados...");
            scn.nextLine();

            juego.lanzar();
            System.out.println("Tiros realizados: " + juego.getTirosRealizados());
            System.out.println("Fichas obtenidas: " + juego.getFichasObtenidas());
            System.out.println("-----------------------------------");
        }

        System.out.println("\n=== Fin del juego ===");
        System.out.println("Tiros realizados: " + juego.getTirosRealizados());
        System.out.println("Fichas obtenidas: " + juego.getFichasObtenidas());

        if (juego.getFichasObtenidas() >= 6) {
            System.out.println("¡Felicidades, ganaste!");
        } else {
            System.out.println("Lo siento, perdiste");
        }

        scn.close();
    }
}
