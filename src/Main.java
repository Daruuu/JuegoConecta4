public class Main {
    public static boolean comprobarFichasEnHorizontal(char[][] tablero, char fichaJugador) {
        for (int i = tablero.length - 1; i >= 0; i--) {   // filas
            int contadorFichasSeguidas = 0;
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == fichaJugador) {
                    contadorFichasSeguidas++;
                } else if (tablero[i][j] != fichaJugador) {
                    contadorFichasSeguidas = 0;
                }

                if (contadorFichasSeguidas == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] tablero = new char[6][7];    //filas-columnas
//        tablero[5][0] = 'X';
//        tablero[5][1] = 'X';
//        tablero[5][2] = 'X';
//        tablero[5][3] = 'O';
//        if (Conecta4.comprobarFichasEnHorizontal(tablero, 'X')) {
//            System.out.println("Ganador encontrado");
//        } else {
//            System.out.println("No ganador");
//        }

//        tablero[2][0] = 'X';
//        tablero[3][0] = 'X';
//        tablero[4][0] = 'X';
//        tablero[5][0] = 'O';

//        if (Conecta4.comprobarFichasEnVertical(tablero, 'X')) {
//            System.out.println("Ganador encontrado");
//        } else {
//            System.out.println("No ganador");
//        }

//        tablero[0][1] = 'X';
//        tablero[0][2] = 'X';
//        tablero[0][3] = 'X';
//        tablero[0][4] = 'X';
//        tablero[0][5] = 'O';
//        if (Conecta4.comprobarFichasDeIzquierdaSuperiorADerechaInferior(tablero, 'X')) {
//            System.out.println("Ganador encontrado");
//        } else {
//            System.out.println("No ganador");
//        }

//        tablero[1][1] = 'X';
//        tablero[1][2] = 'X';
//        tablero[1][3] = 'X';
//        tablero[1][4] = 'O';
//        tablero[1][5] = 'O';
/*
        tablero[3][0] = 'X';
        tablero[2][1] = 'X';
        tablero[1][2] = 'X';
        tablero[0][3] = 'X';
        if (Conecta4.derechaSuperiorAIzquierdaInferior(tablero, 'X')) {
            System.out.println("Ganador encontrado");
        } else {
            System.out.println("No ganador");
        }
*/
        /*

        tablero[3][0] = 'X';
        tablero[2][1] = 'X';
        tablero[1][2] = 'X';
        tablero[0][3] = 'O';
        if (Conecta4.comprobarDerechaSuperiorAIzquierdaInferior(tablero, 'X')) {
            System.out.println("Ganador encontrado");
        } else {
            System.out.println("No ganador");
        }
         */

//        tablero[5][6] = 'X';
//        tablero[4][5] = 'X';
//        tablero[3][4] = 'X';
//        tablero[2][3] = 'X';
//        if (Conecta4.comprobarFichasDeDerechaInferiorAIzquierdaSuperior(tablero, 'X')) {
//            System.out.println("Ganador encontrado");
//        } else {
//            System.out.println("No ganador");
//        }
//        System.out.println("Hello world!");
        //Conecta4.juego();
        /*
        tablero[1][4] = 'X';
        tablero[4][1] = 'X';
        tablero[3][2] = 'X';
        tablero[2][3] = 'X';
        if (imprimirDiagonalIzquierdaInferiorADerechaParte1(tablero, 'X')) {
            System.out.println("Ganador encontrado");
        } else {
            System.out.println("No ganador");
        }
         */
/*
        tablero[5][3] = 'X';
        tablero[4][4] = 'X';
        tablero[3][5] = 'X';
        tablero[2][6] = 'X';

        tablero[5][2] = 'O';
        tablero[4][3] = 'X';
        tablero[3][4] = 'X';
        tablero[2][5] = 'X';
        tablero[1][6] = 'X';
        if (Conecta4.comprobarDiagonalIzquierdaADerechaParte2(tablero, 'X')) {
            System.out.println("Ganador encontrado");
        } else {
            System.out.println("No ganador");
        }
 */

        //diagonal 1
        //i = 3
        //j=6   j--
        /*tablero[3][6] = 'X';
        tablero[2][5] = 'X';
        tablero[1][4] = 'o';
        tablero[0][3] = 'X';*/

        //diagonal 2
        //i = 4 i--
        //j=6   j--
        /*tablero[4][6] = 'O';
        tablero[3][5] = 'O';
        tablero[2][4] = 'X';
        tablero[1][3] = 'X';
        tablero[0][2] = 'X';*/

        //diagonal 3
        //i = 5 i--
        //j=6   j--
/*
        tablero[5][6] = 'O';
        tablero[4][5] = 'X';
        tablero[3][4] = 'X';
        tablero[2][3] = 'X';
        tablero[1][2] = 'X';
        tablero[0][1] = 'X';

        if (Conecta4.comprobarDiagonalDerechaInferiorAIzquierdaSuperiorParte1(tablero, 'X')) {
            System.out.println("Ganador encontrado");
        } else {
            System.out.println("No ganador");
        }
*/
        //diagonal 1
//        tablero[5][3] = 'O';
//        tablero[4][2] = 'X';
//        tablero[3][1] = 'X';
//        tablero[2][0] = 'X';
//        tablero[1][2] = 'X';

        //diagonal 2
        /*tablero[5][4] = 'X';
        tablero[4][3] = 'X';
        tablero[3][2] = 'X';
        tablero[2][1] = 'X';*/
//        tablero[1][0] = 'X';

//        tablero[1][2] = 'X';
        /*tablero[5][5] = 'X';
        tablero[4][4] = 'O';
        tablero[3][3] = 'X';
        tablero[2][2] = 'X';
        tablero[1][1] = 'X';*/
//        tablero[0][0] = 'O';
//        if (Conecta4.diagonalInferiorDerechaASuperiorIzquierdaParte2(tablero, 'X')) {
//            System.out.println("Ganador encontrado");
//        } else {
//            System.out.println("No ganador");
//        }
    }
}