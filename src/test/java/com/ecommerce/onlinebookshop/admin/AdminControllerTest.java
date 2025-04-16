package com.ecommerce.onlinebookshop.admin;

import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

   @Autowired
   private MockMvc mockMvc;
   @Autowired
   private ObjectMapper objectMapper;

  @MockitoBean
  private AdminService adminService;

  private final String BASE_URL ="/api/admins";

    @Test
    @WithMockUser(username = "admin", roles={"ADMIN"})
    void getAllAdmin() throws Exception {
        Admin admin1 = Admin.builder()
                .firstName("admin1")
                .id(1L)
                .email("admin@example.de")
                .build();

        Admin admin2 = Admin.builder()
                .firstName("admin2")
                .id(2L)
                .email("admin2@example.de")
                .build();

        List<Admin> admins = new ArrayList<>();
        admins.add(admin1);
        admins.add(admin2);


        when(adminService.getAllAdmin()).thenReturn(admins);

        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].email").value("admin@example.de"))
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].firstName").value("admin1"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void getAdminById_shouldResturnAdmin_WhenExists() throws Exception {
        Admin admin = Admin.builder()
                .id(1L)
                .build();
        when(adminService.getAdminById(1L)).thenReturn(Optional.of(admin));

        mockMvc.perform(get(BASE_URL + "/admins/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void getAdminById_ShouldReturn404_whenNotFound() throws  Exception{
        when(adminService.getAdminById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get(BASE_URL+"/admins/1"))
                .andExpect(status().isNotFound());

    }

    @Test
    void createAdmin_shouldReturnCreatedAdmin() throws  Exception {
    Admin inputAdmin = Admin.builder()
            .firstName("admin1")
            .email("admin@gmail.com")
            .id(null)
            .build();


        Admin secondAdmin = Admin.builder()
                .firstName("admin1")
                .email("admin@gmail.com")
                .id(1L)
                .build();

        when(adminService.addAmin(any(Admin.class))).thenReturn(secondAdmin);

        mockMvc.perform(post("/api/admins")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputAdmin)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("admin1"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})

    void deleteAdmin_ShouldReturnNoContent() throws  Exception{

        doNothing().when(adminService).deleteAdmin(1L);
        mockMvc.perform(delete(BASE_URL+"/admins/1")
                        .with(csrf()))
                .andExpect(status().isNoContent());
    verify(adminService,times(1)).deleteAdmin(1L);
    }
}