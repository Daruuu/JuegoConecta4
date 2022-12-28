import java.util.Arrays;
import java.util.Scanner;

public class Conecta4 {
    private static final char[][] tablero = new char[6][15];    //filas-columnas
    private static final char[] jugador = {'A', 'B'}; // A= jugador 1  B = jugador 2

    public static void juego(){
        Scanner sc = new Scanner(System.in);
    }


    public static char[][] CrearTablero() {
        for (int filas = 0; filas < tablero.length; filas++) {
            for (int columnas = 0; columnas < tablero[filas].length; columnas++) {
                if (columnas % 2 == 0) {
                    tablero[filas][columnas] = '|';
                } else {
                    tablero[filas][columnas] = ' ';
                }
            }
        }
        return tablero;
    }
//        for(char[] f : tablero){
//            for (char c: f){
//                System.out.print(c);
//            }
//            System.out.println();
//        }

    public static void imprimirTableroJuego(char[][] tablero){
        for(char[] f : tablero){
            for (char c: f){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void visualizarTablero() {

    }


    //crear un cronometro que se mostrara cada vez que muestra el tablero,
    // mostrando el tiempo que transcurre en la partida
    public static void cronometroPorPartida() {

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
