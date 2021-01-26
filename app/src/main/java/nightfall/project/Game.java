package nightfall.project;

import java.io.*;
import java.util.Scanner;

public class Game {
    private Room[][] matrix;
    private Item[][][] items;
    private Sellers[][] sprzedawcy;
    boolean gameloop;
    public Game() {
        this.matrix = new Room[100][100];
        this.items = new Item[100][100][10];
        this.sprzedawcy = new Sellers[100][100];
        this.gameloop = true;
    }

    public Room[][] getMatrix() {
        return matrix;
    }
    public void setMatrix(Room[][] matrix) {
        this.matrix = matrix;
    }
    public Item[][][] getItems() { return items; }
    public void setItems(Item[][][] items) { this.items = items; }

    public void rozpocznijgre(Player gracz, Inventory ekwipunekgracza, Events event){

        gracz.tworzeniepostaci();
        while(gameloop)
        {
            wczytajpokoj(gracz.getPosition().x, gracz.getPosition().y, event);
            systemkomend(gracz,gracz.getPosition().x, gracz.getPosition().y,ekwipunekgracza);
        }
    }
    public void wczytajpokoj(int tx, int ty, Events event)
    {
        if(this.matrix[tx][ty] == null)
        {
            String nazwapliku = Integer.toString(tx) + Integer.toString(ty) + ".txt";
            BufferedReader czyt = null;
            File file = new File("pokoje/" +nazwapliku);
            String sciezka = file.getAbsolutePath();

            try
            {
                czyt = new BufferedReader(new FileReader(sciezka));
                String line = "";
                while ((line = czyt.readLine()) != null) {
                    String [] plik1 = line.split(";");

                    this.matrix[tx][ty] = new Room();
                    this.matrix[tx][ty].setRoomID(Integer.parseInt(plik1[0]));
                    this.matrix[tx][ty].setRoomDescription(plik1[1]);
                    if(plik1[2].equals("polnoc"))
                        this.matrix[tx][ty].setDrogapolnoc(true);
                    else
                        this.matrix[tx][ty].setDrogapolnoc(false);

                    if(plik1[3].equals("poludnie"))
                        this.matrix[tx][ty].setDrogapoludnie(true);
                    else
                        this.matrix[tx][ty].setDrogapoludnie(false);

                    if(plik1[4].equals("wschod"))
                        this.matrix[tx][ty].setDrogawschod(true);
                    else
                        this.matrix[tx][ty].setDrogawschod(false);

                    if(plik1[5].equals("zachod"))
                        this.matrix[tx][ty].setDrogazachod(true);
                    else
                        this.matrix[tx][ty].setDrogazachod(false);
                    this.matrix[tx][ty].setWczesniejwczytany(true);

                    if(plik1[6].equals("tak")) this.matrix[tx][ty].setCzypokojtowalka(true);
                    else this.matrix[tx][ty].setCzypokojtowalka(false);

                    if(plik1[7].equals("tak")) this.matrix[tx][ty].setCzypokojmadialog(true);
                    else this.matrix[tx][ty].setCzypokojmadialog(false);

                    if(plik1[8].equals("tak")) this.matrix[tx][ty].setCzypokojtohandlarz(true);
                    else this.matrix[tx][ty].setCzypokojtohandlarz(false);

                    if(plik1[9].equals("tak")) this.matrix[tx][ty].setCzypokojtoportal(true);
                    else this.matrix[tx][ty].setCzypokojtoportal(false);

                    this.matrix[tx][ty].setPortalx(Integer.parseInt(plik1[10]));
                    this.matrix[tx][ty].setPortaly(Integer.parseInt(plik1[11]));
                    this.matrix[tx][ty].setNazwapotworawpokoju(plik1[12]);

                    if(Integer.parseInt(plik1[13])>0)
                    {
                        int w=13;
                        for(int i = 0; i<Integer.parseInt(plik1[13]); i++)
                        {
                            this.items[tx][ty][i] = new Item();
                            this.items[tx][ty][i].setIdprzedmiotu(Integer.parseInt(plik1[w+1]));
                            this.items[tx][ty][i].setNazwawek(plik1[w+2]);
                            this.items[tx][ty][i].setNazwa(plik1[w+3]);
                            this.items[tx][ty][i].setWartosc(Integer.parseInt(plik1[w+4]));
                            this.items[tx][ty][i].setOpis(plik1[w+5]);
                            this.items[tx][ty][i].setOpiswek(plik1[w+6]);

                            if(plik1[w+7].equals("tak")) this.items[tx][ty][i].setCzynaglowe(true);
                            else this.items[tx][ty][i].setCzynaglowe(false);

                            if(plik1[w+8].equals("tak")) this.items[tx][ty][i].setCzynatulw(true);
                            else this.items[tx][ty][i].setCzynatulw(false);

                            if(plik1[w+9].equals("tak")) this.items[tx][ty][i].setCzynanogi(true);
                            else this.items[tx][ty][i].setCzynanogi(false);

                            if(plik1[w+10].equals("tak")) this.items[tx][ty][i].setCzynarece(true);
                            else this.items[tx][ty][i].setCzynarece(false);

                            if(plik1[w+11].equals("tak")) this.items[tx][ty][i].setCzydoprawadlon(true);
                            else this.items[tx][ty][i].setCzydoprawadlon(false);

                            if(plik1[w+12].equals("tak")) this.items[tx][ty][i].setCzydolewadlon(true);
                            else this.items[tx][ty][i].setCzydolewadlon(false);

                            if(plik1[w+13].equals("tak")) this.items[tx][ty][i].setCzytobronjednoreczna(true);
                            else this.items[tx][ty][i].setCzytobronjednoreczna(false);

                            if(plik1[w+14].equals("tak")) this.items[tx][ty][i].setCzytobrondystansowa(true);
                            else this.items[tx][ty][i].setCzytobrondystansowa(false);

                            if(plik1[w+15].equals("tak")) this.items[tx][ty][i].setCzytobrondwureczna(true);
                            else this.items[tx][ty][i].setCzytobrondwureczna(false);

                            this.items[tx][ty][i].setObrazenawrecz(Integer.parseInt(plik1[w+16]));
                            this.items[tx][ty][i].setObrazenadystans(Integer.parseInt(plik1[w+17]));
                            this.items[tx][ty][i].setWartoscpancerza(Integer.parseInt(plik1[w+18]));
                            this.items[tx][ty][i].setZasiegwrecz(Integer.parseInt(plik1[w+19]));
                            this.items[tx][ty][i].setZasiegdystans(Integer.parseInt(plik1[w+20]));
                            this.items[tx][ty][i].setMinimumobrazen(Integer.parseInt(plik1[w+21]));
                            this.items[tx][ty][i].setSzansatrafienia(Integer.parseInt(plik1[w+22]));
                            this.items[tx][ty][i].setHpzpancerzy(Integer.parseInt(plik1[w+23]));

                            w=w+23;
                        }
                        zaladujpokoj(tx,ty, event);
                    }
                    else zaladujpokoj(tx,ty, event);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("Blad" + e);
            }
            catch (IOException e) {
                System.out.println("Blad" + e);
            }
        }
        else
        {
            zaladujpokoj(tx,ty, event);
        }
    }

    public void zaladujpokoj(int tx, int ty, Events event)
    {
        event.kontrolaeventu(tx,ty);
        this.matrix[tx][ty].inicjalizacjapokoju();
        int itemy = 0;

        while(itemy <= 9){
            if(this.items[tx][ty][itemy] == null) {
                itemy++;
            }
            else{
                System.out.print(this.items[tx][ty][itemy].getOpis());
                itemy++;
            }
        }
    }

    public void systemkomend(Player player,int tx, int ty, Inventory ekiwp)
    {
        if(this.matrix[tx][ty].isCzypokojtowalka() == true) {
            Battle bitka = new Battle();
            bitka.obogowiewalka(player, tx, ty, this.matrix[tx][ty].getNazwapotworawpokoju(), ekiwp);
            if (bitka.isCzyprzegrana() == true) {
                gameloop = false;
                przegrana();
            }
            this.matrix[tx][ty].setCzypokojtowalka(false);
        }
        else if (this.matrix[tx][ty].isCzypokojtohandlarz() == true){

            if(sprzedawcy[tx][ty] != null){
                sprzedawcy[tx][ty].pohandlujmy(player, ekiwp);
            }
            else{
                sprzedawcy[tx][ty] = new Sellers(tx,ty);
                sprzedawcy[tx][ty].zaladujsprzedawca();
                sprzedawcy[tx][ty].pohandlujmy(player, ekiwp);
            }

            if(this.matrix[tx][ty].isDrogapolnoc()) player.idzpolnoc();
            else if(this.matrix[tx][ty].isDrogapoludnie()) player.idzpoludnie();
            else if(this.matrix[tx][ty].isDrogazachod()) player.idzzachod();
            else if(this.matrix[tx][ty].isDrogawschod()) player.idzwschod();
        }
        else
            {
                this.matrix[tx][ty].pokazdostepnekierunki();
                System.out.println("");
                System.out.println("Co chcesz zrobic?");
                Scanner scanner = new Scanner(System.in);
                String x;
                x = scanner.nextLine();

                switch(x){
                    case "polnoc":
                        if(this.matrix[tx][ty].isDrogapolnoc() == true) player.idzpolnoc();
                        else System.out.println("Brak drogi na polnoc");
                        break;
                    case "poludnie":
                        if(this.matrix[tx][ty].isDrogapoludnie() == true) player.idzpoludnie();
                        else System.out.println("Brak drogi na poludnie");
                        break;
                    case "wschod":
                        if(this.matrix[tx][ty].isDrogawschod() == true) player.idzwschod();
                        else System.out.println("Brak drogi na wschod");
                        break;
                    case "zachod":
                        if(this.matrix[tx][ty].isDrogazachod() == true) player.idzzachod();
                        else System.out.println("Brak drogi na zachod");
                        break;
                    case "statystyki":
                        player.wyswietlstatystyki(ekiwp);
                        break;
                    case "ekwipunek":
                        ekiwp.wyswietlekwipunek();
                        break;
                    case "zaloz":
                        if(ekiwp.ileprzedmiotowweq() == 0){
                            System.out.println("Nie masz zadnego przedmiotu w ekwipunku.");
                            break;
                        }
                        else{
                            ekiwp.wyswietlekwipunek();
                            System.out.println("Co chcesz zalozyc?(podaj nr przedmiotu z ekwipunku) ");
                            Scanner scanner3 = new Scanner(System.in);
                            if(scanner3.hasNextInt()) {
                                int x3;
                                x3 = scanner3.nextInt();
                                int liczba = x3;
                                ekiwp.zalozprzedmiot(liczba, player);
                                break;
                            }
                            else{
                                System.out.println("Nie podales numeru! ");
                                break;
                            }

                        }
                    case "zdejmij":
                        if(ekiwp.ileprzedmiotowweq() == 0){
                            System.out.println("Nie masz zadnego przedmiotu w ekwipunku.");
                            break;
                        }
                        else {
                            ekiwp.wyswietlekwipunek();
                            System.out.println("Co chcesz zdjac?(podaj nr przedmiotu z ekwipunku) ");
                            Scanner scanner4 = new Scanner(System.in);
                            if(scanner4.hasNextInt()) {
                                int x4;
                                x4 = scanner4.nextInt();
                                int liczba2 = x4;
                                ekiwp.zdejmijprzedmiot(liczba2, player);
                                break;
                            }
                            else{
                                System.out.println("Nie podales numeru! ");
                                break;
                            }
                        }
                    case "pomoc":
                        wyswietldostepnekomendy();
                        break;
                    case "rezero":
                        int zx=0;
                        int zy=0;
                        Scanner scanner9 = new Scanner(System.in);
                        System.out.println("Podaj x:");
                        if(scanner9.hasNextInt()) {
                            zx = scanner9.nextInt();
                        }
                        System.out.println("Podaj y:");
                        if(scanner9.hasNextInt()) {
                            zy = scanner9.nextInt();
                        }
                        player.teleportacja(zx,zy);
                        break;
                    case "uzyj":
                        if(ekiwp.ileprzedmiotowweq() == 0){
                            System.out.println("Nie masz zadnego przedmiotu w ekwipunku.");
                            break;
                        }
                        else{
                            ekiwp.wyswietlekwipunek();
                            System.out.println("Jakiego przedmiotu chcesz uzyc?");
                            Scanner scanner7 = new Scanner(System.in);
                            if(scanner7.hasNextInt()) {
                                int x7;
                                x7 = scanner7.nextInt();
                                int liczba7 = x7;
                                ekiwp.uzyjprzedmiot(liczba7, player);
                                break;
                            }
                            else{
                                System.out.println("Nie podales numeru! ");
                                break;
                            }
                        }
                    case "bartek":
                        player.setHealthPoints(1);
                        break;
                    case "kamil":
                        ekiwp.setPieniadze(10000);
                        break;
                    case "god":
                        player.setMaxhp(1000);
                        player.setHealthPoints(1000);
                        player.setSila(1000);
                        break;
                    case "wyjdz":
                    case "exit":
                        System.exit(1);
                        break;
                    case "przejdz":
                        if(this.matrix[tx][ty].isCzypokojtoportal()){
                            int sx = this.matrix[tx][ty].getPortalx();
                            int sy = this.matrix[tx][ty].getPortaly();
                            System.out.println("Przechodzisz przez portal, udajac sie w nieznane. ");
                            player.teleportacja(sx,sy);
                        }
                        else{
                            System.out.println("Nie widzisz przejscia przez portal. ");
                        }
                        break;
                    case "podnies":
                        System.out.println("Co chcesz podniesc? ");
                        Scanner scanner2 = new Scanner(System.in);
                        String x2;
                        x2 = scanner2.nextLine();
                        boolean znalezionoprzedmiot = false;
                        int it = 0;
                        while(it <= 9){
                            if(this.items[tx][ty][it] == null)
                            {
                                it++;
                            }
                            else
                            {
                                if(this.items[tx][ty][it].getNazwa().equals(x2))
                                {
                                    if(this.items[tx][ty][it].getIdprzedmiotu() == 9969){
                                        ekiwp.setPieniadze(ekiwp.getPieniadze() + this.items[tx][ty][it].getWartosc());
                                        System.out.println("Podniosles " + this.items[tx][ty][it].getWartosc() + " sztuk zlota.");
                                        this.items[tx][ty][it] = null;
                                        znalezionoprzedmiot = true;
                                        break;
                                    }
                                    else
                                    {
                                        ekiwp.dodajprzedmiot(this.items[tx][ty][it]);
                                        this.items[tx][ty][it] = null;
                                        znalezionoprzedmiot = true;
                                        break;
                                    }
                                }
                                else
                                {
                                    it++;
                                }
                            }
                        }

                        if(znalezionoprzedmiot == false) System.out.println("Brak takiego przedmiotu do podniesienia. ");
                        break;

                    default:
                        System.out.println("Niepoprawna komenda");
                }
            }
        }
    public void wyswietldostepnekomendy()
    {
        System.out.println("---------------------------------------------------------");
        System.out.println("polnoc - idz na polnoc");
        System.out.println("poludnie - idz na poludnie");
        System.out.println("wschod - idz na wschod");
        System.out.println("zachod - idz na zachod");
        System.out.println("pomoc - wyswietla ta liste komend");
        System.out.println("przejdz - przechodzi przez portal, jezeli taki istnieje w lokacji");
        System.out.println("statystyki - wyswietla statystyki twojej postaci");
        System.out.println("zbierz - podnosi przedmiot z pokoju");
        System.out.println("zaloz - zaloz przedmiot na dostepny slot, jezeli taki posiadasz");
        System.out.println("zdejmij - zdejmij przedmiot z dostepnego slotu");
        System.out.println("---------------------------------------------------------");
    }

    public void przegrana()
    {
        System.out.println("Niestety, twoja postac zginela. Zakonczyl sie epizod tej gry. Pamietaj jednak, ze nadal mozesz sprobowac jeszcze raz");
    }

    public void zamknijpokoj(int ttx, int tty, int k)
    {
        if(k == 1) this.matrix[ttx][tty].setDrogapolnoc(false);
        else if(k == 2) this.matrix[ttx][tty].setDrogapoludnie(false);
        else if(k == 3) this.matrix[ttx][tty].setDrogawschod(false);
        else if(k == 4) this.matrix[ttx][tty].setDrogazachod(false);
    }
}

