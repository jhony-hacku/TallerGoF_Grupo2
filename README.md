# Taller de Patrones de Diseño GoF

Este repositorio contiene la solución al **Taller de Patrones de Diseño GoF**, orientado a la implementación de patrones en el contexto de un sistema universitario (Intranet).  
El objetivo es comprender cómo los patrones de diseño mejoran la **eficiencia, mantenibilidad y usabilidad** del software, proporcionando soluciones escalables y reutilizables a problemas comunes.

---

## 📌 Objetivos del Taller

- Aplicar patrones de diseño en función de la lógica del negocio.  
- Comprender la importancia de los patrones en el desarrollo de software.  
- Identificar historias de usuario y problemas comunes, eligiendo patrones de diseño adecuados para resolverlos.  

---

## 🛠️ Patrones Implementados

### 1. Abstract Factory - Gestión de Inscripción en Materias

**Problema identificado:** El sistema universitario necesita gestionar inscripciones de materias para diferentes tipos de estudiantes (pregrado y posgrado), donde cada tipo tiene diferentes reglas de negocio, capacidades de cupo y requisitos.

**Solución implementada:** El patrón Abstract Factory permite crear familias de objetos relacionados (Materias y Cupos) sin especificar sus clases concretas, facilitando la extensión del sistema a nuevos tipos de estudiantes.

#### Componentes principales:

- **`MateriaFactory`** (Abstract Factory): Interfaz que define métodos para crear materias y cupos
  ```java
  public interface MateriaFactory {
      Materia crearMateria(String nombre, String codigo);
      Cupo crearCupo();
  }
  ```

- **`PregradoFactory`** y **`PosgradoFactory`** (Concrete Factories): Implementaciones concretas que crean objetos específicos
  - PregradoFactory crea MateriaPregrado con CupoPregrado (capacidad: 40)
  - PosgradoFactory crea MateriaPosgrado con CupoPosgrado (capacidad: 20)

- **`Materia`** (Abstract Product): Interfaz para todas las materias
- **`MateriaPregrado`** y **`MateriaPosgrado`** (Concrete Products): Implementaciones específicas

- **`Cupo`** (Abstract Product): Interfaz para gestión de cupos
- **`CupoPregrado`** y **`CupoPosgrado`** (Concrete Products): Implementaciones con diferentes capacidades

- **`CatalogoMaterias`**: Singleton que asegura una única instancia de cada materia por código
- **`SistemaInscripcion`**: Cliente que usa las fábricas para gestionar inscripciones
- **`Estudiante`**: Representa a los estudiantes que se inscriben

#### Ventajas de esta implementación:
- ✅ Facilita agregar nuevos tipos de materias (maestría, doctorado, cursos de extensión)
- ✅ Encapsula la lógica de creación de objetos relacionados
- ✅ Garantiza consistencia entre productos de la misma familia
- ✅ Centraliza el control de cupos compartidos mediante el catálogo

---

### 2. Visitor - Gestión de Solicitudes de Estudiantes

**Problema identificado:** Los estudiantes pueden realizar diferentes tipos de solicitudes (certificados, citas con consejeros, constancias, etc.), cada una con su propia lógica de validación y procesamiento. Agregar nuevas validaciones no debe modificar las clases de solicitud existentes.

**Solución implementada:** El patrón Visitor permite separar los algoritmos de validación de las estructuras de datos (solicitudes), facilitando agregar nuevas operaciones sin modificar las clases existentes.

#### Componentes principales:

- **`Solicitud`** (Element): Interfaz que define el método `aceptar()`
  ```java
  interface Solicitud {
      void aceptar(SolicitudVisitor visitor);
  }
  ```

- **`SolicitudCertificado`** y **`SolicitudCitaConsejero`** (Concrete Elements): Tipos específicos de solicitudes
  - Cada una implementa el método `aceptar()` llamando al método correspondiente del visitor

- **`SolicitudVisitor`** (Visitor): Interfaz que declara métodos de visita para cada tipo de solicitud
  ```java
  interface SolicitudVisitor {
      void validar(SolicitudCertificado certificado);
      void validar(SolicitudCitaConsejero citaConsejero);
  }
  ```

- **`ValidacionSolicitudVisitor`** (Concrete Visitor): Implementa la lógica específica de validación
  - Valida solicitudes de certificados
  - Agenda citas con consejeros

- **`Estudiante`**: Procesa solicitudes usando el visitor

#### Ventajas de esta implementación:
- ✅ Facilita agregar nuevas operaciones (aprobación, rechazo, notificación) sin modificar las solicitudes
- ✅ Centraliza la lógica relacionada en una sola clase visitor
- ✅ Cumple con el principio Open/Closed (abierto para extensión, cerrado para modificación)
- ✅ Simplifica el mantenimiento al separar concerns

---

### 3. Patrones Adicionales (Pendiente)

El equipo debe seleccionar e implementar un patrón adicional de cada categoría:

**Patrones de Creación sugeridos:**
- Builder: Para construir objetos complejos como horarios académicos
- Prototype: Para clonar configuraciones de cursos
- Singleton: Para gestionar recursos compartidos (conexión a BD, configuración)

**Patrones Estructurales sugeridos:**
- Adapter: Para integrar sistemas externos (pagos, biblioteca)
- Decorator: Para agregar funcionalidades a materias (laboratorio, práctica)
- Facade: Para simplificar la interacción con subsistemas complejos

**Patrones de Comportamiento sugeridos:**
- Observer: Para notificar cambios en cupos disponibles
- Strategy: Para diferentes métodos de pago
- State: Para gestionar estados de solicitudes (pendiente, aprobada, rechazada)

