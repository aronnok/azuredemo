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
public class JiraController {


    @Autowired
    private JiraRepo repo;

    @RequestMapping("/")
    public String index(){

        return "Hello API!";

    }

    @RequestMapping("/testnew")
    public String testAPI(){

        return "This is new test API!";

    }

    @RequestMapping(
            value = "findall",
            method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers =  "Accept=application/json")
    public ResponseEntity<Iterable<JiraTicket>> getAllJiraTickets(){

        return new ResponseEntity<Iterable<JiraTicket>>(repo.findAll(), HttpStatus.OK);
    }


    @RequestMapping(
            value = "addone",
            method = RequestMethod.POST
            )
    public ResponseEntity<Iterable<JiraTicket>> addOne(@RequestBody  JiraTicket oneTicket){

        System.out.println(oneTicket.toString());
        repo.save(oneTicket);
        return new ResponseEntity<Iterable<JiraTicket>>(repo.findAll(), HttpStatus.OK);
    }

}
