package generatedId;

import models.Hospital;

public class GeneratedId {
    public static Long hospitalID = 0L;
    public static Long doctorID = 0L;

    public static Long departmentID = 0L;
    public static Long patientID = 0L;


    public static long  getHospital(){
        return ++hospitalID;
    }
    public  static long getDoctor(){
        return ++doctorID;
    }
    public static long getPatient(){
        return ++patientID;
    }
    public static long getDepartment(){
        return ++departmentID;
    }


}
