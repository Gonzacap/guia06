package died.guia06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {

	Alumno a1;
	Curso c1,c2,c3,c4;
	ArrayList<Curso> cursosApro,cursando;
	
	@BeforeEach
	public void init(){
		a1 = new Alumno("Juan Dedossi", 12345);
		
		c1 = new Curso(01, "Algoritmos", 2019, 30 , 15, 0);
		c2 = new Curso(02, "Sintaxis", 2020, 20 , 20, 15);
		c3 = new Curso(03, "Paradigmas", 2020, 20 , 20, 15);
		c4 = new Curso(04, "Competitiva", 2021, 30, 25, 35);
		
		cursosApro = new ArrayList<>();
		cursando = new ArrayList<>();
		
		cursosApro.add(c1);
		cursosApro.add(c2);
		cursando.add(c3);
		
		a1.setAprobados(cursosApro);
		a1.setCursando(cursando);
	}
	
	@Test
	void testCreditosObtenidos() {
		
		int esperado = a1.creditosObtenidos();
		assertEquals(esperado,35);
	}

	@Test
	void testAprobar() {
		
		a1.aprobar(c3);
		assertTrue(a1.getAprobados().contains(c3));
	}

	@Test
	void testInscripcionAceptada() {

		a1.inscripcionAceptada(c4);
		assertTrue(a1.getCursando().contains(c4));
	}
	
	
}
