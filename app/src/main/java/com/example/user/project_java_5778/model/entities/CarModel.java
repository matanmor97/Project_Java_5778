package com.example.user.project_java_5778.model.entities;

import java.util.Objects;


public class CarModel {


    public enum Gearbox {
        AUTOMATIC,
        MANUAL
    }

    private int modelCode;

    public void setModelCode(int modelCode) {
        this.modelCode = modelCode;
    }

    public int getModelCode() {
        return this.modelCode;
    }

    private String companyName;

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    private String modelName;

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return this.modelName;
    }

    private int engineCapacity;

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return this.engineCapacity;
    }

    private Gearbox gearbox;

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Gearbox getGearbox() {
        return this.gearbox;
    }

    private int seats;

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return this.seats;
    }


    @Override
    public String toString() {

        String string = null;

        for (Object temp : CarModel.class.getFields()) {
            if (temp instanceof Enum)
                string += ((Enum) temp).ordinal();
            else
                string += temp.toString();

            string += " ";
        }

        return string.trim();
    }
}