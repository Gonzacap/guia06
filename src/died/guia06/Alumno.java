package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	//--------constructores---------
	
	public Alumno(String nombre, Integer nroLibreta) {
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	public Alumno() {
	
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	//-------geters y seters---------
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}
	
	//------------metodos------------

	public int creditosObtenidos() {
		
		int creditos=0;
		for(Curso curso: aprobados){
			creditos += curso.getCreditos();
		}
		return creditos;
	}

	public void aprobar(Curso c) {
		
		if (cursando.contains(c)) {
			c.quitar(this);
			aprobados.add(c);
			cursando.remove(c);
			System.out.println("El alumno " + this.nombre + " aprobo " + c.getNombre());
		} 
		else {
			System.out.println("El alumno " + this.nombre + " no esta cursando " + c.getNombre());
		}
	}

	public void inscripcionAceptada(Curso c) {
		
		if(c.getInscriptos().contains(this)) {
			System.out.println("El alumno " + this.nombre + " ya esta en el curso");
		}
		else {
			if(c.inscribir(this)) {
				this.cursando.add(c);
			}
			else System.out.println("El alumno " + this.nombre + " no se pudo inscribir al curso");
		}
	}
	
	public int cantCursandoEnCiclo(int ciclo) {
		
		int cant = 0;
		
		for(Curso c :this.cursando) {
			if(c.getCicloLectivo()==ciclo) cant++;			
		}
		return cant;
	}
	
	public Boolean equals(Alumno otro) {
		
		if(this.nroLibreta == otro.nroLibreta) return true;
		else return false;
	}


	@Override
	public Integer compareTo(Alumno otro) {
		return this.nombre.compareTo(otro.nombre);
	}
	

}
