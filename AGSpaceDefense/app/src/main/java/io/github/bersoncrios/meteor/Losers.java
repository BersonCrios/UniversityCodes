package io.github.bersoncrios.meteor;

import io.github.bersoncrios.meteor.AndGraph.AGGameManager;
import io.github.bersoncrios.meteor.AndGraph.AGInputManager;
import io.github.bersoncrios.meteor.AndGraph.AGScene;
import io.github.bersoncrios.meteor.AndGraph.AGScreenManager;
import io.github.bersoncrios.meteor.AndGraph.AGSprite;

/**
 * Created by Berson on 07/12/2017.
 */

public class Losers extends AGScene {
    AGSprite gameoverfundo = null;
    AGSprite gameoverMsgn = null;
    AGSprite voltar = null;

    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    public Losers(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {

        /*Colocando o plano de fundo da tela*/
        gameoverfundo = this.createSprite(R.mipmap.fundo_game_over,1,1);
        gameoverfundo.setScreenPercent(100,100);
        gameoverfundo.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

        /*Inserindo a imagem que diz game over, seno que ela aparece com um fadeIn de 5 segundos*/
        gameoverMsgn = this.createSprite(R.mipmap.gameover,1,1);
        gameoverMsgn.fadeIn(5000);
        gameoverMsgn.setScreenPercent(50,20);
        gameoverMsgn.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

        /*Imagem do botão de voltar*/
        voltar = this.createSprite(R.mipmap.voltar, 1, 1);
        voltar.setScreenPercent(11, 8);
        voltar.vrPosition.setXY(voltar.vrPosition.getX() + 600, voltar.vrPosition.getY() + 100);


        //Mudando temporáriamente a cor do fundo para Azul
        setSceneBackgroundColor(1,0,0);
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
