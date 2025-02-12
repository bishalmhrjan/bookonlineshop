package com.ecommerce.onlinebookshop.controller;

import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import com.ecommerce.onlinebookshop.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private  final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable Long id){
        return adminService.getAdminById(id);
    }


    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin){
        return adminService.addAmin(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
    }
}
