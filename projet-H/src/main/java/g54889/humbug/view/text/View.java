package g54889.humbug.view.text;

import g54889.humbug.model.Animal;
import g54889.humbug.model.Board;
import g54889.humbug.model.Bumbelbee;
import g54889.humbug.model.Butterfly;
import g54889.humbug.model.Direction;
import g54889.humbug.model.Grasshopper;
import g54889.humbug.model.Ladybird;
import g54889.humbug.model.Position;
import g54889.humbug.model.Snail;
import g54889.humbug.model.Spider;
import g54889.humbug.model.SquareType;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author younes
 */
public class View implements InterfaceView {

    /**
     *  the board of levels and animals
     * @param board
     * @param animals
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {

        String vue[][] = new String[board.getNbRow() * 3][board.getNbColumn()];

        for (int i = 0; i < board.getNbRow(); i++) {
            for (int j = 0; j < board.getNbColumn(); j++) {
                Position p = new Position(i, j);
                if (!board.isInside(p)) {
                    for (int k = 0; k < 3; k++) {
                        vue[(i * 3) + k][j] = TerminalColor.DEFAULT + "         ";

                    }
                } else {
                    if (board.getSquareType(p) == SquareType.GRASS) {
                        if (board.getSquares()[i][j].hasWall(Direction.NORTH)) {
                            vue[i * 3][j] = TerminalColor.BG_LIGHT_GREY + "| " + TerminalColor.RED + "----- " + TerminalColor.BLACK + "|" + TerminalColor.DEFAULT;
                        } else {
                            vue[i * 3][j] = TerminalColor.BG_GREEN + "|       |" + TerminalColor.DEFAULT;
                        }
                        if (board.getSquares()[i][j].hasWall(Direction.SOUTH)) {
                            vue[(i * 3) + 2][j] = TerminalColor.BG_LIGHT_GREY + "| " + TerminalColor.RED + "----- " + TerminalColor.BLACK + "|" + TerminalColor.DEFAULT;
                        } else {
                            vue[(i * 3) + 2][j] = TerminalColor.BG_GREEN + "|       |" + TerminalColor.DEFAULT;
                        }
                        if (!board.getSquares()[i][j].hasWall(Direction.WEST) && (!board.getSquares()[i][j].hasWall(Direction.EAST))) {
                            vue[(i * 3) + 1][j] = TerminalColor.BG_GREEN + "|       |" + TerminalColor.DEFAULT;
                        } else if (board.getSquares()[i][j].hasWall(Direction.EAST)) {
                            vue[(i * 3) + 1][j] = TerminalColor.BG_GREEN + "|      " + TerminalColor.RED + "I" + TerminalColor.BLACK + "|" + TerminalColor.DEFAULT;
                        } else if (board.getSquares()[i][j].hasWall(Direction.WEST)) {
                            vue[(i * 3) + 1][j] = TerminalColor.BG_GREEN + "|" + TerminalColor.RED + "I" + TerminalColor.BLACK + "      " + TerminalColor.BLACK + "|" + TerminalColor.DEFAULT;
                        } else if (board.getSquares()[i][j].hasWall(Direction.WEST) && (board.getSquares()[i][j].hasWall(Direction.EAST))) {
                            vue[(i * 3) + 1][j] = TerminalColor.BG_GREEN + "|" + TerminalColor.RED + "I" + TerminalColor.BLACK + "      " + TerminalColor.RED + "I" + TerminalColor.BLACK + "|" + TerminalColor.DEFAULT;
                        }
                    } else if (board.getSquareType(p) == SquareType.STAR) {
                        if (board.getSquares()[i][j].hasWall(Direction.NORTH)) {
                            vue[i * 3][j] = TerminalColor.BG_LIGHT_GREY + "| " + TerminalColor.RED + "----- " + TerminalColor.BLACK + "|" + TerminalColor.DEFAULT;
                        } else {
                            vue[i * 3][j] = TerminalColor.BG_GREEN + "|       |" + TerminalColor.DEFAULT;
                        }
                        if (board.getSquares()[i][j].hasWall(Direction.SOUTH)) {
                            vue[(i * 3) + 2][j] = TerminalColor.BG_LIGHT_GREY + "| " + TerminalColor.RED + "----- " + TerminalColor.BLACK + "|" + TerminalColor.DEFAULT;
                        } else {
                            vue[(i * 3) + 2][j] = TerminalColor.BG_GREEN + "|       |" + TerminalColor.DEFAULT;
                        }
                        if (!board.getSquares()[i][j].hasWall(Direction.WEST) && (!board.getSquares()[i][j].hasWall(Direction.EAST))) {
                            vue[(i * 3) + 1][j] = TerminalColor.BG_YELLOW_FG_WHITE + "|  " + TerminalColor.YELLOW + " *" + TerminalColor.BLACK + "   |" + TerminalColor.DEFAULT;
                        } else if (board.getSquares()[i][j].hasWall(Direction.WEST)) {
                            vue[(i * 3) + 1][j] = TerminalColor.BG_YELLOW_FG_WHITE + "|" + TerminalColor.RED + "I" + TerminalColor.YELLOW + "  *" + TerminalColor.BLACK + "   |" + TerminalColor.DEFAULT;

                        } else if (board.getSquares()[i][j].hasWall(Direction.EAST)) {
                            vue[(i * 3) + 1][j] = TerminalColor.BG_YELLOW_FG_WHITE + "|   " + TerminalColor.YELLOW + "*  " + TerminalColor.RED + "I" + TerminalColor.BLACK + "|" + TerminalColor.DEFAULT;
                        } else if (board.getSquares()[i][j].hasWall(Direction.WEST) && (board.getSquares()[i][j].hasWall(Direction.EAST))) {
                            vue[(i * 3) + 1][j] = TerminalColor.BG_GREEN + "|" + TerminalColor.RED + "I" + TerminalColor.BLACK + "     " + TerminalColor.RED + "I" + TerminalColor.BLACK + "|" + TerminalColor.DEFAULT;
                        }

                    }
                }

            }

        }

        for (int i = 0; i < animals.length; i++) {
            if (!animals[i].isOnStar()) {
                int place = 9;
                char[] tab = vue[(animals[i].getPositionOnBoard().getRow() * 3) + 1][animals[i].getPositionOnBoard().getColumn()].toCharArray();
                if (board.getSquares()[animals[i].getPositionOnBoard().getRow()][animals[i].getPositionOnBoard().getColumn()].hasWall(Direction.WEST)) {
                    place = 19;
                }
                if (animals[i] instanceof Snail) {
                    tab[place] = '@';
                    vue[(animals[i].getPositionOnBoard().getRow() * 3) + 1][animals[i].getPositionOnBoard().getColumn()] = String.valueOf(tab);
                } else if (animals[i] instanceof Spider) {
                    tab[place] = 'S';
                    vue[(animals[i].getPositionOnBoard().getRow() * 3) + 1][animals[i].getPositionOnBoard().getColumn()] = String.valueOf(tab);

                } else if (animals[i] instanceof Grasshopper) {
                    tab[place] = 'G';
                    vue[(animals[i].getPositionOnBoard().getRow() * 3) + 1][animals[i].getPositionOnBoard().getColumn()] = String.valueOf(tab);

                } else if (animals[i] instanceof Bumbelbee) {
                    tab[place] = 'B';
                    vue[(animals[i].getPositionOnBoard().getRow() * 3) + 1][animals[i].getPositionOnBoard().getColumn()] = String.valueOf(tab);

                } else if (animals[i] instanceof Butterfly) {
                    tab[place] = 'F';
                    vue[(animals[i].getPositionOnBoard().getRow() * 3) + 1][animals[i].getPositionOnBoard().getColumn()] = String.valueOf(tab);

                } else if (animals[i] instanceof Ladybird) {
                    tab[place] = 'L';
                    vue[(animals[i].getPositionOnBoard().getRow() * 3) + 1][animals[i].getPositionOnBoard().getColumn()] = String.valueOf(tab);

                }
            }

        }

        for (int i = 0; i < vue.length; i++) {
            for (int j = 0; j < vue[i].length; j++) {
                System.out.print(vue[i][j]);
            }
            System.out.println("");

        }

    }

    /**
     *
     *  
     * @param message
     */
    @Override
    public void displayError(String message) {

        System.out.println("Erreur : " + message);

    }

