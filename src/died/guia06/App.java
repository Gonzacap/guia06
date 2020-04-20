package died.guia06;

import java.util.ArrayList;

import Excepciones.CreditInsufException;
import Excepciones.MaxCursosException;
import Excepciones.RegistroAuditoriaException;
import Excepciones.SinCupoException;
import Excepciones.YaInscException;

public class App {

	public static void main(String[] args) throws Exception {
		
		Alumno a1, a2, a3, a4;
		Curso c1,c2, c3, c4,c5;
		ArrayList<Curso> cursando, aux;
		
		c1 = new Curso(01, "Algoritmos", 2020, 3 , 15, 0);
		c2 = new Curso(02, "Sintaxis", 2020, 2 , 20, 15);
		c3 = new Curso(03, "Paradigmas", 2020, 2 , 20, 15);
		c4 = new Curso(05, "Competitiva", 2020, 3, 25, 35);
		c5 = new Curso(05, "Mat. Disc.", 2020, 3, 15, 0);
		
		a1 = new Alumno("Juan Dedossi", 12345);
		a2 = new Alumno("Lukitas Pro", 12346);
		a3 = new Alumno("Pedro Flores", 12347);
		a4 = new Alumno("Juan Dominguez", 12348);
		
		cursando = new ArrayList<>();
		cursando.add(c2);
		cursando.add(c3);
		
		a2.setCursando(cursando);
		c2.setInscriptos(a2);
		c3.setInscriptos(a2);
		
		
		//No hay cupo
		
		a1.inscripcionAceptada(c1); //inscribo a Juan (Dedossi)
		a2.inscripcionAceptada(c1); //inscribo a Lukitas
		a3.inscripcionAceptada(c1); //inscribo a Pedro
		a4.inscripcionAceptada(c1); //no se pudo inscribir a Juan (Dominguez)
	
		//No cumple con los creditos
		
		a3.inscripcionAceptada(c4); //Pedro no tiene los creditos requeridos para inscribirse a Sintaxis
		
		
		//Cantidad maxima de cursos
		
		c4.inscribir(a2); //no se pudo inscribir a Lukitas a Competitiva, ya esta cursando 3 cursos
		a2.inscripcionAceptada(c4);		
		
		//Aprobar
		
		a3.aprobar(c1); //Pedro aprueba Algoritmos
		c2.inscribir(a3); 
		//a3.inscripcionAceptada(c2);//Pedro ahora puede inscribirse a Sintaxis
		
		System.out.println("");
			
		//Imprimir cursos
		
		c1.imprimirInscriptos(); System.out.println("");
		c2.imprimirInscriptos(); System.out.println("");
		c3.imprimirInscriptos(); System.out.println("");
		c4.imprimirInscriptos(); System.out.println("");
		c5.imprimirInscriptos(); System.out.println("");
	
	
		//Metodo inscribirAlumno con excepciones
	
		try {
			c5.inscribirAlumno(a4);
			
		} catch (YaInscException  | SinCupoException | MaxCursosException | CreditInsufException | RegistroAuditoriaException e){
			System.out.println("Hubo un problema:"+e.getMessage());
			e.printStackTrace();
		}
		
		try {
			c4.inscribirAlumno(a1);
			
		} catch (YaInscException  | SinCupoException | MaxCursosException | CreditInsufException | RegistroAuditoriaException e){
			System.out.println("Hubo un problema:"+e.getMessage());
			e.printStackTrace();
		}
		
	
	}
	
	
	
}
