package com.vp.springserver.model.prospecto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProspectoRepository extends CrudRepository<Prospecto, Integer> {

}