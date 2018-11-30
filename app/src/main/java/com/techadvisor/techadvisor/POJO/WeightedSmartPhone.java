package com.techadvisor.techadvisor.POJO;

/**
 * Created by test on 10/15/2018.
 */

public class WeightedSmartPhone {
    String Name;
    Integer ram,camera,battery,processor, score, price;

    public WeightedSmartPhone(String name, Integer price, Integer ram, Integer camera, Integer battery, Integer processor, Integer score) {
        Name = name;
        this.price = price;
        this.ram = ram;
        this.camera = camera;
        this.battery = battery;
        this.processor = processor;
        this.score = score;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getScore() {
        return score;
    }

    public String getName() {
        return Name;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getCamera() {
        return camera;
    }

    public Integer getBattery() {
        return battery;
    }

    public Integer getProcessor() {
        return processor;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
