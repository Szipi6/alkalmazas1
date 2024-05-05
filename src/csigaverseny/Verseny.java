
package csigaverseny;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author kocsis.szabina
 */

   public class Verseny {
    private Csiga[] csigak;
    private String[] szinek = {"piros", "zold", "kek"};
    private Random rand = new Random();
    private int fogadasIndex;

   
    public Verseny() {
        csigak = new Csiga[3];
        for (int i = 0; i < 3; i++) {
            csigak[i] = new Csiga(szinek[i]);
        }
        fogadasIndex = -1;
    }

   
    public void verseny() {
        int[] elozoKor = new int[3];
        for (int i = 0; i < 5; i++) {
            kör(elozoKor);
            körAllasMegjelenites(i + 1);
        }

        int nyertesIndex = nyer();
        System.out.println("A " + csigak[nyertesIndex].getSzin() + " csiga nyert!");
        if (fogadasIndex != -1 && fogadasIndex == nyertesIndex) {
            System.out.println("Gratulalunk! Nyertel!");
        } else if (fogadasIndex != -1) {
            System.out.println("Sajnos nem nyertel.");
        }
    }

    private void kör(int[] elozoKor) {
        for (int i = 0; i < 3; i++) {
            int lepes = rand.nextInt(4);
            csigak[i].hozzaad(lepes + elozoKor[i]);
            
        }
    }

    private int nyer() {
        int nyertesIndex = 0;
        int maxMessze = csigak[0].messze();
        for (int i = 1; i < 3; i++) {
            if (csigak[i].messze() > maxMessze) {
                maxMessze = csigak[i].messze();
                nyertesIndex = i;
            }
        }
        return nyertesIndex;
    }

    public void fogad(char betu) {
        switch (Character.toUpperCase(betu)) {
            case 'P':
                fogadasIndex = 0;
                break;
            case 'Z':
                fogadasIndex = 1;
                break;
            case 'K':
                fogadasIndex = 2;
                break;
            default:
                fogadasIndex = -1;
                System.out.println("ervenytelen fogadas!");
        }
        if (fogadasIndex != -1) {
            System.out.println("Fogadasod rogzitve a " + csigak[fogadasIndex].getSzin() + " csigara!");
        }
    }

    private void körAllasMegjelenites(int kor) {
        System.out.println("\nKor " + kor + " allasa:");
        for (int i = 0; i < 3; i++) {
            System.out.println(csigak[i].getSzin() + " csiga allapota: " + csigak[i].messze());
        }
    }

    public static void main(String[] args) {
        Verseny jatek = new Verseny();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Fogadj egy csigara! (P - piros, Z - zold, K - kek)");
        char fogadasBetu = scanner.nextLine().charAt(0);
        jatek.fogad(fogadasBetu);
        jatek.verseny();
        scanner.close();
    }
}
