package com.demo.personomics.personomics;

/**
 * Created by umeshkhanna on 2016-11-20.
 */

public class Progress {
    private String name;
    private double progressVal;
    private double progressGoal;
    private String units;

    public Progress(String name, double progressVal, float progressGoal, String units) {
        this.name = name;
        this.progressVal = progressVal;
        this.progressGoal = progressGoal;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProgressVal() {
        return progressVal;
    }

    public void setProgressVal(float progressVal) {
        this.progressVal = progressVal;
    }

    public double getProgressGoal() {
        return progressGoal;
    }

    public void setProgressGoal(float progressGoal) {
        this.progressGoal = progressGoal;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
