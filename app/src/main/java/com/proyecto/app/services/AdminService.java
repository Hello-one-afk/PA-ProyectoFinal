package com.proyecto.app.services;

import com.proyecto.app.models.Admin;
import com.proyecto.app.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private final AdminRepository adminRepository;


    public List<Admin> getAll() throws Exception {
        try {
            return adminRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching data: "+e.getMessage());
        }
    }

    public Admin getAdminByID(Long ID) throws Exception {
        return adminRepository.findById(ID).orElseThrow(
            () -> new Exception("This admin doesn't exist!")
        );
    }

    public void deleteAdminByID(Long ID) throws Exception {
        if (!adminRepository.existsById(ID)) {
            throw new Exception("This admin doesn't exist!");
        }
        adminRepository.deleteById(ID);
    }

    public Admin createAdmin(Admin adminToCreate) throws Exception {
        return adminRepository.save(adminToCreate);
    }

    public Admin updateAdmin(Admin adminDetails) throws Exception {
        Admin adminToUpdate = adminRepository.findById(adminDetails.getId())
        .orElseThrow(() -> new Exception("This admin doesn't exist!"));

        adminToUpdate.setUsername(adminToUpdate.getUsername());
        adminToUpdate.setName(adminToUpdate.getName());
        adminToUpdate.setLastname(adminToUpdate.getLastname());
        adminToUpdate.setEmail(adminToUpdate.getEmail());
        adminToUpdate.setPassword(adminToUpdate.getPassword());

        return adminRepository.save(adminToUpdate);
    }



}
