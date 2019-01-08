package com.xelvias;

import com.xelvias.models.Person;
import com.xelvias.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
class PersonController {

    @Autowired
    IPersonService personService;

    @RequestMapping(value={"/person"},method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getAll(){
        return personService.getAllPersons();
    }


}
