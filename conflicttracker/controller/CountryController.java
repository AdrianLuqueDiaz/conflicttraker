package com.example.conflicttracker.controller;

import com.example.conflicttracker.dto.CountryDTO;
import com.example.conflicttracker.model.Country;
import com.example.conflicttracker.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        CountryDTO countryDTO = countryService.getAllCountries()
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (countryDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(countryDTO);
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
