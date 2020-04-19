package died.guia06;

import java.util.List;


public class Alumno implements Comparable {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public int creditosObtenidos() {
		return 1;
	}

	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		//
	}
	
	public Boolean equals(Alumno otro) {
		
		if(this.nroLibreta == otro.nroLibreta) return true;
		else return false;
	}

	public int compareTo(Alumno otro) {
		
		return this.nombre.compareTo(otro.nombre);
	}
	
	

}
