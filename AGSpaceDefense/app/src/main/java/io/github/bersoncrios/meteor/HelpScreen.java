package io.github.bersoncrios.meteor;

import io.github.bersoncrios.meteor.AndGraph.AGGameManager;
import io.github.bersoncrios.meteor.AndGraph.AGInputManager;
import io.github.bersoncrios.meteor.AndGraph.AGScene;
import io.github.bersoncrios.meteor.AndGraph.AGScreenManager;
import io.github.bersoncrios.meteor.AndGraph.AGSprite;

/**
 * Created by Berson on 20/11/2017.
 */

public class HelpScreen extends AGScene {

    AGSprite voltar = null;
    AGSprite tela = null;

    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    public HelpScreen(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {
        tela = this.createSprite(R.mipmap.ajuda, 1, 1);

        tela.setScreenPercent(100, 100);

        tela.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        if (AGInputManager.vrTouchEvents.bBackButtonClicked){
            this.vrGameManager.setCurrentScene(1);
        }
    }
}
