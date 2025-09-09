# Структура проекта для анализа фермы животных

- JDK: 11 (Zulu 11.0.27)
- GroupId: `com.animalfarm`
- ArtifactId: `animal-farm-analysis`
- Version: 1.0-SNAPSHOT

**Структура папок после создания**:
```
animal-farm-analysis/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── animalfarm/
│   │               ├── Animal.java
│   │               └── AnimalFarm.java
│   └── test/
│       └── java/
│           └── com/
│               └── animalfarm/
│                   └── AnimalFarmTest.java
├── pom.xml
└── README.md
```
Как запустить проект:

1. Скомпилировать проект: `mvn compile`
2. Запустить тесты: `mvn test`
3. Запустить главный класс: `mvn exec:java -Dexec.mainClass="com.animalfarm.Main"`