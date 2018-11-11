package com.springframework.bjornpetclinic.controllers;

import com.springframework.bjornpetclinic.model.Pet;
import com.springframework.bjornpetclinic.model.Visit;
import com.springframework.bjornpetclinic.services.PetService;
import com.springframework.bjornpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class VisitController {
    public static final String VIEWS_PETS_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";
    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable Long petId, Model model){
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    @GetMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Long petId, Model model){
        return VIEWS_PETS_CREATE_OR_UPDATE_VISIT_FORM;
    }
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return VIEWS_PETS_CREATE_OR_UPDATE_VISIT_FORM;
        }
        else{
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }


}
