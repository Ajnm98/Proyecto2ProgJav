package utilidades;

import com.opencsv.CSVReader;
import modelos.Item;
import modelos.Personaje;

import java.io.FileReader;
import java.io.IOException;

public class UtilidadesItem {

    public static final char SEPARATOR = ',';
    public static final char QUOTE = '"';

    public void equiparItem(Personaje personaje, Item item) throws IOException {

        personaje.getEquipamiento().add(item);

        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader("C:\\Users\\34638\\IdeaProjects\\concesionario\\src\\main\\java\\documentos\\items.csv"), SEPARATOR, QUOTE);
            String[] nextLine = null;

            if (personaje.getEquipamiento() != null) {
                while(personaje.getEquipamiento() == item){
                    String[] valores = nextLine;

                   personaje.setAtaque(personaje.getAtaque()+(Double.parseDouble(valores[2])));
                    personaje.setDefensa(personaje.getAtaque()+(Double.parseDouble(valores[3])));
                    personaje.setVida(personaje.getAtaque()+(Double.parseDouble(valores[4])));
                    personaje.setMana(personaje.getAtaque()+(Double.parseDouble(valores[5])));

                }
            }
        } catch (Exception e) {
            throw e;
        }
        reader.close();


    }




    }

