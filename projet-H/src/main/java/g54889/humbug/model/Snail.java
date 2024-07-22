/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54889.humbug.model;

/**
 *
 * @author younes
 */
public class Snail extends Animal {

    /**
     *
     * @param positionOnBoard
     */
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    public Snail() {
        super();
    }

    /**
     *
     * methode who verifie the position and modifies the star into grass if
     * animal is at the star position
     *
     * @param board
     * @param direction
     * @param animals
     * @return null if position isn't inside ifnot return position
     *
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {

        Position position = super.getPositionOnBoard();

        if (Walls(board, position, direction)) {
            return super.getPositionOnBoard();
        }

        if (!board.isInside(position.next(direction))) {
            return null;
        }
        if (!super.Free(position.next(direction), animals)) {
            return position;
        }
        super.caseIsOnStar(board, position.next(direction));
        return position.next(direction);
    }

}
