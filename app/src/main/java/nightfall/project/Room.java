package nightfall.project;

public class Room {
        private int roomID;
        private String roomDescription;
        private boolean drogapolnoc;
        private boolean drogapoludnie;
        private boolean drogawschod;
        private boolean drogazachod;
        private boolean wczesniejwczytany;
        private boolean czypokojtowalka;
        private boolean czypokojtohandlarz;
        private boolean czypokojmadialog;
        private boolean czypokojtoportal;
        private int portalx;
        private int portaly;
        private String nazwapotworawpokoju;

        public Room() {  }

        public void setRoomID(int roomID) {this.roomID = roomID; }
        public void setRoomDescription(String roomDescriptionParam){
            roomDescription=roomDescriptionParam;
        }
        public String getRoomDescription(){
            return roomDescription;
        }
        public int getRoomID() {return roomID; }

        public boolean isDrogapolnoc() { return drogapolnoc; }
        public void setDrogapolnoc(boolean drogapolnoc) { this.drogapolnoc = drogapolnoc; }
        public boolean isDrogapoludnie() { return drogapoludnie; }
        public void setDrogapoludnie(boolean drogapoludnie) { this.drogapoludnie = drogapoludnie; }
        public boolean isDrogawschod() { return drogawschod; }
        public void setDrogawschod(boolean drogawschod) { this.drogawschod = drogawschod; }
        public boolean isDrogazachod() { return drogazachod; }
        public void setDrogazachod(boolean drogazachod) { this.drogazachod = drogazachod; }
        public boolean isWczesniejwczytany() { return wczesniejwczytany; }
        public void setWczesniejwczytany(boolean wczesniejwczytany) { this.wczesniejwczytany = wczesniejwczytany; }

    public boolean isCzypokojtoportal() {
        return czypokojtoportal;
    }

    public void setCzypokojtoportal(boolean czypokojtoportal) {
        this.czypokojtoportal = czypokojtoportal;
    }

    public int getPortalx() {
        return portalx;
    }

    public void setPortalx(int portalx) {
        this.portalx = portalx;
    }

    public int getPortaly() {
        return portaly;
    }

    public void setPortaly(int portaly) {
        this.portaly = portaly;
    }

    public boolean isCzypokojtowalka() {
        return czypokojtowalka;
    }

    public void setCzypokojtowalka(boolean czypokojtowalka) {
        this.czypokojtowalka = czypokojtowalka;
    }

    public boolean isCzypokojtohandlarz() {
        return czypokojtohandlarz;
    }

    public void setCzypokojtohandlarz(boolean czypokojtohandlarz) {
        this.czypokojtohandlarz = czypokojtohandlarz;
    }

    public boolean isCzypokojmadialog() {
        return czypokojmadialog;
    }

    public void setCzypokojmadialog(boolean czypokojmadialog) {
        this.czypokojmadialog = czypokojmadialog;
    }

    public String getNazwapotworawpokoju() {
        return nazwapotworawpokoju;
    }

    public void setNazwapotworawpokoju(String nazwapotworawpokoju) {
        this.nazwapotworawpokoju = nazwapotworawpokoju;
    }

    public void inicjalizacjapokoju() {
            System.out.print(this.roomDescription);
        }

        public void pokazdostepnekierunki() {
            System.out.println("");
            System.out.print("Dostepne kierunki ruchu: ");
            if(isDrogapolnoc() == true) System.out.print("polnoc ");
            if(isDrogapoludnie() == true) System.out.print("poludnie ");
            if(isDrogawschod() == true) System.out.print("wschod ");
            if(isDrogazachod() == true) System.out.print("zachod ");

            if(isDrogapolnoc() == false && isDrogapoludnie() == false && isDrogawschod() == false && isDrogazachod() == false)
            {
                    System.out.print("brak");
            }

        }
}
