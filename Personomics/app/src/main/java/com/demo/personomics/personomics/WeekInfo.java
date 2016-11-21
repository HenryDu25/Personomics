package com.demo.personomics.personomics;

import java.util.List;

/**
 * Created by umeshkhanna on 2016-11-20.
 */

public class WeekInfo {
    String name;
    double value;
    String units;
    List<Integer> info;

    public WeekInfo(String name, double value, String units, List<Integer> info) {
        this.name = name;
        this.value = value;
        this.units = units;
        this.info = info;
    }

    public List<Integer> getInfo() {
        return info;
    }

    public void setInfo(List<Integer> info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
