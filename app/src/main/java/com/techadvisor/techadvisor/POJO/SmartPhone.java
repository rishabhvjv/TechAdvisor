package com.techadvisor.techadvisor.POJO;

/**
 * Created by test on 10/14/2018.
 */

public class SmartPhone {

    String Name;
    Integer price,ram,camera,battery,processor;


    public SmartPhone(){}

    public SmartPhone(String name, Integer price, Integer ram, Integer camera, Integer battery, Integer processor) {
        Name = name;
        this.price = price;
        this.ram = ram;
        this.camera = camera;
        this.battery = battery;
        this.processor = processor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getCamera() {
        return camera;
    }

    public void setCamera(Integer camera) {
        this.camera = camera;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public Integer getProcessor() {
        return processor;
    }

    public void setProcessor(Integer processor) {
        this.processor = processor;
    }
}
