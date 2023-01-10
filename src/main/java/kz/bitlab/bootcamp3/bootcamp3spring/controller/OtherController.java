package kz.bitlab.bootcamp3.bootcamp3spring.controller;

import kz.bitlab.bootcamp3.bootcamp3spring.beans.SomeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @Autowired
    private SomeBean someBean;

    @GetMapping(value = "/other-bean")
    public String otherBean(Model model){
        model.addAttribute("result", someBean.getData());
        return "test";
    }

    @GetMapping(value = "/change-data")
    public String changeData(){
        someBean.setName("Leo");
        someBean.setAmount(66);
        return "redirect:/other-bean";
    }

}