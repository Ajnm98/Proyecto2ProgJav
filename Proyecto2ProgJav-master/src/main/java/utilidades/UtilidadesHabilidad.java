package utilidades;

import com.opencsv.CSVReader;
import modelos.Habilidad;
import modelos.Personaje;

import java.io.FileReader;

import java.io.IOException;


public class UtilidadesHabilidad {
    public static final char SEPARATOR = ',';
    public static final char QUOTE = '"';

    public void golpearConHabilidad(Personaje emisor, Personaje receptor, Habilidad habilidadEmisor) throws IOException {
        int x = 0;
        int y = 0;
        if (emisor.getNivel() != 18) {
            while (x <= 17 && emisor.getNivel() < 18) {
                UtilidadesPersonaje.levelUp(emisor);
                x++;
            }
        }
        if (receptor.getNivel() != 18) {
            while (y <= 17 && receptor.getNivel() < 18) {
                UtilidadesPersonaje.levelUp(receptor);
                y++;
            }
    }

        if (emisor.getEquipamiento().size() != 0){
            CSVReader reader = null;
            try {
                reader = new CSVReader(new FileReader("C:\\Users\\34638\\IdeaProjects\\concesionario\\src\\main\\java\\documentos\\items.csv"), SEPARATOR, QUOTE);
                String[] nextLine = null;

                if (emisor.getEquipamiento() != null) {
                    String[] valores = nextLine;
                    while (receptor.getEquipamiento().equals(valores[1])) {

                        emisor.setAtaque(emisor.getAtaque() + (Double.parseDouble(valores[2])));
                        emisor.setDefensa(emisor.getAtaque() + (Double.parseDouble(valores[3])));
                        emisor.setVida(emisor.getAtaque() + (Double.parseDouble(valores[4])));
                        emisor.setMana(emisor.getAtaque() + (Double.parseDouble(valores[5])));

                    }
                }
            } catch (Exception e) {
                throw e;
            }
            reader.close();

        }
        if (receptor.getEquipamiento().size() != 0){
            CSVReader reader = null;
            try {
                reader = new CSVReader(new FileReader("C:\\Users\\34638\\IdeaProjects\\concesionario\\src\\main\\java\\documentos\\items.csv"), SEPARATOR, QUOTE);
                String[] nextLine = null;

                if (receptor.getEquipamiento() != null) {
                    String[] valores = nextLine;

                    while (receptor.getEquipamiento().equals(valores[1])) {

                        receptor.setAtaque(receptor.getAtaque() + (Double.parseDouble(valores[2])));
                        receptor.setDefensa(receptor.getAtaque() + (Double.parseDouble(valores[3])));
                        receptor.setVida(receptor.getAtaque() + (Double.parseDouble(valores[4])));
                        receptor.setMana(receptor.getAtaque() + (Double.parseDouble(valores[5])));

                    }
                }
            } catch (Exception e) {
                throw e;
            }
            reader.close();

        }

        Double Dañototal = habilidadEmisor.getDanyoBase() + (0.2 * emisor.getAtaqueBase()) - (0.1 * receptor.getDefensa());
        emisor.setMana(emisor.getMana()- habilidadEmisor.getCosteMana());
        receptor.setVida(receptor.getVida() - habilidadEmisor.getDanyo());
    }
    }



