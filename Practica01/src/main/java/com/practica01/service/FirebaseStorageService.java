
package com.practica01.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "practica01-59a00.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "practica01";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json que esta en otherSources
    final String archivoJsonFile = "practica01-59a00-firebase-adminsdk-370h3-c7c7ab8ffc.json";
}
