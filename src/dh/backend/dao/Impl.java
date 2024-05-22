package dh.backend.dao;

import dh.backend.db.H2Connection;
import dh.backend.models.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Impl implements IDao<Odontologo> {

    public static Logger LOGGER = Logger.getLogger(Impl.class);
    public static String SQL_INSERT = "INSERT INTO ODONTOLOGO VALUES (DEFAULT, ?, ?,?)";
    public static String SQL_SELECT = "SELECT * FROM ODONTOLOGO WHERE NUMERODEMATRICULA=?";
    public static String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGO";


    public Odontologo registrar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologoRegistrado = null;
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, odontologo.getNumero_matricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                odontologoRegistrado = new Odontologo(id, odontologo.getNumero_matricula(), odontologo.getNombre(),
                        odontologo.getApellido());
            }
            LOGGER.info("odontologo Registrado: "+ odontologoRegistrado);
            connection.commit();
            connection.setAutoCommit(true);
        }catch (Exception e){
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologoRegistrado;
    }



    @Override
    public Odontologo buscarOdontologo(Integer numero) {
        return null;
    }

    @Override
    public List<Odontologo> listarOdontologo() {
        Connection connection = null;
        Odontologo odontologo = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()){
                odontologo = new Odontologo(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3));
                LOGGER.info("Medicamento devuelto: "+ odontologo);
                odontologos.add(odontologo);
            }

        }catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologos;
    }



}
