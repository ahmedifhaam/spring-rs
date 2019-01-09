package com.xelvias.extraconfigurations;

import com.xelvias.dao.PersonDao;
import com.xelvias.dao.PersonDaoImpl;
import com.xelvias.services.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.xelvias"})
public class configurations {

    @Bean
    public PersonDao getPersonDao(){
        return new PersonDaoImpl();
    }

    @Bean
    public PersonServiceImpl getPersonService(){
        return new PersonServiceImpl();
    }
}
