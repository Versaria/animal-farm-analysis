# Animal Farm Analysis Project 🐄🐕🐈

![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Java](https://img.shields.io/badge/Java-11+-blue)
![Maven](https://img.shields.io/badge/Maven-3.9+-orangeм)
![JUnit](https://img.shields.io/badge/JUnit-5-red)

Проект для анализа и управления данными о животных на ферме с возможностью:
- Подсчета животных по видам
- Извлечения уникальных имен
- Добавления новых животных
- Обработки некорректных данных

## 🚀 Быстрый старт
### Требования
- **Java JDK 11+** (рекомендуется Zulu 11.0.27+)
- **Apache Maven 3.9+**
- **Git** (для клонирования)

### Установка и запуск
```bash
git clone https://github.com/your-username/animal-farm-analysis.git
cd animal-farm-analysis
mvn clean compile
mvn test
mvn exec:java -Dexec.mainClass="com.animalfarm.Main"
```

## 📂 Структура проекта
```
animal-farm-analysis/
├── src/
│   ├── main/java/com/animalfarm/
│   │   └── Animal.java              # Перечисление видов животных
│   │   └── AnimalFarm.java          # Основной класс фермы
│   │   └── Main.java                # Класс для демонстрации работы
│   └── test/java/com/animalfarm/
│       └── AnimalFarmTest.java      # Тесты для класса AnimalFarm
├── LICENSE
├── pom.xml                          # Конфигурация Maven
└── README.md
```

## 📋 Функционал
1. **Подсчет животных по видам**
- Автоматическая группировка животных по видам (CAT, DOG, HORSE, COW)
- Обработка некорректных данных с выводом предупреждений
- Возврат статистики в виде Map<Animal, Integer>

2. **Извлечение уникальных имен**
- Автоматическое определение уникальных имен животных
- Игнорирование строк с некорректным форматом
- Использование Set для обеспечения уникальности

 3. **Добавление новых животных**
Три варианта добавления:
- С указанием вида и имени
- Только с указанием вида (имя "N")
- Только с указанием имени (вид NOT_DEFINED)

4. **Обработка ошибок**
- Валидация входных данных
- Корректная обработка некорректных строк
- Информативные сообщения об ошибках

## 📊 Покрытие тестами
Проект включает comprehensive unit-тесты для проверки:
- Корректности подсчета животных по видам
- Извлечения уникальных имен
- Добавления новых животных различных типов
- Обработки некорректных данных
- Строкового представления фермы

**Результаты тестирования:**
- ✅ Tests run: 10
- ✅ Failures: 0
- ✅ Errors: 0
- ✅ Skipped: 0
- ⏱️ Time: 0.034s

Запуск тестов:
```bash
mvn test
```

## 💻 Пример работы
```java
// Создание фермы с тестовыми данными
List<String> animalsData = Arrays.asList(
    "DOG Жучка", 
    "CAT Мурка", 
    "HORSE Буцефал",
    "COW Бурёнка", 
    "DOG Шарик", 
    "CAT",                    // Ошибочная строка
    "UNKNOWN Зверь",          // Ошибочная строка
    "COW Зорька"
);

AnimalFarm farm = new AnimalFarm(animalsData);

// Подсчет животных по видам
Map<Animal, Integer> animalCount = farm.countedAnimals();
// DOG: 2, CAT: 1, HORSE: 1, COW: 2, NOT_DEFINED: 0

// Получение уникальных имен
Set<String> uniqueNames = farm.uniqueNames();
// [Жучка, Мурка, Буцефал, Бурёнка, Шарик, Зорька]

// Добавление новых животных
farm.addFarmAnimal(Animal.DOG, "Тузик");
farm.addFarmAnimal(Animal.CAT);          // Имя: "N"
farm.addFarmAnimal("Неизвестный");       // Вид: NOT_DEFINED

// Вывод информации о ферме
System.out.println(farm.toString());
```

**Вывод в консоль:**
```
Please correct string 'CAT'. Incorrect input data.
Please correct string 'UNKNOWN Зверь'. Incorrect input data.

DOG:Жучка
CAT:Мурka
HORSE:Буцефал
COW:Бурёнка
DOG:Шарик
COW:Зорька
DOG:Тузик
CAT:N
NOT_DEFINED:Неизвестный
```

## 📜 Лицензия
MIT License

## 🤝 Как внести вклад
1. Форкните репозиторий
2. Создайте ветку (`git checkout -b feature/new-dish`)
3. Сделайте коммит (`git commit -am 'Add new menu item'`)
4. Запушьте ветку (`git push origin feature/new-dish`)
5. Откройте Pull Request

---

<details>
<summary>🔧 Дополнительные команды</summary>

```bash
# Запуск тестов с отчетом
mvn test surefire-report:report

# Анализ кода
mvn pmd:pmd checkstyle:checkstyle
```
</details>