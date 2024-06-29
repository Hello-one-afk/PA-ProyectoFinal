package com.proyecto.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.app.models.Admin;
import com.proyecto.app.services.AdminService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService AdminService;

    @GetMapping()
    public ResponseEntity<?> getAllAdmins() throws Exception {
        try {
            return ResponseEntity.ok(AdminService.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{adminID}")
    public ResponseEntity<?> getAdminByID(@PathVariable Long adminID) throws Exception {
        try {
            return ResponseEntity.ok(AdminService.getAdminByID(adminID));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createAdmin(@RequestBody Admin adminToCreate) throws Exception {
        try {
            return ResponseEntity.ok(AdminService.createAdmin(adminToCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{adminID}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Long adminID) throws Exception {
        try {
            AdminService.deleteAdminByID(adminID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateAdmin(@RequestBody Admin adminDetails) throws Exception {
        try {
            return ResponseEntity.ok(AdminService.updateAdmin(adminDetails));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }




}
