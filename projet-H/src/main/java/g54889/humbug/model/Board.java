/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54889.humbug.model;

import static g54889.humbug.model.SquareType.GRASS;
import static g54889.humbug.model.SquareType.STAR;

/**
 *
 * @author younes
 */
public class Board {

    private Square[][] squares;

    public Board() {

    }

    /**
     *
     *
     * @param square
     */
    public Board(Square[][] square) {
        this.squares = square;
    }

    /**
     *
     *
     * @return squares
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     *
     * verifie if the position is inside
     *
     * @param p
     * @return boolean if the position is inside de board, if not false it's not
     * inside
     */
    public boolean isInside(Position p) {

        if (p == null) {
            throw new IllegalArgumentException("vous êtes en dehors du jeu");

        }
        return !(p.getRow() < 0
                || p.getColumn() < 0
                || p.getRow() >= getNbRow()
                || p.getColumn() >= getNbColumn() || squares[p.getRow()][p.getColumn()] == null); //ordre du if (attention a l'ordre des condition

    }

    /**
     *
     * show the type of the square
     *
     * @param p (positon)
     * @return the type of the square,if it is not the case it displays a
     * IllegalArgument
     */
    public SquareType getSquareType(Position p) {

        if (squares[p.getRow()][p.getColumn()] == null) {

            throw new IllegalArgumentException("parametre null");
        }

        return squares[p.getRow()][p.getColumn()].getType();

    }

    /**
     *
     *
     * @return the number of Row
     */
    public int getNbRow() {

        return squares.length;

    }

    /**
     *
     *
     * @return the number of Colulmn
     */
    public int getNbColumn() {

        return squares[0].length;
    }

}
