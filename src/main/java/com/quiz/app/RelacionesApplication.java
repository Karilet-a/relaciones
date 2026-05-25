package com.quiz.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

import com.quiz.app.model.*;
import com.quiz.app.repository.*;

@SpringBootApplication
public class RelacionesApplication implements CommandLineRunner {

    @Autowired private EntrenadorRepository entrenadorRepository;
    @Autowired private AsociacionRepository asociacionRepository;
    @Autowired private JugadorRepository jugadorRepository;
    @Autowired private CompeticionRepository competicionRepository;
    @Autowired private ClubRepository clubRepository;

    public static void main(String[] args) {
        SpringApplication.run(RelacionesApplication.class, args);
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setPort(8139);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== INSERTANDO DATOS DE PRUEBA ===");

        // Entrenadores
        Entrenador e1 = new Entrenador();
        e1.setNombre("Carlos");
        e1.setApellido("Queiroz");
        e1.setEdad(60);
        e1.setNacionalidad("Portugués");
        entrenadorRepository.save(e1);

        Entrenador e2 = new Entrenador();
        e2.setNombre("Reinaldo");
        e2.setApellido("Rueda");
        e2.setEdad(62);
        e2.setNacionalidad("Colombiano");
        entrenadorRepository.save(e2);

        // Asociaciones
        Asociacion a1 = new Asociacion();
        a1.setNombre("FCF");
        a1.setPais("Colombia");
        a1.setPresidente("Ramón Jesurún");
        asociacionRepository.save(a1);

        Asociacion a2 = new Asociacion();
        a2.setNombre("FIFA");
        a2.setPais("Suiza");
        a2.setPresidente("Gianni Infantino");
        asociacionRepository.save(a2);

        // Jugadores
        Jugador j1 = new Jugador();
        j1.setNombre("James");
        j1.setApellido("Rodríguez");
        j1.setNumero(10);
        j1.setPosicion("Mediocampista");
        jugadorRepository.save(j1);

        Jugador j2 = new Jugador();
        j2.setNombre("Radamel");
        j2.setApellido("Falcao");
        j2.setNumero(9);
        j2.setPosicion("Delantero");
        jugadorRepository.save(j2);

        Jugador j3 = new Jugador();
        j3.setNombre("Davinson");
        j3.setApellido("Sánchez");
        j3.setNumero(23);
        j3.setPosicion("Defensa");
        jugadorRepository.save(j3);

        // Competiciones
        Competicion c1 = new Competicion();
        c1.setNombre("Copa Libertadores");
        c1.setMontoPremio(500000);
        c1.setFechaInicio(java.time.LocalDate.of(2024, 2, 1));
        c1.setFechaFin(java.time.LocalDate.of(2024, 11, 30));
        competicionRepository.save(c1);

        Competicion c2 = new Competicion();
        c2.setNombre("Liga BetPlay");
        c2.setMontoPremio(200000);
        c2.setFechaInicio(java.time.LocalDate.of(2024, 1, 15));
        c2.setFechaFin(java.time.LocalDate.of(2024, 12, 15));
        competicionRepository.save(c2);

        // Clubes
        Club club1 = new Club();
        club1.setNombre("Millonarios");
        club1.setEntrenador(e1);
        club1.setAsociacion(a1);
        clubRepository.save(club1);

        Club club2 = new Club();
        club2.setNombre("Santa Fe");
        club2.setEntrenador(e2);
        club2.setAsociacion(a1);
        clubRepository.save(club2);

        System.out.println("=== DATOS INSERTADOS CORRECTAMENTE ===");
        System.out.println("Entrenadores: " + entrenadorRepository.count());
        System.out.println("Asociaciones: " + asociacionRepository.count());
        System.out.println("Jugadores: " + jugadorRepository.count());
        System.out.println("Competiciones: " + competicionRepository.count());
        System.out.println("Clubes: " + clubRepository.count());
    }
}