---

## 📂 Estructura del Proyecto

```
├── CHANGELOG.md              # Historial de cambios del proyecto
├── CONTRIBUTING.md           # Guía para contribuir al proyecto
├── Dockerfile                # Configuración de contenedor Docker
├── docker-compose.yml        # Orquestación de servicios Docker
├── LICENSE                   # Licencia del proyecto
├── Makefile                  # Automatización de tareas
├── README.md                 # Documentación principal (este archivo)
├── conf/                     # Archivos de configuración
├── docs/                     # Documentación adicional
│   ├── api/                  # Documentación de API
│   ├── architecture/         # Diagramas y decisiones arquitectónicas
│   └── user_guide/           # Guías de usuario
├── jupyter/                  # Notebooks de análisis (si aplica)
├── scripts/                  # Scripts de utilidad
│   ├── deploy.sh
│   ├── setup.sh
│   └── test.sh
├── src/                      # Código fuente
│   ├── main/
│   │   ├── java/
│   │   │   ├── creador/      # Patrón Abstract Factory
│   │   │   │   ├── CatalogoMaterias.java
│   │   │   │   ├── Cupo.java
│   │   │   │   ├── CupoPosgrado.java
│   │   │   │   ├── CupoPregrado.java
│   │   │   │   ├── Estudiante.java
│   │   │   │   ├── Main.java
│   │   │   │   ├── Materia.java
│   │   │   │   ├── MateriaFactory.java
│   │   │   │   ├── MateriaPosgrado.java
│   │   │   │   ├── MateriaPregrado.java
│   │   │   │   ├── PosgradoFactory.java
│   │   │   │   ├── PregradoFactory.java
│   │   │   │   └── SistemaInscripcion.java
│   │   │   └── visitor/      # Patrón Visitor
│   │   │       └── MainVisitor.java
│   │   └── resources/        # Recursos (configuración, assets)
│   └── test/                 # Tests unitarios y de integración
└── temp/                     # Archivos temporales
```

---

## ▶️ Ejecución del Proyecto

### Prerrequisitos

#### Para sistemas Linux (Arch, Ubuntu, Debian, etc.)
```bash
# Instalar Docker
sudo pacman -S docker docker-compose  # Arch Linux
# sudo apt-get install docker.io docker-compose  # Ubuntu/Debian

# Iniciar y habilitar el servicio
sudo systemctl start docker
sudo systemctl enable docker

# Agregar tu usuario al grupo docker (para usar sin sudo)
sudo usermod -aG docker $USER

# Cerrar sesión y volver a entrar, o ejecutar:
newgrp docker

# Verificar instalación
docker --version
docker compose version
```

---

### Ejecución con Docker Compose

Docker Compose permite ejecutar cada patrón como un servicio independiente de forma sencilla.

#### Ejecutar el patrón Abstract Factory (Creador)
```bash
docker compose run --rm patron-creador
```

**Salida esperada:**
```
=== Inscripción: Juan Pérez ===
Materia: [PREGRADO] PROG101 - Programación I
Cupos disponibles: 40
✓ Inscripción exitosa!
Cupos restantes: 39
...
```

#### Ejecutar el patrón Visitor
```bash
docker compose run --rm patron-visitor
```

**Salida esperada:**
```
Estudiante: Juan Gomez
Validando solicitud de certificado...
Estudiante: Juan Gomez
Agendando cita con el consejero...
```

#### Otros comandos útiles
```bash
# Ver todos los servicios disponibles
docker compose config --services

# Reconstruir las imágenes después de cambios en el código
docker compose build

# Reconstruir sin usar caché (útil para debugging)
docker compose build --no-cache

# Ver logs de ejecución
docker compose logs

# Detener todos los servicios
docker compose down
```

---

## 🐳 Gestión de Docker

### Ver recursos de Docker

```bash
# Ver imágenes descargadas/creadas
docker images

# Ver contenedores en ejecución
docker ps

# Ver todos los contenedores (incluidos detenidos)
docker ps -a

# Ver uso de espacio en disco
docker system df
```

### Limpieza de recursos

```bash
# Eliminar contenedores detenidos
docker container prune

# Eliminar imágenes sin usar
docker image prune

# Eliminar todo (contenedores, imágenes, volúmenes, redes)
# ⚠️ CUIDADO: Esto elimina TODOS los recursos de Docker
docker system prune -a

# Eliminar solo las imágenes de este proyecto
docker rmi taller-patrones-gof:creador taller-patrones-gof:visitor
```

### Reconstruir después de cambios

```bash
# Si modificaste código Java, reconstruye:
docker compose build --no-cache

# Luego ejecuta normalmente
docker compose run --rm patron-creador
```

### Debugging en el contenedor

```bash
# Entrar al contenedor en modo interactivo
docker run -it --rm taller-patrones-gof bash

# Una vez dentro, puedes:
ls -la /app/creador/        # Ver archivos
cat /app/creador/Main.java  # Ver contenido
cd /app/creador && java Main  # Ejecutar manualmente
```

---

## 🧪 Testing

```bash
# Ejecutar tests (pendiente de implementación)
# mvn test
# o
# gradle test
```

---

## 📊 Diagramas

Los diagramas de arquitectura y diseño se encuentran en la carpeta `docs/architecture/`:

- Diagrama de clases del patrón Abstract Factory
- Diagrama de clases del patrón Visitor
- Diagrama de secuencia de inscripción
- Diagrama de secuencia de validación de solicitudes
