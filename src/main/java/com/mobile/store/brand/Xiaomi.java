package com.mobile.store.brand;

import com.mobile.store.Smartphone;

public class Xiaomi extends Smartphone {

    private String model;
    private String paymentSystem;
    private boolean audioJackPresence;
    private int SimCardNumSupport;
    private int maxSdCardSizeSupportGb;

    public Xiaomi(String brand, String model, String operationSystem, int yearReleased, double screenSize,
                  int buildInMemoryStorage, String paymentSystem,
                  boolean audioJackPresence, int simCardNumSupport, int maxSdCardSizeSupportGb, int id) {
        super(brand, operationSystem, yearReleased, screenSize, buildInMemoryStorage, id);
        this.model = model;
        this.paymentSystem = paymentSystem;
        this.audioJackPresence = audioJackPresence;
        SimCardNumSupport = simCardNumSupport;
        this.maxSdCardSizeSupportGb = maxSdCardSizeSupportGb;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(String paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public boolean isAudioJackPresence() {
        return audioJackPresence;
    }

    public void setAudioJackPresence(boolean audioJackPresence) {
        this.audioJackPresence = audioJackPresence;
    }

    public int getSimCardNumSupport() {
        return SimCardNumSupport;
    }

    public void setSimCardNumSupport(int simCardNumSupport) {
        SimCardNumSupport = simCardNumSupport;
    }

    public int getMaxSdCardSizeSupportGb() {
        return maxSdCardSizeSupportGb;
    }

    public void setMaxSdCardSizeSupportGb(int maxSdCardSizeSupportGb) {
        this.maxSdCardSizeSupportGb = maxSdCardSizeSupportGb;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Xiaomi{");
        sb.append("brand='").append(getBrand()).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", operation system='").append(getOperationSystem()).append('\'');
        sb.append(", release year='").append(getYearReleased()).append('\'');
        sb.append(", screen size='").append(getScreenSize()).append('\'');
        sb.append(", build in storage='").append(getBuildInMemoryStorage()).append('\'');
        sb.append(", paymentSystem='").append(paymentSystem).append('\'');
        sb.append(", audioJackPresence=").append(audioJackPresence);
        sb.append(", SimCardNumSupport=").append(SimCardNumSupport);
        sb.append(", maxSdCardSizeSupportGb=").append(maxSdCardSizeSupportGb);
        sb.append((", id=")).append((getId())).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

