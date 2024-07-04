# AluraLibros

AluraLibros es una aplicación que permite buscar libros utilizando la API de Gutendex y gestionar registros de libros y autores en una base de datos PostgreSQL mediante Spring Boot.

## Funcionalidades

- **Buscar libro por título:** Permite buscar libros utilizando el título como criterio de búsqueda.
- **Listar libros registrados:** Muestra una lista de todos los libros almacenados en la base de datos.
- **Listar autores registrados:** Muestra una lista de todos los autores registrados en la base de datos.
- **Listar autores vivos en un año determinado:** Permite listar autores que estuvieron vivos en un año específico.
- **Listar libros por idioma:** Lista los libros disponibles en un idioma específico, seleccionado entre español (es) e inglés (en).
- **Top 10 libros más descargados:** Muestra los libros más descargados ordenados de mayor a menor número de descargas.
- **Estadísticas:** Proporciona estadísticas sobre los libros y autores registrados en la base de datos.

## Tecnologías Utilizadas

- Java
- Spring Boot
- PostgreSQL
- Hibernate/JPA
- RestTemplate
- Lombok

## Configuración del Proyecto

Para ejecutar el proyecto localmente, asegúrate de tener instalado Java y Maven. Además, configura la base de datos PostgreSQL y ajusta las configuraciones de conexión en `application.properties`.

## Instrucciones de Uso

1. Clona el repositorio desde GitHub.
2. Configura las credenciales de la base de datos en `application.properties`.
3. Ejecuta la aplicación utilizando Maven: `mvn spring-boot:run`.
4. Accede a la consola para interactuar con las diferentes opciones del menú.



## Licencia

Este proyecto está bajo la Licencia MIT. Para más detalles, consulta el archivo LICENSE.
