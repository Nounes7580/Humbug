/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54889.humbug.controller;

import g54889.humbug.model.LevelStatus;
import g54889.humbug.model.Model;
import g54889.humbug.view.text.InterfaceView;

/**
 *
 * @author youne
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;

    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }
/**
 * 
 * @param level 
 */
    public void startGame(int level) {

        game.startLevel(level);
        while (game.getLevelStatus() == LevelStatus.IN_PROGRESS) {

            view.displayBoard(game.getBoard(), game.getAnimals());
            view.displayRemainingMoves(game.getRemainingMoves());
            try {
                game.move(view.askPosition(), view.askDirection());
            } catch (NullPointerException pointeur) {
                view.displayError(pointeur.getMessage());
                
            }
            if (game.getLevelStatus() == LevelStatus.WIN) {
                game.incrémenteLevel();
                game.startLevel(game.getCurrentLevel());
            } else if (game.getLevelStatus() == LevelStatus.FAIL) {
                game.startLevel(game.getCurrentLevel());
            }
        }
    }
}
