package dh.backend.services;

import dh.backend.dao.IDao;
import dh.backend.models.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> OdontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.OdontologoIDao = odontologoIDao;
    }

    public List<Odontologo> listarOdontologo(){
        return OdontologoIDao.listarOdontologo();
    }
    public Odontologo buscarNumeroMatricula(Integer numero){
        return OdontologoIDao.buscarOdontologo(numero);
    }

    public Odontologo registrarOdontologo(Odontologo odontologo){
        return OdontologoIDao.registrar(odontologo);
    }

}
