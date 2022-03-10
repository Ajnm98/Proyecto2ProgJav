package utilidades;

import modelos.Personaje;
import modelos.Region;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesPersonaje {

    public static Personaje levelUp(Personaje personaje) {

        Integer NuevoNivel = personaje.getNivel() + 1;
        personaje.setNivel(NuevoNivel);


        Double EstadisticaAtaque = personaje.getAtaqueBase() + (personaje.getNivel() * personaje.getEscalabilidad().getIncrementoDanyoNivel());
        personaje.setAtaqueBase(EstadisticaAtaque);

        Double EstadisticaDefensa = personaje.getDefensaBase() + (personaje.getNivel() * personaje.getEscalabilidad().getIncrementoDefensaNivel());
        personaje.setDefensaBase(EstadisticaDefensa);

        Double EstadisticaVida = personaje.getVidaBase() + (personaje.getNivel() * personaje.getEscalabilidad().getIncrementoSaludNivel());
        personaje.setDefensaBase(EstadisticaVida);

        Double EstadisticaMana = personaje.getManaBase() + (personaje.getNivel() * personaje.getEscalabilidad().getIncrementoManaNivel());
        personaje.setDefensaBase(EstadisticaMana);


        return personaje;
    }


    public Map<Region, List<Personaje>> getPersonajesPorRegion(List<Personaje> personajes) {

        Map<Region, List<Personaje>> personajesporregion = new HashMap<>();


        for (Region re : Region.RegionList()) {

            personajesporregion.put(re, new ArrayList<>());

            for (Personaje pe : personajes) {
                if (pe.getRegion().equals(Region.BANDLE)) {
                    personajesporregion.get(Region.BANDLE).add(pe);
                    }
                if (pe.getRegion().equals(Region.DEMACIA)) {
                    personajesporregion.get(Region.DEMACIA).add(pe);
                }
                if (pe.getRegion().equals(Region.NOXUS)) {
                    personajesporregion.get(Region.NOXUS).add(pe);
                }
                if (pe.getRegion().equals(Region.JONIA)) {
                    personajesporregion.get(Region.JONIA).add(pe);
                }
                if (pe.getRegion().equals(Region.SHURIMA)) {
                    personajesporregion.get(Region.SHURIMA).add(pe);
                }
                if (pe.getRegion().equals(Region.TARGON)) {
                    personajesporregion.get(Region.TARGON).add(pe);
                }
                if (pe.getRegion().equals(Region.FREIJORD)) {
                    personajesporregion.get(Region.FREIJORD).add(pe);
                }
                if (pe.getRegion().equals(Region.PILTOVER)) {
                    personajesporregion.get(Region.PILTOVER).add(pe);
                }
                if (pe.getRegion().equals(Region.ZAUM)) {
                    personajesporregion.get(Region.ZAUM).add(pe);
                }
                if (pe.getRegion().equals(Region.AGUAS_ESTANCADAS)) {
                    personajesporregion.get(Region.AGUAS_ESTANCADAS).add(pe);
                }
                if (pe.getRegion().equals(Region.DESCONOCIDA)) {
                    personajesporregion.get(Region.DESCONOCIDA).add(pe);
                }

                }

            }


        return personajesporregion;
    }


    public Personaje level0(Personaje personaje) {
        personaje.setNivel(1);

        return personaje;
    }


    public Personaje getMasPoderoso(List<Personaje> personaje){

        List<Personaje> maspoderoso = new ArrayList<Personaje>();
        Integer x = 0;
        for(Personaje pe : personaje){

            if (pe.getNivel() != 18){
                while (x <= 17 && pe.getNivel() < 18){
                levelUp(pe);
                x++;
                maspoderoso.add(pe);}
            }

            maspoderoso.stream().sorted(Comparator.comparing(e -> e.getNivel())).collect(Collectors.toList());
        }
        return maspoderoso.get(0);
    }

}





