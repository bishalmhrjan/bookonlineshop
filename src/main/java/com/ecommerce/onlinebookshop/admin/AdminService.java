package com.ecommerce.onlinebookshop.admin;

import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import com.ecommerce.onlinebookshop.admin.AdminRepository;
import com.ecommerce.onlinebookshop.utility.ConcreteValidChecker;
import com.ecommerce.onlinebookshop.utility.ValidChecker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class AdminService {
    /**
     * crud operations
     */
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();

    }

    public Optional<Admin> getAdminById(Long id){
        if(ConcreteValidChecker.validId(id)){
            return  adminRepository.findById(id);
        }
        throw new RuntimeException("Invalid Id");
    }

    @Transactional  public Admin addAmin(Admin admin){
      if(admin == null){
          throw  new IllegalArgumentException("Admin can not be null");
      }
        if(adminRepository.findAdminByEmail(admin.getEmail()).isEmpty()){
            return adminRepository.save(admin);

        }
        throw new IllegalArgumentException("Adming with email address "+admin.getEmail()+" already exists!");
    }

    @Transactional public void deleteAdmin(Long id){
        if(ConcreteValidChecker.validId(id) && adminRepository.getReferenceById(id) != null){
            adminRepository.deleteById(id);
        }
        adminRepository.deleteById(id);
    }


    public List<Admin> findAdminByFirstName(String email){
        if(!email.isEmpty() && email != null){
            return adminRepository.findAdminByFirstName(email);
        }
        throw  new IllegalArgumentException("Email is invalid!!!");

    }
    public List<Admin> findAdminByCity(String city){
        if(!city.isEmpty() && city !=null){
            return adminRepository.findAdminByCity(city);
        }
        throw new IllegalArgumentException("City is invalid!!!");
    }

    public List<Admin> findAdminByLastName(String lastName){
        if(!lastName.isEmpty() && lastName != null){
            return   adminRepository.findAdminByLastName(lastName);

        }
        throw new IllegalArgumentException("lastname is invalid");
    }


}
