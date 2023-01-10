package kz.bitlab.bootcamp3.bootcamp3spring.beans;

import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Component
@Scope(value = "singleton")
public class SomeBean {


    public SomeBean(){
        System.out.println("Creating new bean of Some Bean");
        this.name = "Serik";
        this.amount = 8;
    }

    private String name;
    private int amount;

    public String getData(){
        return this.name + " - " + this.amount;
    }

}
