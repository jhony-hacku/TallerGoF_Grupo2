// PregradoFactory.java
public class PregradoFactory implements MateriaFactory {
    @Override
    public Cupo crearCupo() {
        return new CupoPregrado();
    }

    @Override
    public Materia crearMateria(String nombre, String codigo) {
        // la fábrica crea la materia junto con su cupo
        return new MateriaPregrado(nombre, codigo, crearCupo());
    }
}
