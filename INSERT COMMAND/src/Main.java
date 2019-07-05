import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<Pais> ListaPaises = new ArrayList<>();
        ArrayList<Aeropuerto> ListaAeropuerto = new ArrayList<>();
        Set<Aeropuerto> SetAeropuerto = new HashSet<>();
        String lineaLeida;
        String lineaLeida2;
        String lineaLeida3;
        String lala[];
        boolean visa = true;
        boolean pasaporte = true;
        int id = 1;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("paises.txt"));

            while ((lineaLeida = reader.readLine()) != null) {//Aqui leo cada linea de paises
                BufferedReader readerAeropuerto = new BufferedReader(new FileReader("paisesdeaeropuerto.txt"));
                int ran = (int) (Math.random() * ((1 - 0) + 1));
                if (ran == 0) {
                    visa = false;
                }
                if (ran == 1) {
                    visa = true;
                }
                int ran2 = (int) (Math.random() * ((1 - 0) + 1));
                if (ran2 == 1) {
                    pasaporte = true;
                }
                if (ran2 == 0) {
                    pasaporte = false;
                }

                Pais pais = new Pais(id, lineaLeida, visa, pasaporte);
                ListaPaises.add(pais);

                BufferedReader readerDirecciones = new BufferedReader(new FileReader("direcciones.txt"));
                while (((lineaLeida2 = readerAeropuerto.readLine()) != null && (lineaLeida3 = readerDirecciones.readLine()) != null)) {//aqui leo el paisaeropuerto
                    int ran3 = (int) (Math.random() * (999999 - 1)); //Codigo postal del aeropuerto
                    lala = lineaLeida2.split("\\t");

                    if (lineaLeida.length() > 11) {
                        lineaLeida = lineaLeida.substring(1);
                    }
                    //System.out.println(lineaLeida + "-" + lala[1]);
                    if (lineaLeida.equals(lala[1])) {
                        //System.out.println("-------------------------------");
                        Aeropuerto aeropuerto = new Aeropuerto(lala[0], lineaLeida3, ran3, id);
                        ListaAeropuerto.add(aeropuerto);
                        //System.out.println("--------------" + ListaAeropuerto.get(0).getNombre());
                    }
                }
                id++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("el Archivo no existeeeeee");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("me cai");
        }

        BufferedWriter output = null;
        try {
            File file = new File("comandosAeropuerto.txt");
            String nombreTabla = "PAISES";
            String text = "INSERT INTO " + "`" + nombreTabla + "`" + " (`nombre`,`direccion`,`codigo_postal`,`id_pais`) VALUES ";
            output = new BufferedWriter(new FileWriter(file));
            BufferedReader br = new BufferedReader(new FileReader("comandosAeropuerto.txt"));
            /*if (br.readLine() == null) {
                output.write(text);
            }
            for (Pais i : ListaPaises) {
                String text2 = "(" + i.getId() + "," + "\"" + i.getNombre() + "\"" + "," + i.getPasaporte() + "," + i.getVisa() + "),";
                output.write(text2);
            }*/
            //System.out.println("lala");
            SetAeropuerto.addAll(ListaAeropuerto);
            ListaAeropuerto.clear();
            ListaAeropuerto.addAll(SetAeropuerto);
            for (int i = 0; i < ListaAeropuerto.size(); i++){
                if (ListaAeropuerto.get(i).getNombre().equals("DNO")){
                    ListaAeropuerto.remove(ListaAeropuerto.get(i));
                }
                for (int k = 0; k < ListaAeropuerto.size(); k++){
                    if (ListaAeropuerto.get(i).getNombre().equals(ListaAeropuerto.get(k).getNombre()) && (i != k)){
                        ListaAeropuerto.remove(ListaAeropuerto.get(k));
                    }
                }
            }
            if (br.readLine() == null) {
                for (Aeropuerto a : ListaAeropuerto) {
                    if (a.getId_pais() <= 227) {
                        String text3 = "(\"" + a.getNombre() + "\"," + "\"" + a.getDireccion() + "\"" + "," + a.getCodigo_postal() + "," + a.getId_pais() + "),";
                        output.write(text3);
                    }
                }
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                try {
                    output.close();
                } catch (Exception e){

                }
            }
        }
        System.out.println("TERMINE");
    }
}
