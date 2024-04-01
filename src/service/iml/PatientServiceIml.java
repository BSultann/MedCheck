package service.iml;

import dao.DaoPatient;
import dao.daoIml.DaoPatientImpl;
import generatedId.GeneratedId;
import generic.GenericService;
import models.Patient;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceIml implements GenericService<Patient> , PatientService {
       DaoPatient dao = new DaoPatientImpl();
       GenericService <Patient> daoGeneric = new DaoPatientImpl();
    @Override
    public String add(Long hospitalId, Patient patient) {
        return daoGeneric.add(hospitalId,patient);
    }

    @Override
    public void removeById(Long id) {
        daoGeneric.removeById(id);

    }

    @Override
    public String updateById(Long id, Patient patient) {
        return daoGeneric.updateById(id,patient);
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return dao.addPatientsToHospital(id,patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return dao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return dao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return dao.sortPatientsByAge(ascOrDesc);
    }
}
