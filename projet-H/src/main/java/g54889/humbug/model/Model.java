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
public interface Model {

    Board getBoard();

    Animal[] getAnimals();

    int getRemainingMoves();

    void startLevel(int level);

    LevelStatus getLevelStatus();

    void move(Position position, Direction direction);

    public void incrémenteLevel();

    public int getCurrentLevel();
}
