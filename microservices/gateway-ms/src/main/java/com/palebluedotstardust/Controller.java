package com.palebluedotstardust;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


   

    @RequestMapping("/")
    public String index(){

        return "Hello Gateway-ms";

    }

    @RequestMapping("/testnew")
    public String testAPI(){
        return "This is new test API from Gateway-MS!";

    }


     @RequestMapping("/api3")
     public String anotherAPI(){
         return "This is new test API 3 from Gateway-MS!";

}    }
