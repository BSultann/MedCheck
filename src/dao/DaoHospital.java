package dao;

import models.Hospital;
import models.Patient;
import myException.HospitalNotFoundException;

import java.util.List;
import java.util.Map;

public interface DaoHospital {
    String addHospital(Hospital hospital);
    Hospital findHospitalById(Long id) throws HospitalNotFoundException;
    List<Hospital> getAllHospital();
    List<Patient> getAllPatientFromHospital(Long id);
    String deleteHospitalById(Long id);
    Map<String, Hospital> getAllHospitalByAddress(String address);
}

