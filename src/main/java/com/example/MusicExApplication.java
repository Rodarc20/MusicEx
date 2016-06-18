package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

import com.example.dominio.Artista;
import com.example.dominio.Album;
import com.example.dominio.Cancion;

@EnableAutoConfiguration
@EntityScan(basePackageClasses = Artista.class)
@SpringBootApplication
public class MusicExApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicExApplication.class, args);
	}
}
