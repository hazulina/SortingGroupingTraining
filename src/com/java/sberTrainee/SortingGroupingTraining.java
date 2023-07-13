package com.java.sberTrainee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortingGroupingTraining {

    public static void main(String[] args) {
        SortingGroupingTraining training = new SortingGroupingTraining();
        List<City> citiesDictionaryList = training.getCityDictionaryListFromFile("resources/Задача ВС Java Сбер.csv");

        Map<String, Integer> citiesInRegionCount = training.getQuantityOfCitiesInEveryRegionMap(citiesDictionaryList);

        citiesInRegionCount.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    private Map<String, Integer> getQuantityOfCitiesInEveryRegionMap(List<City> citiesDictionaryList) {
        return citiesDictionaryList.stream()
                .collect(Collectors.groupingBy(City::getRegion, Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    private void getCityIndexWithMaxPopulation(City[] array) {
        int cellNumber = 0;
        long population = array[0].getPopulation();
        for (int i = 1; i < array.length; i++) {
            if (array[i].getPopulation() > population) {
                population = array[i].getPopulation();
                cellNumber = i;
            }
        }
        System.out.println(cellNumber + " = " + population);
    }

    private void setListPrettyForOutput(List<City> citiesDictionaryList) {
        for (City city : citiesDictionaryList) {
            System.out.println(city + "\n");
        }
    }

    private void sortingByCityNameDesc(List<City> citiesDictionaryList) {
        citiesDictionaryList.sort((o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName()));
    }

    private void sortingByDistrictAndCityNameDesc(List<City> citiesDictionaryList) {
        citiesDictionaryList.sort((o1, o2) -> {
            int result = o2.getDistrict().compareTo(o1.getDistrict());
            if (result == 0) {
                return o2.getName().compareTo(o1.getName());
            }
            return result;
        });
    }

    private List<City> getCityDictionaryListFromFile(String pathname) {
        List<City> citiesDictionaryList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(pathname), StandardCharsets.UTF_8)) {
            scanner.useDelimiter(";|\r");
            while (scanner.hasNext()) {
                scanner.skip("[^;]*;");
                citiesDictionaryList.add(createCityFromFile(scanner));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return citiesDictionaryList;
    }

    private City createCityFromFile(Scanner scanner) {
        City model = new City();
        model.setName(scanner.next());
        model.setRegion(scanner.next());
        model.setDistrict(scanner.next());
        model.setPopulation(Long.parseLong(scanner.next()));
        model.setFoundation(scanner.next());
        return model;
    }
}
