# calculadoraSanitas
Demo calculadora sanitas

API de calculadora con spring boot y maven Pasos para generar el jar y ejecutarlo. Se incluye documentación de la API 

1 - Descargar el proyecto https://github.com/pablodiazmolina07/calculadoraSanitas

2 - Abrir un cmd en la carpeta donde se encuentra el pom.xml y ejecutar el comando: 
    
    + Sin test: mvn install:install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId=com.tracer -DartifactId=tracer -Dversion=1.0 -Dpackaging=jar package -Dmaven.test.skip=true  
    
    + Con test: mvn install:install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId=com.tracer -DartifactId=tracer -Dversion=1.0 -Dpackaging=jar package
    
3 - Tras la compilación en la misma ventanta de comando y en la carpeta donde se encuentra el pom.xml y ejecutar el comando: mvn spring-boot:run

4 - Mediante un navegador realizar la llamada a la api. Por ejemplo: http://localhost:8080/api/calculadora/realizarOperacion?numero1=100,7&numero2=5&operacion=suma

5 - Deberá de obtener un resultado parecido al siguiente: {"result":"105.7","success":true}

6 - Para ver la documentación de el uso de la API existe un fichero de swagger calculadora-api.json en la carpeta doc del proyecto
