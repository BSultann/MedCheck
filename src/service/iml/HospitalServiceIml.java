package service.iml;

import dao.DaoHospital;
import dao.daoIml.DaoHospitalImpl;
import generic.GenericService;
import models.Hospital;
import models.Patient;
import myException.HospitalNotFoundException;
import service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceIml implements  HospitalService {
DaoHospital dao = new DaoHospitalImpl();

    @Override
    public String addHospital(Hospital hospital) {
      return   dao.addHospital(hospital);

    }

    @Override
    public Hospital findHospitalById(Long id) throws HospitalNotFoundException {
     return   dao.findHospitalById(id);

    }

    @Override
    public List<Hospital> getAllHospital() {
       return dao.getAllHospital();

    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return dao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return dao.deleteHospitalById(id);
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return dao.getAllHospitalByAddress(address);
    }
}
