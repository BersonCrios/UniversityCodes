package br.com.hackathon.heavebattlespace;

import br.com.hackathon.heavebattlespace.AndGraph.AGGameManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGScene;
import br.com.hackathon.heavebattlespace.AndGraph.AGScreenManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGSoundManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGSprite;
import br.com.hackathon.heavebattlespace.AndGraph.AGTimer;

public class TelaSplash extends AGScene {
    //Declaração da variávle tempo, do tipo AGTime;
    AGTimer tempo = null;
    AGSprite tela = null;
    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    public TelaSplash(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {
        tempo = new AGTimer(4000);
        tela = this.createSprite(R.mipmap.splash,1,1);

        tela.setScreenPercent(100,100);

        tela.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight/2);

        AGSoundManager.vrMusic.loadMusic("trilha1.mp3",true);

        AGSoundManager.vrMusic.play();

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
        tempo.update();
        if (tempo.isTimeEnded()){
            this.vrGameManager.setCurrentScene(1);
        }
    }
}