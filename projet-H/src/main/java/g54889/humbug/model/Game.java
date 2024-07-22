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
public class Game implements Model {

    public Board board;
    public Animal[] animals;
    public int remainingMoves;
    public int currentLevel;

    /**
     *
     * return bord
     *
     * @return one instance of Board
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     *
     * @return one instance of Animal
     */
    @Override
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     *
     * 
     * @param level
     */
    @Override
    public void startLevel(int level) {
        this.currentLevel = level;
        Level theLevel = Level.getLevel(this.currentLevel);
        this.animals = theLevel.getAnimal();
        this.board = theLevel.getBoard();
        this.remainingMoves = theLevel.getnMoves();
    }

    /**
     * @return true if animal is on Star, if not false
     *
     */
    private boolean levelIsOver() {

        for (Animal animal : animals) {

            if (!animal.isOnStar()) {
                return false;
            }
        }
        return true;
    }

    /**
     * allows the displacement of animal
     *
     * @param position
     * @param direction
     */
    @Override
    public void move(Position position, Direction direction) {

        
        
        Position pos = animals[select(position)].move(board, direction, animals);

        if (pos != null) {
            animals[select(position)].setPositionOnBoard(pos);
        } else {
            System.out.println("oups tu es tombé copain ");
        }
        this.remainingMoves--;
    }

    /**
     *
     * @param position
     * @return position of the animal selected on array animals
     */
    private int select(Position position) {

        for (int i = 0; i < this.animals.length; i++) {

            if (position.equals(animals[i].getPositionOnBoard())) {
                return i;
            }

        }

        throw new NullPointerException("il n'y a pas d'animaux :/");
    }
/**
 * 
 * @return remainigMoves
 */
    @Override
    public int getRemainingMoves() {
        return this.remainingMoves;
    }
/**
 * 
 * return the status of level 
 * 
 * @return LevelStatus.NOT_STARTED if the the level hasn't started yet 
 *  return LevelStatus.WIN if the level is over 
 *  return LevelStatus.IN_PROGRESS if the level is in progress otherwise return LevelSatus.FAIL if the player loses 
 * 
 */
    @Override
    public LevelStatus getLevelStatus() {
        if (this.board == null || this.animals == null) {
            return LevelStatus.NOT_STARTED;
        }
        if (this.levelIsOver()) {
            return LevelStatus.WIN;
        } else {
            if (this.remainingMoves > 0) {
                return LevelStatus.IN_PROGRESS;
            } else {
                return LevelStatus.FAIL;
            }
        }
    }
/**
 * 
 */
    @Override
    public void incrémenteLevel() {
        if (this.currentLevel <= 39) {
            this.currentLevel++;
        } else if (this.currentLevel == 40) {
            this.currentLevel = 100;
        }
    }
/**
 * 
 * @return currentLevel
 */
    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

}
