import java.util.Scanner;

public class Conecta4 {
    private static final char[][] tablero = new char[6][15];    //filas-columnas
    private static final char[] jugador = {'X', 'O'}; // X= jugador 1  O= jugador 2

    public static void juego() {
        Scanner sc = new Scanner(System.in);
        int opcion = opcionesJuego(sc);
        switch (opcion) {
            case 1:
                int subopcion = subopciones(sc);
                switch (subopcion) {
                    case 1:
                        crearTablero(tablero);
                        imprimirTablero(tablero);
                        break;
                    case 2:
                        turnosJugadores(tablero,sc);
                        comprobarGanador();
                        break;
                }
                break;
            case 2:

                break;
            default:
                break;
        }
    }

    public static int opcionesJuego(Scanner sc) {
        System.out.print("Juego Conecta4:\n" +
                "[1]- Jugar con un amigo\n" +
                "[2]- Jugar contra la maquina\n" +
                "Elige una opcion: ");
        return sc.nextInt();
    }

    public static int subopciones(Scanner sc) {
        System.out.print("(1)- mostrar tablero:\n" +
                "(2)- comenzar juego:\n" +
                "Elige una opcion: ");
        return sc.nextInt();
    }

    public static void crearTablero(char[][] tablero) {
        System.out.println("Tablero previo a juego:");
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

    public static void visualizarTablero(char[][] tablero) {
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

    //0-1-2-3-4-5-6 --> columnas a elegir en el juego == 6
    //iterar por cada fila
    public static void introducirFichaJugador1(char[][] tablero, Scanner sc) {
        System.out.print("Jugador 1\nelige una columna del 0 al 6: ");
        int ficha = sc.nextInt();
        int nuevaFicha = ficha * 2 + 1;    //posiciones equivalentes en el tablero --> 1-3-5-7-9-11-13
        // 0-5 = filas de cada columna en el TABLERO
        //iterar de la fila 6 a la fila 1
        for (int i = tablero.length; i > 0; i--) {
            if (tablero[i][nuevaFicha] == ' ') {
                tablero[i][nuevaFicha] = 'X';
                break;
            }
        }
    }

    public static void introducirFichaJugador2(char[][] tablero, Scanner sc) {
        System.out.print("Jugador 2\nelige una columna del 0 al 6: ");
        int ficha = sc.nextInt();
        int nuevaFicha = ficha * 2 + 1;
        for (int i = 6; i > 0; i--) {
            if (tablero[i][nuevaFicha] == ' ') {
                tablero[i][nuevaFicha] = 'O';
                break;
            }
        }
    }

    public static void turnosJugadores(char[][] tablero, Scanner sc) {
        boolean turnoJugador = true;
        int contadorTurnos = 0;
        int turno = 0;
        int turnosMaximos = 42;

        while (turnoJugador) {
            if (turno % 2 == 0) {
                introducirFichaJugador1(tablero, sc);
            } else if (turno % 2 != 0) {
                introducirFichaJugador2(tablero, sc);
            }
            contadorTurnos++;
            imprimirTablero(tablero);
            comprobarGanador();
//            if (contadorTurnos > 42) {
//                turnoJugador = false;
//                System.out.println("juego acabado");
//            }
        }
    }

    public static void imprimirTablero(char[][] tablero) {
        for (char[] f : tablero) {
            for (char c : f) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("|1|2|3|4|5|6|");
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
    // comprobamos si las 4 posiciones NO estan vacias y que las 4 posiciones coincidan en el caracter del jugador
    public static boolean comprobarFichasEnHorizontal(char[][] tablero, char jugador) {
        for (int i = 0; i < tablero.length; i++) {   // filas
            for (int j = 0; j <= tablero[i].length; j += 2) {  //posicones col totales = 15
                if (
                        (tablero[i][j + 1] != ' ') &&
                                (tablero[i][j + 3] != ' ') &&
                                (tablero[i][j + 5] != ' ') &&
                                (tablero[i][j + 7] != ' ')
                                &&
                                (tablero[i][j + 1] == jugador) &&
                                (tablero[i][j + 3] == jugador) &&
                                (tablero[i][j + 5] == jugador) &&
                                (tablero[i][j + 7] == jugador)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    // comprobar cada columna de ultima posicion a primera posicion
    //[j][i]
    //[0][0]
    //[1][0]
    //[2][0]
    //[3][0]
    //[4][0]
    //[5][0]
    public static boolean comprobarFichasEnVertical(char[][] tablero, char jugador) {
        System.out.println(tablero.length); //6
        System.out.println(tablero[0].length);  //15
        for (int i = tablero.length; i > 0; i--) {
            for (int j = 1; j < tablero[0].length; j += 2) {
                if (
                        (tablero[j][i] != ' ') &&
                                (tablero[j + 1][i] != ' ') &&
                                (tablero[j + 2][i] != ' ') &&
                                (tablero[j + 3][i] != ' ')
                                &&
                                (tablero[j][i] == jugador) &&
                                (tablero[j + 1][i] == jugador) &&
                                (tablero[j + 2][i] == jugador) &&
                                (tablero[j + 3][i] == jugador)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    // comprobar 6 diagonales dentro de la tabla
    //[1][1] [3][1] [5][] [7][] [9][] [11][] [13][]
    //[2][1] [3][2] [5][] [7][] [9][] [11][] [13][]
    //[3][1] [3][3] [5][] [7][] [9][] [11][] [13][1]
    //[4][1] [3][4] [5][] [7][] [9][] [11][] [13][]
    //[5][1] [3][5] [5][] [7][] [9][] [11][] [13][]
    //[6][1] [3][6] [5][] [7][] [9][] [11][] [13][]
    // diagonal izquierda arriba a derecha abajo
    public static boolean comprobarFichasDeIzquierdaSuperiorADerechaInferior(char[][] tablero, char jugador) {
        for (int i = 0; i < 3; i++) {
            for (int j = 7; j <= 7; j += 2) {
                if (
                        (tablero[i][j] != ' ') &&
                                (tablero[i + 1][j + 2] != ' ') &&
                                (tablero[i + 2][j + 4] != ' ') &&
                                (tablero[i + 3][j + 6] != ' ')
                                &&
                                (tablero[i][j] == jugador) &&
                                (tablero[i + 1][j + 2] == jugador) &&
                                (tablero[i + 2][j + 4] == jugador) &&
                                (tablero[i + 3][j + 6] == jugador)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    // comprobar 6 diagonales dentro de la tabla
    //                              [0][1]
    //                        [1][2]
    //                  [2][3]
    //            [3][2]
    //      [4][1]
    //[5][0]
    //[1][1] [1][3] [1][5] [1][7] [1][9] [1][11] [1][13]
    //[2][1] [2][3] [2][5] [2][7] [2][9] [2][11] [2][13]
    //[3][1] [3][3] [3][5] [3][7] [3][9] [3][11] [3][13]
    //[4][1] [4][3] [4][5] [4][7] [4][9] [4][11] [4][13]
    //[5][1] [5][3] [5][5] [5][7] [5][9] [5][11] [5][13]
    //[6][1] [6][3] [6][5] [6][7] [6][9] [6][11] [6][13]
    public static boolean comprobarFichasDeDerechaInferiorAIzquierdaSuperior(char[][] tablero, char jugador) {
        for (int i = tablero.length; i > 3; i--) {
            for (int j = tablero.length - 2; j >= 7; j -= 2) {
                if (
                        (tablero[i][j] != ' ') &&
                                (tablero[i + 1][j - 2] != ' ') &&
                                (tablero[i + 2][j - 4] != ' ') &&
                                (tablero[i + 3][j - 6] != ' ')
                                &&
                                (tablero[i][j] == jugador) &&
                                (tablero[i + 1][j - 2] == jugador) &&
                                (tablero[i + 2][j - 4] == jugador) &&
                                (tablero[i + 3][j - 6] == jugador)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void comprobarGanador() {

        if (comprobarFichasEnVertical(tablero, jugador[0]) || comprobarFichasEnHorizontal(tablero, jugador[0]) || comprobarFichasDeIzquierdaSuperiorADerechaInferior(tablero, jugador[0]) || comprobarFichasDeDerechaInferiorAIzquierdaSuperior(tablero, jugador[0])) {
            System.out.println("jugador 1 gana");
        } else if (comprobarFichasEnVertical(tablero, jugador[1]) || comprobarFichasEnHorizontal(tablero, jugador[1]) || comprobarFichasDeIzquierdaSuperiorADerechaInferior(tablero, jugador[1]) || comprobarFichasDeDerechaInferiorAIzquierdaSuperior(tablero, jugador[1])) {
            System.out.println("jugador 2 gana");
        } else {
            System.out.println("no hay ganador");
        }
    }

    public static void resumenPartida() {
        cronometro();
    }
}
