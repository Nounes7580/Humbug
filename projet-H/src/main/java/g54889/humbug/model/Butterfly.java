/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54889.humbug.model;

/**
 *
 * @author youne
 */
public class Butterfly extends Animal {

    /**
     *
     * @param positionOnBoard
     */
    public Butterfly(Position positionOnBoard) {

        super(positionOnBoard);
    }

    /**
     * flies three squares and bounces on the animals on arrival.
     *
     * @param board
     * @param direction
     * @param animals
     * @return
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position position = super.getPositionOnBoard().next(direction).next(direction).next(direction);

        while (!Free(position, animals)) {
            position = position.next(direction);

        }
        if (board.isInside(position)) {

            super.caseIsOnStar(board, position);
            return position;
        } else {
            return null;
        }

    }

    public Butterfly() {
        super();
    }

}
