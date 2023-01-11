import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Conecta4 {
    private static final int filas = 6;
    private static final int columnas = 7;
    private static long inicioPartida;
    private static long finPartida;
    private static long tiempoTranscurrido;
    private static final int turnosJuego = 42;
    private static int contadorTurnos;
    private static char[][] tablero = new char[6][7];
    private static final char[] jugador = {'X', 'O'};

    public static void conectaCuatro() {
        Scanner sc = new Scanner(System.in);
        int opcion = opcionesJuego(sc);
        switch (opcion) {
            case 1:
                tableroDeJuego();
                imprimirTablero();
                Date tiempoInicio = new Date();
                inicioPartida = tiempoInicio.getTime();
                turnosJugadores();
                Date tiempoFin = new Date();
                finPartida = tiempoFin.getTime();
                break;
            case 2:
                System.out.println("no disponible aun");
                break;
            default:
                System.out.println("elige una opcion correcta");
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
        for (char[] chars : tablero) {
            Arrays.fill(chars, '-');
        }
        /*
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '-';
            }
        }
         */
    }


    public static void imprimirTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (j == 0) {
                    if (tablero[i][j] == 'X') {
                        System.out.print("  " + "\033[31m" + tablero[i][j] + "\033[0m"); // color rojo
                    } else if (tablero[i][j] == 'O') {
                        System.out.print("  " + "\033[33m" + tablero[i][j] + "\033[0m");   //color amarillo en secuencia ANSI
                    } else {
                        System.out.print("  " + "\033[34m" + tablero[i][j] + "\033[0m");
                    }
                } else {
                    // System.out.print("   " + tablero[i][j]);
                    if (tablero[i][j] == 'X') {
                        System.out.print("   " + "\033[31m" + tablero[i][j] + "\033[0m"); // color rojo
                    } else if (tablero[i][j] == 'O') {
                        System.out.print("   " + "\033[33m" + tablero[i][j] + "\033[0m");   //color amarillo en secuencia ANSI
                    } else {
                        System.out.print("   " + "\033[34m" + tablero[i][j] + "\033[0m");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\033[34m" + "| 0 | 1 | 2 | 3 | 4 | 5 | 6 |" + "\033[0m");
    }

    public static boolean comprobarRangoDeFicha(int fichaEnColumna) {
        if (fichaEnColumna >= 0 && fichaEnColumna < columnas) {
            return true;
        } else {
            System.out.println("\033[31m" + "COLUMNA DE FICHA INEXISTENTE!" + "\033[0m"); // color rojo
            return false;
        }
    }

    public static boolean comprobarColumnaLlena(int columna) {
        return tablero[0][columna] != '-';
    }

    public static boolean agregarFichaTablero(int indiceJugador) {
        Scanner sc = new Scanner(System.in);
        System.out.print("JUGADOR " + jugador[indiceJugador] + "\033[34m\nelige una columna del 0 al 6: \033[0m");
        int ficha = sc.nextInt();
        if (comprobarRangoDeFicha(ficha)) {
            if (comprobarColumnaLlena(ficha)) {
                System.out.println("\033[31m" + "COLUMNA LLENA!" + "\033[0m"); // color rojo
                return false;
            } else {
                for (int i = tablero.length - 1; i >= 0; i--) {
                    if (tablero[i][ficha] == '-') {
                        tablero[i][ficha] = jugador[indiceJugador];
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void turnosJugadores() {
        contadorTurnos = 0;
        boolean esFichaCorrecta = false;
        boolean ganadorEncontrado = false;

        while (contadorTurnos < turnosJuego && !ganadorEncontrado) {
            if (contadorTurnos % 2 == 0) {
                esFichaCorrecta = agregarFichaTablero(0);

            } else if (contadorTurnos % 2 == 1) {
                esFichaCorrecta = agregarFichaTablero(1);
            }
            if (esFichaCorrecta) {
                contadorTurnos++;
                ganadorEncontrado = comprobarGanador();
            }
            imprimirTablero();
        }
    }

    public static void tiempoPartida() {
        SimpleDateFormat formatoHora = new SimpleDateFormat("mm:ss");
        tiempoTranscurrido = finPartida - inicioPartida;
        System.out.println("\nTiempo transcurrido: " + formatoHora.format(tiempoTranscurrido) + "s");
    }

    /*

    [0][0] [0][1] [0][2] [0][3] [0][4] [0][5] [0][6]
    [1][0] [1][1] [1][2] [1][3] [1][4] [1][5] [1][6]
    [2][0] [2][1] [2][2] [2][3] [2][4] [2][5] [2][6]
    [3][0] [3][1] [3][2] [3][3] [3][4] [3][5] [3][6]
    [4][0] [4][1] [4][2] [4][3] [4][4] [4][5] [4][6]
    [5][0] [5][1] [5][2] [5][3] [5][4] [5][5] [5][6]

    */

    public static boolean fichasEnHorizontal(char fichaJugador) {

        for (int i = tablero.length - 1; i >= 0; i--) {
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

    public static boolean diagonalIzquierdaInferiorADerechaSuperior1(char fichaJugador) {

        for (int k = 3; k <= tablero.length - 1; k++) {
            int contadorFichasConsecutivas = 0;
            int i = k;
            int j = 0;
            while (i >= 0 && j <= tablero[0].length - 1) {
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

    public static boolean diagonalIzquierdaInferiorADerechaSuperior2(char fichaJugador) {

        for (int k = 1; k <= tablero[0].length - 1; k++) {
            int contadorFichasConsecutivas = 0;
            int i = tablero.length - 1;
            int j = k;
            while (j <= tablero[0].length - 1) {
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

    public static boolean diagonalDerechaInferiorAIzquierdaSuperior1(char fichaJugador) {

        for (int k = 3; k <= tablero.length - 1; k++) {
            int contadorFichasConsecutivas = 0;
            int i = k;
            int j = tablero[0].length - 1;
            while (i >= 0) {
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

    public static boolean diagonalDerechaInferiorAIzquierdaSuperior2(char fichaJugador) {

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
            System.out.print("  \033[31m\"<<<<<<<<<< JUGADOR 1 'X' GANA >>>>>>>>>>\033[0m"); // color rojo
            resumenPartida();
            return true;

        } else if (fichasEnHorizontal(jugador[1]) || fichasEnVertical(jugador[1]) || diagonalIzquierdaInferiorADerechaSuperior1(jugador[1]) || diagonalIzquierdaInferiorADerechaSuperior2(jugador[1]) || diagonalDerechaInferiorAIzquierdaSuperior1(jugador[1]) || diagonalDerechaInferiorAIzquierdaSuperior2(jugador[1])) {
            System.out.println("  \033[33m\"<<<<<<<<<< JUGADOR 2 'O' GANA >>>>>>>>>>\033[0m");  //amarillo
            resumenPartida();
            return true;

        } else if (contadorTurnos == turnosJuego - 1) {
            System.out.println("EMPATE");
            resumenPartida();
            opcionesJuego(sc);
            return true;
        }
        return false;
    }

    public static void resumenPartida() {
        tiempoPartida();
    }
}