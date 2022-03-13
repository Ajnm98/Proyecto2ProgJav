package documentos;

import com.opencsv.CSVReader;
import modelos.*;
import utilidades.UtilidadesPersonaje;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class UtilidadesFichero {

    public static final char SEPARATOR = ',';
    public static final char QUOTE = '"';

    public List<Personaje> leerPersonajes() throws IOException {

        List<Personaje> personajes = new ArrayList<>();
        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader("C:\\Users\\34638\\IdeaProjects\\concesionario\\src\\main\\java\\documentos\\personajes.csv"), SEPARATOR, QUOTE);
            String[] nextLine = null;
            int count = 0;

            while ((nextLine = reader.readNext()) != null) {

                if (count > 0) {
                    String[] valores = nextLine;
                    Personaje p = new Personaje();
                    p.setNivel(1);

                    p.setId(Integer.parseInt(valores[0]));
                    p.setNombre(valores[1]);
                    p.setFechaCreacion(LocalDate.parse(valores[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    p.setAtaqueBase(Double.parseDouble(valores[3]));
                    p.setDefensaBase(Double.parseDouble(valores[4]));
                    p.setVidaBase(Double.parseDouble(valores[5]));
                    p.setManaBase(Double.parseDouble(valores[6]));
                    p.setRegion(Region.valueOf(valores[7]));
                    personajes.add(p);
                }
                count++;
            }
        } catch (Exception e) {
            throw e;
        }
        reader.close();
        return personajes;
    }



    public List<Personaje> leerYAprenderHabilidades() throws IOException {

        List<Personaje> personaje1 = new ArrayList<>();
        List<Habilidad> habilidades = new ArrayList<>();
        CSVReader reader = null;
        personaje1 = leerPersonajes();


        try {
            reader = new CSVReader(new FileReader("C:\\Users\\34638\\IdeaProjects\\concesionario\\src\\main\\java\\documentos\\habilidades.csv"), SEPARATOR, QUOTE);
            String[] nextLine = null;
            int count = 0;

            while ((nextLine = reader.readNext()) != null) {

                if (count > 0) {
                    String[] valores = nextLine;
                    Habilidad h = new Habilidad();
                    h.setId(Integer.parseInt(valores[0]));
                    h.setNombre(valores[2]);
                    h.setDanyoBase(Double.parseDouble(valores[3]));
                    h.setCosteMana(Double.parseDouble(valores[4]));
                    h.setTipoHabilidad(TipoHabilidad.valueOf(valores[5]));
                    int Id_per = Integer.parseInt(valores[1]);
                    for(Personaje p : personaje1) {
                        if (p.getId() == Id_per){
                            p.getHabilidades().add(h);
                        }
                    }

                }
                count++;
            }
        } catch (Exception e) {
            throw e;
        }
        reader.close();
        return personaje1;
    }





    public List<Item> leerItems() throws IOException {

        List<Item> items = new ArrayList<>();
        CSVReader reader = null;


        try {
            reader = new CSVReader(new FileReader("C:\\Users\\34638\\IdeaProjects\\concesionario\\src\\main\\java\\documentos\\items.csv"), SEPARATOR, QUOTE);
            String[] nextLine = null;
            int count = 0;

            while ((nextLine = reader.readNext()) != null) {

                if (count > 0) {
                    String[] valores = nextLine;
                    Item i = new Item();

                    i.setId(Integer.parseInt(valores[0]));
                    i.setNombre(valores[1]);
                    i.setAumentoDanyo(Double.parseDouble(valores[2]));
                    i.setAumentoDefensa(Double.parseDouble(valores[3]));
                    i.setAumentoSalud(Double.parseDouble(valores[4]));
                    i.setAumentoMana(Double.parseDouble(valores[5]));

                }
                count++;
            }
        } catch (Exception e) {
            throw e;
        }
        reader.close();
        return items;

    }
}



