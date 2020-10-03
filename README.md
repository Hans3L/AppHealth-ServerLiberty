# AppHealth-ServerLiberty
**Ejecutando el artefacto en un JAR Ejecutable**
1) mvn liberty:package -Dinclude=runnable
2) java -jar target/*.jar

**Ejecutando el artefacto en un WAR separado del Servidor Liberty**
1) mvn liberty:run
2) Path del artefacto guardado en Liberty
<code>\wlp\usr\servers\defaultServer\apps</code>
