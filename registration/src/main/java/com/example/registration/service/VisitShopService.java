package com.example.registration.service;

import com.example.registration.entity.VisitShop;
import com.example.registration.repository.VisitShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitShopService {

    @Autowired
    private VisitShopRepository repository;

    public VisitShop createOrUpdateVisitShop(VisitShop visitShop) {
        return repository.save(visitShop);
    }

    public Optional<VisitShop> getVisitShopById(Long id) {
        return repository.findById(id);
    }

    public void deleteVisitShop(Long id) {
        repository.deleteById(id);
    }

    public List<VisitShop> getAllVisitShops() {
        return repository.findAll();
    }
}
