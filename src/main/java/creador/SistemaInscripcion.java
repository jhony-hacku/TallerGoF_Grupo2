package creador;

// SistemaInscripcion.java
public class SistemaInscripcion {
    public void inscribir(Estudiante e, MateriaFactory factory, String nombreMateria, String codigoMateria) {
        Materia materia = CatalogoMaterias.getOrCreate(factory, nombreMateria, codigoMateria);

        System.out.println("\n=== Inscripción: " + e.getNombre() + " ===");
        System.out.println("Materia: " + materia.getInfo());
        System.out.println("Cupos disponibles: " + materia.getCuposDisponibles());

        if (materia.reservarCupo()) {
            System.out.println("✓ Inscripción exitosa!");
            System.out.println("Cupos restantes: " + materia.getCuposDisponibles());
        } else {
            System.out.println("✗ No hay cupos disponibles");
        }
    }
}
