
import enums.Gender;
import generatedId.GeneratedId;
import models.Department;
import models.Doctor;
import models.Hospital;
import models.Patient;
import myException.DoctorNotFoundException;
import myException.HospitalNotFoundException;
import service.iml.DepartmentServiceIml;
import service.iml.DoctorServiceIml;
import service.iml.HospitalServiceIml;
import service.iml.PatientServiceIml;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DoctorNotFoundException, HospitalNotFoundException {
        HospitalServiceIml hospitalServiceIml = new HospitalServiceIml();
        DoctorServiceIml doctorServiceIml = new DoctorServiceIml();
        DepartmentServiceIml departmentServiceIml = new DepartmentServiceIml();
        PatientServiceIml patientServiceIml = new PatientServiceIml();
        boolean isTureMenu = true;
        while (isTureMenu) {
            System.out.println("""w
                    1.Hospital
                    2.Doctor
                    3.Department
                    4.Patient
                    5.Exit
                    Пожалуйста, выберите:"");
                    """);
           try{ switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    boolean isTrueHospital = true;
                    while (isTrueHospital) {
                        System.out.println("""
                                1. Add Hospital
                                2. Find Hospital by ID
                                3. Get all Hospitals
                                4. Get all Patients from Hospital
                                5. Delete Hospital by ID
                                6. Get all Hospitals by Address
                                7. Exit
                                    """);
                        switch (new Scanner(System.in).nextInt()) {
                            case 1 -> {
                                Hospital hospital = new Hospital();
                                hospital.setId(GeneratedId.getHospital());
                                System.out.print("write Hospital name: ");
                                hospital.setHospitalName(new Scanner(System.in).nextLine());
                                System.out.print("write Hospital address:  ");
                                hospital.setAddress(new Scanner(System.in).nextLine());
                                System.out.println(hospitalServiceIml.addHospital(hospital));
                            }
                            case 2 -> {
                                System.out.print("write Hospital ID: ");
                                System.out.println(hospitalServiceIml.findHospitalById(new Scanner(System.in).nextLong()));
                            }
                            case 3 -> {
                                System.out.println(hospitalServiceIml.getAllHospital());
                            }
                            case 4 -> {
                                System.out.println("write Hospital ID");
                                System.out.println(hospitalServiceIml.getAllPatientFromHospital(new Scanner(System.in).nextLong()));
                            }
                            case 5 -> {
                                System.out.println("write id");
                                System.out.println(hospitalServiceIml.deleteHospitalById(new Scanner(System.in).nextLong()));
                            }
                            case 6 -> {
                                System.out.println(hospitalServiceIml.getAllHospitalByAddress(new Scanner(System.in).nextLine()));
                            }
                            case 7 -> {
                                isTrueHospital = false;
                            }
                            default -> {
                                System.out.println("give the correct commands");
                            }

                        }

                    }
                }
                case 2 -> {
                    boolean isTrueDoctor = true;
                    while (isTrueDoctor) {
                        System.out.println("""
                                1. Add Doctor
                                2. Remove by ID
                                3. Update by ID
                                4. Find Doctor by ID                          
                                5. Assign Doctor to Department
                                6. Get all Doctors by Hospital ID
                                7. Get all Doctors by Department ID
                                8. Exit
                                                          
                                 """);
                        switch (new Scanner(System.in).nextInt()) {
                            case 1 -> {
                                System.out.println("write id Hospital");
                                Long id = new Scanner(System.in).nextLong();
                                Doctor doctor = new Doctor();
                                doctor.setId(GeneratedId.getDoctor());
                                System.out.print("write name: ");
                                doctor.setFirstName(new Scanner(System.in).nextLine());
                                System.out.print("write Last name: ");
                                doctor.setLastName(new Scanner(System.in).nextLine());
                                System.out.print("write gender: ");
                                doctor.setGender(Gender.valueOf(new Scanner(System.in).nextLine()));
                                System.out.print("write your experience: ");
                                doctor.setExperienceYear(new Scanner(System.in).nextInt());
                                System.out.println(doctorServiceIml.add(id, doctor));
                            }
                            case 2 -> {
                                System.out.print("write id: ");
                                doctorServiceIml.removeById(new Scanner(System.in).nextLong());
                            }
                            case 3 -> {
                                System.out.println("write Hospital ID");
                                Long id = new Scanner(System.in).nextLong();
                                Doctor newDoctor = new Doctor();
                                System.out.println("Write newName");
                                newDoctor.setFirstName(new Scanner(System.in).nextLine());
                                System.out.println("write newLastName");
                                newDoctor.setLastName(new Scanner(System.in).nextLine());
                                System.out.println("Write new Gender");
                                System.out.println("MALEOrFEMALE");
                                newDoctor.setGender(Gender.valueOf(new Scanner(System.in).nextLine()));
                                System.out.println("write new Experience");
                                newDoctor.setExperienceYear(new Scanner(System.in).nextInt());
                                System.out.println(doctorServiceIml.updateById(id, newDoctor));
                            }
                            case 4 -> {
                                System.out.println("write doctor id ");
                                System.out.println(doctorServiceIml.findDoctorById(new Scanner(System.in).nextLong()));
                            }
                            case 5 -> {

                            }
                            case 6 -> {
                                System.out.print("Write id Hospital: ");
                                System.out.println(doctorServiceIml.getAllDoctorsByHospitalId(new Scanner(System.in).nextLong()));
                            }
                            case 7 -> {
                                System.out.print("write id department:  ");
                                System.out.println(doctorServiceIml.getAllDoctorsByDepartmentId(new Scanner(System.in).nextLong()));
                            }
                            case 8 -> {
                                isTrueDoctor = false;
                            }
                        }
                    }


                }
                case 3 -> {
                    boolean isTrueDepartment = true;
                    while (isTrueDepartment) {
                        System.out.println("""
                                1. Add Department
                                2. Find Department by Name
                                3. Get All Departments by Hospital
                                4. Remove by ID
                                5. Update by ID
                                6. Exit
                                     """);
                        switch (new Scanner(System.in).nextInt()) {
                            case 1 -> {
                                Department department = new Department();
                                department.setId(GeneratedId.getDepartment());
                                System.out.println("write id Hospital");
                                Long idHospital = new Scanner(System.in).nextLong();
                                System.out.print("Write name: ");
                                department.setDepartmentName(new Scanner(System.in).nextLine());
                                System.out.println(departmentServiceIml.add(idHospital, department));
                            }
                            case 2 -> {
                                System.out.println("write name Department");
                                System.out.println(departmentServiceIml.findDepartmentByName(new Scanner(System.in).nextLine()));
                            }
                            case 3 -> {
                                System.out.println("write hospital ID");
                                System.out.println(departmentServiceIml.getAllDepartmentByHospital(new Scanner(System.in).nextLong()));
                            }
                            case 4 -> {
                                System.out.println("write id: ");
                                departmentServiceIml.removeById(new Scanner(System.in).nextLong());

                            }
                            case 5 -> {
                                System.out.println("write Hospital id");
                                Long idHospital = new Scanner(System.in).nextLong();
                                Department department = new Department();
                                department.setId(GeneratedId.getDepartment());
                                System.out.println("write new Name");
                                department.setDepartmentName(new Scanner(System.in).nextLine());
                                System.out.println(departmentServiceIml.updateById(idHospital, department));

                            }
                            case 6 -> {
                                isTrueDepartment = false;
                            }
                        }
                    }
                }
                case 4-> {
                    boolean isTurePatient = true;
                    while (isTurePatient) {
                        System.out.println("""
                                1. Add Patient
                                2. Get Patient by ID
                                3. Sort Patients by Age
                                4. Remove Patient by ID
                                5. Update Patient Information by ID
                                6. Add Patients to Hospital
                                7. Get Patients by Age
                                8. Exit
                                """);
                        switch (new Scanner(System.in).nextInt()) {
                            case 1 -> {
                                Patient patient = new Patient();
                                System.out.println("write id Hospital: ");
                                Long idHospital = new Scanner(System.in).nextLong();
                                patient.setId(GeneratedId.getPatient());
                                System.out.println("write name: ");
                                patient.setFirstName(new Scanner(System.in).nextLine());
                                System.out.println("write age");
                                patient.setAge(new Scanner(System.in).nextInt());
                                System.out.println("write LastName: ");
                                patient.setLastName(new Scanner(System.in).nextLine());
                                System.out.println("write gender    MALEorFEMALE");
                                patient.setGender(Gender.valueOf(new Scanner(System.in).nextLine()));
                                System.out.println(patientServiceIml.add(idHospital, patient));
                            }
                            case 2 -> {
                                System.out.println("write patient id");
                                System.out.println(patientServiceIml.getPatientById(new Scanner(System.in).nextLong()));
                            }
                            case 3 -> {
                                System.out.println(patientServiceIml.sortPatientsByAge(new Scanner(System.in).nextLine()));
                            }
                            case 4 -> {
                                System.out.println("write id patient");
                                patientServiceIml.removeById(new Scanner(System.in).nextLong());
                            }
                            case 5 -> {
                                System.out.println("департментин id жаз");
                                System.out.println("write id patient");
                                Long idPatient = new Scanner(System.in).nextLong();
                                Patient newPatient = new Patient();
                                System.out.println("write name");
                                newPatient.setFirstName(new Scanner(System.in).nextLine());
                                System.out.println("write lastName");
                                newPatient.setLastName(new Scanner(System.in).nextLine());
                                System.out.println("write Age");
                                newPatient.setAge(new Scanner(System.in).nextInt());
                                System.out.println("write Gender");
                                newPatient.setGender(Gender.valueOf(new Scanner(System.in).nextLine()));
                                System.out.println(patientServiceIml.updateById(idPatient, newPatient));
                            }
                            case 6 -> {
                                System.out.println();
                               //  patientServiceIml.addPatientsToHospital();
                            }
                            case 7 -> {
                                isTurePatient = false;
                            }
                            default -> {
                                System.out.println("hot found choice");
                            }


                        }
                    }
                }case 5->{
                   System.exit(0);
               }
            }

        }catch (InputMismatchException e){
               System.err.println("Input error");
        }
    }
}


