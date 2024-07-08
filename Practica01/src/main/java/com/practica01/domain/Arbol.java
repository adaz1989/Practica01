
package com.practica01.domain;
import java.io.Serializable;

//Importa las clases necesarias para trabajar con JPA
//(Java Persistence API), que se utiliza para interactuar con la base de datos.
import jakarta.persistence.*;
//Importa la anotación @Data de Lombok, que automáticamente genera 
//getters, setters, toString(), hashCode(), y equals().
import lombok.Data;

@Data //Genera automáticamente el código getters, setters, y otros métodos comunes.
@Entity //Indica que esta clase es una entidad de JPA y está mapeada a una tabla de base de datos.
@Table(name = "arbol")
public class Arbol implements Serializable{
    
//  Identificador de versión para la serialización de objetos.
    private static final long serialVersionUID = 1L;
    
//  -------------------------  
// Clave primaria autoincremental
    @Id //Indica que el campo al que se aplica es la clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Clave primaria sera generado automáticamente por la base de datos
    @Column(name = "id_arbol") //Mapea el campo de la clase a una columna específica en la tabla de la base de datos
    private Long idArbol;
//  -------------------------
    
    private String nombreComun;
    private String nombreCientifico;
    private int edad;
    private String rutaImagen;

    public Arbol() {
    }
    

}
