import java.util.Scanner;

public class Conecta4 {
    private static char[][] tablero = new char[6][15];    //filas-columnas
    private static final char[] jugador = {'A', 'B'}; // A= jugador 1  B = jugador 2

    public static void juego() {
        Scanner sc = new Scanner(System.in);
        int opcion = opcionesMenu(sc);
        switch (opcion) {
            case 1:
                System.out.println("Tablero vacio:");
                crearTablero(tablero);
                imprimirTablero(tablero);
                break;
            case 2:
                cronometro();

                break;
            default:
                break;
        }
    }

    public static int opcionesMenu(Scanner sc) {
        System.out.print("Juego Conecta4:\n" +
                "[1]- Jugar con un amigo\n" +
                "[2]- Jugar contra la maquina\n" +
                "Elige una opcion: ");
        return sc.nextInt();
    }

    public static void crearTablero(char[][] tablero) {
        for (int filas = 0; filas < tablero.length; filas++) {
            for (int columnas = 0; columnas < tablero[filas].length; columnas++) {
                if (columnas % 2 == 0) {
                    tablero[filas][columnas] = '|';
                } else {
                    tablero[filas][columnas] = ' ';
                }
            }
        }
    }

    public static void imprimirTablero(char[][] tablero) {
        for (char[] f : tablero) {
            for (char c : f) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void visualizarTablero() {

    }


    //crear un cronometro que se mostrara cada vez que muestra el tablero,
    // mostrando el tiempo que transcurre en la partida
    public static void cronometro() {
        Scanner sc = new Scanner(System.in);
        long inicio,fin;
        double tiempoTotal;
        //si ejecuto la opcion 1 del menu, el cronometro empieza a ejecutarse.
        System.out.println("escribe un caracter para empezar el cronometro:");
        char comienzaTiempo = sc.next().charAt(0);
        inicio = System.currentTimeMillis();
        System.out.println("escribe un caracter para finalizar el cronometro:");
        char terminaTiempo = sc.next().charAt(0);
        fin = System.currentTimeMillis();
        tiempoTotal = (fin - inicio) / 1000.0;
        System.out.println(tiempoTotal);
    }

    public static boolean ComprobarFichasEnHorizontal(char[][] tablero, char jugador) {
        return true;
    }

    public static boolean ComprobarFichasEnVertical(char[][] tablero, char jugador) {
        return true;
    }

    public static boolean ComprobarFichasEnDiagonal(char[][] tablero, char jugador) {
        return true;
    }

}
