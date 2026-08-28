# 🫀 AI-Pulse Backend — Cardiac Telemetry & Health AI REST API

> Backend de télémétrie médicale développé avec **Spring Boot 3** et **PostgreSQL** pour l'enregistrement, l'évaluation du risque cardiaque (BPM) et le suivi des diagnostics de santé assistés par IA.

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-Jakarta_Persistence_3.1-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-42.7.3-336791?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

---

## 📌 Présentation du Projet

**AI-Pulse Backend** est une API REST sécurisée conçue pour centraliser les flux de télémétrie cardiaque et les prédictions d'évaluation des risques générées par des modèles d'intelligence artificielle :

- 💓 **Mesure & Télémétrie** : Réception des données de fréquence cardiaque en temps réel (**BPM** - *Beats Per Minute*).
- ⚠️ **Évaluation du Risque** : Enregistrement de l'indicateur de risque cardiovasculaire (`risk: boolean`) et du rapport de diagnostic (`result`).
- 🕒 **Horodatage Automatique** : Traçabilité précise de chaque mesure avec `LocalDateTime`.
- 📊 **Historique & Analyse** : Consultation des diagnostics passés pour l'analyse des tendances et le suivi médical.

---

## 🏗️ Architecture Technique & Structure du Code

Le projet suit une **architecture en couches** standard Spring Boot 3 :

```
src/main/java/com/aipulse/backend/
├── BackendApplication.java            # Point d'entrée principal Spring Boot 3
├── controller/
│   └── DiagnosisController.java       # Contrôleur REST (/api/diagnosis) avec support CORS
├── dto/
│   ├── DiagnosisRequest.java          # DTO d'entrée (Payload BPM)
│   └── DiagnosisResponse.java         # DTO de sortie (Message & niveau de risque)
├── entity/
│   └── Diagnosis.java                 # Entité JPA persistée en base PostgreSQL
└── repository/
    └── DiagnosisRepository.java       # Interface Spring Data JPA pour les requêtes CRUD
```

---

## 🗄️ Modèle de Données (PostgreSQL)

L'entité JPA `Diagnosis` est mappée automatiquement sur la base `aipulse_db` :

| Colonne | Type SQL | Description |
|---|---|---|
| `id` | `BIGINT (IDENTITY)` | Identifiant unique auto-généré (Clé primaire) |
| `bpm` | `INTEGER` | Fréquence cardiaque mesurée (Battements par minute) |
| `risk` | `BOOLEAN` | Indicateur de risque cardiovasculaire détecté |
| `result` | `VARCHAR(255)` | Message / Rapport de prédiction généré par l'IA |
| `timestamp` | `TIMESTAMP` | Date et heure précises de l'enregistrement |

---

## 📡 Endpoints de l'API REST

Base URL : `http://localhost:8080/api/diagnosis`

### 1. Enregistrer un diagnostic cardiaque
* **Méthode** : `POST`
* **URL** : `/api/diagnosis`
* **Headers** : `Content-Type: application/json`
* **Exemple de Requête** :
```json
{
  "bpm": 95,
  "risk": false,
  "result": "Fréquence cardiaque normale - Aucun risque détecté"
}
```
* **Réponse (`200 OK`)** :
```json
{
  "id": 1,
  "bpm": 95,
  "risk": false,
  "result": "Fréquence cardiaque normale - Aucun risque détecté",
  "timestamp": "2026-08-29T00:45:00"
}
```

### 2. Récupérer l'historique complet des diagnostics
* **Méthode** : `GET`
* **URL** : `/api/diagnosis`
* **Réponse (`200 OK`)** :
```json
[
  {
    "id": 1,
    "bpm": 95,
    "risk": false,
    "result": "Fréquence cardiaque normale - Aucun risque détecté",
    "timestamp": "2026-08-29T00:45:00"
  },
  {
    "id": 2,
    "bpm": 135,
    "risk": true,
    "result": "Tachycardie détectée - Consultation recommandée",
    "timestamp": "2026-08-29T01:10:00"
  }
]
```

---

## ⚙️ Configuration & Démarrage

### Prérequis
- **Java JDK 17**
- **PostgreSQL 14+**
- **Maven 3.8+**

### 1. Cloner le dépôt
```bash
git clone https://github.com/salahABOU03/aipulse-backend-.git
cd aipulse-backend-
```

### 2. Configuration de la base de données
Créer la base dans PostgreSQL :
```sql
CREATE DATABASE aipulse_db;
```

Ajuster `src/main/resources/application.properties` au besoin :
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/aipulse_db
spring.datasource.username=postgres
spring.datasource.password=votre_mot_de_passe
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Compiler et lancer
```bash
# Build
mvn clean package

# Lancement
mvn spring-boot:run
```

---

## 👤 Auteur
**Salah Eddine Abouelkemhe** — Développeur Full-Stack & Spécialiste Backend (Java / Spring Boot)
