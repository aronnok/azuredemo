package com.palebluedotstardust;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    @Autowired
    private RedisTicketRepository redisTicketRepo;


    private static final Logger logger = LoggerFactory.getLogger(JiraController.class);


    @RequestMapping("/")
    public String index(){
        return "ping!";
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

        oneTicket = repo.save(oneTicket);


        logger.info(" ID ="+oneTicket.getId() +" Check if non null");
        redisTicketRepo.save(oneTicket);

        return new ResponseEntity<Iterable<JiraTicket>>(repo.findAll(), HttpStatus.OK);
    }

}
