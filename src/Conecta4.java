import java.util.Scanner;

public class Conecta4 {
    private static char[][] tablero = new char[6][7];    //filas-columnas
    private static char[] jugador = {'X', 'O'}; // X= jugador 1  O= jugador 2

    public static void juego() {
        Scanner sc = new Scanner(System.in);
        int opcion = opcionesJuego(sc);
        switch (opcion) {
            case 1:
                tableroDeJuego(tablero);
                break;
            case 2:
                turnosJugadores(tablero, sc);
                comprobarGanador();
                break;
            case 3:
                introducirFichaJugador(tablero, sc,jugador[0]);
                break;
            default:
                break;
        }
    }

    public static int opcionesJuego(Scanner sc) {
        System.out.print("Juego Conecta4:\n" +
                "[1]- Jugar con un amigo\n" +
                "[2]- Jugar contra robot\n" +
                "Elige una opcion: ");
        return sc.nextInt();
    }

    //tablero del juego
    public static void tableroDeJuego(char[][] tablero) {
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

    public static void imprimirTablero(char[][] tablero) {
        for (char[] f : tablero) {
            for (char c : f) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("|0|1|2|3|4|5|6|");
    }

    //0-1-2-3-4-5-6 --> columnas a elegir en el juego
    public static void introducirFichaJugador(char[][] tablero, Scanner sc, int indiceJugador) {

        System.out.print("Jugador" + jugador[indiceJugador] + "\nelige una columna del 0 al 6: ");
        int ficha = sc.nextInt();
        //iterar de la fila 6 a la fila 1
        while (ficha>-1 && ficha<7){
            for (int i = tablero.length - 1; i >= 0; i--) {
                if (tablero[i][ficha] == ' ') {
                    tablero[i][ficha] = jugador[indiceJugador];
                    break;
                }
            }
            ficha = sc.nextInt();
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
            }
            contadorTurnos++;
            imprimirTablero(tablero);
            comprobarGanador();
        }
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

    /*[0][0] [0][1] [0][2] [0][3] [0][4] [0][5] [0][6]
    [1][0] [1][1] [1][2] [1][3] [1][4] [1][5] [1][6]
    [2][0] [2][1] [2][2] [2][3] [2][4] [2][5] [2][6]
    [3][0] [3][1] [3][2] [3][3] [3][4] [3][5] [3][6]
    [4][0] [4][1] [4][2] [4][3] [4][4] [4][5] [4][6]
    [5][0] [5][1] [5][2] [5][3] [5][4] [5][5] [5][6]*/
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

    public static boolean comprobarDiagonalIzquierdaInferiorADerechaSuperior1(char[][] tablero, int fichaJugador) {
        for (int k = 3; k <= tablero.length - 1; k++) { //k=3
            int contadorFichasConsecutivas = 0;
            int i = k;  //i=3
            int j = 0;  //j=0
            //j aumenta hasta tablero[0].length
            while (i >= 0 && j <= tablero[0].length - 1) {
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

    public static boolean comprobarDiagonalIzquierdaInferiorADerechaSuperior2(char[][] tablero, int fichaJugador) {
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

    public static boolean comprobarDiagonalDerechaInferiorAIzquierdaSuperior1(char[][] tablero, int fichaJugador) {
        for (int k = 3; k <= tablero.length - 1; k++) {
            int contadorFichasConsecutivas = 0;
            int i = k;
            int j = tablero[0].length - 1;  //6 -> 5 -> 4 -> 3 -> 2 -> 1
            while (i >= 0) { //i=3 -> i=2 -> i=1 -> i= ultima iteracion = 0
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasConsecutivas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasConsecutivas = 0;
                }
                if (contadorFichasConsecutivas == 4) {
                    return true;
                }
                i--;
                j--;
            }
        }
        return false;
    }

    public static boolean comprobarDiagonalDerechaInferiorAIzquierdaSuperior2(char[][] tablero, int fichaJugador) {
        for (int k = tablero.length - 1; k >= 0; k--) {
            int contadorFichasConsecutivas = 0;
            int i = tablero.length - 1;
            int j = k;
            while (j >= 0) {
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasConsecutivas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasConsecutivas = 0;
                }
                if (contadorFichasConsecutivas == 4) {
                    return true;
                }
                i--;
                j--;
            }
        }
        return false;
    }

    public static void comprobarGanador() {

        if (comprobarFichasEnHorizontal(tablero, jugador[0]) || comprobarFichasEnVertical(tablero, jugador[0]) || comprobarDiagonalIzquierdaInferiorADerechaSuperior1(tablero, jugador[0]) || comprobarDiagonalIzquierdaInferiorADerechaSuperior2(tablero, jugador[0]) || comprobarDiagonalDerechaInferiorAIzquierdaSuperior1(tablero, jugador[0]) || comprobarDiagonalDerechaInferiorAIzquierdaSuperior2(tablero, jugador[0])) {
            System.out.println("jugador 1 con ficha X gana");

        } else if (comprobarFichasEnHorizontal(tablero, jugador[1]) || comprobarFichasEnVertical(tablero, jugador[1]) || comprobarDiagonalIzquierdaInferiorADerechaSuperior1(tablero, jugador[1]) || comprobarDiagonalIzquierdaInferiorADerechaSuperior2(tablero, jugador[1]) || comprobarDiagonalDerechaInferiorAIzquierdaSuperior1(tablero, jugador[1]) || comprobarDiagonalDerechaInferiorAIzquierdaSuperior2(tablero, jugador[1])) {
            System.out.println("jugador 2 con ficha O gana");

        } else {
            System.out.println("empate");
        }
    }

    public static void resumenPartida() {
        cronometro();
    }
}
