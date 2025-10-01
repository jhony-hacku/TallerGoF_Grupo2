// CatalogoMaterias.java
import java.util.HashMap;
import java.util.Map;

/**
 * Catálogo simple para asegurar que cada código de materia tenga una única instancia.
 */
public class CatalogoMaterias {
    private static final Map<String, Materia> CATALOGO = new HashMap<>();

    public static synchronized Materia getOrCreate(MateriaFactory factory, String nombre, String codigo) {
        return CATALOGO.computeIfAbsent(codigo, k -> factory.crearMateria(nombre, codigo));
    }
}
