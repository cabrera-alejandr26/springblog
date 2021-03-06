package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    //Addition Method
    @RequestMapping(path="/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String addition (@PathVariable int num1, @PathVariable int num2){
        return String.valueOf(num1 + num2);
    }

    //Subtraction Method
    @RequestMapping(path="/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtraction (@PathVariable int num1, @PathVariable int num2){
        return String.valueOf(num1 - num2);
    }

    //Multiplication Method
    @RequestMapping(path="/multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplication (@PathVariable int num1, @PathVariable int num2){
        return String.valueOf(num1 * num2);
    }

    //Division Method
    @RequestMapping(path="/divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String Division (@PathVariable int num1, @PathVariable int num2){
        return String.valueOf(num1/num2);
    }
}
