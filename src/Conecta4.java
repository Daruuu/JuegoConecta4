import java.util.Scanner;

public class Conecta4 {
    private static char[][] tablero = new char[6][15];    //filas-columnas
    private static final char[] jugador = {'X', 'O'}; // X= jugador 1  O= jugador 2

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
                comprobarFichasEnVertical(tablero, jugador[0]);

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
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (j % 2 == 0) {
                    tablero[i][j] = '|';
                } else {
                    tablero[i][j] = ' ';
                }
            }
        }
    }

    public static void visualizarTablero(char[][] tablero, int ficha) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (j % 2 == 0) {
                    tablero[i][j] = '|';
                } else {
                    tablero[i][j] = ' ';
                }
            }
        }
        imprimirTablero(tablero);
    }

    //0-1-2-3-4-5-6 --> columnas a elegir en el juego
    //1-3-5-7-9-11-13 --> columnas equivalentes en el TABLERO
    //iterar por cada fila
    public static void introducirFichaJugador1(char[][] tablero) {
        Scanner sc = new Scanner(System.in);
        System.out.print("elige una columna del 0 al 6: ");
        int ficha = 2 * sc.nextInt() + 1;
        // 0-5 = filas de cada columna en el TABLERO
        //iterar de la fila 5 a la fila 0
        for (int i = 5; i >= 0; i--) {
            if (tablero[i][ficha] == ' ') {
                tablero[i][ficha] = 'X';
                break;
            }
        }
    }

    public static void introducirFichaJugador2(char[][] tablero, Scanner sc) {
        System.out.print("elige una columna del 0 al 6: ");
        int ficha = 2 * sc.nextInt() + 1;
        for (int i = 5; i >= 0; i--) {
            if (tablero[i][ficha] == ' ') {
                tablero[i][ficha] = 'O';
                break;
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
        System.out.println("|0|1|2|3|4|5|6|");
    }


    //si ejecuto la opcion 1 del menu, el cronometro empieza a ejecutarse.
    //crear un cronometro que se mostrara y actualizar mientras el juego no acabe
    public static void cronometro() {
        Scanner sc = new Scanner(System.in);
        long inicio, fin;
        double tiempoTranscurridoTotal;
        System.out.println("escribe un caracter para empezar el cronometro:");
        char comienzaTiempo = sc.next().charAt(0);
        inicio = System.currentTimeMillis();
        System.out.println("escribe un caracter para finalizar el cronometro:");
        char terminaTiempo = sc.next().charAt(0);
        fin = System.currentTimeMillis();

        tiempoTranscurridoTotal = (fin - inicio) / 1000.0;
        System.out.println(tiempoTranscurridoTotal);
    }

    // posiciones en TABLERO:
    // 1-3-5-7-9-11-13
    // comprobacion 1 = 1-3-5-7
    // comprobacion 2 = 3-5-7-9
    // comprobacion 3 = 5-7-9-11
    // comprobacion 4 = 7-9-11-13

    public static boolean ComprobarFichasEnHorizontal(char[][] tablero, char jugador) {
        for (int i = 0; i < tablero.length; i++) {   // filas
            for (int j = 0; j < tablero[i].length; j += 2) {  //posicones col totales = 15
                if ((tablero[i][j + 1] == jugador) &&
                        (tablero[i][j + 3] == jugador) &&
                        (tablero[i][j + 5] == jugador) &&
                        (tablero[i][j + 7] == jugador)) {
                    return true;
                }
            }
        }
        return true;
    }

    // comprobar cada columna de ultima posicion a primera posicion
    //
    //[0][0]
    //[1][0]
    //[2][0]
    //[3][0]
    //[4][0]
    //[5][0]
    public static boolean comprobarFichasEnVertical(char[][] tablero, char jugador) {
        System.out.println(tablero.length);
        System.out.println(tablero[0].length);
        for (int i = tablero.length - 1; i >= 0; i--) {
            for (int j = 1; j < tablero[0].length; j += 2) {
                if ((tablero[i][j] == jugador) &&
                        (tablero[i][j + 1] == jugador) &&
                        (tablero[i][j + 2] == jugador) &&
                        (tablero[i][j + 3] == jugador)) {
                    return true;
                }
            }
        }
        return true;
    }
    // comprobar 6 diagonales dentro de la tabla
    public static boolean ComprobarFichasEnDiagonal(char[][] tablero, char jugador) {
        return true;
    }

    public static void resumenPartida() {
        cronometro();
    }

}
