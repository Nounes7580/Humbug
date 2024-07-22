/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54889.humbug.model;

public class Bumbelbee extends Animal {

    /**
     *
     * @param positionOnBoard
     */
    public Bumbelbee(Position positionOnBoard) {

        super(positionOnBoard);
    }

    /**
     * flies two squares even above the void. If the is busy, it stops at the
     * next one.
     *
     * @param board
     * @param direction
     * @param animals
     * @return
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position position = super.getPositionOnBoard().next(direction).next(direction);

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

    public Bumbelbee() {
        super();
    }
}
