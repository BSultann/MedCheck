package service.iml;

import dao.DaoDoctor;
import dao.daoIml.DaoDoctorImpl;
import generic.GenericService;
import models.Doctor;
import myException.DoctorNotFoundException;
import service.DoctorService;

import java.util.List;

public class DoctorServiceIml implements GenericService<Doctor>, DoctorService {
    DaoDoctor dao = new DaoDoctorImpl();
    GenericService<Doctor> genericDao = new DaoDoctorImpl();
    @Override
    public String add(Long hospitalId, Doctor doctor) {
        return  genericDao.add(hospitalId,doctor);

    }

    @Override
    public void removeById(Long id) {
        genericDao.removeById(id);

    }

    @Override
    public String updateById(Long id, Doctor doctor) {
      return   genericDao.updateById(id,doctor);

    }

    @Override
    public Doctor findDoctorById(Long id) throws DoctorNotFoundException {
       return dao.findDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return dao.assignDoctorToDepartment(departmentId,doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return dao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return dao.getAllDoctorsByDepartmentId(id);
    }
}
