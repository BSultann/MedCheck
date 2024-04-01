package dao.daoIml;

import dao.DaoDoctor;
import dateBase.DataBase;
import generic.GenericService;
import models.Department;
import models.Doctor;
import models.Hospital;
import myException.DoctorNotFoundException;

import java.util.ArrayList;
import java.util.Formattable;
import java.util.Iterator;
import java.util.List;

public class DaoDoctorImpl implements GenericService<Doctor>, DaoDoctor {
    @Override
    public Doctor findDoctorById(Long id) throws DoctorNotFoundException {
      try{
        for (Hospital hospital : DataBase.hospitals) {
            for (int i = 0; i < hospital.getDoctors().size(); i++) {
                if (hospital.getDoctors().get(i).getId().equals(id)) {
                    return hospital.getDoctors().get(i);


                }
            }
        }
        return null;
    }catch (Exception e){
          System.out.println("");
      }
        return null;
      }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        StringBuilder result = new StringBuilder();
        result.append("Assigned doctors to department ").append(departmentId).append(": ");
        for (Long doctorId : doctorsId) {
            result.append(doctorId).append(", ");
        }
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }


    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital hospital : DataBase.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital.getDoctors();
            }

        }

        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        try {
            for (Hospital hospital : DataBase.hospitals) {
                for (Department department : hospital.getDepartments()) {
                    if (department.getId().equals(id)) {
                        return department.getDoctors();
                    }
                }
            }
            return new ArrayList<>();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        try {
            for (Hospital hospital : DataBase.hospitals) {
                if (hospital.getId().equals(hospitalId)) {
                    hospital.getDoctors().add(doctor);
                    return "SuccessFully added";
                }


            }
            return "";
        } catch (Exception e) {
            return "not gound id " + e;
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            for (Hospital hospital : DataBase.hospitals) {
                Iterator<Doctor> doctorIterator = hospital.getDoctors().iterator();
                while (doctorIterator.hasNext()) {
                    Doctor doctor = doctorIterator.next();
                    if (doctor.getId().equals(id)) {
                        doctorIterator.remove();
                        System.out.println("Doctor with ID " + id + " removed successfully.");
                    }
                }
            }
            System.out.println("Doctor with ID " + id + " not found.");
        } catch (Exception e) {
            System.out.println("Error occurred while removing doctor: " + e.getMessage());
        }
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        try {
            for (Hospital hospital : DataBase.hospitals) {
                for (int i = 0; i < hospital.getDoctors().size(); i++) {
                    if (hospital.getDoctors().get(i).getId().equals(id)) {
                        hospital.getDoctors().set(i, doctor);
                        return "SuccessFully updated";
                    }

                }
            }

        } catch (Exception e) {
            return "Doctor with ID " + id + " not found";
        }
     return "";
    }
}
