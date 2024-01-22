package com.mobile.store.brand;

import com.mobile.store.Smartphone;
import com.mobile.store.service.Services;

public class Samsung extends Smartphone implements Services {

    private static String model;
    private static String paymentSystem;
    private static boolean audioJackPresence;
    private static int SimCardNumSupport;
    private static int maxSdCardSizeSupportGb;

    public Samsung(String brand, String model, String operationSystem, int yearReleased, double screenSize,
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

    private void setModel(String model) {
        this.model = model;
    }

    public static String getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(String paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public static boolean isAudioJackPresence() {
        return audioJackPresence;
    }

    public void setAudioJackPresence(boolean audioJackPresence) {
        this.audioJackPresence = audioJackPresence;
    }

    public static int getSimCardNumSupport() {
        return SimCardNumSupport;
    }

    public void setSimCardNumSupport(int simCardNumSupport) {
        SimCardNumSupport = simCardNumSupport;
    }

    public static int getMaxSdCardSizeSupportGb() {
        return maxSdCardSizeSupportGb;
    }

    public void setMaxSdCardSizeSupportGb(int maxSdCardSizeSupportGb) {
        this.maxSdCardSizeSupportGb = maxSdCardSizeSupportGb;
    }



    @Override
    public boolean emergencyCall(boolean emergencyCall) {
        return false;
    }

    @Override
    public boolean pinProtection(boolean pinProtection) {
        return false;
    }

    @Override
    public boolean voiceCall(boolean voiceCall) {

        return voiceCall;
    }

    @Override
    public boolean faceTimeCall(boolean faceTimeCall) {
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Samsung{");
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
