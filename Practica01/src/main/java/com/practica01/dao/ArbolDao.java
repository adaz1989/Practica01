
package com.practica01.dao;

import com.practica01.domain.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;

// Long, tipo de dato de la llave primaria de la entidad Arbol
public interface ArbolDao extends JpaRepository <Arbol,Long>{
    
}

/*
    Al extender JpaRepository, CategoriaDao hereda varios métodos útiles para realizar operaciones 
sobre la entidad sin necesidad de implementarlos explícitamente. Algunos de estos métodos incluyen:

Operaciones CRUD:

save(S entity): Guarda una entidad.
findById(ID id): Encuentra una entidad por su ID.
findAll(): Encuentra todas las entidades.
deleteById(ID id): Elimina una entidad por su ID.

Soporta transacciones y manejo de excepciones de manera integrada.
*/