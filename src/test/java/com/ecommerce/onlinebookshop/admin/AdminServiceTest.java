package com.ecommerce.onlinebookshop.admin;

import com.ecommerce.onlinebookshop.model.entity.Adress;
import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
  class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;
    @Test
    void getAllAdmin() {
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        Admin admin3 = new Admin();
        List<Admin> admins = new ArrayList<>();
        admins.add(admin1);
        admins.add(admin2);
        admins.add(admin3);


        when(adminRepository.findAll()).thenReturn(admins);
        List<Admin> result = adminService.getAllAdmin();

        assertEquals(3,result.size());


    }

    @Test
    void getAdminById() {
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        Admin admin3 = new Admin();

        Long id = 1L;
        admin1.setId(id);
        List<Admin> admins = new ArrayList<>();
        admins.add(admin1);
        admins.add(admin2);
        admins.add(admin3);

        when(adminRepository.findById(id)).thenReturn(Optional.of(admin1));
        Optional<Admin> result = adminService.getAdminById(id);

        assertTrue(result.isPresent());
        assertEquals(id,result.get().getId());
    }

    @Test
    void addAmin() {

        Admin admin1 = new Admin();
        Admin admin2 = new Admin();

        List<Admin> admins = new ArrayList<>();
        admins.add(admin1);
        admins.add(admin2);

        when(adminRepository.findAll()).thenReturn(admins);
        List<Admin> result = adminService.getAllAdmin();
        Admin admin3 = new Admin();
        assertEquals(2, result.size());

        admins.add(admin3);
        when(adminRepository.save(admin3)).thenReturn(admin3);
        adminService.addAmin(admin3);

        assertEquals(3, result.size());
        verify(adminRepository, times(1)).save(admin3);
     }

    @Test
    void deleteAdmin() {

        // yesko garna baki cha
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        Admin admin3 = new Admin();

        Long id = 1L;
        admin1.setId(id);
        List<Admin> admins = new ArrayList<>();
        admins.add(admin1);
        admins.add(admin2);
        admins.add(admin3);




        when(adminRepository.findById(id)).thenReturn(Optional.of(admin1));
        Optional<Admin> deleteAdmin = adminService.getAdminById(id);
        adminService.deleteAdmin(id);

        verify(adminRepository,times(1)).deleteById(id);

    }

    @Test
    void findAdminByFirstName() {
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();

        String firstName="Bishal";

        List<Admin> admins = new ArrayList<>();
        admins.add(admin1);
        admins.add(admin2);

        admin1.setFirstName(firstName);
        admin2.setFirstName(firstName);

        when(adminRepository.findAdminByFirstName(firstName)).thenReturn(admins);

        List<Admin> bishalNameAdmin = adminService.findAdminByFirstName(firstName);

        assertEquals(2,bishalNameAdmin.size());
        verify(adminRepository,times(1)).findAdminByFirstName(firstName);



    }

    @Test
    void findAdminByCity() {
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        Admin admin3 = new Admin();

        String cityName="Karlsruhe";

        List<Admin> admins = new ArrayList<>();
        List<Admin> karlsruheAdmin = new ArrayList<>();
        admins.add(admin1);
        admins.add(admin2);


        String city1="Karlsruhe";
        String city2="Hamburg";
        String city3="Karlsruhe";

        Adress adress1= new Adress();
        Adress adress2= new Adress();
        Adress adress3= new Adress();

        adress1.setCityName(city1);
        adress2.setCityName(city2);
        adress3.setCityName(city3);

        karlsruheAdmin.add(admin1);
        karlsruheAdmin.add(admin3);

        admin1.setShippingAddress(adress1);
        admin2.setShippingAddress(adress2);
        admin3.setShippingAddress(adress3);

        when(adminRepository.findAdminByCity(city1)).thenReturn(karlsruheAdmin);
        List<Admin> result = adminService.findAdminByCity(city1);

        assertEquals(2,result.size());

        verify(adminRepository,times(1)).findAdminByCity(city1);


    }

    @Test
    void findAdminByLastName() {
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();

        String lastName="Maharjan";

        List<Admin> admins = new ArrayList<>();
        admins.add(admin1);
        admins.add(admin2);

        admin1.setLastName(lastName);
        admin2.setLastName(lastName);

        when(adminRepository.findAdminByLastName(lastName)).thenReturn(admins);

        List<Admin> bishalNameAdmin = adminService.findAdminByLastName(lastName);

        assertEquals(2,bishalNameAdmin.size());
        verify(adminRepository,times(1)).findAdminByLastName(lastName);
    }
}