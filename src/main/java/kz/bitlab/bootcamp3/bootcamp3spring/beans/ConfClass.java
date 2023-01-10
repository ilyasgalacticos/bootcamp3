package kz.bitlab.bootcamp3.bootcamp3spring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfClass {

    @Bean
    public SomeOtherBean chifKif(){
        return new SomeOtherBean();
    }

    @Bean
    public SomeOtherBean chifKifzhan(){
        return new SomeOtherBean();
    }

}
