/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderotulcan.modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe
 */
public class ServicioServidorUniversidadTest {
    
    public ServicioServidorUniversidadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of datosConductorCedula method, of class ServicioServidorUniversidad.
     */
    @Test
    public void testDatosConductorCedula() {
        System.out.println("datosConductorCedula");
        String entradaCedula = "1111";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        String expResult = "{\"cedula\":\"1111\",\"codigo\":\"123\",\"nombre\":\"pepito\",\"apellido\":\"perez\",\"rol\":null,\"fecha_nacimiento\":null,\"genero\":null}";
        String result = instance.datosConductorCedula(entradaCedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of datosConductorCodigo method, of class ServicioServidorUniversidad.
     */
    @Test
    public void testDatosConductorCodigo() {
        System.out.println("datosConductorCodigo");
        String entradaCodigo = "123";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        String expResult = "{\"cedula\":\"1111\",\"codigo\":\"123\",\"nombre\":\"pepito\",\"apellido\":\"perez\",\"rol\":null,\"fecha_nacimiento\":null,\"genero\":null}";
        String result = instance.datosConductorCodigo(entradaCodigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of confirmarLogin method, of class ServicioServidorUniversidad.
     */
    @Test
    public void testConfirmarLogin() {
        System.out.println("confirmarLogin");
        String usuario = "felipe";
        String pass = "0000";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        String expResult = "vigilante";
        String result = instance.confirmarLogin(usuario, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of datosVigilante method, of class ServicioServidorUniversidad.
     */
    @Test
    public void testDatosVigilante() {
        System.out.println("datosVigilante");
        String usuario = "felipe";
        String pass = "0000";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        String expResult = "{\"id\":\"1111\",\"nombre\":\"felipe\",\"apellido\":\"salazar\",\"fechaNacimieto\":null,\"genero\":\"Masculino\",\"empresa\":\"IO\"}";
        String result = instance.datosVigilante(usuario, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of datosAdministrativo method, of class ServicioServidorUniversidad.
     */
    @Test
    public void testDatosAdministrativo() {
        System.out.println("datosAdministrativo");
        String usuario = "andrea";
        String pass = "0000";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        String expResult = "{\"id\":\"2222\",\"nombre\":\"Andrea\",\"apellido\":\"perez\",\"fechaNacimiento\":null,\"genero\":\"Femenino\"}";
        String result = instance.datosAdministrativo(usuario, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of datosAutomovilesPorCedula method, of class ServicioServidorUniversidad.
     */
    @Test
    public void testDatosAutomovilesPorCedula() {
        System.out.println("datosAutomovilesPorCedula");
        String entradaCedula = "1111";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        String expResult = "[{\"tipo\":\"MOTO\",\"placa\":\"KID123\",\"marca\":\"MAZDA\"}]";
        String result = instance.datosAutomovilesPorCedula(entradaCedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of datosAutomovilesPorCodigo method, of class ServicioServidorUniversidad.
     */
    @Test
    public void testDatosAutomovilesPorCodigo() {
        System.out.println("datosAutomovilesPorCodigo");
        String entradaCodigo = "123";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        String expResult = "[{\"tipo\":\"MOTO\",\"placa\":\"KID123\",\"marca\":\"MAZDA\"}]";
        String result = instance.datosAutomovilesPorCodigo(entradaCodigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of ingresarDatosConductor method, of class ServicioServidorUniversidad.
     */
    
    /*@Test
    public void testIngresarDatosConductor() {
        System.out.println("ingresarDatosConductor");
        String cedula = "";
        String codigo = "";
        String nombre = "";
        String apellido = "";
        String rol = "";
        String genero = "";
        String fechaNacimiento = "";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        instance.ingresarDatosConductor(cedula, codigo, nombre, apellido, rol, genero, fechaNacimiento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of ingresarDatosAutomovil method, of class ServicioServidorUniversidad.
     */
   /* 
    @Test
    public void testIngresarDatosAutomovil() {
        System.out.println("ingresarDatosAutomovil");
        String placa = "";
        String marca = "";
        String tipo = "";
        String cedulaConductor = "";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        instance.ingresarDatosAutomovil(placa, marca, tipo, cedulaConductor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of vincularAutomovilConductor method, of class ServicioServidorUniversidad.
     */
  /*
    @Test
    public void testVincularAutomovilConductor() {
        System.out.println("vincularAutomovilConductor");
        String placa = "";
        String numeroId = "";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        instance.vincularAutomovilConductor(placa, numeroId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of actualizarMapa method, of class ServicioServidorUniversidad.
     */
  /*  @Test
    public void testActualizarMapa() {
        System.out.println("actualizarMapa");
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        String expResult = "";
        String result = instance.actualizarMapa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of actualizarBahia method, of class ServicioServidorUniversidad.
     */
  /*  @Test
    public void testActualizarBahia() {
        System.out.println("actualizarBahia");
        String estado = "";
        String nombreBahia = "";
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        instance.actualizarBahia(estado, nombreBahia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of conectar method, of class ServicioServidorUniversidad.
     */
  /*  @Test
    public void testConectar() throws Exception {
        System.out.println("conectar");
        String address = "";
        int port = 0;
        ServicioServidorUniversidad instance = new ServicioServidorUniversidad();
        instance.conectar(address, port);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
