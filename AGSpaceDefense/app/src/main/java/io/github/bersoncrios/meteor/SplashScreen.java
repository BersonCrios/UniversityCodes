package io.github.bersoncrios.meteor;

import io.github.bersoncrios.meteor.AndGraph.AGGameManager;
import io.github.bersoncrios.meteor.AndGraph.AGScene;
import io.github.bersoncrios.meteor.AndGraph.AGScreenManager;
import io.github.bersoncrios.meteor.AndGraph.AGSoundEffect;
import io.github.bersoncrios.meteor.AndGraph.AGSoundManager;
import io.github.bersoncrios.meteor.AndGraph.AGSprite;
import io.github.bersoncrios.meteor.AndGraph.AGTimer;

/**
 * Created by Berson on 20/11/2017 .
 */

public class SplashScreen extends AGScene {
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
    public SplashScreen(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {
        //instânciando o objeto tempo, com 5 segundo(5000ms)
        tempo = new AGTimer(4000);
        tela = this.createSprite(R.mipmap.splash,1,1);

        tela.setScreenPercent(100,100);

        tela.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight/2);

        AGSoundManager.vrMusic.loadMusic("trilhaSonora.mp3",true);

        AGSoundManager.vrMusic.play();

        //Mudando temporáriamente a cor do fundo para verde
        setSceneBackgroundColor(0,1,0);
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
