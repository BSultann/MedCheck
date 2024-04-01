package dao.daoIml;

import dao.DaoHospital;
import dateBase.DataBase;
import generic.GenericService;
import models.Hospital;
import models.Patient;
import myException.HospitalNotFoundException;

import java.util.*;

public class DaoHospitalImpl implements DaoHospital {
    @Override
    public String addHospital(Hospital hospital) {
        try {
            DataBase.hospitals.add(hospital);
            return "Hospital successfully added.";
        } catch (Exception e) {
            return "Error occurred while adding hospital: " + e.getMessage();
        }
    }

    @Override
    public Hospital findHospitalById(Long id) throws HospitalNotFoundException {
        for (Hospital hospital : DataBase.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital;
            }
        }
        throw new HospitalNotFoundException("not found");
    }

    @Override
    public List<Hospital> getAllHospital() {
        try {
            return DataBase.hospitals;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        try {
            for (Hospital hospital : DataBase.hospitals) {
                if (hospital.getId().equals(id)) {
                    return hospital.getPatients();
                }
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    @Override
    public String deleteHospitalById(Long id) {
        try {
            for (Hospital hospital : DataBase.hospitals) {
                if (hospital.getId().equals(id)) {
                    DataBase.hospitals.remove(hospital);
                    return "Hospital with ID " + id + " deleted successfully.";
                }
            }
            return "Hospital with ID " + id + " not found.";
        } catch (Exception e) {
            return "Error occurred while deleting hospital: " + e.getMessage();

        }
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> hospitalsByAddress = new HashMap<>();

        try {
            for (Hospital hospital : DataBase.hospitals) {
                if (hospital.getAddress().equals(address)) {
                    hospitalsByAddress.put(hospital.getHospitalName(), hospital);
                }
            }
        } catch (Exception e) {
            return new HashMap<>();
        }

        return hospitalsByAddress;
    }
}


