import java.util.Scanner;

public class Conecta4 {
    private static char[][] tablero = new char[6][7];    //filas-columnas
    private static char[] jugador = {'X', 'O'}; // X= jugador 1  O= jugador 2

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
                        turnosJugadores(tablero, sc);
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

    //tablero del juego
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

    //0-1-2-3-4-5-6 --> columnas a elegir en el juego
    public static void introducirFichaJugador(char[][] tablero, Scanner sc, int indiceJugador) {
        System.out.print("Jugador 1\nelige una columna del 0 al 6: ");
        int ficha = sc.nextInt();
        //iterar de la fila 6 a la fila 1
        for (int i = tablero.length - 1; i >= 0; i--) {
            if (tablero[i][ficha] == ' ') {
                tablero[i][ficha] = jugador[indiceJugador];
                break;
            }
        }
    }

    public static void turnosJugadores(char[][] tablero, Scanner sc) {
        boolean turnoJugador = true;
        int contadorTurnos = 0;
        int turnosMaximos = 42;
        while (turnoJugador && contadorTurnos <= turnosMaximos) {
            if (contadorTurnos % 2 == 0) {
                introducirFichaJugador(tablero, sc, 0);
            } else if (contadorTurnos % 2 == 1) {
                introducirFichaJugador(tablero, sc, 1);
                // introducirFichaJugador2(tablero, sc);
            }
            contadorTurnos++;
            imprimirTablero(tablero);
            comprobarGanador();
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

    //[0][0] [0][1] [0][2] [0][3] [0][4] [0][5] [0][6]
    //[1][0] [1][1] [1][2] [1][3] [1][4] [1][5] [1][6]
    //[2][0] [2][1] [2][2] [2][3] [2][4] [2][5] [2][6]
    //[3][0] [3][1] [3][2] [3][3] [3][4] [3][5] [3][6]
    //[4][0] [4][1] [4][2] [4][3] [4][4] [4][5] [4][6]
    //[5][0] [5][1] [5][2] [5][3] [5][4] [5][5] [5][6]
    public static boolean comprobarFichasEnHorizontal(char[][] tablero, char fichaJugador) {
        for (int i = tablero.length - 1; i >= 0; i--) {   // filas
            int contadorFichasConsecutivas = 0;
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasConsecutivas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasConsecutivas = 0;
                }

                if (contadorFichasConsecutivas == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    // comprobar cada columna de la ultima posicion a primera posicion
    //[0][0] [0][1] [0][2] [0][3] [0][4] [0][5] [0][6]
    //[1][0] [1][1] [1][2] [1][3] [1][4] [1][5] [1][6]
    //[2][0] [2][1] [2][2] [2][3] [2][4] [2][5] [2][6]
    //[3][0] [3][1] [3][2] [3][3] [3][4] [3][5] [3][6]
    //[4][0] [4][1] [4][2] [4][3] [4][4] [4][5] [4][6]
    //[5][0] [5][1] [5][2] [5][3] [5][4] [5][5] [5][6]
    public static boolean comprobarFichasEnVertical(char[][] tablero, char fichaJugador) {
        for (int j = 0; j < tablero[0].length; j++) {
            int contadorFichasConsecutivas = 0;
            for (int i = tablero.length - 1; i >= 0; i--) {
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasConsecutivas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasConsecutivas = 0;
                }
                if (contadorFichasConsecutivas == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean imprimirDiagonalIzquierdaInferiorADerechaParte1(char[][] tablero, int fichaJugador) {

        for (int k = 3; k <= tablero.length - 1; k++) { //k=3
            int contadorFichasConsecutivas = 0;
            int i = k;  //i=3
            int j = 0;  //j=0
            //j aumenta hasta tablero[0].length
            while (i >= 0 && j <= tablero[0].length-1) {
                //i=3       j=0
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasConsecutivas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasConsecutivas = 0;
                }
                if (contadorFichasConsecutivas == 4) {
                    return true;
                }
                i--;    //i=2
                j++;    //j=1
            }
        }
        return false;
    }

    public static boolean comprobarDiagonalIzquierdaADerechaParte2(char[][] tablero, int fichaJugador) {

        for (int k = 1; k <= tablero[0].length - 1; k++) {  //k=1 aumentara hasta k=6
            int contadorFichasConsecutivas = 0;
            int i = tablero.length - 1; //i=5
            int j = k;  //j=1
            while (j <= tablero[0].length - 1) {
                // 1 <= 6
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasConsecutivas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasConsecutivas = 0;
                }
                if (contadorFichasConsecutivas == 4) {
                    return true;
                }
                i--;
                j++;
            }
        }
        return false;
    }





    // comprobar 4 diagonales dentro de la tabla
    //[0][0] [0][1] [0][2] [0][3] [0][4] [0][5] [0][6]
    //[1][0] [1][1] [1][2] [1][3] [1][4] [1][5] [1][6]
    //[2][0] [2][1] [2][2] [2][3] [2][4] [2][5] [2][6]
    //[3][0] [3][1] [3][2] [3][3] [3][4] [3][5] [3][6]
    //[4][0] [4][1] [4][2] [4][3] [4][4] [4][5] [4][6]
    //[5][0] [5][1] [5][2] [5][3] [5][4] [5][5] [5][6]
    //                     [0][3]
    //              [1][2]
    //       [2][1]
    //[3][0]

    public static boolean iteracionEnDiagonalDerechaAIzquierda(char[][] tablero, int inicioI, int finalI, int inicioJ, int finalJ, char fichaJugador) {
        //                                                                              0           4           3           0
        int j = inicioJ;
        int contadorFichasConsecutivas = 0;
        for (int i = inicioI; i < finalI; i++) {
//            while (j != finalJ){
            if (tablero[i][j] == fichaJugador) {
                contadorFichasConsecutivas++;
            } else if (tablero[i][j] != fichaJugador) {
                contadorFichasConsecutivas = 0;
            }
            if (contadorFichasConsecutivas == 4) {
                return true;
            }
            j--;
        }
//        }
        return false;
    }

    // comprobar 6 diagonales dentro de la tabla
    //[0][0] [0][1] [0][2] [0][3] [0][4] [0][5] [0][6]
    //[1][0] [1][1] [1][2] [1][3] [1][4] [1][5] [1][6]
    //[2][0] [2][1] [2][2] [2][3] [2][4] [2][5] [2][6]
    //[3][0] [3][1] [3][2] [3][3] [3][4] [3][5] [3][6]
    //[4][0] [4][1] [4][2] [4][3] [4][4] [4][5] [4][6]
    //[5][0] [5][1] [5][2] [5][3] [5][4] [5][5] [5][6]
    // diagonal izquierda arriba a derecha abajo
    public static boolean comprobarFichasDeIzquierdaSuperiorADerechaInferior(char[][] tablero, char fichaJugador) {
        int j = 3;
        int contadorFichasConsecutivas = 0;
        for (int i = 0; i < 4; i++) {
            if (tablero[i][j] == fichaJugador) {
                contadorFichasConsecutivas++;
            } else if (tablero[i][j] != fichaJugador) {
                contadorFichasConsecutivas = 0;
            }
            if (contadorFichasConsecutivas == 4) {
                return true;
            }
            j--;
        }
//        for (int i = 0; i < 4; i++) {
//            int contadorFichasConsecutivas = 0;
//            for (int j = 0; j < tablero[i].length; j++) {
//                if (tablero[i][j] == fichaJugador) {
//                    contadorFichasConsecutivas++;
//                } else if (tablero[i][j] != fichaJugador) {
//                    contadorFichasConsecutivas = 0;
//                }
//                if (contadorFichasConsecutivas == 4) {
//                    return true;
//                }
//            }
//        }
        return false;
    }

    //i  j
    //[0][0] [0][1] [0][2] [0][3] [0][4] [0][5] [0][6]
    //[1][0] [1][1] [1][2] [1][3] [1][4] [1][5] [1][6]
    //[2][0] [2][1] [2][2] [2][3] [2][4] [2][5] [2][6]
    //[3][0] [3][1] [3][2] [3][3] [3][4] [3][5] [3][6]
    //[4][0] [4][1] [4][2] [4][3] [4][4] [4][5] [4][6]
    //[5][0] [5][1] [5][2] [5][3] [5][4] [5][5] [5][6]
    public static boolean derechaSuperiorAIzquierdaInferior(char[][] tablero, char fichaJugador) {
        /*
        int inicioFilaI = 0;
        int inicioColumnaJ = 3;

        while (inicioColumnaJ < 7 || inicioFilaI > 6) {
            for (int i = 0; i < tablero.length; i++) {
                int contadorFichasConsecutivas = 0;
                for (int j = tablero[0].length - 1; j >= 0; j--) {

                    if (tablero[i][j] == fichaJugador) {
                        contadorFichasConsecutivas++;
                    } else if (tablero[i][j] != fichaJugador) {
                        contadorFichasConsecutivas = 0;
                    }
                    if (contadorFichasConsecutivas == 4) {
                        return true;
                    }
                }
                inicioFilaI++;
                inicioColumnaJ++;
            }
        }
        return false;
    }
         */

        for (int i = 0; i < tablero.length; i++) {
            int contadorFichasConsecutivas = 0;

            for (int j = tablero[0].length - 1; j >= 0; j--) {
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasConsecutivas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasConsecutivas = 0;
                }
                if (contadorFichasConsecutivas == 4) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean comprobarDerechaSuperiorAIzquierdaInferior(char[][] tablero, char fichaJugador) {
        int diagonal = 6;
        int inicio_i = 0, fin_i = 5, inicio_j = 0, fin_j = 6;
        while (diagonal >= 1) {
            if (diagonal == 1) {
                inicio_i = 3;
                fin_i = 0;
                inicio_j = 0;
                fin_j = 3;
            } else if (diagonal == 2) {
                inicio_i = 4;
                fin_i = 0;
                inicio_j = 0;
                fin_j = 4;
            }
            int i = inicio_i, j = inicio_j;
            int contadorFichasConsecutivas = 0;
            while (i >= fin_i && j <= fin_j) {
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasConsecutivas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasConsecutivas = 0;
                }
                if (contadorFichasConsecutivas == 4) {
                    return true;
                }
                --i;
                ++j;
            }
            --diagonal;
        }
        /*
        for (int i = 0; i <; i++) {
            for (int j = tablero[0].length - 1; j >= 0; j--) {
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasConsecutivas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasConsecutivas = 0;
                }
                if (contadorFichasConsecutivas == 4) {
                    return true;
                }
            }
        }
         */
        return false;
    }

    // comprobar 6 diagonales dentro de la tabla
    //[0][0] [0][1] [0][2] [0][3] [0][4] [0][5] [0][6]
    //[1][0] [1][1] [1][2] [1][3] [1][4] [1][5] [1][6]
    //[2][0] [2][1] [2][2] [2][3] [2][4] [2][5] [2][6]
    //[3][0] [3][1] [3][2] [3][3] [3][4] [3][5] [3][6]
    //[4][0] [4][1] [4][2] [4][3] [4][4] [4][5] [4][6]
    //[5][0] [5][1] [5][2] [5][3] [5][4] [5][5] [5][6]
    public static boolean comprobarFichasDeDerechaInferiorAIzquierdaSuperior(char[][] tablero, char fichaJugador) {
        for (int i = tablero.length - 1; i >= 0; i--) {
            int contadorFichasConsecutivas = 0;
            for (int j = tablero[i].length - 1; j >= 0; j--) {
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasConsecutivas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasConsecutivas = 0;
                }
                if (contadorFichasConsecutivas == 4) {
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
