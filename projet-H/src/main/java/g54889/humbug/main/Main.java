
package g54889.humbug.main;

import g54889.humbug.controller.Controller;
import g54889.humbug.model.Game;
import g54889.humbug.view.text.View;

/**
 *
 * @author younes
 */
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame(1);
    }
}
