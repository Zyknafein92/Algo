import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // Difficulté Ordi  Medium -> Si trouve 1 case libre acôté d'une case jouée, il s'y place
    //                         -> Si 2 cases consécutifs, jouer la 3e consécutives pour remplir
    public static void main(String[] args) {
        boolean gameType = gameBoard();

        do {
            game(gameType);
        } while(playAgain());
    }

    private static boolean isInBoard(int pos, String[] boards) {
        return pos >= 0 && pos < boards.length;
    }

    private static String computerIA(String[] boards) {
        String result = null;
        for (int i = 0; i < boards.length; i++) {
            // Horizontal
            if(boards[i].equals("O")) {
                if (isInBoard(i + 1, boards) && isCellFree(boards[i + 1]) && (i + 1 % 3 == 0)) {
                    result = boards[i + 1];
                    break;
                }
                else if (isInBoard(i - 1, boards) && isCellFree(boards[i - 1]) && (i - 1 % 3 == 0)) {
                    result = boards[i - 1];
                    break;
                }
                else if (isInBoard(i + 3, boards) && isCellFree(boards[i + 3])) {
                    result = boards[i + 3];
                    break;
                }
                else if (isInBoard(i - 3, boards) && isCellFree(boards[i - 3])) {
                    result = boards[i - 3];
                    break;
                }
                else if (isInBoard(i - 4, boards)&& isCellFree(boards[i - 4]) && (i == 8 || i == 6 || i == 4)) {
                    result = boards[i - 4];
                    break;
                }
                else  if (isInBoard(i + 4, boards)&& isCellFree(boards[i + 4]) && (i == 0 || i == 2 || i == 4)) {
                    result = boards[i + 4];
                    break;
                }
            }
        }
        if (Objects.isNull(result)) {
            Random rd = new Random();
            int computerPlay = 1 + rd.nextInt(9);
            //System.out.println(computerPlay);
            while (!isCellFree(boards[computerPlay - 1])) {
                computerPlay =  1 + rd.nextInt(9);
            }
            result = String.valueOf(computerPlay);
        }
        return result;
    }


    private static void game(boolean gameType) {
        String[] boards = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String symbol = "X";

        System.out.println("---------------------------");
        System.out.println("-------- TicTacToe --------");
        System.out.println("---------------------------");
        printBoard(boards);
        while (true) {
            if(gameType) {
                if (play(symbol, boards)) {
                    break;
                }
            } else {
                if(playWithComputer(symbol,boards)) {
                    break;
                }
            }
            symbol = symbol.equals("X") ? "O" : "X";
        }
    }

    private static boolean gameBoard() {
        System.out.println("Choisissez votre mode de jeu :");
        System.out.println("0. 1 joueur");
        System.out.println("1. 2 joueurs");
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        return value == 1;
    }

    private static boolean playAgain() {
        System.out.println("Souhaitez-vous rejouer ?");
        System.out.println("0. Non");
        System.out.println("1. Oui");
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        return value == 1;
    }

    private static boolean playWithComputer(String symbol, String[] boards) {
        if( symbol.equals("X")) {
            System.out.println("Joueur " + symbol + " , a vous de jouez ! Choisissez une position :");
            Scanner in = new Scanner(System.in);
            int value = in.nextInt();
            while(!isCellFree( boards[value - 1])) {
                System.out.println("Vous devez choisir une position libre");
                value = in.nextInt();
            }
            boards[value - 1] = symbol;
            printBoard(boards);
        } else {
            int value = Integer.parseInt(computerIA(boards));
            boards[value - 1] = symbol;
            printBoard(boards);
        }
        if(gameIsWin(boards, symbol)) {
            System.out.println("Jouer " + symbol + " a gagné");
            return true;
        } else if (!gameIsOver(boards)){
            System.out.println("Match nul !");
            return true;
        }
        return false;
    }

    private static boolean play(String symbol, String[] boards) {
        System.out.println("Joueur " + symbol + " , a vous de jouez ! Choisissez une position :");
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        /*
        while(!cellIsFree( boards[value - 1]))
            if(cellIsFree( boards[value - 1])) {
                System.out.println("Vous devez choisir une position libre");
                value = in.nextInt();
            } else {
                boards[value - 1] = symbol;
                printBoard(boards);
            }

         */
        while(!isCellFree( boards[value - 1])) {
            System.out.println("Vous devez choisir une position libre");
            value = in.nextInt();
        }
        boards[value - 1] = symbol;
        printBoard(boards);
        if(gameIsWin(boards, symbol)) {
            System.out.println("Jouer " + symbol + " a gagné");
            return true;
        } else if (!gameIsOver(boards)) {
            System.out.println("Match nul !");
            return true;
        }
        return false;
    }

    private static boolean isCellFree(String cell) {
        return !cell.equals("X") && !cell.equals("O");
    }

    private static boolean isHorizontalEqual(int beginIndex, String[] boards) {
        boolean result = false;
        int i = 0;
        while (i < 9){
            result = result || boards[i].equals("X") && boards[i + 1].equals("X") && boards[i + 2].equals("X");
            i += 3;
        }
        return result;
    }

    private static boolean gameIsOver(String[] boards) {
        return Arrays.stream(boards).anyMatch(value -> isCellFree(value));
    }
    private static boolean gameIsWin(String[] boards, String symbole) {

        //horizontal
        boolean isHorizontalEqual =
                (boards[0].equals(symbole) && boards[1].equals(symbole) && boards[2].equals(symbole)) ||
                        (boards[3].equals(symbole) && boards[4].equals(symbole) && boards[5].equals(symbole)) ||
                        (boards[6].equals(symbole) && boards[7].equals(symbole) && boards[8].equals(symbole));

        boolean isVerticalEqual =
                (boards[0].equals(symbole) && boards[3].equals(symbole) && boards[6].equals(symbole)) ||
                        (boards[1].equals(symbole) && boards[4].equals(symbole) && boards[7].equals(symbole)) ||
                        (boards[2].equals(symbole) && boards[5].equals(symbole) && boards[8].equals(symbole));

        boolean isDiagonalEqual =
                (boards[0].equals(symbole) && boards[4].equals(symbole) && boards[8].equals(symbole)) ||
                        (boards[2].equals(symbole) && boards[4].equals(symbole) && boards[6].equals(symbole));

        return isHorizontalEqual || isVerticalEqual || isDiagonalEqual;


        /*
        return (boards[0].equals("X") && boards[1].equals("X") && boards[2].equals("X")) ||
                (boards[3].equals("X") && boards[4].equals("X") && boards[5].equals("X")) ||
                (boards[6].equals("X") && boards[7].equals("X") && boards[8].equals("X")) ||
                (boards[0].equals("X") && boards[3].equals("X") && boards[8].equals("X")) ||
                (boards[1].equals("X") && boards[4].equals("X") && boards[7].equals("X")) ||
                (boards[2].equals("X") && boards[5].equals("X") && boards[8].equals("X")) ||
                (boards[0].equals("X") && boards[4].equals("X") && boards[8].equals("X")) ||
                (boards[2].equals("X") && boards[4].equals("X") && boards[6].equals("X")) ||
                (boards[0].equals("O") && boards[1].equals("O") && boards[2].equals("O")) ||
                (boards[3].equals("O") && boards[4].equals("O") && boards[5].equals("O")) ||
                (boards[6].equals("O") && boards[7].equals("O") && boards[8].equals("O")) ||
                (boards[0].equals("O") && boards[3].equals("O") && boards[8].equals("O")) ||
                (boards[1].equals("O") && boards[4].equals("O") && boards[7].equals("O")) ||
                (boards[2].equals("O") && boards[5].equals("O") && boards[8].equals("O")) ||
                (boards[0].equals("O") && boards[4].equals("O") && boards[8].equals("O")) ||
                (boards[2].equals("O") && boards[4].equals("O") && boards[6].equals("O"));
*/


    }

    private static void printBoard(String[] boards) {
        System.out.println(initGrid(3, boards));
    }

    public static String initGrid(int size, String[] boards) {
        String grid = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //sb.append(i * size + j + 1);
                sb.append(boards[i * size + j]);
                if (i * size + j + 1 > 9) {
                    if (j < size - 1) {
                        sb.append("   |");
                        sb.append(" ");
                    }
                } else {
                    if (j < size - 1) {

                        sb.append("    |");
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
            for (int j = 0; j < size; j++) {
                if (j < size - 1) {
                    sb.append("     | ");
                } else {
                    sb.append("     ");
                }

            }
            sb.append("\n");
            for (int j = 0; j < size; j++) {
                if (i < size - 1) {
                    if (j < size - 1) {
                        sb.append("_____|");
                        sb.append("_");
                    } else {
                        sb.append("_____");
                    }
                } else {
                    if (j < size - 1) {
                        sb.append("     |");
                        sb.append(" ");
                    } else {
                        sb.append("      ");
                    }
                }
            }
            sb.append("\n");

            /*sb.append(count).append("    |");
            count++;
            sb.append(" ").append(count).append("   |");
            count++;
            sb.append(" ").append(count).append("    ");
            count++;
            for (int j = 0; j < size; j++) {
                sb.append("\n");
                sb.append("     |     |     ");
                sb.append("\n");
                sb.append("-----|-----|-----|");
                sb.append("\n");
            }*/

        }

        return sb.toString();


//
//        grid += "1    | 2   | 3   ";
//        grid += "\n";
//        grid += "     |     |     ";
//        grid += "\n";
//        grid += "|__________|_____";
//        grid += "\n";
//        grid += "4    | 5   | 6   ";
//        grid += "\n";
//        grid += "     |     |     ";
//        grid += "\n";
//        grid += "_____|_____|_____";
//        grid += "\n";
//        grid += "7    | 8   | 9   ";
//        grid += "\n";
//        grid += "     |     |     ";
//        grid += "\n";
//        grid += "     |     |     ";
    }
}
