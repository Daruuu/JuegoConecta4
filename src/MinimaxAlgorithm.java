import java.util.ArrayList;
import java.util.List;

public class MinimaxAlgorithm {

    /*
    la idea principal del algoritmo es iniciar en una posicion y utilizar un generador de movimientos
    plausibles para generera un conjunto de posiciones de posibles sucesores,
    se aplica una funcion de evaluacion estatica y se selecciona el mejor movimiento promoviendo el valor
    la heuristica del juego es :

    si yo gano heuristica es 1
    si yo empato heuristica es 0
    si yo pierdo heristica es -1
     */
    // estado incial es el nodo inicial del problema
    public static int minimax(int position, int depth, boolean maximizadorJugador) {
        if (depth == 0) {    //o el juego ha terminado en una posicion
            return 0;   //stattic evaluation of position
        }
        int mejorValor = Integer.MIN_VALUE;
        int peorValor = Integer.MAX_VALUE;

        if (maximizadorJugador) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {

                }
            }
        }
        return 0;
    }

    public static int negamax(char[][] tablero, int fichaJugador, boolean esMaximizador) {

        int mejorValor = Integer.MIN_VALUE;
        for (int columna = 0; columna < tablero[0].length; columna++) {
            if (!Conecta4.comprobarColumnaLlena(columna)) {
//                char[][]copiaTablero =
            }
        }
        return 0;
    }

    public static int alfaBeta(char[][] tablero, int depth, int alfa, int beta, boolean maximizadorJugador) {  //
        int mejorValor = Integer.MIN_VALUE;
        int peorValor = Integer.MAX_VALUE;

        if (depth == 0) {    //o si el juego se ha acabado
            //return ;        //regrese la funcion de evaluar (tablero, maximizado ? 1 : 2)
        }
        if (maximizadorJugador == true) {
            return mejorValor;
        } else if (maximizadorJugador == false) {
            return peorValor;
        }
        return 0;
    }

    //esta funcion la utilizaremos para calcular el puntaje del tablero
    // en funcion de la posicion de la fichas en el tablero
    //esto nos permite determinar cual es la mejor opcion para el siguiente movimiento
    public static int evaluarPuntaje(char fichaJugador) {

        // Comprobamos si hay filas ganadoras en el tablero.
        if (Conecta4.fichasEnHorizontal(fichaJugador)) {
            return 100;
        }

        // Comprobamos si hay columnas ganadoras en el tablero.
        if (Conecta4.fichasEnVertical(fichaJugador)) {
            return 100;
        }

        // Comprobamos si hay diagonales ganadoras en el tablero.
        if (Conecta4.diagonalDerechaInferiorAIzquierdaSuperior1(fichaJugador) || Conecta4.diagonalDerechaInferiorAIzquierdaSuperior2(fichaJugador) || Conecta4.diagonalIzquierdaInferiorADerechaSuperior1(fichaJugador) || Conecta4.diagonalIzquierdaInferiorADerechaSuperior2(fichaJugador)) {
            return 100;
        }
        return -100;
    }

    //la funcion heuristica es la funcion donde creo la condicion que designara cual es la mejor jugada para el jugador y
    // que puntaje recibe si es esa jugada es buena o es mala
    // y el puntaje que doy al maximizador


    // crear una funcion que genere un moviemiento en el juego
    // return los
    public static void generarMoviminetoJugador(char[][] tablero){
        List<Integer> movimientosX = new ArrayList<>();

    }
}
