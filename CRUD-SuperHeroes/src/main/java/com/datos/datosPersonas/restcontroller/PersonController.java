/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datos.datosPersonas.restcontroller;

import org.springframework.ui.Model;
import com.datos.datosPersonas.entity.Person;
import com.datos.datosPersonas.service.PersonService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    
    @Autowired
    private PersonService service;
    
    @RequestMapping("/")
     public String viewHomePage(HttpSession session, Model model){
        session.getAttribute("mySessionAttribute");
            List<Person> listPerson = service.listAll();
            model.addAttribute("listPerson", listPerson);
            return "index";
     }
    
    
    
    @RequestMapping("/nuevo")
    public String showNewPersonPage(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);

        return "new";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person person){
        service.save(person);
        
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPersonPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        Person person = service.get(id);
        mav.addObject("person", person);

        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
