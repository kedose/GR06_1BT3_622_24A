# Usa la imagen oficial de Tomcat como base
FROM tomcat:9.0

# Copia el archivo WAR al directorio webapps de Tomcat
COPY target/PaginaWebPoli-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Exponer el puerto 8081 para que se pueda acceder a la aplicación
EXPOSE 8081

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
