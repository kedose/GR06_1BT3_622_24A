# Usar la imagen oficial de Tomcat
FROM tomcat:10-jdk17-temurin-jammy

# Copiar la aplicación a Tomcat y renombrarla para que el contexto sea /PaginaWebPoli
COPY ./target/PaginaWebPoli-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/PaginaWebPoli.war

# Exponer el puerto de Tomcat
EXPOSE 8080

# Iniciar Tomcat
CMD ["catalina.sh", "run"]
