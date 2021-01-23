package nightfall.project;

import java.awt.*;
import java.util.Scanner;

public class Player {
    private String playerName;

    private int sila;
    private int zrecznosc;
    private int inteligencja;
    private int kondycja;
    private int szybkosc;

    private int pancerzsuma;
    private int pancerzglowa;
    private int pancerztulw;
    private int pancerzrece;
    private int pancerznogi;
    private int obrazeniawrecz;
    private int obrazeniadystans;
    private int tarcza;
    private int maxhp;

    private int healthPoints;

    private Point position;

    public Player() {
        this.position = new Point(50,50);
        this.healthPoints = 0;
        this.sila = 1;
        this.pancerzsuma = 0;
        this.pancerzglowa = 0;
        this.pancerztulw = 0;
        this.pancerzrece = 0;
        this.tarcza = 0;
        this.pancerznogi = 0;
        this.zrecznosc = 1;
        this.inteligencja = 1;
        this.kondycja = 1;
        this.szybkosc = 0;
        this.obrazeniawrecz = 1;
        this.obrazeniadystans = 0;
    }

    public void setPlayerName(String playerNameParam)
    {
        playerName=playerNameParam;
    }
    public String getPlayerName(){
        return playerName;
    }

    public Point getPosition() {
        return position;
    }

    public void idzpolnoc() {this.position.y = this.position.y - 1; }
    public void idzpoludnie() { this.position.y = this.position.y + 1; }
    public void idzwschod() {
        this.position.x = this.position.x + 1;
    }
    public void idzzachod() {
        this.position.x = this.position.x-1;
    }
    public void teleportacja(int x, int y) {

        this.position.x = x;
        this.position.y = y;
    }

    public int getSila() { return sila; }
    public void setSila(int sila) { this.sila = sila; }
    public int getZrecznosc() { return zrecznosc; }
    public void setZrecznosc(int zrecznosc) { this.zrecznosc = zrecznosc; }
    public int getInteligencja() { return inteligencja; }
    public void setInteligencja(int inteligencja) {this.inteligencja = inteligencja; }
    public int getKondycja() { return kondycja; }
    public void setKondycja(int kondycja) { this.kondycja = kondycja; }
    public int getSzybkosc() { return szybkosc; }
    public void setSzybkosc(int szybkosc) { this.szybkosc = szybkosc; }
    public int getObrazeniawrecz() { return obrazeniawrecz; }
    public void setObrazeniawrecz(int obrazeniawrecz) { this.obrazeniawrecz = obrazeniawrecz; }
    public int getObrazeniadystans() { return obrazeniadystans; }
    public void setObrazeniadystans(int obrazeniadystans) { this.obrazeniadystans = obrazeniadystans; }
    public int getHealthPoints() { return healthPoints; }
    public void setHealthPoints(int healthPoints) { this.healthPoints = healthPoints; }

    public int getPancerzsuma() {
        return pancerzsuma;
    }

    public void setPancerzsuma(int pancerzsuma) {
        this.pancerzsuma = pancerzsuma;
    }

    public int getPancerzglowa() {
        return pancerzglowa;
    }

    public void setPancerzglowa(int pancerzglowa) {
        this.pancerzglowa = pancerzglowa;
    }

    public int getPancerztulw() {
        return pancerztulw;
    }

    public void setPancerztulw(int pancerztulw) {
        this.pancerztulw = pancerztulw;
    }

    public int getPancerzrece() {
        return pancerzrece;
    }

    public void setPancerzrece(int pancerzrece) {
        this.pancerzrece = pancerzrece;
    }

    public int getPancerznogi() {
        return pancerznogi;
    }

