package dao.daoIml;

import dao.DaoPatient;
import dateBase.DataBase;
import generic.GenericService;
import models.Doctor;
import models.Hospital;
import models.Patient;

import java.util.*;
import java.util.stream.Collectors;

public class DaoPatientImpl implements GenericService<Patient>, DaoPatient {

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital:DataBase.hospitals){
            if(hospital.getPatients().equals(id)){
                hospital.getPatients().addAll(patients);
                return "SuccessFully added";
            }
        }
        return null;
    }

    @Override
    public Patient getPatientById(Long id) {
        return DataBase.hospitals.stream()
                .flatMap(hospital -> hospital.getPatients().stream())
                .filter(patient -> patient.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        for (Hospital hospital : DataBase.hospitals ) {
            Comparator<Patient> sort = Comparator.comparing(Patient::getAge);
            if (ascOrDesc.equalsIgnoreCase("asc")) {
                hospital.getPatients().sort(sort);
                return hospital.getPatients();
            } else {
                Comparator<Patient> sort2 = Comparator.comparing(Patient::getAge).reversed();
                hospital.getPatients().sort(sort);
                return hospital.getPatients();
            }
        }
return null;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        for (Hospital hospital:DataBase.hospitals){
           if(hospital.getId().equals(hospitalId)){
               hospital.getPatients().add(patient);
               return "SuccessFully added";
           }
        }
        return null;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital: DataBase.hospitals){
            for (int i = 0; i < hospital.getPatients().size(); i++) {
                if(hospital.getPatients().get(i).getId().equals(i)){
                    hospital.getPatients().remove(i);
                }

            }
        }

    }

    @Override
    public String updateById(Long id, Patient patient) {
        for (Hospital hospital : DataBase.hospitals) {
            for (int i = 0; i <hospital.getPatients().size() ; i++) {
                if(hospital.getPatients().get(i).getId()==id){
                    hospital.getPatients().set(i,patient);
                    return "SuccessFully updated";
                }

            }

        }

        return null;
    }
}