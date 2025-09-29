
public class Jugador {
    private String nombre;
    private int tiros;
    private int fichas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tiros = 0;
        this.fichas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiros() {
        return tiros;
    }

    public int getFichas() {
        return fichas;
    }

    public void incrementarTiros() {
        tiros++;
    }

    public void agregarFichas(int cantidad) {
        fichas += cantidad;
        if (fichas < 0) fichas = 0;
    }

    public boolean finDelJuego() {
        return tiros >= 10 || fichas >= 6;
    }

    @Override
    public String toString() {
        return nombre + " - Tiros: " + tiros + ", Fichas: " + fichas;
    }
}

