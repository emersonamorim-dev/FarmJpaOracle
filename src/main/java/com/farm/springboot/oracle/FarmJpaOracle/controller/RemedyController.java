package com.farm.springboot.oracle.FarmJpaOracle.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.springboot.oracle.FarmJpaOracle.model.Remedy;
import com.farm.springboot.oracle.FarmJpaOracle.service.RemedyService;

@RestController
@RequestMapping("/remedy")
public class RemedyController {

    @Autowired
    RemedyService remedyService;

    @GetMapping("/")
    public List<Remedy> getAll() {
        return remedyService.getAll();

    }

    @PostMapping("/")
    public String addRemedy(@RequestBody Remedy rem) {
        return remedyService.addRemedy(rem);
    }

    @PutMapping("/")
    public String editRemedy(@RequestBody Remedy rem) {
        return remedyService.editRemedy(rem);
    }

    public String DeleteRemedy(@PathVariable("id") int id) {
        return remedyService.deleteRemedy(id);
    }

    @GetMapping("/page")
    public Map<String, Object> get(@RequestParam(value = "pageno", required = false, defaultValue = "0") int pageno,
            @RequestParam(value = "pagesize", required = false, defaultValue = "8") int pagesize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortby) {

        return remedyService.get(pageno, pagesize, sortby);
    }

    public List<Remedy> search(@RequestParam(value = "searchword") String searchword) {
        return remedyService.search(searchword);
    }

}
