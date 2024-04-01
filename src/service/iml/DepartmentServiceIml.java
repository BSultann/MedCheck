package service.iml;

import dao.DaoDepartment;
import dao.daoIml.DaoDoctorImpl;
import dao.daoIml.DoaDepartmentImpl;
import generic.GenericService;
import models.Department;
import models.Doctor;
import service.DepartmentService;

import java.util.List;

public class DepartmentServiceIml implements GenericService<Department>,DepartmentService {
  DaoDepartment daoDepartment = new DoaDepartmentImpl();
  GenericService<Department> daoGeneric = new DoaDepartmentImpl();
    @Override
    public String add(Long hospitalId, Department department) {
        return daoGeneric.add(hospitalId,department);
    }

    @Override
    public void removeById(Long id) {
        daoGeneric.removeById(id);
    }

    @Override
    public String updateById(Long id, Department department) {
        return updateById(id,department);
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return daoDepartment.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return daoDepartment.findDepartmentByName(name);
    }
}
