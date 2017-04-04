package com.ipartek.formacion.nagore;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ipartek.formacion.nagore.domain.Receta;

/**
 * Test para comprobar la dependecia hacia el Model
 * 
 * @author Curso
 *
 */
public class TestDependencyWr17Service {

	/**
	 * Test de dependencia hacia el Model
	 */
	@Test()
	public void test() {
		Receta r = new Receta();
		assertNotNull(r);
	}

}
