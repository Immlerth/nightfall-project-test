package nightfall.project;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Enemy[] enemy;
    private Item[] loot;
    private boolean czyprzegrana;
    private int krawedzlewa;
    private int krawedzprawa;
    private int gx;
    private int px;
    private int tura;

    public Battle() {
        this.enemy = new Enemy[1];
        this.loot = new Item[10];
        this.czyprzegrana = false;
        this.krawedzlewa = 0;
        this.krawedzprawa = 40;
        this.gx = 20;
        this.px = 25;
        this.tura = 0;
    }

    public boolean isCzyprzegrana() {
        return czyprzegrana;
    }

    public void setCzyprzegrana(boolean czyprzegrana) {
        this.czyprzegrana = czyprzegrana;
    }

    public void obogowiewalka(Player player, int tx, int ty, String nazwaprzeciwnika, Inventory invet)
    {
        zaladujprzeciwnika(nazwaprzeciwnika);
        zaladujloot(nazwaprzeciwnika);
        System.out.println("");
        System.out.println(enemy[0].getOpisenc());
        int inicjatywagracza = player.getSzybkosc();
        int inicjatywaprzeciwnika = enemy[0].getSzybkosc();

        if(inicjatywagracza >= inicjatywaprzeciwnika)
        {
            while(player.getHealthPoints() > 0 && enemy[0].getHealthPoints() > 0){
                opissytuacji(player);
                if(player.getHealthPoints() < 0 || enemy[0].getHealthPoints() < 0) break;
                turagracza(player, invet);
                if(player.getHealthPoints() < 0 || enemy[0].getHealthPoints() < 0) break;
                turaprzeciwnika(player, invet);
            }
        }
        else
        {
            while(player.getHealthPoints() > 0 && enemy[0].getHealthPoints() > 0){
                opissytuacji(player);
                if(player.getHealthPoints() < 0 || enemy[0].getHealthPoints() < 0) break;
                turaprzeciwnika(player, invet);
                if(player.getHealthPoints() < 0 || enemy[0].getHealthPoints() < 0) break;
                turagracza(player, invet);
            }
        }


        if(player.getHealthPoints() <= 0){
            czyprzegrana = true;
        }
        else
        {
            System.out.println("Gratulacje, udalo ci sie pokonac przeciwnika. Znalazles obok niego: ");
            lootpowygranej(invet);
        }

    }

    public void zaladujprzeciwnika(String nazwaprzeciwnika)
    {
        String nazwapliku = nazwaprzeciwnika + ".txt";
        BufferedReader czyt = null;
        File file = new File("przeciwnicy/" +nazwapliku);
        String sciezka = file.getAbsolutePath();

        try
        {
            czyt = new BufferedReader(new FileReader(sciezka));
            String line = "";
            while ((line = czyt.readLine()) != null)
            {
                String[] potworek = line.split(";");
                this.enemy[0] = null;
                this.enemy[0] = new Enemy();
                this.enemy[0].setName(potworek[0]);
                this.enemy[0].setNamedp(potworek[1]);
                this.enemy[0].setOpisenc(potworek[2]);
                this.enemy[0].setIdpot(Integer.parseInt(potworek[3]));
                this.enemy[0].setSila(Integer.parseInt(potworek[4]));
                this.enemy[0].setInteligencja(Integer.parseInt(potworek[5]));
                this.enemy[0].setKondycja(Integer.parseInt(potworek[6]));
                this.enemy[0].setZrecznosc(Integer.parseInt(potworek[7]));
                this.enemy[0].setHealthPoints(Integer.parseInt(potworek[8]));
                this.enemy[0].setObrazeniawrecz(Integer.parseInt(potworek[9]));
                this.enemy[0].setObrazeniadystans(Integer.parseInt(potworek[10]));
                this.enemy[0].setPancerzglowa(Integer.parseInt(potworek[11]));
                this.enemy[0].setPancerztulw(Integer.parseInt(potworek[12]));
                this.enemy[0].setPancerzrece(Integer.parseInt(potworek[13]));
                this.enemy[0].setPancerznogi(Integer.parseInt(potworek[14]));
                this.enemy[0].setPancerzsuma(Integer.parseInt(potworek[15]));
                this.enemy[0].setStalydystanswrecz(Integer.parseInt(potworek[16]));
                this.enemy[0].setStalydystansdaleko(Integer.parseInt(potworek[17]));
                this.enemy[0].setIlegolda(Integer.parseInt(potworek[18]));
                this.enemy[0].setSzansanawrecz(Integer.parseInt(potworek[19]));
                this.enemy[0].setSzansanadystans(Integer.parseInt(potworek[20]));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Blad" + e);
        }
        catch (IOException e) {
            System.out.println("Blad" + e);
        }
    }

    public void zaladujloot(String nz){
        String nazwapliku = nz + ".txt";
        BufferedReader czyt = null;
        File file = new File("loot/" +nazwapliku);
        String sciezka = file.getAbsolutePath();

        try {
            czyt = new BufferedReader(new FileReader(sciezka));
            String line = "";
            while ((line = czyt.readLine()) != null) {
                String[] itemy = line.split(";");
                if (Integer.parseInt(itemy[0]) > 0) {
                    int w = 0;
                    for(int k = 0; k<Integer.parseInt(itemy[0]); k++){
                        this.loot[k] = new Item();
                        this.loot[k].setIdprzedmiotu(Integer.parseInt(itemy[w+1]));
                        this.loot[k].setNazwawek(itemy[w+2]);
                        this.loot[k].setNazwa(itemy[w+3]);
                        this.loot[k].setWartosc(Integer.parseInt(itemy[w+4]));
                        this.loot[k].setOpis(itemy[w+5]);
                        this.loot[k].setOpiswek(itemy[w+6]);

                        if(itemy[w+7].equals("tak")) this.loot[k].setCzynaglowe(true);
                        else this.loot[k].setCzynaglowe(false);

                        if(itemy[w+8].equals("tak")) this.loot[k].setCzynatulw(true);
                        else this.loot[k].setCzynatulw(false);

                        if(itemy[w+9].equals("tak")) this.loot[k].setCzynanogi(true);
                        else this.loot[k].setCzynanogi(false);

                        if(itemy[w+10].equals("tak")) this.loot[k].setCzynarece(true);
                        else this.loot[k].setCzynarece(false);

                        if(itemy[w+11].equals("tak")) this.loot[k].setCzydoprawadlon(true);
                        else this.loot[k].setCzydoprawadlon(false);

                        if(itemy[w+12].equals("tak")) this.loot[k].setCzydolewadlon(true);
                        else this.loot[k].setCzydolewadlon(false);

                        if(itemy[w+13].equals("tak")) this.loot[k].setCzytobronjednoreczna(true);
                        else this.loot[k].setCzytobronjednoreczna(false);

                        if(itemy[w+14].equals("tak")) this.loot[k].setCzytobrondystansowa(true);
                        else this.loot[k].setCzytobrondystansowa(false);

                        if(itemy[w+15].equals("tak")) this.loot[k].setCzytobrondwureczna(true);
                        else this.loot[k].setCzytobrondwureczna(false);

                        this.loot[k].setObrazenawrecz(Integer.parseInt(itemy[w+16]));
                        this.loot[k].setObrazenadystans(Integer.parseInt(itemy[w+17]));
                        this.loot[k].setWartoscpancerza(Integer.parseInt(itemy[w+18]));
                        this.loot[k].setZasiegwrecz(Integer.parseInt(itemy[w+19]));
                        this.loot[k].setZasiegdystans(Integer.parseInt(itemy[w+20]));
                        this.loot[k].setMinimumobrazen(Integer.parseInt(itemy[w+21]));
                        this.loot[k].setSzansatrafienia(Integer.parseInt(itemy[w+22]));
                        this.loot[k].setHpzpancerzy(Integer.parseInt(itemy[w+23]));

                        w=w+23;
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

    public void opissytuacji(Player player)
    {
        tura++;
        int odleglosc = px-gx;
        System.out.println("Znajdujesz sie w odleglosci " + odleglosc + " metrow od przeciwnika," );
        System.out.println("Masz " + player.getHealthPoints() + " HP.");

    }
    public void turagracza(Player player, Inventory invent) {
        boolean dobradecyzja = true;
        while (dobradecyzja == true)
        {
            System.out.println("Jest twoja kolej.");
            System.out.println("[1] Ruch");
            System.out.println("[2] Atak wrecz");
            if (player.getObrazeniadystans() > 0) System.out.println("[3] Atak dystansowy");
            System.out.println("Co chcesz zrobic?");

            Scanner scanner8 = new Scanner(System.in);
            String x4;
            x4 = scanner8.nextLine();

            switch (x4) {
                case "1":
                    boolean poprawyruch = true;
                    while(poprawyruch){
                        System.out.println("Chcesz sie zblizyc czy oddalic od przeciwnika?");
                        System.out.println("[1] Zblizyc");
                        System.out.println("[2] Oddalic");
                        Scanner scanner9 = new Scanner(System.in);
                        String x5;
                        x5 = scanner9.nextLine();

                        switch(x5) {
                        case "1":
                            if(gx+1 == px) {
                                System.out.println("Nie mozesz sie zblizyc, masz na drodze przeciwnika.");
                                poprawyruch = false;
                            }
                            else
                            {
                                gx=gx+1;
                                System.out.println("Ruszyles sie do przodu.");
                                dobradecyzja = false;
                                poprawyruch = false;
                            }
                        break;
                        case "2":
                            if(gx-1 < 0) {
                                System.out.println("Nie mozesz poruszyc do tylu. Dochodzisz do krawedzi mapy");
                            }
                            else
                            {
                                gx=gx-1;
                                System.out.println("Ruszyles sie do tylu.");
                                dobradecyzja = false;
                                poprawyruch = false;
                            }
                            break;
                        default:
                        System.out.println("Brak dostepnej opcji");
                        }
                    }
                    break;
                case "2":
                    if(px-gx <= invent.zasieg_broni_wrecz()){
                        atakgracza(player, invent, 0, px-gx);
                        dobradecyzja = false;
                    }
                    else{
                        System.out.println("Nie masz zasiegu na atak!");
                    }
                    break;
                case "3":
                    if (player.getObrazeniadystans() > 0) {
                        if(px-gx <= invent.zasieg_broni_dystans() ){
                            atakgracza(player, invent, 1, px-gx);
                            dobradecyzja = false;
                        }
                        else{
                            System.out.println("Nie masz zasiegu na atak!");
                        }
                    } else {
                        System.out.println("Brak dostepnej opcji");
                    }
                    break;
                default:
                    System.out.println("Brak dostepnej opcji");
            }
        }
    }

    public void turaprzeciwnika(Player player, Inventory invent)
    {
        System.out.println("Kolej przeciwnika.");
        Random rand = new Random();
        int fate = rand.nextInt(100);

        if(enemy[0].getStalydystansdaleko() > 0)
        {
            if(px-gx <= enemy[0].getStalydystansdaleko()){
                int ostateczneobrazenia = enemy[0].getZrecznosc() + rand.nextInt(enemy[0].getObrazeniadystans());;
                System.out.println("Przeciwnik probuje cie zaatakowac. Ma on " + enemy[0].getSzansanadystans() +"% szans na trafienie");
                System.out.println("Rzucil " + fate);
                if(fate > 0 && fate <= enemy[0].getSzansanadystans())
                {
                    int wco = rand.nextInt(100);
                    String pozycja = "";
                    if(wco >0 && wco <=15)
                    {
                        pozycja = "glowe";
                        ostateczneobrazenia = ostateczneobrazenia - player.getPancerzglowa();
                    }
                    else if(wco >15 && wco <=60)
                    {
                        pozycja = "tulw";
                        ostateczneobrazenia = ostateczneobrazenia - player.getPancerztulw();
                    }
                    else if(wco >60 && wco <=85)
                    {
                        pozycja = "rece";
                        ostateczneobrazenia = ostateczneobrazenia - player.getPancerzrece();
                    }
                    else
                    {
                        pozycja = "nogi";
                        ostateczneobrazenia = ostateczneobrazenia - player.getPancerznogi();
                    }
                    int zas = px-gx;
                    System.out.println("Przeciwnik trafil cie! Zadaje ci " + ostateczneobrazenia + " obrazen w " + pozycja + " oraz dodatkowe obrazenia za zasieg rowne" + zas);
                    player.setHealthPoints(player.getHealthPoints() - ((ostateczneobrazenia)+zas));
                }
                else
                {
                    System.out.println(enemy[0].getNamedp() + " nie trafil cie.");
                }
            }
            else if(px-gx <= enemy[0].getStalydystanswrecz())
            {
                atakwroga(fate,player);
            }
            else
            {
                if(px-1 == gx) {
                    atakwroga(fate,player);
                }
                else
                {
                    px=px-1;
                    System.out.println(enemy[0].getNamedp() + " zblizyl sie do ciebie.");

                }
            }
        }
        else if(px-gx <= enemy[0].getStalydystanswrecz())
        {
           atakwroga(fate,player);
        }
        else
        {
            if(px-1 == gx) {
                atakwroga(fate,player);
            }
            else
            {
                px=px-1;
                System.out.println(enemy[0].getNamedp() + " zblizyl sie do ciebie.");

            }
        }
    }

    public void atakwroga(int fate, Player player){
        Random rand = new Random();
        int ostateczneobrazenia = enemy[0].getSila() + rand.nextInt(enemy[0].getObrazeniawrecz());
        System.out.println("Przeciwnik probuje cie zaatakowac. Ma on " + enemy[0].getSzansanawrecz() +"% szans na trafienie");
        System.out.println("Rzucil " + fate);
        if(fate > 0 && fate <= enemy[0].getSzansanawrecz())
        {
            int wco = rand.nextInt(100);
            String pozycja = "";
            if(wco >0 && wco <=15)
            {
                pozycja = "glowe";
                ostateczneobrazenia = ostateczneobrazenia - player.getPancerzglowa();
            }
            else if(wco >15 && wco <=60)
            {
                pozycja = "tulw";
                ostateczneobrazenia = ostateczneobrazenia - player.getPancerztulw();
            }
            else if(wco >60 && wco <=85)
            {
                pozycja = "rece";
                ostateczneobrazenia = ostateczneobrazenia - player.getPancerzrece();
            }
            else
            {
                pozycja = "nogi";
                ostateczneobrazenia = ostateczneobrazenia - player.getPancerznogi();
            }

            System.out.println("Przeciwnik trafil cie! Zadaje ci " + ostateczneobrazenia + " obrazen w " + pozycja + ".");
            player.setHealthPoints(player.getHealthPoints() - (ostateczneobrazenia));
        }
        else
        {
            System.out.println(enemy[0].getNamedp() + " nie trafil cie.");
        }
    }
    public void lootpowygranej(Inventory invent)
    {
        int i = 0;
        while(this.loot[i] != null)
        {
            invent.dodajprzedmiot(this.loot[i]);
            invent.setPieniadze(invent.getPieniadze() + enemy[0].getIlegolda());
            System.out.println("Podniosles "+ enemy[0].getIlegolda() + " sztuk zlota");
            i++;
        }
    }
    public void atakgracza(Player player, Inventory invent, int dys, int zas)
    {
        Random rand = new Random();
        int fate = rand.nextInt(100);
        if(fate == 0) fate = 1;
        int szansawr = 100 - (enemy[0].getZrecznosc()*15) + invent.podaj_bonus_trafienia() + (player.getInteligencja()*5);
        if(szansawr < 0) szansawr = 10;
        int szansazr = 100 - (enemy[0].getZrecznosc()*15) + invent.podaj_bonus_trafienia() + (player.getInteligencja()*5);
        if(szansazr < 0) szansawr = 10;
        int inbobr = 0;
        if(player.getObrazeniawrecz()>1) inbobr = rand.nextInt(player.getObrazeniawrecz() + 1 - invent.minimalneobrazenia() + invent.minimalneobrazenia());
        int inbobrds = 0;
        if(player.getObrazeniadystans()>1) inbobrds = rand.nextInt(player.getObrazeniadystans() + 1 - invent.minimalneobrazenia() + invent.minimalneobrazenia());

        if(dys == 1)
        {
            int ostateczneobrazenia = player.getZrecznosc() + inbobrds;
            System.out.println("Probujesz zaatakowac przeciwnika. Masz " + szansazr +"% szans na trafienie");
            System.out.println("Rzuciles " + fate);
            if(fate > 0 && fate <= szansazr)
            {
                int wco = rand.nextInt(100);
                String pozycja = "";
                if(wco >0 && wco <=15)
                {
                    pozycja = "glowe";
                    ostateczneobrazenia = ostateczneobrazenia - enemy[0].getPancerzglowa();
                }
                else if(wco >15 && wco <=60)
                {
                    pozycja = "tulw";
                    ostateczneobrazenia = ostateczneobrazenia - enemy[0].getPancerztulw();
                }
                else if(wco >60 && wco <=85)
                {
                    pozycja = "rece";
                    ostateczneobrazenia = ostateczneobrazenia - enemy[0].getPancerzrece();
                }
                else
                {
                    pozycja = "nogi";
                    ostateczneobrazenia = ostateczneobrazenia - enemy[0].getPancerznogi();
                }

                System.out.println("Udalo ci sie trafic przeciwnika! Zadajesz mu " + ostateczneobrazenia + " obrazen w " + pozycja + " oraz dodatkowe obrazenia za zasieg rowne" + zas);
                enemy[0].setHealthPoints(enemy[0].getHealthPoints() - ((ostateczneobrazenia)+zas));
            }
            else
            {
                System.out.println("Nie trafiles przeciwnika.");
            }
        }
        else
            {
            int ostateczneobrazenia = player.getSila() + inbobr;
            System.out.println("Probojesz zaatakowac przeciwnika. Masz " + szansawr +"% szans na trafienie");
            System.out.println("Rzuciles " + fate);
            if(fate > 0 && fate <= szansawr)
            {
                int wco = rand.nextInt(100);
                String pozycja = "";
                if(wco >0 && wco <=15)
                {
                    pozycja = "glowe";
                    ostateczneobrazenia = ostateczneobrazenia - enemy[0].getPancerzglowa();
                }
                else if(wco >15 && wco <=60)
                {
                    pozycja = "tulw";
                    ostateczneobrazenia = ostateczneobrazenia - enemy[0].getPancerztulw();
                }
                else if(wco >60 && wco <=85)
                {
                    pozycja = "rece";
                    ostateczneobrazenia = ostateczneobrazenia - enemy[0].getPancerzrece();
                }
                else
                {
                    pozycja = "nogi";
                    ostateczneobrazenia = ostateczneobrazenia - enemy[0].getPancerznogi();
                }

                System.out.println("Udalo ci sie trafic przeciwnika! Zadajesz mu " + ostateczneobrazenia + " obrazen w " + pozycja + ".");
                enemy[0].setHealthPoints(enemy[0].getHealthPoints() - (ostateczneobrazenia));
            }
            else
            {
                System.out.println("Nie trafiles przeciwnika.");
            }
        }
    }
}
