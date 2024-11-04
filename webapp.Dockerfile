# Usar la imagen oficial de Tomcat
FROM tomcat:10-jdk17-temurin-jammy

# Copiar la aplicación a Tomcat
COPY ./target/tienda.war /usr/local/tomcat/webapps/tienda.war

# Exponer el puerto de Tomcat
EXPOSE 8080

# Iniciar Tomcat
CMD ["catalina.sh","run"]
