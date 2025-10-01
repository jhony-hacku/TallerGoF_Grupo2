// Main.java
public class Main {
    public static void main(String[] args) {
        MateriaFactory pregradoFactory = new PregradoFactory();
        MateriaFactory posgradoFactory = new PosgradoFactory();

        Estudiante juan = new Estudiante("Juan Pérez", "EST001");
        Estudiante maria = new Estudiante("María García", "EST002");

        SistemaInscripcion sistema = new SistemaInscripcion();

        // Inscripciones (las materias usan un único objeto por código gracias al catálogo)
        sistema.inscribir(juan, pregradoFactory, "Programación I", "PROG101");
        sistema.inscribir(juan, pregradoFactory, "Cálculo I", "MAT101");

        sistema.inscribir(maria, posgradoFactory, "Machine Learning", "ML501");
        sistema.inscribir(maria, posgradoFactory, "Big Data", "BD502");

        // Mostrar que PROG101 comparte cupo entre estudiantes
        System.out.println("\n--- Demostración de cupos compartidos (llenado) ---");
        for (int i = 0; i < 3; i++) {
            Estudiante s = new Estudiante("Alumno" + i, "X" + i);
            sistema.inscribir(s, pregradoFactory, "Programación I", "PROG101");
        }
    }
}
