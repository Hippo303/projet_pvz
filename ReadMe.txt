Projet Plantes VS Zombies

Ce projet est un backend permettant de faire fonctionner un jeu frontend Plantes vs Zombies.


Technologies utilisées :

- Java21
- Maven
- Tomcat10
- Spring MVC
- JDBC
- MySQL

Structure du Projet :

- src/main/java/com/epf : Code source principal (Controllers, Services, DAO, Models, DTOs, Config)
- src/main/webapp/images/ : Images utilisées pour les plantes, zombies et maps
- src/main/webapp/WEB-INF/ : Fichiers de config

Les Routes API

Le backend est accessible pour les plantes par exemple via l'url : http://localhost:8080/CoursEpfBack/plantes


### Plantes
- `GET /plantes` - Liste toutes les plantes
- `GET /plantes/{id}` - Récupère une plante par son ID
- `POST /plantes` - Crée une nouvelle plante
- `PUT /plantes/{id}` - Modifie une plante existante
- `DELETE /plantes/{id}` - Supprime une plante

### Zombies
- `GET /zombies` - Liste tous les zombies
- `GET /zombies/{id}` - Récupère un zombie par son ID
- `POST /zombies` - Crée un nouveau zombie
- `PUT /zombies/{id}` - Modifie un zombie existant
- `DELETE /zombies/{id}` - Supprime un zombie

### Maps
- `GET /maps` - Liste toutes les maps
- `GET /maps/{id}` - Récupère une map par son ID
- `POST /maps` - Crée une nouvelle map
- `PUT /maps/{id}` - Modifie une map existante
- `DELETE /maps/{id}` - Supprime une map


Installation

1. Prérequis

- Java21 installé
- Tomcat10 installé 
- MySQL installé
- Maven installé

2. installer ou cloner le projet

git clone https://github.com/Hippo303/projet_pvz.git

3. Configurer la bdd

Changer les valeurs pour l'utilisateur dans spring-config.xml et DataSourceConnection.java si nécessaire



        <property name="url" value="jdbc:mysql://localhost:3306/pvz"/>
        <property name="username" value="epf"/>
        <property name="password" value="mot_de_passe"/>

    public DataSource DataSourceConnection(){ 
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pvz");
        dataSource.setUsername("epf");
        dataSource.setPassword("mot_de_passe");
        return dataSource;
    }



4. Peupler la bdd

Créer une bdd "pvz" et exécuter le script sql suivant :

USE pvz;

-- Supprimer les tables si elles existent déjà (dans l'ordre pour respecter les contraintes)
DROP TABLE IF EXISTS Zombie;
DROP TABLE IF EXISTS Plante;
DROP TABLE IF EXISTS Map;

-- Créer la table "map"
CREATE TABLE Map (
    id_map INT AUTO_INCREMENT PRIMARY KEY,
    ligne INT UNSIGNED NOT NULL,
    colonne INT UNSIGNED NOT NULL,
    chemin_image VARCHAR(255) DEFAULT NULL
);

-- Créer la table "plante"
CREATE TABLE Plante (
    id_plante INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    point_de_vie INT UNSIGNED NOT NULL,
    attaque_par_seconde DECIMAL(5, 2) DEFAULT 0.00,
    degat_attaque INT UNSIGNED DEFAULT 0,
    cout INT UNSIGNED NOT NULL,
    soleil_par_seconde DECIMAL(5, 2) DEFAULT 0.00,
    effet ENUM('normal', 'slow low', 'slow medium', 'slow stop') DEFAULT 'normal',
    chemin_image VARCHAR(255) DEFAULT NULL
);

-- Créer la table "zombie"
CREATE TABLE Zombie (
    id_zombie INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    point_de_vie INT UNSIGNED NOT NULL,
    attaque_par_seconde DECIMAL(5, 2) DEFAULT 0.00,
    degat_attaque INT UNSIGNED NOT NULL,
    vitesse_de_deplacement DECIMAL(5, 2) DEFAULT 0.00,
    chemin_image VARCHAR(255) DEFAULT NULL,
    id_map INT,
    CONSTRAINT fk_zombie_map FOREIGN KEY (id_map) REFERENCES Map(id_map)
);

-- Peuplement de la table "map"
INSERT INTO Map (ligne, colonne, chemin_image) VALUES
    (5, 9, 'images/map/gazon.png'),
    (6, 9, 'images/map/gazon.png'),
    (4, 8, 'images/map/gazon.png');

-- Peuplement de la table "plante"
INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES
    ('Tournesol', 100, 0.00, 0, 50, 25.00, 'normal', 'images/plante/tournesol.png'),
    ('Pois Tireur', 150, 1.50, 20, 100, 0.00, 'normal', 'images/plante/poistireur.png'),
    ('Double Pisto P', 150, 1.50, 40, 200, 0.00, 'normal', 'images/plante/doublepois.png'),
    ('Glace Pois', 120, 1.00, 10, 175, 0.00, 'slow low', 'images/plante/glacepois.png'),
    ('Noix', 300, 0.00, 0, 50, 0.00, 'normal', 'images/plante/noix.png');

-- Peuplement de la table "zombie"
INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES
    ('Zombie de base', 100, 0.80, 10, 0.50, 'images/zombie/zombie.png', 1),
    ('Zombie Cone', 200, 0.80, 10, 0.45, 'images/zombie/conehead.png', 1),
    ('Zombie Seau', 300, 0.70, 10, 0.40, 'images/zombie/buckethead.png', 1),
    ('Runner Zombie', 80, 1.00, 8, 0.70, 'images/zombie/runner.png', 2),
    ('Football Zombie', 250, 0.90, 12, 0.60, 'images/zombie/football.png', 3);

-- Création de l'utilisateur s'il n'existe pas déjà
CREATE USER IF NOT EXISTS 'userEPF'@'%' IDENTIFIED BY 'EPF';

-- Attribution de tous les privilèges à l'utilisateur sur la base de données pvz
GRANT ALL PRIVILEGES ON pvz.* TO 'userEPF'@'%';

-- Application des changements de privilèges
FLUSH PRIVILEGES;


5. Lancer le backend

- Copier le fichier "CoursEpfBack.war" situé dans "projet_pvz\target" dans le répertoire "webapps" de tomcat

Par exemple "C:\Program Files\Apache\apache-tomcat-10.1.35\webapps" sous Windows

- Lancer tomcat (Pour Windows : exécuter le fichier "startup.bat" du répertoire \bin de tomcat en tant qu'administrateur)

6. Lancer le front

Se placer dans le répertoire du front ("projet_pvz\zip_PVZ_V1") et exécuter la commande "npm run start"
Le front est accessible à l'adresse "http://localhost:5173"


PS : Si des modifications sont apportées au projet il faut exécuter la commande "mvn clean install" dans le répertoire du projet ce qui génèrera un nouveau fichier "CoursEpfBack.war" dans "projet_pvz\target" à copier dans le répertoire "webapps" de tomcat.



