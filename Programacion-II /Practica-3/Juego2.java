package juedo;

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


package juedo;
import java.util.Scanner;
public class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;
    public JuegoAdivinaNumero(int vidas) {
        super(vidas);}
    public boolean validaNumero(int n) {
        return n >= 0 && n <= 10;}
    public void juega() {
        reiniciaPartida();
        numeroAAdivinar = (int)(Math.random() * 11);
        Scanner sc = new Scanner(System.in);
        System.out.println("adivina un numero entre 0 y 10");
        while (true) {
            System.out.print("ingresa tu numero: ");
            int intento = sc.nextInt();

            if (!validaNumero(intento)) {
                System.out.println("numero invalido, debe estar entre 0 y 10");
                continue;
            }
            if (intento == numeroAAdivinar) {
                System.out.println("acertaste!!");
                actualizaRecord();
                break;
            } else {
                if (!quitaVida()) {
                    System.out.println("perdiste, el numero era: " + numeroAAdivinar);
                    break;
                } else {
                    if (intento < numeroAAdivinar) {
                        System.out.println("el numero a adivinar es mayor");
                    } else {
                        System.out.println("el numero a adivinar es menor");
                    }
                }
            }
        }
    }
}


package juedo;
import java.util.Scanner;
public class JuegoAdivinaImpar extends JuegoAdivinaNumero {
    public JuegoAdivinaImpar(int vidas) {
        super(vidas);}
    public boolean validaNumero(int n) {
        if (n < 0 || n > 10) return false;
        if (n % 2 != 0) return true;
        System.out.println("error: el numero debe ser impar");
        return false; }
    public void juega() {
        reiniciaPartida();
        do {
            numeroAAdivinar = (int) (Math.random() * 11);
        } while (numeroAAdivinar % 2 == 0);
        Scanner sc = new Scanner(System.in);
        System.out.println("adivina un numero impar entre 0 y 10");
        while (true) {
            System.out.print("ingresa tu numero: ");
            int intento = sc.nextInt();
            if (!validaNumero(intento)) continue; // si no es impar, vuelve a pedir
            if (intento == numeroAAdivinar) {
                System.out.println("acertaste!!");
                actualizaRecord();
                break;
            } else {
                if (!quitaVida()) {
                    System.out.println("perdiste, el numero era: " + numeroAAdivinar);
                    break;}
                System.out.println(intento < numeroAAdivinar ? "el numero a adivinar es mayor" : "el numero a adivinar es menor");
            }
        }
    }
}



package juedo;
import java.util.Scanner;
public class JuegoAdivinaPar extends JuegoAdivinaNumero {
    public JuegoAdivinaPar(int vidas) {
        super(vidas);
    }
    public boolean validaNumero(int n) {
        if (n < 0 || n > 10) return false;
        if (n % 2 == 0) return true;
        System.out.println("error: el numero debe ser par");
        return false;
    }
    public void juega() {
        reiniciaPartida();
        do {
            numeroAAdivinar = (int) (Math.random() * 11);
        } while (numeroAAdivinar % 2 != 0);
        Scanner sc = new Scanner(System.in);
        System.out.println("adivina un numero par entre 0 y 10");
        while (true) {
            System.out.print("ingresa tu numero: ");
            int intento = sc.nextInt();
            if (!validaNumero(intento)) continue; // si no es par, vuelve a pedir
            if (intento == numeroAAdivinar) {
                System.out.println("acertaste!!");
                actualizaRecord();
                break;
            } else {
                if (!quitaVida()) {
                    System.out.println("perdiste, el numero era: " + numeroAAdivinar);
                    break;}
                System.out.println(intento < numeroAAdivinar ? "el numero a adivinar es mayor" : "el numero a adivinar es menor");
            }
        }
    }
}


package juedo;

public class Aplicacion {
    public static void main(String[] args) {
        Juego j1 = new JuegoAdivinaNumero(3);
        Juego j2 = new JuegoAdivinaPar(3);
        Juego j3 = new JuegoAdivinaImpar(3);

        System.out.println("=== JUEGO NORMAL ===");
        j1.juega();

        System.out.println("\n=== JUEGO PAR ===");
        j2.juega();

        System.out.println("\n=== JUEGO IMPAR ===");
        j3.juega();
    }
}
