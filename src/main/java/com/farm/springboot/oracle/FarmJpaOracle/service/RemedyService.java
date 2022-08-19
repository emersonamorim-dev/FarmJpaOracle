package com.farm.springboot.oracle.FarmJpaOracle.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.farm.springboot.oracle.FarmJpaOracle.model.Remedy;
import com.farm.springboot.oracle.FarmJpaOracle.repository.RemedyRepository;

@Service
public class RemedyService {

    @Autowired
    RemedyRepository remedyRepository;

    public List<Remedy> getAll() {
        return (List<Remedy>) remedyRepository.findAll();
    }

    public String addRemedy(Remedy rem) {
        String response;
        if (remedyRepository.save(rem) != null)
            response = "Success";
        else
            response = "Faild";
        return response;
    }

    public String editRemedy(Remedy rem) {
        String response;
        if (remedyRepository.save(rem) != null)
            response = "Edit Success";
        else
            response = "Edit Faild!";
        return response;
    }

    public String deleteRemedy(int id) {
        String response;
        try {
            remedyRepository.deleteById(id);
            response = "Delete Success";
        } catch (IllegalArgumentException e) {
            response = "Delete False";
        }
        return response;
    }

    public Map<String, Object> get(int pageno, int pagesize, String sortBy) {
        Map<String, Object> response = new HashMap<String, Object>();
        PageRequest pageable = PageRequest.of(pageno, pagesize, Sort.by(sortBy));
        Page<Remedy> page = remedyRepository.findAll(pageable);
        response.put("count", page.getTotalElements());
        response.put("currentPage", page.getNumber());
        response.put("totalPages", page.getTotalPages());
        response.put("data", page.getContent());
        return response;

    }

    public List<Remedy> search(String searchword) {
        return remedyRepository.findRemedy(searchword);
    }

}
