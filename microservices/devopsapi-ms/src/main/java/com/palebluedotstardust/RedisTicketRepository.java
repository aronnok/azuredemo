package com.palebluedotstardust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisTicketRepository {

    private HashOperations hashOperations;

    @Autowired
    private RedisTemplate redisTemplate;

    public RedisTicketRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(JiraTicket ticket){
        hashOperations.put("JIRA", ticket.getId(), ticket);
    }
    public List findAll(){
        return hashOperations.values("JIRA");
    }

    public JiraTicket findById(String id){
        return (JiraTicket) hashOperations.get("JIRA", id);
    }

//    public void update(User user){
//        save(user);
//    }
//
//    public void delete(String id){
//        hashOperations.delete("USER", id);
//    }

}