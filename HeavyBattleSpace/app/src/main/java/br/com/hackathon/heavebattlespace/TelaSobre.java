package br.com.hackathon.heavebattlespace;

import br.com.hackathon.heavebattlespace.AndGraph.AGGameManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGInputManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGScene;
import br.com.hackathon.heavebattlespace.AndGraph.AGScreenManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGSoundManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGSprite;
import br.com.hackathon.heavebattlespace.AndGraph.AGTimer;

public class TelaSobre extends AGScene {
    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/

    public TelaSobre(AGGameManager pManager) {
        super(pManager);
    }
    AGSprite cenario = null;
    AGSprite voltar = null;

    @Override
    public void init() {
        cenario = this.createSprite(R.mipmap.sobre,1,1);
        cenario.setScreenPercent(100,100);
        cenario.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight/2);

        AGSoundManager.vrMusic.loadMusic("trilha1.mp3",true);
        AGSoundManager.vrMusic.play();

        voltar = this.createSprite(R.mipmap.voltar, 1, 1);
        voltar.setScreenPercent(12, 7);
        voltar.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.1f, AGScreenManager.iScreenHeight * 0.92f);

        setSceneBackgroundColor(0,0,0);
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
