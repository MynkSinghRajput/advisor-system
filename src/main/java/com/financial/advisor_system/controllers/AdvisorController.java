package com.financial.advisor_system.controllers;

import com.financial.advisor_system.entities.Advisor;
import com.financial.advisor_system.repositories.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController // Tells Spring: "This class handles web requests"
@RequestMapping("/advisors") // Tells Spring: "All URLs starting with /advisors come here"
public class AdvisorController {

    @Autowired // Automatically connects the Repository we made earlier
    private AdvisorRepository advisorRepository;

    // 1. GET ALL ADVISORS
    // URL: http://localhost:8080/advisors
    @GetMapping
    public List<Advisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    // 2. GET ONE ADVISOR BY ID
    // URL: http://localhost:8080/advisors/1
    @GetMapping("/{id}")
    public Advisor getAdvisorById(@PathVariable Long id) {
        return advisorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Advisor not found"));
    }

    // 3. CREATE A NEW ADVISOR
    // URL: POST http://localhost:8080/advisors
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Advisor createAdvisor(@RequestBody Advisor newAdvisor) {
        return advisorRepository.save(newAdvisor);
    }

    // 4. DELETE AN ADVISOR
    // URL: DELETE http://localhost:8080/advisors/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdvisor(@PathVariable Long id) {
        advisorRepository.deleteById(id);
    }
}