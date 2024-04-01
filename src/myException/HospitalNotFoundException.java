package myException;

public class HospitalNotFoundException  extends Exception{
    public HospitalNotFoundException(){
        super("Hospital hot found");
    }
    public HospitalNotFoundException(String e){
        super(e);

    }
}
