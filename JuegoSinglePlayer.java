import java.util.Scanner;

public class JuegoSinglePlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Gánale al Dado (Single Player) ===");
        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        GanaleAlDado juego = new GanaleAlDado();

        System.out.println("\n== Inicio del juego ==");
        System.out.println("Instrucciones resumidas:");
        System.out.println("- El juego termina al llegar a 10 tiros o 6 fichas.");
        System.out.println("- Cada dado puede salir '*', 'L', 'R', 'C'.");
        
        while (!juego.finDelJuego()) {
            char[] resultado = juego.lanzar();

            System.out.println("Tiro #" + juego.getTirosRealizados() +
                               ": |Dado1=" + resultado[0] +
                               " |Dado2=" + resultado[1] +
                               " |-> Fichas=" + juego.getFichasObtenidas());
        }

        System.out.println("\n=== Fin del juego ===");
        System.out.println("Jugador: " + nombre);
        System.out.println("Tiros realizados: " + juego.getTirosRealizados());
        System.out.println("Fichas obtenidas: " + juego.getFichasObtenidas());
        System.out.println("Estado: " + (juego.gano() ? "GANASTE" : "PERDISTE"));
    }
}




