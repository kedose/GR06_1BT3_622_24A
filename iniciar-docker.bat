@echo off
mvnw clean && mvnw test && mvnw package && docker compose up
pause
