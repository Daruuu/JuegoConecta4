import java.util.Scanner;

public class Conecta4 {
    private static final int filas = 6;
    private static final int columnas = 7;
    private static int numTurnos = 42;
    private static int contadorTurnos;
    private static char[][] tablero = new char[6][7];    //filas-columnas
    private static final char[] jugador = {'X', 'O'}; // X= jugador 1  O= jugador 2

    public static void juego() {
        Scanner sc = new Scanner(System.in);
        int opcion = opcionesJuego(sc);
        switch (opcion) {
            case 1:
                tableroDeJuego();
                imprimirTablero();
                turnosJugadores();
                break;
            case 2:

                break;
            case 3:

                break;
            default:
                break;
        }
    }

    public static int opcionesJuego(Scanner sc) {
        System.out.print("Juego Conecta4:\n" +
                "[1]- Jugar con un amigo\n" +
                "[2]- Jugar contra un robot\n" +
                "[3]- Mostrar resumen de partida\n" +
                "Elige una opcion: ");
        return sc.nextInt();
    }

    public static void tableroDeJuego() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    public static void imprimirTablero() {
        for (char[] filas : tablero) {
            for (char columnas : filas) {
                System.out.print(columnas);
            }
            System.out.println();
        }
        System.out.println("|0|1|2|3|4|5|6|");
    }

    public static boolean comprobarFicha(int fichaEnColumna) {
        if (fichaEnColumna >= 0 && fichaEnColumna < columnas) {
            return true;
        } else {
            System.err.println("COLUMNA DE FICHA INEXISTENTE");
            return false;
        }
    }

    //0-1-2-3-4-5-6 --> columnas a elegir en el juego
    public static boolean agregarFichaTablero(int indiceJugador) {
        System.out.print("Jugador " + jugador[indiceJugador] + " \nelige una columna del 0 al 6: ");
        Scanner sc = new Scanner(System.in);
        int ficha = sc.nextInt();

        if (comprobarFicha(ficha)) {
            for (int i = tablero.length - 1; i >= 0; i--) {
                if (tablero[i][ficha] == '-') {
                    tablero[i][ficha] = jugador[indiceJugador];
                    return true;
                }
            }
        }
        return false;
    }

    public static void turnosJugadores() {
        contadorTurnos = 0;
        boolean esFichaCorrecta = false;
        boolean ganadorEncontrado = false;
        while (contadorTurnos < numTurnos && !ganadorEncontrado) {

            if (contadorTurnos % 2 == 0) {
                esFichaCorrecta = agregarFichaTablero(0);
            } else if (contadorTurnos % 2 != 0) {
                esFichaCorrecta = agregarFichaTablero(1);
            }
            if (esFichaCorrecta) {
                contadorTurnos++;
                ganadorEncontrado = comprobarGanador();
            }
            imprimirTablero();
        }
    }

    public static long inicioCronometro() {
        return System.currentTimeMillis();
    }

    public static long finCronometro() {
        return System.currentTimeMillis();
    }

    public static long tiempoPartida() {
        return (finCronometro() - inicioCronometro()) / 1000;
    }

    /*[0][0] [0][1] [0][2] [0][3] [0][4] [0][5] [0][6]
    [1][0] [1][1] [1][2] [1][3] [1][4] [1][5] [1][6]
    [2][0] [2][1] [2][2] [2][3] [2][4] [2][5] [2][6]
    [3][0] [3][1] [3][2] [3][3] [3][4] [3][5] [3][6]
    [4][0] [4][1] [4][2] [4][3] [4][4] [4][5] [4][6]
    [5][0] [5][1] [5][2] [5][3] [5][4] [5][5] [5][6]*/

    public static boolean fichasEnHorizontal(char fichaJugador) {
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

    public static boolean fichasEnVertical(char fichaJugador) {
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

    public static boolean diagonalIzquierdaInferiorADerechaSuperior1(int fichaJugador) {
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

    public static boolean diagonalIzquierdaInferiorADerechaSuperior2(int fichaJugador) {
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

    public static boolean diagonalDerechaInferiorAIzquierdaSuperior1(int fichaJugador) {
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

    public static boolean diagonalDerechaInferiorAIzquierdaSuperior2(int fichaJugador) {
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

    public static boolean comprobarGanador() {
        Scanner sc = new Scanner(System.in);
        if (fichasEnHorizontal(jugador[0]) || fichasEnVertical(jugador[0]) || diagonalIzquierdaInferiorADerechaSuperior1(jugador[0]) || diagonalIzquierdaInferiorADerechaSuperior2(jugador[0]) || diagonalDerechaInferiorAIzquierdaSuperior1(jugador[0]) || diagonalDerechaInferiorAIzquierdaSuperior2(jugador[0])) {
            System.out.println("JUGADOR 1 CON FICHA X GANA");
            return true;

        } else if (fichasEnHorizontal(jugador[1]) || fichasEnVertical(jugador[1]) || diagonalIzquierdaInferiorADerechaSuperior1(jugador[1]) || diagonalIzquierdaInferiorADerechaSuperior2(jugador[1]) || diagonalDerechaInferiorAIzquierdaSuperior1(jugador[1]) || diagonalDerechaInferiorAIzquierdaSuperior2(jugador[1])) {
            System.out.println("JUGADOR 2 CON FICHA O GANA");
            return true;

        } else if (contadorTurnos == numTurnos - 1) {
            System.out.println("EMPATE");
            opcionesJuego(sc);
            return true;
        }
        return false;
    }

    public static void resumenPartida() {
        tiempoPartida();
    }
}
