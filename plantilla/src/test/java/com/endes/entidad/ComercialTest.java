package com.endes.entidad;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ComercialTest {

	Comercial c1;
	Comercial c2;
	Empleado e1;
	
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Comercial("47337701K", "Kevin", "Fuentes Benito", 1250.00, 500.50);
		c2 = new Comercial("47337701K", "Kevin", "Fuentes Benito", 1250.00, 100.0);
	}

	@Test
	@DisplayName("Debe obtener las ventas de un comercial")
	void testGetVentas() {
		Double ventasEsperadas = 500.50;
		assertEquals(ventasEsperadas, c1.getVentas(), "Las ventas no coinciden");
		
	}
	
	@Test
	@DisplayName("Debe modificar el valor de las ventas")
	void testSetVentas() {
		Double ventasEsperadas = 800.00;
		c1.setVentas(800.00);
		assertEquals(ventasEsperadas, c1.getVentas(), "El precio no se ha modificado correctamente desde el set");
	}
	
	@Test
	@DisplayName("La modificación del valor no puede ser negativa")
	void testSetVentasNegativo() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
				()->{new Comercial("47337701K", "Kevin", "Fuentes Benito", 1250.00, -5.95);});
		String mensajeEsperado = "El precio no puede ser negativo: -5.95";
		assertEquals(mensajeEsperado, exception.getMessage(), "No se corresponde con el mensaje");
	}
	
	@Test
	@DisplayName("Debe calcular el valor extra de las ventas")
	void testCalcularExtra() {
		Double extraEsperado = c1.getVentas() * 0.10;
		assertEquals(extraEsperado, c1.calcularExtra(), "El valor extra no es el esperado");
	}
	
	@Test
	@DisplayName("Debe obtener el sueldo del Empleado Comercial")
	void testGetSueldo() {
		Double sueldoEsperado = 1250.0 + c1.calcularExtra();
		assertEquals(sueldoEsperado, c1.getSueldo(), "No es el suelo del comercial 1 esperado");
		
		Double sueldoEsperado2 = 1250.0 + c2.calcularExtra();
		assertEquals(sueldoEsperado2, c2.getSueldo(), "No es el sueldo del comercial 2 esperado");
	}

}
