package kz.bitlab.bootcamp3.bootcamp3spring.beans;

public class SomeOtherBean {

    public SomeOtherBean(){
        System.out.println("CHIF KIF");
    }

    public SomeOtherBean(String name, int value){
        System.out.println("OBEZYAN");
        this.name = name;
        this.value = value;
    }

    private String name;
    private int value;

}
