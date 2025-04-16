package com.ecommerce.onlinebookshop.admin;

import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
@PreAuthorize("ADMIN")
  class AdminController {

    private  final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmin(){
        List<Admin> admins= adminService.getAllAdmin();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id){
        Optional<Admin> admin= adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
         Admin savedAdmin= adminService.addAmin(admin);
         return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
