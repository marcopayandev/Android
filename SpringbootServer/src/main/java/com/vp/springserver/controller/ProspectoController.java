package com.vp.springserver.controller;

import com.vp.springserver.model.prospecto.Prospecto;
import com.vp.springserver.model.prospecto.ProspectoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProspectoController {

  @Autowired
  private ProspectoDao prospectoDao;

    @GetMapping("/prospecto/todos")
    public List<Prospecto> getAllProspectos() {
      return prospectoDao.getAllProspectos();
    }

    @PostMapping("/prospecto/guardar")
    public Prospecto guardar(@RequestBody Prospecto prospecto) {
      return prospectoDao.guardar(prospecto);
    }
  

    @PostMapping("/prospecto/actualizarEstatus")
    public Prospecto actualizarEstatus(@RequestBody Prospecto prospecto) {
        return prospectoDao.actualizarEstatus(prospecto.getId(), prospecto.getEstatus(), prospecto.getDescripcion());
    }
    
    @PostMapping("/prospecto/delete")
    public void deleteProspecto(@RequestBody Prospecto prospecto) {
         prospectoDao.borrar(prospecto.getId());
         
    }
  
}
