package spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.app.models.Person;
import spring.app.services.PersonService;

import java.util.List;

@Controller
@RequestMapping("/pc")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @RequestMapping("/createPerson")
    public String createPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person-info";
    }

    @RequestMapping("/savePerson")
    public String savePerson(@ModelAttribute("person") Person person) {
        personService.saveOrUpdate(person);
        return "redirect:/pc/findPersons";
    }


    @GetMapping("/findPersons")
    public String findAll(Model model) {
        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "all-persons";
    }

    @RequestMapping("/updatePerson")
    public String updatePerson(@RequestParam("person_id") int id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "person-info";
    }

    @RequestMapping("/deletePerson")
    public String deletePerson(@RequestParam("id") Integer id) {
        personService.deletePerson(id);
        return "redirect:/pc/findPersons";
    }

}
