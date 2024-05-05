
package csigaverseny;

/**
 *
 * @author kocsis.szabina
 */
class Csiga {
    private String szin;
    private int sebesseg;
    

    public Csiga(String szin) {
        this.szin = szin;
        this.sebesseg = 0;
    }

    public int messze() {
        return sebesseg;
    }

    public void hozzaad(int lepes) {
        sebesseg += lepes;
    }

    public String getSzin() {
        return szin;
    }

   
}