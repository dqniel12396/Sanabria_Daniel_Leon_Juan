package dh.backend.dao;

import dh.backend.models.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class IDaoArrayList implements IDao<Odontologo> {
    ArrayList<Odontologo> ListaOdon = new ArrayList<>();






    @Override
    public Odontologo registrar(Odontologo odontologo) {

        ListaOdon.add(odontologo);
        return odontologo;
    }

    @Override
    public Odontologo buscarOdontologo(Integer numero) {
        return null;
    }

    @Override
    public List<Odontologo> listarOdontologo() {
        return ListaOdon;

    }
}
