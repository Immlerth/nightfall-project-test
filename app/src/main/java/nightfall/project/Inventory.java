package nightfall.project;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private Item[] slotnaglowiezajety;
    private Item[] slotnatulowiuzajety;
    private Item[] slotnanogizajety;
    private Item[] slotnalewejrecezajety;
    private Item[] slotnaprawejrecezajety;
    private Item[] slotnarecezajety;
    private ArrayList<Item> items;
    private int pieniadze;


    public Inventory() {
        slotnaglowiezajety = new Item[1];
        slotnatulowiuzajety = new Item[1];
        slotnanogizajety = new Item[1];
        slotnarecezajety = new Item[1];
        slotnalewejrecezajety = new Item[1];
        slotnaprawejrecezajety = new Item[1];
        this.pieniadze = 0;
        items = new ArrayList<Item>(60);
    }

    public int getPieniadze() {
        return pieniadze;
    }

    public void setPieniadze(int pieniadze) {
        this.pieniadze = pieniadze;
    }

    public int zasieg_broni_wrecz(){
        if(slotnaprawejrecezajety[0] == null){
            return 1;
        }
        else{
            return slotnaprawejrecezajety[0].getZasiegwrecz();
        }
    }

    public int minimalneobrazenia(){
        if(slotnaprawejrecezajety[0] == null){
            return 1;
        }
        else{
            return slotnaprawejrecezajety[0].getMinimumobrazen();

        }
    }

    public int zasieg_broni_dystans(){
        if(slotnaprawejrecezajety[0] == null){
            return 1;
        }
        else{
            return slotnaprawejrecezajety[0].getZasiegdystans();
        }
    }

    public boolean czy_zalozona_bron_prawo(){
        if(slotnaprawejrecezajety[0] == null){
            return false;
        }
        else{
            return true;
        }
    }
    public int podaj_bonus_trafienia(){
        if(slotnaprawejrecezajety[0] == null){
            return 0;
        }
        else{
            return slotnaprawejrecezajety[0].getSzansatrafienia();
        }

    }
    public boolean czy_istnieje_o_id(int id)
        {
            for(int i=0;i<items.size();i++){
                if(items.get(i).getIdprzedmiotu()==id){
                    return true;
                }
            }
                return false;
        }
    public void dodajprzedmiot(Item item){
        items.add(item);
        System.out.println("Podniosles "+item.getNazwawek()+".");
    }

    public int ileprzedmiotowweq(){
        return items.size();
    }
    public void wyswietlekwipunek(){
        int ile = items.size();
        int licznik = 0;

        System.out.println("---------------------------------------------------------");
        System.out.println("Twoj wyekwipowane przedmioty to: ");
        if(slotnaglowiezajety[0] != null) System.out.println("Glowa: " + slotnaglowiezajety[0].getNazwawek() + " Wartosc ochrony: " +slotnaglowiezajety[0].getWartoscpancerza() + ", Dodatkowe maksymalne HP: +" +slotnaglowiezajety[0].getHpzpancerzy());
        else System.out.println("Glowa: brak");
        if(slotnatulowiuzajety[0] != null) System.out.println("Tors: " + slotnatulowiuzajety[0].getNazwawek() + " Wartosc ochrony: " +slotnatulowiuzajety[0].getWartoscpancerza()+ ", Dodatkowe maksymalne HP: +" +slotnatulowiuzajety[0].getHpzpancerzy());
        else System.out.println("Tors: brak");
        if(slotnarecezajety[0] != null) System.out.println("Rece: " + slotnarecezajety[0].getNazwawek() + " Wartosc ochrony: " +slotnarecezajety[0].getWartoscpancerza()+ ", Dodatkowe maksymalne HP: +" +slotnarecezajety[0].getHpzpancerzy());
        else System.out.println("Rece: brak");
        if(slotnanogizajety[0] != null) System.out.println("Buty: " + slotnanogizajety[0].getNazwawek() + " Wartosc ochrony: " +slotnanogizajety[0].getWartoscpancerza()+ ", Dodatkowe maksymalne HP: +" +slotnanogizajety[0].getHpzpancerzy());
        else System.out.println("Buty: brak");
        if(slotnaprawejrecezajety[0] != null){
            if(slotnaprawejrecezajety[0].isCzytobronjednoreczna()) {
                System.out.println("Bron: " + slotnaprawejrecezajety[0].getNazwawek() + " Rodzaj: Bron jednoręczna Obrazenia wręcz: od " +slotnaprawejrecezajety[0].getMinimumobrazen()+ " do " + slotnaprawejrecezajety[0].getObrazenawrecz()+", Zasieg ataku wrecz: " + items.get(licznik).getZasiegwrecz());
            }
            else if(slotnaprawejrecezajety[0].isCzytobrondystansowa())
            {
                System.out.println("Bron: " + slotnaprawejrecezajety[0].getNazwawek() + " Rodzaj: Bron dystansowa Obrazenia dystansowe: od " +slotnaprawejrecezajety[0].getMinimumobrazen()+ " do " + slotnaprawejrecezajety[0].getObrazenadystans()+", Zasieg ataku dystansowego: " + items.get(licznik).getZasiegdystans());
            }
        }
        else System.out.println("Bron: brak");
        if(slotnalewejrecezajety[0] != null){
            System.out.println("Tarcza: " + slotnalewejrecezajety[0].getNazwawek() + " Rodzaj: Tarcza Dodatkowy pancerz: " +slotnalewejrecezajety[0].getWartoscpancerza()+ ", Dodatkowe maksymalne HP: +" +slotnalewejrecezajety[0].getHpzpancerzy());
        }
        else System.out.println("Tarcza: brak");
        System.out.println("");
        System.out.println("W ekwipunku posiadasz nastepujace przedmioty: ");
        System.out.println("---------------------------------------------------------");
        if(ile == 0) System.out.println("Brak przedmiotow.");
        while(licznik < ile){
            System.out.println(licznik + 1 +". " +items.get(licznik).getNazwawek() +": " + items.get(licznik).getOpiswek() + " Wartosc: " + items.get(licznik).getWartosc() +" sztuk zlota.");
            if(items.get(licznik).isCzynaglowe()) System.out.println("Rodzaj: Helm, Wartosc pancerza na glowe: " + items.get(licznik).getWartoscpancerza()+ ", Dodatkowe maksymalne HP: +" +items.get(licznik).getHpzpancerzy());
            if(items.get(licznik).isCzynatulw()) System.out.println("Rodzaj: Pancerz, Wartosc pancerza na tulowie: " + items.get(licznik).getWartoscpancerza()+ ", Dodatkowe maksymalne HP: +" +items.get(licznik).getHpzpancerzy());
            if(items.get(licznik).isCzynarece()) System.out.println("Rodzaj: Rekawice, Wartosc pancerza na rekach: " + items.get(licznik).getWartoscpancerza()+ ", Dodatkowe maksymalne HP: +" +items.get(licznik).getHpzpancerzy());
            if(items.get(licznik).isCzynanogi()) System.out.println("Rodzaj: Buty, Wartosc pancerza na nogach: " + items.get(licznik).getWartoscpancerza()+ ", Dodatkowe maksymalne HP: +" +items.get(licznik).getHpzpancerzy());
            if(items.get(licznik).isCzydoprawadlon())
            {
                if(items.get(licznik).isCzytobronjednoreczna())
                {
                    System.out.println("Rodzaj: Bron jednoreczna, Wartosc obrazen wrecz: od " + items.get(licznik).getMinimumobrazen() +" do " + items.get(licznik).getObrazenawrecz() + ", Zasieg ataku wrecz: " + items.get(licznik).getZasiegwrecz() + ", Szansa trafienia: +" + items.get(licznik).getSzansatrafienia());
                }
                else System.out.println("Rodzaj: Bron dystansowa, Wartosc obrazen dystansowych: od " + items.get(licznik).getMinimumobrazen() +" do " + + items.get(licznik).getObrazenadystans() + ", Zasieg ataku dystansowego: " + items.get(licznik).getZasiegdystans()  + ", Szansa trafienia: +" + items.get(licznik).getSzansatrafienia());
            }
            if(items.get(licznik).isCzydolewadlon()) System.out.println("Rodzaj: Tarcza, Wartosc bonusowego pancerza: " + items.get(licznik).getWartoscpancerza()+ ", Dodatkowe maksymalne HP: +" +items.get(licznik).getHpzpancerzy());
            licznik++;
        }
        System.out.println("");
        System.out.println("Posiadasz " + pieniadze + " sztuk zlota");
        System.out.println("---------------------------------------------------------");
    }

    public void zalozprzedmiot(int x, Player gracz)
    {
        int ile = x-1;
        if(ile+1>items.size()){
            System.out.println("Taki przedmiot nie istnieje");
        }
        else {
            if (items.get(ile).isCzynaglowe()) {
                gracz.resetg();
                slotnaglowiezajety[0] = items.get(ile);
                gracz.addtopanglow(items.get(ile).getWartoscpancerza());
                gracz.setMaxhp(gracz.getMaxhp() + items.get(ile).getHpzpancerzy());
                System.out.println("Zalozono przedmiot " + items.get(ile).getNazwawek());
            } else if (items.get(ile).isCzynatulw()) {
                gracz.resett();
                slotnatulowiuzajety[0] = items.get(ile);
                gracz.addtopantulw(items.get(ile).getWartoscpancerza());
                gracz.setMaxhp(gracz.getMaxhp() + items.get(ile).getHpzpancerzy());
                System.out.println("Zalozono przedmiot " + items.get(ile).getNazwawek());
            } else if (items.get(ile).isCzynarece()) {
                gracz.resetr();
                slotnarecezajety[0] = items.get(ile);
                gracz.addtopanrec(items.get(ile).getWartoscpancerza());
                gracz.setMaxhp(gracz.getMaxhp() + items.get(ile).getHpzpancerzy());
                System.out.println("Zalozono przedmiot " + items.get(ile).getNazwawek());
            } else if (items.get(ile).isCzynanogi()) {
                gracz.resetn();
                slotnanogizajety[0] = items.get(ile);
                gracz.addtopannog(items.get(ile).getWartoscpancerza());
                gracz.setMaxhp(gracz.getMaxhp() + items.get(ile).getHpzpancerzy());
                System.out.println("Zalozono przedmiot " + items.get(ile).getNazwawek());
            } else if (items.get(ile).isCzydoprawadlon()) {
                gracz.resetwr();
                gracz.resetdys();
                slotnaprawejrecezajety[0] = items.get(ile);
                if (items.get(ile).isCzytobronjednoreczna()) gracz.addobrwr(items.get(ile).getObrazenawrecz());
                else if (items.get(ile).isCzytobrondystansowa()) gracz.addobrd(items.get(ile).getObrazenadystans());
                System.out.println("Zalozono przedmiot " + items.get(ile).getNazwawek());
            } else if (items.get(ile).isCzydolewadlon()) {
                gracz.resettar();
                slotnalewejrecezajety[0] = items.get(ile);
                gracz.addtotarcza(items.get(ile).getWartoscpancerza());
                gracz.setMaxhp(gracz.getMaxhp() + items.get(ile).getHpzpancerzy());
                System.out.println("Zalozono przedmiot " + items.get(ile).getNazwawek());

            } else {
                System.out.println("Nie mozna zalozyc tego przedmiotu.");
            }
        }
    }

    public void zdejmijprzedmiot(int x, Player gracz)
    {
        int ile = x-1;
        if(ile+1>items.size()){
            System.out.println("Taki przedmiot nie istnieje");
        }
        else {
            if(items.get(ile).isCzynaglowe())
            {
                gracz.resetg();
                gracz.setMaxhp(gracz.getMaxhp() - items.get(ile).getHpzpancerzy());
                slotnaglowiezajety[0] = null;
                System.out.println("Zdjeto przedmiot " + items.get(ile).getNazwawek());
            }
            else if(items.get(ile).isCzynatulw())
            {
                gracz.resett();
                gracz.setMaxhp(gracz.getMaxhp() - items.get(ile).getHpzpancerzy());
                slotnatulowiuzajety[0] = null;
                System.out.println("Zdjeto przedmiot " + items.get(ile).getNazwawek());
            }
            else if(items.get(ile).isCzynarece())
            {
                gracz.resetr();
                gracz.setMaxhp(gracz.getMaxhp() - items.get(ile).getHpzpancerzy());
                slotnarecezajety[0] = null;
                System.out.println("Zdjeto przedmiot " + items.get(ile).getNazwawek());
            }
            else if(items.get(ile).isCzynanogi())
            {
                gracz.resetn();
                gracz.setMaxhp(gracz.getMaxhp() - items.get(ile).getHpzpancerzy());
                slotnanogizajety[0] = null;
                System.out.println("Zdjeto przedmiot " + items.get(ile).getNazwawek());
            }
            else if(items.get(ile).isCzydoprawadlon())
            {
                gracz.resettar();
                gracz.setMaxhp(gracz.getMaxhp() - items.get(ile).getHpzpancerzy());
                slotnaprawejrecezajety[0] = null;
                System.out.println("Zdjeto przedmiot " + items.get(ile).getNazwawek());
            }
            else if(items.get(ile).isCzydolewadlon())
            {
                gracz.resetwr();
                gracz.resetdys();
                slotnalewejrecezajety[0] = null;
                System.out.println("Zdjeto przedmiot" + items.get(ile).getNazwawek());
            }
            else {
                System.out.println("Nie mozna zdjac tego przedmiotu.");
            }
        }
    }

    public void sprzedajprzedmiot(Player player, ArrayList<Item> itemki){
        wyswietlekwipunek();
        boolean kupno = true;
        while(kupno){
            System.out.println("Ktory przedmiot chcesz sprzedac? (podaj numer przedmiotu, wpisz 0 aby wyjsc)");
            Scanner scanner7 = new Scanner(System.in);
            String x7;
            x7 = scanner7.nextLine();
            int item = Integer.parseInt(x7) - 1;

            if(item+1 == 0){
                kupno = false;
                break;
            }
            else if(item>items.size()) System.out.println("Nie ma takiego przedmiotu");
            else
            {
                if(items.get(item) == slotnaglowiezajety[0]){
                    System.out.println("Nie mozna sprzedac tego przedmiotu. Jest on zalozony.");
                    kupno = false;
                    break;
                }
                else if (items.get(item) == slotnatulowiuzajety[0]){
                    System.out.println("Nie mozna sprzedac tego przedmiotu. Jest on zalozony.");
                    kupno = false;
                    break;
                }
                else if(items.get(item) == slotnanogizajety[0]){
                    System.out.println("Nie mozna sprzedac tego przedmiotu. Jest on zalozony.");
                    kupno = false;
                    break;
                }
                else if(items.get(item) == slotnarecezajety[0])
                {
                    System.out.println("Nie mozna sprzedac tego przedmiotu. Jest on zalozony.");
                    kupno = false;
                    break;
                }
                else if(items.get(item) == slotnalewejrecezajety[0]){
                    System.out.println("Nie mozna sprzedac tego przedmiotu. Jest on zalozony.");
                    kupno = false;
                    break;
                }
                else if(items.get(item) == slotnaprawejrecezajety[0]){
                    System.out.println("Nie mozna sprzedac tego przedmiotu. Jest on zalozony.");
                    kupno = false;
                    break;
                }
                else
                    {
                        float mnoznikinteligencji  = 1 + 0.05f * player.getInteligencja();
                        int wartosc = Math.round(items.get(item).getWartosc() * mnoznikinteligencji);
                        System.out.println("Udalo ci sie utargowac cene i sprzedac " +items.get(item).getNazwawek() +" za " + wartosc + " sztuk zlota.");
                        setPieniadze(getPieniadze() + wartosc);
                        itemki.add(items.get(item));
                        items.remove(item);
                        kupno = false;
                    }
                }
            }
        }

        public void uzyjprzedmiot(int liczba, Player player)
        {
            ArrayList<Integer> przedmiotyleczaceza2 = new ArrayList<Integer>();
            przedmiotyleczaceza2.add(61);
            ArrayList<Integer> przedmiotyleczacezafull = new ArrayList<Integer>();
            przedmiotyleczacezafull.add(62);

            int ile = liczba-1;
            int i = 0;
            boolean czyuzyto = false;
            if(ile >= items.size())
            {
                System.out.println("Nie ma takiego przedmiotu.");
                czyuzyto = true;
            }
            else{
                while(i < przedmiotyleczaceza2.size())
                {
                    if(przedmiotyleczaceza2.get(i) == items.get(ile).getIdprzedmiotu()){
                        if(player.getMaxhp() == player.getHealthPoints()) {
                            System.out.println("Nie mozesz zjesc " + items.get(ile).getNazwawek() + " bo masz maksymalne punkty zycia");
                            czyuzyto = true;
                        }
                        else if(player.getHealthPoints() == player.getMaxhp()-1){
                            player.setHealthPoints(player.getMaxhp());
                            System.out.println("Zjadles kabanosa. Zyskales 1 HP");
                            items.remove(ile);
                            czyuzyto = true;
                            break;
                        }
                        else{
                            player.setHealthPoints(player.getHealthPoints() + 2);
                            System.out.println("Zjadles kabanosa. Zyskales 2 HP.");
                            items.remove(ile);
                            czyuzyto = true;
                            break;
                        }
                    }
                    i++;
                }


                if(czyuzyto==false){
                    i = 0;
                    while (i < przedmiotyleczacezafull.size()) {
                        if (przedmiotyleczacezafull.get(i) == items.get(ile).getIdprzedmiotu()) {
                            if (player.getMaxhp() == player.getHealthPoints()) {
                                System.out.println("Nie mozesz wypic " + items.get(ile).getNazwawek() + " bo masz maksymalne punkty zycia");
                                czyuzyto = true;
                            } else {
                                player.setHealthPoints(player.getMaxhp());
                                System.out.println("Wypiles miksturke. Wyleczyles sie calkowicie");
                                items.remove(ile);
                                czyuzyto = true;
                                break;
                            }
                        }
                        i++;
                    }
                }

            }
            if(czyuzyto == false) System.out.println("Ten przedmiot nie moze byc uzyty.");
        }
  }
