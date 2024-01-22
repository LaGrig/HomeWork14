package com.mobile.store.brand;

public class Protected_Smartphone extends Samsung {
    private String militaryStandard;
    private boolean radioProtection;

    public Protected_Smartphone(String brand, String model, String operationSystem, int yearReleased,
                                double screenSize, int buildInMemoryStorage, String paymentSystem,
                                boolean audioJackPresence, int simCardNumSupport, int maxSdCardSizeSupportGb,
                                String militaryStandard, boolean radioProtection, int id) {
        super(brand, model, operationSystem, yearReleased, screenSize, buildInMemoryStorage, paymentSystem,
                audioJackPresence, simCardNumSupport, maxSdCardSizeSupportGb, id);
        this.militaryStandard = militaryStandard;
        this.radioProtection = radioProtection;
    }

    @Override
    public String toString() {
        return "Protected_Smartphone{" +
                "militaryStandard='" + militaryStandard + '\'' +
                ", radioProtection=" + radioProtection +
                "} " + super.toString();
    }

    public String getMilitaryStandard() {
        return militaryStandard;
    }

    public void setMilitaryStandard(String militaryStandard) {
        this.militaryStandard = militaryStandard;
    }

    public boolean isRadioProtection() {
        return radioProtection;
    }

    public void setRadioProtection(boolean radioProtection) {
        this.radioProtection = radioProtection;
    }
}
