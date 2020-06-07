# jasper
Realizar un pequeño informe con la librería JasperReport sobre la BD Apache Derby.

Apache Derby es una Base de Datos Relacional Open Source escrita completamente en Java. Derby nos ofrece un motor de bases de datos basado en estándares de tamaño reducido y que puede integrarse perfectamente en cualquier solución basada en Java. Dicha base de datos venía incluida anteriormente en el JDK.

La versión que utilicé del JDK es la 1.8, la cual no incluye dicha BD por lo que tendremos que proceder a realizar su instalación.
He incluido la Base de datos Derby dentro del proyecto en la carpeta Derby-10, además de la librería JasperReport(versión 4.8).
Incluyo también informe generado en PDF.

Pasos a seguir:

1.	Descargar la BD Apache Derby de la siguiente url: https://db.apache.org/derby/derby_downloads.html y descomprimir en nuestro sistema.

2.	Instalación y configuración de Apache Derby
    - Registrar la BD en Netbeans. En la pestaña "Prestaciones" -> Java DB -> Propiedades. Se nos preguntará la ubicación de la carpeta de los archivos descargados y la ubicación de la base de datos.
    - Instalación de controladores. Pestaña "Prestaciones" -> Controladores -> Nuevo controlador. Agregaremos los ficheros derby.jar y derbyclient.jar contenidos en la carpeta Derby-10/lib.
    - Iniciar servidor Derby. Pestaña "Prestaciones" -> Java DB -> Iniciar servidor
    - Crear BD de ejemplo. Pestaña "Prestaciones" -> Java DB -> Create Sample Database. Indicaremos un nombre para la BD de ejemplo, en mi caso "sample". Tras lo cual veremos que se creo una conexión JDBC.
    - Conectarnos a la BD creada, para ello garemos clic sobre la conexión JDBD pudiendo visualizar las tablas que forman parte de Apache Derby.(*)
    
3.	Descargar la librería de JasperReport versión 4.8, de la siguiente URL: https://sourceforge.net/projects/jasperreports/files/archive/jasperreports/JasperReports%204.8.0/

4.	Creación de un nuevo proyecto en Netbeans del tipo Java Application con clase principal.

5.	Agregar en Bibliotecas la librería JasperReport además de otras dependencias. Deberemos de agregar:
    - jasperreports-4.8.0.jar
    - commons-beanutils-1.8.0.jar
    - commons-collections-2.1.1.jar
    - commons-digester-1.1.1.jar
    - commons-logging-1.1.1.jar Todas estas librerías están incluidas dentro de la carpeta lib de la librería.

6.	Agregar librería Java DB Driver, Bibliotecas -> Agregar Biblioteca -> Java DB Driver -> Importar librería

7.	Creación de carpetas. Crearemos dentro de nuestro proyecto las carpetas que utilizaremos para las plantillas y los informes generados. Sobre la carpeta raíz del proyecto crearemos una carpeta llamada "report" y dentro de esta otras dos llamadas "templates" y "results".

8.	Creación de la plantilla. Clic con el botón derecho del ratón sobre la carpeta "templates" y a continuación seleccionaremos Nuevo -> Otro -> Otras -> Archivo vacío. Le podremos a la plantilla el nombre "productos.jrxml".
Este tipo de archivos no es reconocido en primera instancia por Netbeans. Para que sea reconocido clic en Herramientas -> Opciones -> Apartado Varios -> Ficha Archivos -> clic en el botón nuevo “Nueva” y la agregamos, indicaremos que el tipo MIME es Archivos XML (text/xml).

9.	Desarrollo del código en "productos.jrxml"

10.	Desarrollo del código de nuestra clase principal

11.	Compilar el proyecto. Podremos visualizar en pantalla el informe generado, podríamos a continuación imprimirlo en papel o pasarlo a formato PDF, además dentro de la carpeta results podremos visualizar que el mismo informe ha sido generado en formato .html

(*) Al conectarnos en primera instancia a la BD se produjo un error solicitando un usuario y contraseña. Para su resolución deberemos: agregar una regla permisiva para el acceso a nuestro propio equipo por el puerto 1527, para lo cual agregamos la línea:

permission java.net.SocketPermission "localhost:1527", "listen";

en el JDK, concretamente en el archivo de seguridad C:\Program Files\Java\jdk1.8.0_231\jre\lib\security\java.policy

