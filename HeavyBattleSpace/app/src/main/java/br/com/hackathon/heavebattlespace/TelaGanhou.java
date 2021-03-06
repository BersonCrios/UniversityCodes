package br.com.hackathon.heavebattlespace;

import br.com.hackathon.heavebattlespace.AndGraph.AGGameManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGInputManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGScene;
import br.com.hackathon.heavebattlespace.AndGraph.AGScreenManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGSoundManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGSprite;

public class TelaGanhou extends AGScene {

    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    AGSprite cenario = null;
    AGSprite voltar = null;

    public TelaGanhou(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {
        cenario = this.createSprite(R.mipmap.venceu, 1, 1);
        cenario.setScreenPercent(100, 100);
        cenario.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

        AGSoundManager.vrMusic.loadMusic("winner.mp3",false);
        AGSoundManager.vrMusic.play();

        voltar = this.createSprite(R.mipmap.voltar, 1, 1);
        voltar.setScreenPercent(12, 7);
        voltar.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.1f, AGScreenManager.iScreenHeight * 0.92f);

        setSceneBackgroundColor(0,1,1);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        voltar();
    }

    public void voltar() {
        if (AGInputManager.vrTouchEvents.backButtonClicked()) {
            this.vrGameManager.setCurrentScene(1);
            return;
        }
        if (voltar.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
            this.vrGameManager.setCurrentScene(1);
            return;
        }
    }
}
