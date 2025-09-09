package com.animalfarm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Демонстрационный класс для тестирования функциональности AnimalFarm.
 */
public class Main {
    public static void main(String[] args) {
        // Создаем тестовые данные с корректными и некорректными строками
        List<String> animalsData = Arrays.asList(
                "DOG Жучка",
                "CAT Мурка",
                "HORSE Буцефал",
                "COW Бурёнка",
                "DOG Шарик",
                "CAT", // Ошибочная строка - нет имени
                "UNKNOWN Зверь", // Ошибочная строка - неизвестный вид
                "COW Зорька"
        );

        // Создаем экземпляр фермы
        AnimalFarm farm = new AnimalFarm(animalsData);

        System.out.println("=== Подсчет животных по видам ===");
        Map<Animal, Integer> animalCount = farm.countedAnimals();
        for (Map.Entry<Animal, Integer> entry : animalCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\n=== Уникальные имена животных ===");
        Set<String> uniqueNames = farm.uniqueNames();
        System.out.println("Уникальные имена: " + uniqueNames);

        System.out.println("\n=== Добавление новых животных ===");
        farm.addFarmAnimal(Animal.DOG, "Тузик");
        farm.addFarmAnimal(Animal.CAT);
        farm.addFarmAnimal("Неизвестный");

        System.out.println("\n=== Строковое представление фермы ===");
        System.out.println(farm); // Убрал ненужный toString()
    }
}