package com.animalfarm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class AnimalFarmTest {

    @Test
    void testCountedAnimals() {
        List<String> animals = Arrays.asList("DOG Шарик", "CAT Мурка", "DOG Бобик");
        AnimalFarm farm = new AnimalFarm(animals);

        Map<Animal, Integer> result = farm.countedAnimals();

        assertEquals(2, result.get(Animal.DOG));
        assertEquals(1, result.get(Animal.CAT));
        assertEquals(0, result.get(Animal.HORSE));
    }

    @Test
    void testUniqueNames() {
        List<String> animals = Arrays.asList("DOG Шарик", "CAT Мурка", "DOG Шарик");
        AnimalFarm farm = new AnimalFarm(animals);

        Set<String> result = farm.uniqueNames();

        assertEquals(2, result.size());
        assertTrue(result.contains("Шарик"));
        assertTrue(result.contains("Мурка"));
    }

    @Test
    void testToString() {
        List<String> animals = Arrays.asList("DOG Шарик", "CAT Мурка");
        AnimalFarm farm = new AnimalFarm(animals);

        String result = farm.toString();

        assertTrue(result.contains("DOG:Шарик"));
        assertTrue(result.contains("CAT:Мурка"));
    }

    @Test
    void testAddFarmAnimalWithNameAndType() {
        List<String> animals = new ArrayList<>();
        animals.add("DOG Шарик");
        AnimalFarm farm = new AnimalFarm(animals);

        farm.addFarmAnimal(Animal.CAT, "Васька");

        assertEquals(2, farm.getFarmAnimals().size());
        assertTrue(farm.getFarmAnimals().contains("CAT Васька"));
    }

    @Test
    void testAddFarmAnimalWithTypeOnly() {
        List<String> animals = new ArrayList<>();
        animals.add("DOG Шарик");
        AnimalFarm farm = new AnimalFarm(animals);

        farm.addFarmAnimal(Animal.COW);

        assertEquals(2, farm.getFarmAnimals().size());
        assertTrue(farm.getFarmAnimals().contains("COW N"));
    }

    @Test
    void testAddFarmAnimalWithNameOnly() {
        List<String> animals = new ArrayList<>();
        animals.add("DOG Шарик");
        AnimalFarm farm = new AnimalFarm(animals);

        farm.addFarmAnimal("Безымянный");

        assertEquals(2, farm.getFarmAnimals().size());
        assertTrue(farm.getFarmAnimals().contains("NOT_DEFINED Безымянный"));
    }

    @Test
    void testCountedAnimalsWithInvalidData() {
        List<String> animals = Arrays.asList("DOG Шарик", "INVALID", "CAT Мурка", "UNKNOWN Зверь");
        AnimalFarm farm = new AnimalFarm(animals);

        Map<Animal, Integer> result = farm.countedAnimals();

        // Проверяем, что корректные данные обработаны правильно
        assertEquals(1, result.get(Animal.DOG));
        assertEquals(1, result.get(Animal.CAT));
        // Некорректные данные не должны влиять на подсчет
    }

    @Test
    void testUniqueNamesWithInvalidData() {
        List<String> animals = Arrays.asList("DOG Шарик", "CAT", "HORSE Буцефал");
        AnimalFarm farm = new AnimalFarm(animals);

        Set<String> result = farm.uniqueNames();

        // Должны быть только имена из корректных строк
        assertEquals(2, result.size());
        assertTrue(result.contains("Шарик"));
        assertTrue(result.contains("Буцефал"));
    }

    @Test
    void testConstructorWithEmptyList() {
        List<String> emptyList = Collections.emptyList();
        AnimalFarm farm = new AnimalFarm(emptyList);

        assertTrue(farm.getFarmAnimals().isEmpty());
    }

    @Test
    void testAddMultipleAnimals() {
        List<String> animals = new ArrayList<>();
        AnimalFarm farm = new AnimalFarm(animals);

        farm.addFarmAnimal(Animal.DOG, "Рекс");
        farm.addFarmAnimal(Animal.CAT);
        farm.addFarmAnimal("Мурзик");

        assertEquals(3, farm.getFarmAnimals().size());
        assertTrue(farm.getFarmAnimals().contains("DOG Рекс"));
        assertTrue(farm.getFarmAnimals().contains("CAT N"));
        assertTrue(farm.getFarmAnimals().contains("NOT_DEFINED Мурзик"));
    }
}