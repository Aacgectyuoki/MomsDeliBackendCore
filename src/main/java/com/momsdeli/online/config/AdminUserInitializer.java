//package com.momsdeli.online.config;
//
//import com.momsdeli.online.service.impl.AdminService;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//
//
///**
//
// * @author Shahbaz Khan
// * @date 28/08/2024
// */
//
//@Configuration
//public class AdminUserInitializer {
//
//    private final AdminService adminService;
//
//    public AdminUserInitializer(AdminService adminService) {
//        this.adminService = adminService;
//    }
//
//    @Bean
//    CommandLineRunner createAdminUserOnStartup() {
//        return args -> {
//            String username = "admin";
//            String email = "shahbazaliiq@gmail.com";
//            String password = "Dell0312";
//
//            try {
//                adminService.createAdminUser(username, email, password);
//                System.out.println("Admin user created successfully.");
//            } catch (Exception e) {
//                System.out.println("Admin user creation failed: " + e.getMessage());
//            }
//        };
//    }
//}