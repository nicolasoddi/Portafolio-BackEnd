package com.portfoliooddi.oddi.Interface;

import com.portfoliooddi.oddi.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    
    //trae lista de personas cuando llamo a getPersona
    public List<Persona> getPersona();

    //guarda persona de tipo Persona
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    //Va a buscar una Persona por id
    public Persona findPersona(Long id);
    
}
