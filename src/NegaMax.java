public class NegaMax {


    public static int minimax(int position, int depth, boolean maximizadorJugador){
        if (depth == 0){    //o el juego ha terminado en una posicion
            return 0;   //stattic evaluation of position
        }
        int mejorValor = Integer.MIN_VALUE;
        int peorValor = Integer.MAX_VALUE;

        if (maximizadorJugador){

        }
        return 0;
    }


    public static int negamax(char[][] tablero,int fichaJugador , boolean esMaximizador){


        int mejorValor = Integer.MIN_VALUE;
        for (int columna = 0; columna < tablero[0].length; columna++) {
            if (!Conecta4.comprobarColumnaLlena(columna)){
//                char[][]copiaTablero =
            }
        }
        return 0;
    }

    public static int alfaBeta(char[][] tablero, int depth, int alfa, int beta, boolean maximizadorJugador){  //

        int mejorValor = Integer.MIN_VALUE;
        int peorValor = Integer.MAX_VALUE;

        if (depth == 0){    //o si el juego se ha acabado
            //return ;        //regrese la funcion de evaluar (tablero, maximizado ? 1 : 2)
        }
        if (maximizadorJugador == true){
            return mejorValor ;
        }else if (maximizadorJugador == false){
            return peorValor;
        }
        return 0;
    }
}
