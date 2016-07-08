package com.example.controlador;

/**
 * Created by rodrigo on 17/06/16.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dominio.Artista;
import com.example.dominio.Album;
import com.example.dominio.Cancion;
import com.example.repositorio.ArtistaRepositorio;
import com.example.repositorio.AlbumRepositorio;
import com.example.repositorio.CancionRepositorio;

import com.example.servicio.CancionService;
import com.example.servicio.ArtistaService;

@RestController
public class ReproductorControlador {
	/*@Autowired
	ArtistaRepositorio artistaRepositorio;

	@Autowired
	AlbumRepositorio albumRepositorio;

	@Autowired
	CancionRepositorio cancionRepositorio;*/

	/*@RequestMapping("/artistas")
	@ResponseBody
	public List<Artista> artistas() {
		return artistaRepositorio.findAll();
	}
*/
    @Autowired
    ArtistaService artistaService;

    @RequestMapping("/artistas2")
    @ResponseBody
    public List<Artista> artistas() {
        //return artistaRepositorio.findAll();
        return artistaService.all();
    }
    //esta funcoin esta funcionando
	@RequestMapping(value = "/artista2", method = RequestMethod.POST)
	@ResponseBody
	public Artista guardarArtista(@RequestBody Artista artista) {
        return artistaService.agregarArtista(artista);
		//return artistaRepositorio.save(artista);
	}

	//@RequestMapping("/cursos")
	/*@RequestMapping(value = "/albums", method = RequestMethod.GET)
	@ResponseBody
	public List<Album> albums() {
		return albumRepositorio.findAll();
	}*/

    //lo anterior no deberia estar
    @Autowired
    CancionService cancionService;

    @RequestMapping(value = "/canciones", method = RequestMethod.GET)
    @ResponseBody
    public List<Cancion> canciones(){
        return cancionService.canciones();
    }
}