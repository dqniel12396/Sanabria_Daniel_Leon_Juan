package dh.backend.test;

import dh.backend.dao.Impl;
import dh.backend.db.H2Connection;
import dh.backend.models.Odontologo;
import dh.backend.services.OdontologoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {


    @BeforeAll
    static void crearTablas(){

        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = H2Connection.getConnection();
            connection = DriverManager.getConnection("jdbc:h2:~/parcial;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
    public static Logger LOGGER = Logger.getLogger(OdontologoServiceTest.class);

    @Test
    @DisplayName("Testear que  permita guardar un odontologo")
    void testearMedicamentoEnBaseDeDatos(){
        Odontologo odontologo = new Odontologo(1234,"DANE","SANTOS");
        OdontologoService odontologoService = new OdontologoService(new Impl());
        Odontologo odontologoRegistrado = odontologoService.registrarOdontologo(odontologo);

        assertNotNull(odontologoRegistrado);
    }

    @Test
    @DisplayName("Testear que se pueda listar Odontologos")
    void testearListarOdontologosEnBaseDeDatos(){
        OdontologoService odontologoService = new OdontologoService(new Impl());
        List<Odontologo> odontologosRecibidos = odontologoService.listarOdontologo();

        assertEquals(1, odontologosRecibidos.size());
    }





}