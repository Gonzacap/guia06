package Excepciones;

public class YaInscException extends Exception{
	
	public YaInscException(){
		super("El alumno ya esta inscripto");
	}
}
