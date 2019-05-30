package com.palebluedotstardust;

import org.springframework.data.repository.CrudRepository;

public interface JiraRepo extends CrudRepository<JiraTicket,Long>{
}
