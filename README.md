# Sistema de Gestión Escolar con JPA y Hibernate

Este proyecto es un ejemplo de un sistema de gestión escolar desarrollado utilizando Java Persistence API (JPA) y Hibernate. El sistema permite realizar operaciones básicas de carga de datos desde archivos y consultas a una base de datos PostgreSQL.

## Configuración del Proyecto

1. **Dependencias Maven**: El proyecto utiliza Maven para la gestión de dependencias. Asegúrate de tener configurado Maven en tu entorno de desarrollo.

2. **Base de Datos PostgreSQL**: Se utiliza una base de datos PostgreSQL para persistir los datos. Asegúrate de tener PostgreSQL instalado y configurado en tu sistema.

3. **Configuración de la Persistencia**: La configuración de la unidad de persistencia se encuentra en el archivo `persistence.xml` en el directorio `src/main/resources/META-INF/`. Asegúrate de ajustar la configuración según tus credenciales y configuración de tu base de datos PostgreSQL.

## Funcionalidades

El proyecto proporciona las siguientes funcionalidades principales:

### Carga de Datos desde Archivos

El sistema permite cargar datos desde archivos de texto en formato CSV para las siguientes entidades:

- Grupos (`groups.txt`)
- Materias (`subjects.txt`)
- Sesiones (`sessions.txt`)
- Departamentos (`departments.txt`)
- Profesores (`teachers.txt`)

### Consultas y Visualización de Datos

El sistema proporciona consultas predefinidas para cada entidad y permite visualizar los datos en la consola. Las consultas disponibles son:

- Listar grupos
- Listar materias
- Listar sesiones
- Listar departamentos
- Listar profesores

## Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona este repositorio en tu máquina local.
2. Importa el proyecto en tu entorno de desarrollo preferido (Eclipse, IntelliJ, etc.).
3. Asegúrate de tener una instancia de PostgreSQL ejecutándose y configurada según lo especificado en `persistence.xml`.
4. Ejecuta el método `cargarDatos` en la clase `SchoolMain` para cargar los datos desde los archivos.
5. Ejecuta los métodos de impresión correspondientes en `SchoolMain` para visualizar los datos en la consola.

## Notas

- Asegúrate de tener las bibliotecas de Hibernate y JPA en tu classpath para poder compilar y ejecutar el proyecto correctamente.
