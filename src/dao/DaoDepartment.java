package dao;

import models.Department;

import java.util.List;

public interface DaoDepartment {
    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
}
