package com.example.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registration.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
