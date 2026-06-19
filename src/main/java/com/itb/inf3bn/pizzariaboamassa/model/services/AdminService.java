package com.itb.inf3bn.pizzariaboamassa.model.services;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariaboamassa.model.repository.AdminRepository;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

     // Usando o construtor para injetar a dependência
     
    public AdminService (AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }



}
