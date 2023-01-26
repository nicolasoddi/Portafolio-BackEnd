package com.portfoliooddi.oddi.Controller;

import com.portfoliooddi.oddi.Entity.Persona;
import com.portfoliooddi.oddi.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    
    //Metodo que va a usar el front para traer la info.
    @GetMapping ("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    //Va a crear un usuario
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    //Como esta entre () va a ser vartiable y va a esperar el dato
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nombreNuevo,
                                @RequestParam("apellido") String apellidoNuevo,
                                @RequestParam("img") String imgNuevo)
    {
     Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nombreNuevo);
        persona.setApellido(apellidoNuevo);
        persona.setImg(imgNuevo);
        
        ipersonaService.savePersona(persona);
        return persona;      
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long) 1);
    }
    
}