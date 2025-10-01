// MateriaPosgrado.java
public class MateriaPosgrado implements Materia {
    private final String nombre;
    private final String codigo;
    private final Cupo cupo;

    public MateriaPosgrado(String nombre, String codigo, Cupo cupo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cupo = cupo;
    }

    @Override
    public String getInfo() {
        return "[POSGRADO] " + codigo + " - " + nombre;
    }

    @Override
    public boolean reservarCupo() {
        return cupo.reservar();
    }

    @Override
    public int getCuposDisponibles() {
        return cupo.getCuposDisponibles();
    }

    @Override
    public String getCodigo() {
        return codigo;
    }
}
