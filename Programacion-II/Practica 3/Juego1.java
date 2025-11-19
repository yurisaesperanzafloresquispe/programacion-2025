package juego ;
public abstract class Juego {
    protected int numeroDeVidas;
    protected int record;

    public Juego(int vidas) {
        this.numeroDeVidas = vidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        System.out.println("reiniciando partida...");
    }

    public void actualizaRecord() {
        record++;
        System.out.println("nuevo record = " + record);
    }

    public boolean quitaVida() {
        numeroDeVidas--;
        if (numeroDeVidas > 0) {
            System.out.println("te quedan " + numeroDeVidas + " vidas");
            return true;
        } else {
            System.out.println("ya no tienes vidas");
            return false;
        }
    }
    public abstract void juega();
}

package juego;
import java.util.Scanner;
public class JuegoAdivinaNumero extends Juego {
    private int numeroAAdivinar;
    public JuegoAdivinaNumero(int vidas) {
        super(vidas);  }
    public void juega() {
        reiniciaPartida();
        numeroAAdivinar = (int)(Math.random() * 11); // 0-10
        Scanner sc = new Scanner(System.in);
        System.out.println("adivina un numero entre 0 y 10");
        while (true) {
            System.out.print("tu numero: ");
            int intento = sc.nextInt();
            if (intento == numeroAAdivinar) {
                System.out.println("acertaste!!");
                actualizaRecord();
                break;
            } else {
                if (!quitaVida()) {
                    System.out.println("perdiste, el numero era " + numeroAAdivinar);
                    break;
                } else {
                    if (intento < numeroAAdivinar) {
                        System.out.println("el numero es mayor");
                    } else {
                        System.out.println("el numero es menor"); } } } } }
    public String toString() {
        return "JuegoAdivinaNumero [vidas=" + numeroDeVidas + ", record=" + record + "]";
    }
}


package juego;
public class Aplicacion {
    public static void main(String[] args) {
        JuegoAdivinaNumero j = new JuegoAdivinaNumero(3); 
        j.juega();
    }
}