    /**
     * methode hoe ask the user to set two values and returns the position
     *
     * @return the position
     */
    @Override
    public Position askPosition() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("mettez une possition");
        int row = 0;
        int column = 0;
        while (!clavier.hasNextInt()) {
            System.out.println("veuillez entrez un nombre entier positif");
            clavier.next();
        }
        row = clavier.nextInt();

        while (!clavier.hasNextInt()) {
            System.out.println("veuillez entrez un nombre entier");
            clavier.next();
        }
        column = clavier.nextInt();

        return new Position(row, column);
    }

    /**
     * methode hoe ask the user to set value and returns the direction
     *
     * @return the direction
     */
    @Override
    public Direction askDirection() {

        Scanner clavier = new Scanner(System.in);

        System.out.println("Choisissez une direction [NORTH (N); SOUTH (S) ; EAST (E) ; WEST (W)");

        char choix = clavier.next().charAt(0);

        while (choix != 'N' && choix != 'S' && choix != 'E' && choix != 'W') {
            System.out.println("Entrez une direction valide");
            choix = clavier.next().charAt(0);
        }

        switch (choix) {
            case 'N':
                return Direction.NORTH;
            case 'S':
                return Direction.SOUTH;
            case 'E':
                return Direction.EAST;
            case 'W':
                return Direction.WEST;
        }
        throw new IllegalArgumentException("La direction n'existe pas");
    }
/**
 *  shows how much movement is left
 * 
 * @param nMoves 
 */
    @Override
    public void displayRemainingMoves(int nMoves) {

        System.out.println("il vous reste : " + nMoves + " deplacements");

    }
}
