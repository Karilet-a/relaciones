package com.quiz.app.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "clubes")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Un club tiene UN entrenador
    @OneToOne
    private Entrenador entrenador;

    // Un club tiene MUCHOS jugadores
    @OneToMany
    @JoinColumn(name = "id_club")
    private List<Jugador> jugadores;

    // Muchos clubes pertenecen a UNA asociación
    @ManyToOne
    private Asociacion asociacion;

    // Muchos clubes participan en MUCHAS competiciones
    @ManyToMany
    private List<Competicion> competiciones;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }
    public List<Jugador> getJugadores() { return jugadores; }
    public void setJugadores(List<Jugador> jugadores) { this.jugadores = jugadores; }
    public Asociacion getAsociacion() { return asociacion; }
    public void setAsociacion(Asociacion asociacion) { this.asociacion = asociacion; }
    public List<Competicion> getCompeticiones() { return competiciones; }
    public void setCompeticiones(List<Competicion> competiciones) { this.competiciones = competiciones; }
}