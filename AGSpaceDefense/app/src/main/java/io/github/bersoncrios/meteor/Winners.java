package io.github.bersoncrios.meteor;

import io.github.bersoncrios.meteor.AndGraph.AGGameManager;
import io.github.bersoncrios.meteor.AndGraph.AGInputManager;
import io.github.bersoncrios.meteor.AndGraph.AGScene;
import io.github.bersoncrios.meteor.AndGraph.AGScreenManager;
import io.github.bersoncrios.meteor.AndGraph.AGSprite;

/**
 * Created by Berson on 07/12/2017.
 */

public class Winners extends AGScene {
    AGSprite winfundo = null;
    AGSprite winMsgn = null;
    AGSprite voltar = null;
    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    public Winners(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {

         /*Colocando o plano de fundo da tela*/
        winfundo = this.createSprite(R.mipmap.win_fundo,1,1);
        winfundo.setScreenPercent(100,100);
        winfundo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

        /*Inserindo a imagem que diz game over, seno que ela aparece com um fadeIn de 5 segundos*/
        winMsgn = this.createSprite(R.mipmap.win,1,1);
        winMsgn.fadeIn(5000);
        winMsgn.setScreenPercent(50,20);
        winMsgn.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

        /*Imagem do botão de voltar*/
        voltar = this.createSprite(R.mipmap.voltar, 1, 1);
        voltar.setScreenPercent(11, 8);
        voltar.vrPosition.setXY(voltar.vrPosition.getX() + 600, voltar.vrPosition.getY() + 100);



        setSceneBackgroundColor(0.3f, 0.3f, 0.7f);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
                /*Se o botão de volrar for clicado ira voltar para a cena 1, ou seja, menu*/
        if (AGInputManager.vrTouchEvents.screenClicked()) {
            if (voltar.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                this.vrGameManager.setCurrentScene(1);
                return;
            }
        }
    }
}
