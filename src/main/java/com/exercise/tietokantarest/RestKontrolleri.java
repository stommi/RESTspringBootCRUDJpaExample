package com.exercise.tietokantarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RestKontrolleri {
    @Autowired
    HuonekaluRepository hr;

    @GetMapping("/huonekalut")
    public Iterable<Huonekalut> getAll() {
        return hr.findAll();
    }

    @PostMapping("/huonekalut")
    public String postNewHuonekalu(@RequestBody Huonekalut huonekalut) {
        try {
            hr.save(huonekalut);
            return "Uusi huonekalu lisätty onnistuneesti.";
        } catch (Exception e) {
            System.err.println(e);
        } return "Huonekalun lisäys epäonnistui. Syötithän nimen.";
    }

    @DeleteMapping("/huonekalut/{id}")
    public String deleteHuonekalu(@PathVariable(name = "id", required = true) Integer id) {
        try {
            hr.deleteById(id);
            return "Huonekalu poistettu onnistuneesti.";
        } catch (Exception e) {
            System.err.println(e);
        } return "Id:tä " + id + " ei löydy.";
    }

    @PutMapping("/huonekalut/{id}")
    public String muokkaaHuonekalu(@RequestBody Huonekalut huonekalut, @PathVariable(name = "id", required = true) Integer id) {
        try {
            Optional<Huonekalut> huonekaluToUpdate = hr.findById(id);
            Optional<Huonekalut> updatedHuonekalu = huonekaluToUpdate;
            updatedHuonekalu.get().setNimi(huonekalut.getNimi());
            updatedHuonekalu.get().setVari(huonekalut.getVari());
            updatedHuonekalu.get().setLkm(huonekalut.getLkm());
            hr.save(updatedHuonekalu.get());

            return "Huonekalun tiedot päivitetty onnistuneesti";

        } catch (Error e) {
            System.err.println(e);
        }
        return "Huonekalun päivitys epäonnistui.";
    }

    @GetMapping("/huonekalut/{id}")
    public Optional<Huonekalut> getHuonekaluById(@PathVariable(name = "id", required = true) Integer id) {
        return hr.findById(id);
    }

    @GetMapping("/punaisethuonekalut")
    public Iterable<Huonekalut> getPunaisetHuonekalut() {
        return hr.getPunaisetHuonekalut();
    }

    @GetMapping("/huonekalutmaarittain{maara}")
    public Iterable<Huonekalut> getHuonekalutByMaara(@RequestParam(name="maara", required=true) Integer maara) {
        return hr.getHuonekalutByMaara(maara);
    }

    @GetMapping("/ruskeathuonekaluryhmat")
    public Iterable<Huonekalut> getRuskeatHuonekaluryhmat() {
        return hr.getRuskeatHuonekaluryhmat();
    }

}
