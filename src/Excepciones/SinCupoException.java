package Excepciones;

public class SinCupoException extends Exception{
	
	public SinCupoException() {
		super("El curso tiene el cupo completo");
	}
}
