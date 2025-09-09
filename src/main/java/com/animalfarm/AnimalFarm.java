package com.animalfarm;

import java.util.*;

/**
 * Класс, представляющий ферму животных.
 * Содержит методы для анализа и управления животными на ферме.
 */
public class AnimalFarm {
    // Список строк в формате "ВИД_ЖИВОТНОГО ИМЯ_ЖИВОТНОГО"
    private final List<String> farmAnimals; // Добавлен final

    /**
     * Конструктор фермы животных.
     * @param farmAnimals список животных в формате "ВИД ИМЯ"
     */
    public AnimalFarm(List<String> farmAnimals) {
        // Создаем новый ArrayList чтобы избежать модификации исходного списка извне
        this.farmAnimals = new ArrayList<>(farmAnimals);
    }

    /**
     * Метод для подсчета количества животных каждого вида.
     * @return Map где ключ - вид животного, значение - количество
     */
    public Map<Animal, Integer> countedAnimals() {
        Map<Animal, Integer> animalCountMap = new HashMap<>();

        // Инициализируем карту нулевыми значениями для всех видов животных
        for (Animal animal : Animal.values()) {
            animalCountMap.put(animal, 0);
        }

        for (String farmAnimal : farmAnimals) {
            String[] parts = farmAnimal.split(" ");

            // Проверяем, что строка содержит хотя бы одно слово
            if (parts.length < 1) {
                System.out.printf("Please correct string '%s'. Incorrect input data.%n", farmAnimal);
                continue;
            }

            try {
                // Пытаемся преобразовать первую часть строки в enum Animal
                Animal animalType = Animal.valueOf(parts[0].toUpperCase());
                // Увеличиваем счетчик для данного вида животного
                animalCountMap.put(animalType, animalCountMap.get(animalType) + 1);
            } catch (IllegalArgumentException e) {
                // Если вид животного не распознан, выводим сообщение об ошибке
                System.out.printf("Please correct string '%s'. Incorrect input data.%n", farmAnimal);
            }
        }

        return animalCountMap;
    }

    /**
     * Метод для получения уникальных имен животных на ферме.
     * @return Set уникальных имен
     */
    public Set<String> uniqueNames() {
        Set<String> uniqueNamesSet = new HashSet<>();

        for (String farmAnimal : farmAnimals) {
            String[] parts = farmAnimal.split(" ");

            // Проверяем, что строка содержит два слова: вид и имя
            if (parts.length < 2) {
                System.out.printf("Please correct string '%s'. Incorrect input data.%n", farmAnimal);
                continue;
            }

            // Добавляем имя животного в Set (автоматически обеспечивает уникальность)
            uniqueNamesSet.add(parts[1]);
        }

        return uniqueNamesSet;
    }

    /**
     * Добавление животного с указанием вида и имени.
     * @param animal вид животного
     * @param name имя животного
     */
    public void addFarmAnimal(Animal animal, String name) {
        farmAnimals.add(animal.name() + " " + name);
    }

    /**
     * Добавление животного с указанием только вида.
     * Имя устанавливается как "N".
     * @param animal вид животного
     */
    public void addFarmAnimal(Animal animal) {
        farmAnimals.add(animal.name() + " N");
    }

    /**
     * Добавление животного с указанием только имени.
     * Вид устанавливается как NOT_DEFINED.
     * @param name имя животного
     */
    public void addFarmAnimal(String name) {
        farmAnimals.add(Animal.NOT_DEFINED.name() + " " + name);
    }

    /**
     * Переопределенный метод для строкового представления фермы.
     * @return строка в формате "ВИД:ИМЯ" для каждого животного
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (String farmAnimal : farmAnimals) {
            // Заменяем пробел на двоеточие для требуемого формата вывода
            String formattedAnimal = farmAnimal.replace(" ", ":");
            result.append(formattedAnimal).append("\n");
        }

        return result.toString();
    }

    /**
     * Дополнительный метод для получения текущего списка животных.
     * @return копия списка животных
     */
    public List<String> getFarmAnimals() {
        return new ArrayList<>(farmAnimals); // Возвращаем копию для безопасности
    }
}