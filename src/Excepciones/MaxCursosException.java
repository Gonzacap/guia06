package Excepciones;

public class MaxCursosException extends Exception{

	public MaxCursosException(){
		super("El alumno llego al limite de cursos en este ciclo");
	}
}
