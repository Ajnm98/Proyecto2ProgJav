package utilidades;

import modelos.Jugador;
import modelos.Partida;
import modelos.Personaje;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.JulianFields;
import java.util.*;

public class UtilidadesPartida implements IUtilidadesPartida {

    public void inicializarPartida(Partida partida, List<Jugador> participantes, List<Personaje> personajesDisponibles) {

        Map<Jugador, Personaje> mapajupe = new HashMap<>();
        Map<Integer, Set<Jugador>> jugadorequipo = new HashMap<>();
        Set<Jugador> jupar = new HashSet<>();

        for (Jugador ju : participantes) {
            for (Personaje pe : personajesDisponibles) {
                if (ju.getPersonajesFavoritos() != null) {
                    if (ju.getPersonajesFavoritos() == pe) {
                        mapajupe.put(ju, pe);
                    }

                }
                if (ju.getPersonajesFavoritos() == null) {
                    mapajupe.put(ju, pe);
                }
            }
        }
        partida.setElecciones(mapajupe);


            for (Jugador ju1 : participantes) {
                jupar.add(ju1);
                if (participantes.indexOf(ju1) % 2 == 0) {
                    jugadorequipo.put(1, jupar);

                }
                else{
                    jugadorequipo.put(2, jupar);
                }

            }
            partida.setJugadoresPorEquipo(jugadorequipo);


            partida.setInicioPartida(LocalDateTime.now());

        }


    public void finalizarPartida(Partida partida, Integer equipoVencedor){




        partida.setFinPartida(LocalDateTime.now());
        partida.setDuracionPartida(partida.getFinPartida().getSecond()-partida.getInicioPartida().getSecond());


        partida.setEquipoVencedor(equipoVencedor);


        for(Jugador ju2 : partida.getJugadoresPorEquipo().equals(equipoVencedor, Jugador)){
            ju2.setPartidasGanadas(ju2.getPartidasGanadas() + partida.getElecciones().equals(ju2,partida.getElecciones().)1);


        }






    }
}
