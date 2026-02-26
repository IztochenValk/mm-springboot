# spring-boot-cdafad2501
Projet de cours Java Spring Boot

### 1 Cloner ou forker le repository github
```sh
git clone https://github.com/mithridatem/spring-boot-cdafad2501.git games
cd games
```

### 2 Créer la base de données :
```sql
CREATE DATABASE IF NOT EXISTS nom_bdd CHARSET utf8mb4;
```

### 3 Configurer le fichier des variables d'environnement :  
**applications.properties** (*avec vos valeurs*)
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nom_bdd
spring.datasource.username=login_BDD
spring.datasource.password=Password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver (le driver MYSQl . MariaDB)
```
