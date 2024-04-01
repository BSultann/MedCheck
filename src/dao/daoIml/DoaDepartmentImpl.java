package dao.daoIml;

import dao.DaoDepartment;
import dateBase.DataBase;
import generic.GenericService;
import models.Department;
import models.Hospital;

import java.util.List;

public class DoaDepartmentImpl implements GenericService<Department>, DaoDepartment {

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital : DataBase.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital.getDepartments();
            }
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital hospital : DataBase.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getDepartmentName().equals(name)) {
                    return department;
                }
            }
        }
        return null;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        for (Hospital hospital : DataBase.hospitals) {
            if (hospital.getId().equals(hospitalId)) {
                hospital.getDepartments().add(department);
                return "SuccessFully added";
            }
        }
        return null;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : DataBase.hospitals) {
            for (int i = 0; i < hospital.getDepartments().size(); i++) {
                if (hospital.getDepartments().get(i).equals(id)) {
                    hospital.getDepartments().remove(i);
                }
            }


        }

    }

    @Override
    public String updateById(Long id, Department department) {
        for (Hospital hospital:DataBase.hospitals){
            for (int i = 0; i < hospital.getDepartments().size(); i++) {
                if(hospital.getDepartments().get(i).getId().equals(id)){
                    hospital.getDepartments().add(i,department);
                    return "SuccessFully Updated";
                }

            }
        }
        return null;
    }
}
