interface Solicitud {
    void aceptar(SolicitudVisitor visitor);
}

class SolicitudCertificado implements Solicitud {
    @Override
    public void aceptar(SolicitudVisitor visitor) {
        visitor.validar(this);
    }
}

class SolicitudCitaConsejero implements Solicitud {
    @Override
    public void aceptar(SolicitudVisitor visitor) {
        visitor.validar(this);
    }
}

interface SolicitudVisitor {
    void validar(SolicitudCertificado certificado);
    void validar(SolicitudCitaConsejero citaConsejero);
}

class ValidacionSolicitudVisitor implements SolicitudVisitor {
    @Override
    public void validar(SolicitudCertificado certificado) {
        System.out.println("Validando solicitud de certificado...");
    }

    @Override
    public void validar(SolicitudCitaConsejero citaConsejero) {
        System.out.println("Agendando cita con el consejero...");
    }
}

class Estudiante {
    private String nombre;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public void procesarSolicitud(Solicitud solicitud, SolicitudVisitor visitor) {
        System.out.println("Estudiante: " + nombre);
        solicitud.aceptar(visitor);
    }
}

public class MainVisitor {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Juan Gomez");
        SolicitudVisitor visitor = new ValidacionSolicitudVisitor();

        Solicitud solicitud1 = new SolicitudCertificado();
        Solicitud solicitud2 = new SolicitudCitaConsejero();

        estudiante.procesarSolicitud(solicitud1, visitor);
        estudiante.procesarSolicitud(solicitud2, visitor);
    }
}
