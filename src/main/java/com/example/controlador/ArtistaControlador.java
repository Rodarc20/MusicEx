package com.example.controlador;

/**
 * Created by rodrigo on 08/07/16.
 */
import java.util.List;

import com.example.dominio.Album;
import com.example.dominio.Artista;
import com.example.servicio.AlbumService;
import com.example.servicio.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArtistaControlador {
    @Autowired
    ArtistaService artistaService;

    @Autowired
    AlbumService albumService;

    @RequestMapping("/artistas")
    @ResponseBody
    public List<Artista> artistas() {
        //return artistaRepositorio.findAll();
        return artistaService.all();
    }
    //esta funcoin esta funcionando
    @RequestMapping(value = "/artista", method = RequestMethod.POST)
    @ResponseBody
    public Artista guardarArtista(@RequestBody Artista artista) {
        return artistaService.agregarArtista(artista);
        //return artistaRepositorio.save(artista);
    }

    @RequestMapping(value = "/artista/{idArtista}", method = RequestMethod.GET)
    @ResponseBody
    public Artista verArtista(@PathVariable(value="idArtista") Integer idArtista){
        return artistaService.verArtista(idArtista);
    }

    @RequestMapping(value = "/artista/{idArtista}/albums", method = RequestMethod.GET)
    @ResponseBody
    public List<Album> verAlbums(@PathVariable(value="idArtista") Integer idArtista){
        return albumService.albumArtista(idArtista);
    }

}
