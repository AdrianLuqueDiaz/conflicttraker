package com.example.conflicttracker.service;

import com.example.conflicttracker.dto.CountryDTO;
import com.example.conflicttracker.model.Country;
import com.example.conflicttracker.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // Obtener todos los países como DTO
    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Obtener país por id como DTO
    public CountryDTO getCountryById(Long id) {
        return countryRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Guardar un país
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    // Eliminar país por id
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    // Conversión a DTO
    private CountryDTO convertToDTO(Country country) {
        return new CountryDTO(country.getId(), country.getNombre());
    }
}
