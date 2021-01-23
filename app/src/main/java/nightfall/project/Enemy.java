package nightfall.project;

public class Enemy extends Player {
    private String name;
    private String namedp;
    private int idpot;
    private String opisenc;
    private int stalydystansdaleko;
    private int stalydystanswrecz;
    private int ilegolda;
    private int szansanadystans;
    private int szansanawrecz;

    public int getSzansanadystans() {
        return szansanadystans;
    }

    public void setSzansanadystans(int szansanadystans) {
        this.szansanadystans = szansanadystans;
    }

    public int getSzansanawrecz() {
        return szansanawrecz;
    }

    public void setSzansanawrecz(int szansanawrecz) {
        this.szansanawrecz = szansanawrecz;
    }

    public int getIlegolda() {
        return ilegolda;
    }

    public void setIlegolda(int ilegolda) {
        this.ilegolda = ilegolda;
    }

    public int getStalydystansdaleko() {
        return stalydystansdaleko;
    }

    public void setStalydystansdaleko(int stalydystansdaleko) {
        this.stalydystansdaleko = stalydystansdaleko;
    }

    public int getStalydystanswrecz() {
        return stalydystanswrecz;
    }

    public void setStalydystanswrecz(int stalydystanswrecz) {
        this.stalydystanswrecz = stalydystanswrecz;
    }

    public String getOpisenc() {
        return opisenc;
    }

    public void setOpisenc(String opisenc) {
        this.opisenc = opisenc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamedp() {
        return namedp;
    }

    public void setNamedp(String namedp) {
        this.namedp = namedp;
    }

    public int getIdpot() {
        return idpot;
    }

    public void setIdpot(int idpot) {
        this.idpot = idpot;
    }
}
