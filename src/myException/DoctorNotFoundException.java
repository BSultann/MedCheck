package myException;

public class DoctorNotFoundException extends Exception{
    public DoctorNotFoundException(){
        super("Doctor not found");
    }
    public DoctorNotFoundException(String e){
        super(e);

    }

}
