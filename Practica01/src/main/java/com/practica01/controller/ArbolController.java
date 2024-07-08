
package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import com.practica01.serviceImpl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j
@RequestMapping("/") 
public class ArbolController {
    
    @Autowired
    private ArbolService arbolService;
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/arbol")
    public String inicio(Model model) {
        var arboles = arbolService.getArboles();        
        model.addAttribute("arboles", arboles);
        return "/listado"; //arbol/listado";
    }
    
    @GetMapping("/nuevo")
    public String arbolNuevo(Arbol arbol) {
        return "/arbol/modifica";
    }
    
    @PostMapping("/guardar")
    public String categoriaGuardar(Arbol arbol,
            @RequestParam("imageFile") MultipartFile imagenFile){
        if(!imagenFile.isEmpty()){
            arbolService.save(arbol);
            arbol.setRutaImagen(
                firebaseStorageService.cargaImagen(
                        imagenFile, 
                        "arbol", 
                        arbol.getIdArbol()
                )
        );        
    }
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }
    
    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol arbol){
        arbolService.delete(arbol);
        return"redirect:/arbol/listado";
    }
    
    @GetMapping("/modificar/{idArbol}")
    public String categoriaModificar(Arbol arbol, Model model) {
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }
     
}
