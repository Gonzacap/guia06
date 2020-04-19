package died.guia06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;

class CursoTest {
	Alumno a1, a2, a3;
	Curso c1,c2, c3, c4;
	ArrayList<Curso> cursando;
	
	@BeforeEach
	public void init(){
		
		c1 = new Curso(01, "Algoritmos", 2019, 30 , 15, 0);
		c2 = new Curso(02, "Sintaxis", 2020, 20 , 20, 15);
		c3 = new Curso(03, "Paradigmas", 2020, 20 , 20, 15);
		c4 = new Curso(04, "Competitiva", 2021, 30, 25, 35);
		
		a1 = new Alumno("Juan Dedossi", 12345);
		a2 = new Alumno("Lukitas Pro", 12346);
		a3 = new Alumno("Pedro Flores", 12347);
		
		cursando = new ArrayList<>();
		cursando.add(c2);
		cursando.add(c3);
		cursando.add(c4);
	}
	
	@Test
	void testSePudoInscribir() {
		boolean inscribir = c1.inscribir(a2);
		boolean contiene = c1.getInscriptos().contains(a2);
		assertTrue(inscribir && contiene);
	}
	
	@Test
	void testNoSePudoInscribir1() {
		a1.setCursando(cursando);
		assertFalse(c1.inscribir(a1) && c1.getInscriptos().contains(a1));
	}
	
	@Test
	void testNoSePudoInscribir2() {
		assertFalse(c3.inscribir(a3) && c3.getInscriptos().contains(a3));
	}
	

}