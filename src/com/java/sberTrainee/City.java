package com.java.sberTrainee;

import java.util.Date;
import java.util.Objects;


public class City {
    private String name;
    private String region;
    private String district;
    private long population;
    private String foundation;

    public City() {
    }

    public City(String name, String region, String district, long population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return population == city.population && Objects.equals(name, city.name) && Objects.equals(region, city.region) && Objects.equals(district, city.district) && Objects.equals(foundation, city.foundation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, district, population, foundation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }
}