    public void setPancerznogi(int pancerznogi) {
        this.pancerznogi = pancerznogi;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getTarcza() {
        return tarcza;
    }

    public void setTarcza(int tarcza) {
        this.tarcza = tarcza;
    }
    public void addtotarcza(int x){
        this.tarcza = tarcza + x;
    }
    public void addtopanglow(int x){
        this.pancerzglowa = pancerzglowa + x;
    }
    public void addtopantulw(int x){
        this.pancerztulw = pancerztulw +x;
    }
    public void addtopanrec(int x){
        this.pancerzglowa = pancerzglowa +x;
    }
    public void addtopannog(int x) {
        this.pancerznogi = pancerznogi +x;
    }
    public void resetg(){
        this.pancerzglowa = 0;
    }
    public void resettar(){
        this.tarcza = 0;
    }
    public void resett(){
        this.pancerztulw = 0;
    }
    public void resetr(){
        this.pancerzglowa = 0;
    }
    public void resetn() {
        this.pancerznogi = 0;
    }

    public void addobrwr(int x) {
        this.obrazeniawrecz = obrazeniawrecz +x;
    }
    public void resetwr(){
        this.obrazeniawrecz = 1;
    }
    public void addobrd(int x) {
        this.obrazeniadystans = obrazeniadystans +x;
    }
    public void resetdys(){
        this.obrazeniadystans = 0;
    }

    public void sumujpancerz(int x) {
        pancerzsuma = pancerzglowa + pancerztulw + pancerznogi + pancerzrece;
    }
    public void resetstatystyk() {
        this.healthPoints = 1;
        this.sila = 1;
        this.zrecznosc = 1;
        this.inteligencja = 1;
        this.kondycja = 1;
        this.szybkosc = 0;
        this.obrazeniawrecz = 0;
        this.obrazeniadystans = 0;
    }

    public void tworzeniepostaci() {
        Scanner scanner6 = new Scanner(System.in);
        System.out.println("Podaj nazwe gracza: ");
        String name=scanner6.nextLine();
        setPlayerName(name);
        System.out.println("Witaj podrozniku w naszej grze. Wybrales juz imie, lecz aby na powaznie zaczac ta przygode, musisz stworzyc postac.");
        System.out.println("Wydaj punkty na statystyki: ");
        resetstatystyk();
        int pulapunktow = 8;
        do{
            System.out.println("Sila: " + sila);
            System.out.println("Zrecznosc: " + zrecznosc);
            System.out.println("Inteligencja: " + inteligencja);
            System.out.println("Kondycja: " + kondycja);
            System.out.println("");
            System.out.println("Dostepne punkty: " + pulapunktow);
            System.out.println("Na co chcesz wydac swoje punkty?");
            System.out.println("[1] Sila");
            System.out.println("[2] Zrecznosc");
            System.out.println("[3] Inteligencja");
            System.out.println("[4] Kondycja");
            Scanner scanner = new Scanner(System.in);
            String x;
            x = scanner.nextLine();
            switch(x){
                case "1":
                    pulapunktow--;
                    sila++;
                    break;
                case "2":
                    pulapunktow--;
                    zrecznosc++;
                    break;
                case "3":
                    pulapunktow--;
                    inteligencja++;
                    break;
                case "4":
                    pulapunktow--;
                    kondycja++;
                    break;
                default:
                    System.out.println("Brak dostepnej opcji");
            }
        }
        while(pulapunktow > 0);
        szybkosc = zrecznosc*3;
        obrazeniawrecz = 0;
        healthPoints= kondycja*3;
        maxhp = healthPoints;

        System.out.println("Twoje ostateczne statystyki to:");
        System.out.println("Sila " + sila);
        System.out.println("Zrecznosc " + zrecznosc);
        System.out.println("Inteligencja " + inteligencja);
        System.out.println("Kondycja " + kondycja);
        System.out.println("Szybkosc " + szybkosc);
        System.out.println("Punkty zycia: " + healthPoints);
        System.out.println("Podstawowe obrazenia wrecz " + sila);
        System.out.println("Podstawowe obrazenia na dystans " + obrazeniadystans);
        boolean decyzja = true;
        while(decyzja){
        System.out.println("Czy chcesz rozpocząc gre?");
        System.out.println("[1] tak, pora rozpoczac gre");
        System.out.println("[2] nie, chce stworzyc postac jeszcze raz");
        Scanner scanner = new Scanner(System.in);
        String x;
        x = scanner.nextLine();

            switch(x) {
                case "1":
                    decyzja = false;
                    break;
                case "2":
                    tworzeniepostaci();
                    decyzja = false;
                    break;
                default:
                    System.out.println("Niepoprawna opcja");
            }
        }
    }

    public void wyswietlstatystyki(Inventory inventor) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Nazywasz sie: " + playerName);
        System.out.println("Twoje aktualne statystyki to:");
        System.out.println("Sila " + sila);
        System.out.println("Zrecznosc " + zrecznosc);
        System.out.println("Inteligencja " + inteligencja);
        System.out.println("Kondycja " + kondycja);
        System.out.println("Szybkosc " + szybkosc);
        System.out.println("Punkty zycia: " + healthPoints);
        System.out.println("Podstawowe obrazenia wrecz: " + sila);
        System.out.println("Podstawowe obrazenia na dystans: " + zrecznosc );
        System.out.println("---------------------------------------------------------");
    }

}
