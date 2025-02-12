package com.ecommerce.onlinebookshop.service;

import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import com.ecommerce.onlinebookshop.repository.AdminRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();

    }

    public Optional<Admin> getAdminById(Long id){
        return  adminRepository.findById(id);
    }

    public Admin addAmin(Admin admin){
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id){
        adminRepository.deleteById(id);
    }

}
