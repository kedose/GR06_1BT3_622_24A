# Usar la imagen oficial de MySQL
FROM mysql:latest

# Establecer las variables de entorno
ENV MYSQL_ROOT_PASSWORD=1234
ENV MYSQL_DATABASE=javaweb
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=1234

# Copiar archivos de configuración y script de inicialización
COPY ./my.cnf /etc/mysql/conf.d/my.cnf
COPY ./init.sql /docker-entrypoint-initdb.d/init.sql

# Exponer el puerto de MariaDB
EXPOSE 3306
