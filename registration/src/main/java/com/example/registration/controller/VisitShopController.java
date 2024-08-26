package com.example.registration.controller;

import com.example.registration.entity.VisitShop;
import com.example.registration.service.VisitShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/visit-shop")
public class VisitShopController {

    @Autowired
    private VisitShopService visitShopService;

    @PostMapping
    public ResponseEntity<VisitShop> createVisitShop(@RequestBody VisitShop visitShop) {
        VisitShop createdVisitShop = visitShopService.createOrUpdateVisitShop(visitShop);
        return new ResponseEntity<>(createdVisitShop, HttpStatus.CREATED);
    }
    
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // Handle file upload
        return ResponseEntity.ok("File uploaded successfully");
    }


    @GetMapping("/{id}")
    public ResponseEntity<VisitShop> getVisitShopById(@PathVariable Long id) {
        Optional<VisitShop> visitShop = visitShopService.getVisitShopById(id);
        return visitShop.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<VisitShop>> getAllVisitShops() {
        List<VisitShop> visitShops = visitShopService.getAllVisitShops();
        return ResponseEntity.ok(visitShops);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitShop(@PathVariable Long id) {
        visitShopService.deleteVisitShop(id);
        return ResponseEntity.noContent().build();
    }
}

