# **Backend - Architecture Microservices**

Ce projet backend est basé sur une architecture de microservices et utilise **Docker** et **Docker Compose** pour orchestrer ses différents services.

---

## **Table des matières**
1. [Microservices disponibles](#microservices-disponibles)
2. [Prérequis](#prérequis)
3. [Installation et lancement](#installation-et-lancement)
4. [Configuration](#configuration)
5. [Contributions](#contributions)
6. [Licence](#licence)

---

## **Microservices disponibles**

Le backend est constitué des microservices suivants :

- **User Service** : Gestion des utilisateurs et de l'authentification.
- **Article Service** : Gestion des articles.
- **Reservation Service** : Gestion des réservations.
- **Emplacement Service** : Gestion des emplacements.
- **Messagerie Service** : Gestion de la messagerie entre utilisateurs.
- **Notification Service** : Gestion des notifications (temps réel ou différé).
- **Image Service** : Gestion des images (upload, stockage, récupération).
- **API Gateway** : Point d'entrée centralisé pour router les requêtes vers les microservices.
- **Discovery Service** : Service de découverte basé sur Eureka pour enregistrer et localiser les microservices.

---

## **Prérequis**

Avant de commencer, assurez-vous d'avoir les outils suivants installés sur votre machine :

- [Docker](https://www.docker.com/) (version récente)
- [Docker Compose](https://docs.docker.com/compose/)
- [Git](https://git-scm.com/)
- Un terminal compatible avec les scripts shell (`bash` ou équivalent)

---

## **Installation et lancement**

### **Étape 1 : Cloner le projet**
Clonez le dépôt Git de ce projet en utilisant la commande suivante :  

git clone https://github.com/romain-mezghenna/projet-iwa-backend    
cd projet-iwa-backend  

#### **Étape 2 : Mise à jour des sous-modules**  
Exécutez le script update-ms.sh pour mettre à jour les microservices :  

./update-ms.sh  

#### **Étape 3 : Lancer les microservices**  
Lancez tous les services définis dans le fichier docker-compose.yml en exécutant :  

docker compose up --build  
Remarque : Cette commande construira et démarrera tous les microservices ainsi que leurs bases de données et services dépendants.  

**Configuration**    

Ports par défaut  

- Microservice	Port  
- User Service	http://localhost:8081  
- Article Service	http://localhost:8089  
- Reservation Service	http://localhost:8091  
- Emplacement Service	http://localhost:8088  
- Messagerie Service	http://localhost:8093  
- Notification Service	http://localhost:8082  
- API Gateway	http://localhost:8083  
- Discovery Service	http://localhost:8761  

**Bases de données**    
Chaque microservice est associé à une base de données PostgreSQL. Les configurations spécifiques sont définies dans le fichier docker-compose.yml via des variables d'environnement.  

**Réseau**    
Tous les microservices sont connectés via un réseau Docker interne nommé iwa-network. Les interactions entre les services passent par leurs noms DNS définis dans le fichier docker-compose.yml.  

**Kafka et Zookeeper**    
Le backend utilise Kafka pour la communication entre certains microservices. Zookeeper est configuré pour supporter Kafka :  

Kafka : localhost:9092  
Zookeeper : localhost:2181  
Contributions  

Les contributions sont les bienvenues ! Voici comment participer :  

Forkez le dépôt.  
Créez une branche pour vos modifications (feature/nouvelle-fonctionnalite).  
Soumettez une pull request pour revue.  

**Auteurs**    

Romain Mezghenna : romain24.mezghenna01@gmail.com  
Robin Vincent : robin.vin100@gmail.com  
Lilian Monnereau : lilian.monnereau@gmail.com  

