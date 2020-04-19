package Excepciones;

public class CreditInsufException extends Exception {

	public CreditInsufException(){
		super("El alumno no posee los creditos suficientes para este curso");
	}
}
