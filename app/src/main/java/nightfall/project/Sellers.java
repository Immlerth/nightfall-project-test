package nightfall.project;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sellers {
    private String nazwa;
    private String nazwadp;
    private String opis;
    private String wiadomoscpowitalna;
    private String wiadomosczakup;
    private String wiadomoscsprzedaz;
    private float mnozniksprzedazy;
    private int tx;
    private int ty;
    private ArrayList<Item> items;
    private boolean zak = true;

    public Sellers(int x, int y) {
        items = new ArrayList<Item>(10);
        tx = x;
        ty = y;
    }

    public void zaladujsprzedawca(){
        String nazwapliku = tx + "" + ty + "s.txt";
        BufferedReader czyt = null;
        File file = new File("sprzedawcy/" +nazwapliku);
        String sciezka = file.getAbsolutePath();

        try {
            czyt = new BufferedReader(new FileReader(sciezka));
            String line = "";
            while ((line = czyt.readLine()) != null) {
                String[] sprzed = line.split(";");
                this.nazwa = sprzed[0];
                this.nazwadp = sprzed[1];
                this.opis = sprzed[2];
                this.wiadomoscpowitalna = sprzed[3];
                this.wiadomosczakup = sprzed[4];
                this.wiadomoscsprzedaz = sprzed[5];
                this.mnozniksprzedazy = Float.parseFloat(sprzed[6]);
                if (Integer.parseInt(sprzed[7]) > 0) {
                    int w = 7;
                    for (int k = 0; k < Integer.parseInt(sprzed[7]); k++) {
                        Item itemek;
                        itemek = new Item();
                        itemek.setIdprzedmiotu(Integer.parseInt(sprzed[w + 1]));
                        itemek.setNazwawek(sprzed[w + 2]);
                        itemek.setNazwa(sprzed[w + 3]);
                        itemek.setWartosc(Integer.parseInt(sprzed[w + 4]));
                        itemek.setOpis(sprzed[w + 5]);
                        itemek.setOpiswek(sprzed[w + 6]);

                        if (sprzed[w + 7].equals("tak")) itemek.setCzynaglowe(true);
                        else itemek.setCzynaglowe(false);

                        if (sprzed[w + 8].equals("tak")) itemek.setCzynatulw(true);
                        else itemek.setCzynatulw(false);

                        if (sprzed[w + 9].equals("tak")) itemek.setCzynanogi(true);
                        else itemek.setCzynanogi(false);

                        if (sprzed[w + 10].equals("tak")) itemek.setCzynarece(true);
                        else itemek.setCzynarece(false);

                        if (sprzed[w + 11].equals("tak")) itemek.setCzydoprawadlon(true);
                        else itemek.setCzydoprawadlon(false);

                        if (sprzed[w + 12].equals("tak")) itemek.setCzydolewadlon(true);
                        else itemek.setCzydolewadlon(false);

                        if (sprzed[w + 13].equals("tak")) itemek.setCzytobronjednoreczna(true);
                        else itemek.setCzytobronjednoreczna(false);

                        if (sprzed[w + 14].equals("tak")) itemek.setCzytobrondystansowa(true);
                        else itemek.setCzytobrondystansowa(false);

                        if (sprzed[w + 15].equals("tak")) itemek.setCzytobrondwureczna(true);
                        else itemek.setCzytobrondwureczna(false);

                        itemek.setObrazenawrecz(Integer.parseInt(sprzed[w + 16]));
                        itemek.setObrazenadystans(Integer.parseInt(sprzed[w + 17]));
                        itemek.setWartoscpancerza(Integer.parseInt(sprzed[w + 18]));
                        itemek.setZasiegwrecz(Integer.parseInt(sprzed[w + 19]));
                        itemek.setZasiegdystans(Integer.parseInt(sprzed[w + 20]));
                        itemek.setHpzpancerzy(Integer.parseInt(sprzed[w + 21]));
                        itemek.setSzansatrafienia(Integer.parseInt(sprzed[w + 22]));
                        itemek.setMinimumobrazen(Integer.parseInt(sprzed[w + 23]));

                        items.add(itemek);
                        w = w + 23;
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Blad" + e);
        }
        catch (IOException e) {
            System.out.println("Blad" + e);
        }
    }

    public void pohandlujmy(Player player, Inventory inventor){
        System.out.println(opis);
        zak = true;
        while(zak){
            wyswietlprzedmioty();
            dostepneopcje(player,inventor);
        }
    }

    public void wyswietlprzedmioty(){
        System.out.println(nazwadp + " ma do sprzedania ponizsze przedmioty: ");
        System.out.println("---------------------------------------------------------");
        int i =0;
        int k = 0;
        while(i<items.size()){
                int wartosc = Math.round(items.get(i).getWartosc() * mnozniksprzedazy);
                k++;
                if(items.get(i).isCzynaglowe())
                {
                    System.out.println(k + ". " + items.get(i).getNazwawek() + ", Wartosc: " + wartosc);
                    System.out.println("Rodzaj: Helm, Wartosc pancerza na glowe: " + items.get(i).getWartoscpancerza() + ", Wartsc bonusowego HP: "+ items.get(i).getHpzpancerzy());
                    System.out.println("Opis: " + items.get(i).getOpiswek());
                }
                else if(items.get(i).isCzynatulw())
                {
                    System.out.println(k + ". " + items.get(i).getNazwawek() + ", Wartosc: " + wartosc);
                    System.out.println("Rodzaj: Pancerz, Wartosc pancerza na tulowie: " + items.get(i).getWartoscpancerza() + ", Wartsc bonusowego HP: "+ items.get(i).getHpzpancerzy());
                    System.out.println("Opis: " + items.get(i).getOpiswek());
                }
                else if(items.get(i).isCzynarece())
                {
                    System.out.println(k + ". " + items.get(i).getNazwawek() + ", Wartosc: " + wartosc);
                    System.out.println("Rodzaj: Rekawice, Wartosc pancerza na rekach: " + items.get(i).getWartoscpancerza() + ", Wartsc bonusowego HP: "+ items.get(i).getHpzpancerzy());
                    System.out.println("Opis: " + items.get(i).getOpiswek());
                }
                else if(items.get(i).isCzynanogi())
                {
                    System.out.println(k + ". " + items.get(i).getNazwawek() + ", Wartosc: " + wartosc);
                    System.out.println("Rodzaj: Buty, Wartosc pancerza na nogach: " + items.get(i).getWartoscpancerza() + ", Wartsc bonusowego HP: "+ items.get(i).getHpzpancerzy());
                    System.out.println("Opis: " + items.get(i).getOpiswek());
                }
                else if(items.get(i).isCzydoprawadlon())
                {
                    if(items.get(i).isCzytobrondystansowa() == true){
                        System.out.println(k + ". " + items.get(i).getNazwawek() + ", Wartosc: " + wartosc);
                        System.out.println("Rodzaj: Bron dystansowa, Wartosc obrazen dystansowych: od " + items.get(i).getMinimumobrazen() +" do " + + items.get(i).getObrazenadystans() + ", Zasieg ataku dystansowego: " + items.get(i).getZasiegdystans()  + ", Szansa trafienia: +" + items.get(i).getSzansatrafienia());
                        System.out.println("Opis: " + items.get(i).getOpiswek());
                    }
                    else
                    {
                        System.out.println(k + ". " + items.get(i).getNazwawek() + ", Wartosc: " + wartosc);
                        System.out.println("Rodzaj: Bron jednoreczna, Wartosc obrazen wrecz: od " + items.get(i).getMinimumobrazen() +" do " + items.get(i).getObrazenawrecz() + ", Zasieg ataku wrecz: " + items.get(i).getZasiegwrecz() + ", Szansa trafienia: +" + items.get(i).getSzansatrafienia());
                        System.out.println("Opis: " + items.get(i).getOpiswek());
                    }
                }
                else if(items.get(i).isCzydolewadlon())
                {
                        System.out.println(k + ". " + items.get(i).getNazwawek() + ", Wartosc: " + wartosc);
                        System.out.println("Rodzaj: Tarcza, Wartosc dodatkowego pancerza: " + items.get(i).getWartoscpancerza() + ", Wartsc bonusowego HP: "+ items.get(i).getHpzpancerzy());
                        System.out.println("Opis: " + items.get(i).getOpiswek());
                }
                else {
                        System.out.println(k + ". " + items.get(i).getNazwawek() + ", Wartosc: " + wartosc);
                        System.out.println("Opis: " + items.get(i).getOpiswek());
                }
                i++;

        }
        System.out.println("---------------------------------------------------------");
    }

    public void dostepneopcje(Player player, Inventory inventor) {
        System.out.println("Co chcesz zrobic?");
        System.out.println("[1] Kup przedmiot");
        System.out.println("[2] Sprzedaj przedmiot");
        System.out.println("[3] Zakoncz handel");
        Scanner scanner = new Scanner(System.in);
        String x;
        x = scanner.nextLine();


        switch (x) {
            case "1":
                wyswietlprzedmioty();
                boolean kupno = true;
                while(kupno){
                System.out.println("Ktory przedmiot chcesz kupic? (podaj numer przedmiotu, wpisz 0 aby wyjsc)");
                Scanner scanner6 = new Scanner(System.in);
                String x6;
                x6 = scanner.nextLine();
                int item = Integer.parseInt(x6) - 1;

                if(item>items.size())
                {
                    System.out.println("Nie ma takiego przedmiotu");
                }
                if(item == items.size()){
                    System.out.println("Nie ma takiego przedmiotu");
                }
                if(item+1 == 0)
                {
                    kupno = false;
                    break;
                }
                else
                {
                    int wartosc = Math.round(items.get(item).getWartosc() * mnozniksprzedazy);
                    if(inventor.getPieniadze() > wartosc){
                        inventor.setPieniadze(inventor.getPieniadze() - wartosc);
                        inventor.dodajprzedmiot(items.get(item));
                        items.remove(item);
                        kupno = false;
                    }
                    else
                    {
                        System.out.println("Nie masz wystarczajacej ilosci gotowki na zakup tego przedmiotu");
                    }
                }
                }
                break;
            case "2":
                inventor.sprzedajprzedmiot(player,items);
                break;
            case "3":
                zak = false;
                break;
            default:
                System.out.println("blad");
        }
    }
}
