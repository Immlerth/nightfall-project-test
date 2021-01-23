package nightfall.project;

public class Item {
    private String nazwa;
    private int wartosc;
    private String opis;
    private String opiswek;
    private int idprzedmiotu;
    private String nazwawek;
    private boolean czynaglowe;
    private boolean czynarece;
    private boolean czynatulw;
    private boolean czynanogi;
    private boolean czydoprawadlon;
    private boolean czydolewadlon;
    private boolean czytobronjednoreczna;
    private boolean czytobrondystansowa;
    private boolean czytobrondwureczna;
    private int wartoscpancerza;
    private int minimumobrazen;
    private int szansatrafienia;
    private int hpzpancerzy;
    private int obrazenawrecz;
    private int obrazenadystans;
    private int zasiegdystans;
    private int zasiegwrecz;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public int getMinimumobrazen() { return minimumobrazen; }

    public void setMinimumobrazen(int minimumobrazen) { this.minimumobrazen = minimumobrazen; }

    public int getSzansatrafienia() { return szansatrafienia; }

    public void setSzansatrafienia(int szansatrafienia) { this.szansatrafienia = szansatrafienia; }

    public int getHpzpancerzy() { return hpzpancerzy; }

    public void setHpzpancerzy(int hpzpancerzy) { this.hpzpancerzy = hpzpancerzy; }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isCzynarece() {
        return czynarece;
    }

    public void setCzynarece(boolean czynarece) {
        this.czynarece = czynarece;
    }

    public boolean isCzytobronjednoreczna() {
        return czytobronjednoreczna;
    }

    public void setCzytobronjednoreczna(boolean czytobronjednoreczna) {
        this.czytobronjednoreczna = czytobronjednoreczna;
    }

    public boolean isCzytobrondystansowa() {
        return czytobrondystansowa;
    }

    public void setCzytobrondystansowa(boolean czytobrondystansowa) {
        this.czytobrondystansowa = czytobrondystansowa;
    }

    public boolean isCzytobrondwureczna() {
        return czytobrondwureczna;
    }

    public void setCzytobrondwureczna(boolean czytobrondwureczna) {
        this.czytobrondwureczna = czytobrondwureczna;
    }

    public int getIdprzedmiotu() {
        return idprzedmiotu;
    }

    public int getWartoscpancerza() {
        return wartoscpancerza;
    }

    public String getNazwawek() {
        return nazwawek;
    }

    public void setNazwawek(String nazwawek) {
        this.nazwawek = nazwawek;
    }

    public void setWartoscpancerza(int wartoscpancerza) {
        this.wartoscpancerza = wartoscpancerza;
    }

    public void setIdprzedmiotu(int idprzedmiotu) {
        this.idprzedmiotu = idprzedmiotu;
    }

    public boolean isCzynatulw() {
        return czynatulw;
    }

    public void setCzynatulw(boolean czynatulw) {
        this.czynatulw = czynatulw;
    }

    public boolean isCzynaglowe() {
        return czynaglowe;
    }

    public void setCzynaglowe(boolean czynaglowe) {
        this.czynaglowe = czynaglowe;
    }

    public boolean isCzynanogi() {
        return czynanogi;
    }

    public void setCzynanogi(boolean czynanogi) {
        this.czynanogi = czynanogi;
    }

    public boolean isCzydoprawadlon() {
        return czydoprawadlon;
    }

    public void setCzydoprawadlon(boolean czydoprawadlon) {
        this.czydoprawadlon = czydoprawadlon;
    }

    public boolean isCzydolewadlon() {
        return czydolewadlon;
    }

    public void setCzydolewadlon(boolean czydolewadlon) {
        this.czydolewadlon = czydolewadlon;
    }

    public String getOpiswek() {
        return opiswek;
    }

    public void setOpiswek(String opiswek) {
        this.opiswek = opiswek;
    }

    public int getObrazenawrecz() {
        return obrazenawrecz;
    }

    public void setObrazenawrecz(int obrazenawrecz) {
        this.obrazenawrecz = obrazenawrecz;
    }

    public int getObrazenadystans() {
        return obrazenadystans;
    }

    public void setObrazenadystans(int obrazenadystans) {
        this.obrazenadystans = obrazenadystans;
    }

    public int getZasiegdystans() { return zasiegdystans; }

    public void setZasiegdystans(int zasiegdystans) { this.zasiegdystans = zasiegdystans; }

    public int getZasiegwrecz() { return zasiegwrecz; }

    public void setZasiegwrecz(int zasiegwrecz) { this.zasiegwrecz = zasiegwrecz; }
}
