package nightfall.project;

import java.io.*;
public class Events {
    private String opis;
    private String id;
    private boolean czywstep = false;
    private boolean czydom = false;
    private boolean czywieszcz = false;
    private boolean czydrakkar = false;
    private boolean czywioska = false;
    private boolean czystudnia = false;
    private boolean czynekro = false;
    public void kontrolaeventu(int x, int y){
        if(x == 50 && y == 50){
            if(czywstep == false){
                String nazwapliku = Integer.toString(x) + Integer.toString(y) + ".txt";
                BufferedReader czyt = null;
                File file = new File("eventy/" +nazwapliku);
                String sciezka = file.getAbsolutePath();

                try
                {
                    czyt = new BufferedReader(new FileReader(sciezka));
                    String line = "";
                    while ((line = czyt.readLine()) != null) {
                        String [] plik1 = line.split(";");
                        id = plik1[0];
                        opis = plik1[1];
                    }
                }
                catch (FileNotFoundException e) {
                    System.out.println("Blad" + e);
                }
                catch (IOException e) {
                    System.out.println("Blad" + e);
                }

                System.out.println(opis);
                czywstep = true;
            }
        }
        else if(x == 54 && y == 54){
            if(czydom == false){
                String nazwapliku = Integer.toString(x) + Integer.toString(y) + ".txt";
                BufferedReader czyt = null;
                File file = new File("eventy/" +nazwapliku);
                String sciezka = file.getAbsolutePath();

                try
                {
                    czyt = new BufferedReader(new FileReader(sciezka));
                    String line = "";
                    while ((line = czyt.readLine()) != null) {
                        String [] plik1 = line.split(";");
                        id = plik1[0];
                        opis = plik1[1];
                    }
                }
                catch (FileNotFoundException e) {
                    System.out.println("Blad" + e);
                }
                catch (IOException e) {
                    System.out.println("Blad" + e);
                }

                System.out.println(opis);
                czydom = true;
            }
        }
        else if(x == 55 && y == 53){
            if(czywieszcz == false){
                String nazwapliku = Integer.toString(x) + Integer.toString(y) + ".txt";
                BufferedReader czyt = null;
                File file = new File("eventy/" +nazwapliku);
                String sciezka = file.getAbsolutePath();

                try
                {
                    czyt = new BufferedReader(new FileReader(sciezka));
                    String line = "";
                    while ((line = czyt.readLine()) != null) {
                        String [] plik1 = line.split(";");
                        id = plik1[0];
                        opis = plik1[1];
                    }
                }
                catch (FileNotFoundException e) {
                    System.out.println("Blad" + e);
                }
                catch (IOException e) {
                    System.out.println("Blad" + e);
                }

                System.out.println(opis);
                czywieszcz = true;
            }
        }
        else if(x == 59 && y == 52){
            if(czydrakkar == false){
                String nazwapliku = Integer.toString(x) + Integer.toString(y) + ".txt";
                BufferedReader czyt = null;
                File file = new File("eventy/" +nazwapliku);
                String sciezka = file.getAbsolutePath();

                try
                {
                    czyt = new BufferedReader(new FileReader(sciezka));
                    String line = "";
                    while ((line = czyt.readLine()) != null) {
                        String [] plik1 = line.split(";");
                        id = plik1[0];
                        opis = plik1[1];
                    }
                }
                catch (FileNotFoundException e) {
                    System.out.println("Blad" + e);
                }
                catch (IOException e) {
                    System.out.println("Blad" + e);
                }

                System.out.println(opis);
                czydrakkar = true;
            }
        }

        else if(x == 5 && y == 81){
            if(czystudnia == false){
                String nazwapliku = Integer.toString(x) + Integer.toString(y) + ".txt";
                BufferedReader czyt = null;
                File file = new File("eventy/" +nazwapliku);
                String sciezka = file.getAbsolutePath();

                try
                {
                    czyt = new BufferedReader(new FileReader(sciezka));
                    String line = "";
                    while ((line = czyt.readLine()) != null) {
                        String [] plik1 = line.split(";");
                        id = plik1[0];
                        opis = plik1[1];
                    }
                }
                catch (FileNotFoundException e) {
                    System.out.println("Blad" + e);
                }
                catch (IOException e) {
                    System.out.println("Blad" + e);
                }

                System.out.println(opis);
                czystudnia = true;
            }
        }

        else if(x == 54 && y == 50){
            if(czystudnia == true && czywioska == false){
                String nazwapliku = Integer.toString(x) + Integer.toString(y) + ".txt";
                BufferedReader czyt = null;
                File file = new File("eventy/" +nazwapliku);
                String sciezka = file.getAbsolutePath();

                try
                {
                    czyt = new BufferedReader(new FileReader(sciezka));
                    String line = "";
                    while ((line = czyt.readLine()) != null) {
                        String [] plik1 = line.split(";");
                        id = plik1[0];
                        opis = plik1[1];
                    }
                }
                catch (FileNotFoundException e) {
                    System.out.println("Blad" + e);
                }
                catch (IOException e) {
                    System.out.println("Blad" + e);
                }

                System.out.println(opis);
                czywioska = true;
            }
        }
        else if(x == 99 && y == 96){
            if(czynekro == false){

            }
        }
    }
}
