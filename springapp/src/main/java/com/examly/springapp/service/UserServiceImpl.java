package com.examly.springapp.service;

import com.examly.springapp.model.Department;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public User addUser(User user) {
        // If user has a department, ensure it exists or create it
        if (user.getDepartment() != null && user.getDepartment().getDepartmentId() != null) {
            Long deptId = user.getDepartment().getDepartmentId();
            if (!departmentRepository.existsById(deptId)) {
                // Create a default department if it doesn't exist
                Department dept = new Department();
                dept.setDepartmentId(deptId);
                dept.setDepartmentName("Default Department");
                dept.setContactEmail("default@example.com");
                dept.setContactPhone("0000000000");
                departmentRepository.save(dept);
            }
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setUserId(id);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}