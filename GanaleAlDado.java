import java.util.Scanner;

/**
 * Clase para modo single player usando DadoLCR.
 */
public class GanaleAlDado {
    private DadoLCR dado1, dado2;
    private int tirosRealizados;
    private int fichasObtenidas;

    public GanaleAlDado() {
        dado1 = new DadoLCR();
        dado2 = new DadoLCR();
        tirosRealizados = 0;
        fichasObtenidas = 0;
    }

    public boolean finDelJuego() {
        return (tirosRealizados >= 10 || fichasObtenidas >= 6);
    }

    private int deltaPorCara(char cara) {
        switch (cara) {
            case '*': return 1;
            case 'L': return -1;
            case 'R': return -2;
            case 'C': return 0;
            default: return 0;
        }
    }

    /**
     * Lanza ambos dados, actualiza tiros y fichas.
     * @return un array de dos chars con el resultado de los dados.
     */
    public char[] lanzar() {
        char c1 = dado1.lanzar();
        char c2 = dado2.lanzar();
        tirosRealizados++;

        fichasObtenidas += deltaPorCara(c1);
        fichasObtenidas += deltaPorCara(c2);

        if (c1 == 'C' || c2 == 'C') {
            fichasObtenidas *= 2;
        }

        if (fichasObtenidas < 0) fichasObtenidas = 0;

        return new char[]{c1, c2};
    }

    // getters
    public int getTirosRealizados() { return tirosRealizados; }
    public int getFichasObtenidas() { return fichasObtenidas; }
    public boolean gano() { return fichasObtenidas >= 6; }
}



