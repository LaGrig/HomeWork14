package com.mobile.store;

public abstract class Smartphone{
    private int id;
    private String brand;
    private String operationSystem;
    private int yearReleased;
    private double screenSize;
    private int buildInMemoryStorage;

    public Smartphone(String brand, String operationSystem, int yearReleased, double screenSize, int buildInMemoryStorage, int id) {
        this.brand = brand;
        this.operationSystem = operationSystem;
        this.yearReleased = yearReleased;
        this.screenSize = screenSize;
        this.buildInMemoryStorage = buildInMemoryStorage;
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBuildInMemoryStorage() {
        return buildInMemoryStorage;
    }

    public void setBuildInMemoryStorage(int buildInMemoryStorage) {
        this.buildInMemoryStorage = buildInMemoryStorage;
    }

    public int getId() { return id;  }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Smartphone{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", operationSystem='").append(operationSystem).append('\'');
        sb.append(", yearReleased=").append(yearReleased);
        sb.append(", screenSize=").append(screenSize);
        sb.append(", buildInMemoryStorage=").append(buildInMemoryStorage);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}