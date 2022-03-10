package modelos;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public class Partida {

    private int id;
    private String codigo;
    private Double server;
    private Map<Jugador,Personaje> elecciones;
    private Map<Integer, Set<Jugador>> jugadoresPorEquipo;
    private LocalDateTime inicioPartida;
    private LocalDateTime finPartida;
    //duracionPartida en segundos
    private int duracionPartida;
    private Integer equipoVencedor;


}
