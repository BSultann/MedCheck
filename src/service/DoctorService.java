package service;

import models.Doctor;
import myException.DoctorNotFoundException;

import java.util.List;

public interface DoctorService  {
    Doctor findDoctorById(Long id) throws DoctorNotFoundException;

    // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган Department'ге табылган Doctor'лорду кошуп коюнунуз
    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
    List<Doctor> getAllDoctorsByHospitalId(Long id);
    List<Doctor> getAllDoctorsByDepartmentId(Long id);

}
