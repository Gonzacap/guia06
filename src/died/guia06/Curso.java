package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Excepciones.CreditInsufException;
import Excepciones.MaxCursosException;
import Excepciones.RegistroAuditoriaException;
import Excepciones.SinCupoException;
import Excepciones.YaInscException;
import died.guia06.util.Registro;


/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	
	//----------constructores------
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}

	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo,
			Integer creditos, Integer creditosRequeridos) {
		
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	
	//----------geters y seters---------
	
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCicloLectivo() {
		return cicloLectivo;
	}

	public Integer getCupo() {
		return cupo;
	}

	public List<Alumno> getInscriptos() {
		return inscriptos;
	}

	public int getCreditos() {
		return creditos;
	}

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public Registro getLog() {
		return log;
	}
	
	public void setInscriptos(Alumno a) {
		this.inscriptos.add(a);
	}
	
	//----------metodos------------
	

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */

	
	public boolean inscribir(Alumno a) {
		
		int cantCursando = a.cantCursandoEnCiclo(this.cicloLectivo);
		int cantCred = a.creditosObtenidos();
		
		if(cantCursando<3 && this.getCupo()>0 && this.getCreditosRequeridos()<=cantCred) {
			
			try {
				log.registrar(this, "inscribir ",a.toString());
				
			}
			catch(IOException e){
				System.out.println("Hubo un problema:"+e.getMessage());
				e.printStackTrace();
			}
			
			this.inscriptos.add(a);
			this.cupo--;
			
			return true;
		}
		else return false;
	}

	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */

	
	public void imprimirInscriptos()  {
		
		if(this.inscriptos.size() > 0) {
			CompararAlfabeticamente comparacion = new CompararAlfabeticamente();
			Collections.sort(inscriptos, comparacion);
			
			System.out.println("Inscriptos en " + this.nombre + "\n");
			
			for(int i=0; i<inscriptos.size() ; i++){
				System.out.println("Nombre: "+inscriptos.get(i).getNombre() +" , Nro. Libreta: " + inscriptos.get(i).getNroLibreta() );	
			}

		}
		else System.out.println("No hay inscriptos en el curso "+this.getNombre()+"\n");
	
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		}
		catch(IOException e){
			System.out.println("Hubo un problema:"+e.getMessage());
			e.printStackTrace();
		}
		
	}

	public void quitar(Alumno a) {
		this.inscriptos.remove(a);
	}
	
	public Boolean inscribirAlumno(Alumno a) throws Exception {
		
		int cantCursando = a.cantCursandoEnCiclo(this.getCicloLectivo());
		int cantCred = a.creditosObtenidos();
		
		if(!this.inscriptos.contains(a)){
			if(this.getCreditosRequeridos()<=cantCred){
				if(cantCursando < 3){
					if(this.getCupo()>0){
						
						try {
							log.registrar(this, "inscribir ",a.toString());	
						}
						catch (IOException e) {
							System.out.println("Hubo un problema:"+e.getMessage());
							e.printStackTrace();		
						}
						
						this.inscriptos.add(a);
						this.cupo--;
						return true;
					}
					else throw new SinCupoException();
				}
				else throw new MaxCursosException();
			}
			else throw new CreditInsufException();
		}
		else throw new YaInscException();	

	}
	
	
}
