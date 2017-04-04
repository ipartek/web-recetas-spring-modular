package com.ipartek.formacion.nagore;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ipartek.formacion.nagore.domain.Receta;

/**
 * Test de compracion de dependencia
 * 
 * @author Curso
 *
 */
public class TestDependencyWr17Model {

	/**
	 * Test de dependencia
	 */

	@Test()
	public void test() {
		Receta r = new Receta();
		assertNotNull(r);
	}

}
