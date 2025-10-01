package creador;

// CupoPregrado.java
public class CupoPregrado implements Cupo {
    private final int capacidad = 40;
    private int ocupados = 0;

    @Override
    public synchronized boolean reservar() {
        if (ocupados < capacidad) {
            ocupados++;
            return true;
        }
        return false;
    }

    @Override
    public synchronized int getCuposDisponibles() {
        return capacidad - ocupados;
    }
}
