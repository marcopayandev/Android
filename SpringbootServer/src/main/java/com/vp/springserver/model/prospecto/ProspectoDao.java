package com.vp.springserver.model.prospecto;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class ProspectoDao {

  @Autowired
  private ProspectoRepository repository;

  public Prospecto guardar(Prospecto prospecto) {
    return repository.save(prospecto);
  }

  public List<Prospecto> getAllProspectos() {
    List<Prospecto> prospecto = new ArrayList<>();
    Streamable.of(repository.findAll())
        .forEach(prospecto::add);
    return prospecto;
  }
  
 public Prospecto actualizarEstatus(int prospectoId, int estatus, String descripcion) {
    Prospecto prospecto = repository.findById(prospectoId).orElseThrow(() -> new RuntimeException("No se encontro el prospecto con ID " + prospectoId));
    prospecto.setEstatus(estatus);
    prospecto.setDescripcion(descripcion);
    return repository.save(prospecto);
}

 public Prospecto getById(int prospectoId){
    Prospecto prospecto = repository.findById(prospectoId).orElseThrow(() -> new RuntimeException("No se encontro el prospecto con ID " + prospectoId));
    return prospecto;
 }

  public void borrar(int prospectoId) {
    repository.deleteById(prospectoId);
  }
  
  
}
