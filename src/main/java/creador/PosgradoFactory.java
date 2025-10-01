package creador;

// PosgradoFactory.java
public class PosgradoFactory implements MateriaFactory {
    @Override
    public Cupo crearCupo() {
        return new CupoPosgrado();
    }

    @Override
    public Materia crearMateria(String nombre, String codigo) {
        return new MateriaPosgrado(nombre, codigo, crearCupo());
    }
}
