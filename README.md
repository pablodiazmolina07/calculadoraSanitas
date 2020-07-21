# calculadoraSanitas
Demo calculadora sanitas

API de calculadora con spring boot y maven Pasos para generar el jar y ejecutarlo. Se incluye documentación de la API 

1 - Descargar el proyecto https://github.com/pablodiazmolina07/calculadoraSanitas

2 - Abrir un cmd en la carpeta donde se encuentra el pom.xml y ejecutar el comando: 
    + Sin test: mvn install:install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId=com.tracer -DartifactId=tracer -Dversion=1.0 -Dpackaging=jar package -Dmaven.test.skip=true  
    + Con test: mvn install:install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId=com.tracer -DartifactId=tracer -Dversion=1.0 -Dpackaging=jar package
    
3 - Una vez que termina de construir el jar entrar en la carpeta target y ejecutar el comando: java -jar calculadora-1.0.0-SNAPSHOT.jar

4 - Para ver la documentación de el uso de la API existe un fichero de swagger calculadora-api.json en la carpeta doc del proyecto
