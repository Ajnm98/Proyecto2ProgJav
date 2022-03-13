package modelos;

import java.util.List;

public enum Region {
    DEMACIA, NOXUS, JONIA, SHURIMA, TARGON, FREIJORD, PILTOVER, ZAUM, BANDLE, AGUAS_ESTANCADAS, DESCONOCIDA;

    public static List<Region> RegionList(){
        return List.of(Region.values());
    }

}
