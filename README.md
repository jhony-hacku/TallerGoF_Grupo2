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
Se modela un sistema que permite la creación y gestión eficiente de inscripciones a materias.  
Clases principales:
- `MateriaFactory`
- `Materia`
- `Estudiante`

### 2. Visitor - Gestión de Solicitudes de Estudiantes
Sistema para validar y procesar diferentes tipos de solicitudes (certificados, citas con consejeros).  
Clases principales:
- `SolicitudVisitor`
- `SolicitudCertificado`
- `SolicitudCitaConsejero`
- `Estudiante`

### 3. Patrones Seleccionados por el Equipo
Cada grupo debe elegir **un patrón adicional de cada tipo** (Creación, Estructural, Comportamiento) para mejorar la solución de un problema identificado dentro del sistema universitario.  

Ejemplos de problemas:
- Pago de matrícula y servicios (biblioteca, cursos extra, deportes).  
- Inscripción y gestión de horarios/cupos.  

---

## 📂 Estructura del Proyecto

├── CHANGELOG.md # Historial de cambios del proyecto
├── CONTRIBUTING.md # Guía para contribuir al proyecto
├── Dockerfile # Imagen base para contenedor
├── LICENSE # Licencia del proyecto
├── Makefile # Automatización de tareas
├── README.md # Documentación principal
├── conf/ # Configuración (YAML, JSON)
├── docker-compose.yml # Orquestación con Docker
├── docs/ # Documentación técnica y de usuario
│ ├── api
│ ├── architecture
│ └── user_guide
├── jupyter/ # Datasets y notebooks de análisis
├── scripts/ # Scripts de despliegue, setup y pruebas
├── src/ # Código fuente (Java, tests y recursos)
└── temp/ # Archivos temporales


---

## ▶️ Ejecución del Proyecto

1. Clonar el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd taller-patrones-gof

javac src/**/*.java -d bin
java -cp bin Main

## Diagramas
Revisar los diagramas en la carpeta diagrams/