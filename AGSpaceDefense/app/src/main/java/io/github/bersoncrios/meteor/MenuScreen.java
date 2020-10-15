package io.github.bersoncrios.meteor;

import io.github.bersoncrios.meteor.AndGraph.AGGameManager;
import io.github.bersoncrios.meteor.AndGraph.AGInputManager;
import io.github.bersoncrios.meteor.AndGraph.AGMusic;
import io.github.bersoncrios.meteor.AndGraph.AGScene;
import io.github.bersoncrios.meteor.AndGraph.AGScreenManager;
import io.github.bersoncrios.meteor.AndGraph.AGSoundManager;
import io.github.bersoncrios.meteor.AndGraph.AGSprite;

/**
 * Created by Berson on 20/11/2017.
 */

public class MenuScreen extends AGScene {


    AGSprite btnIniciar = null;
    AGSprite btnAjuda = null;
    AGSprite btnSobre = null;

    AGSprite SomOn = null;
    AGSprite SomOff = null;
    AGSprite fundoMenu = null;

    int contaMeteoros = 0;

    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    public MenuScreen(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {

        /*Colocando as imagens na variável, imagem esta que está em res/mipmap/mdpi*/
        fundoMenu = this.createSprite(R.mipmap.menu,1,1);

        btnIniciar = this.createSprite(R.mipmap.play, 1, 1);
        btnAjuda = this.createSprite(R.mipmap.help, 1, 1);
        btnSobre = this.createSprite(R.mipmap.about, 1, 1);

        SomOff = this.createSprite(R.mipmap.volumeoff, 1, 1);
        SomOn = this.createSprite(R.mipmap.volumeon, 1, 1);

        /*Setando a porcentagem que aquela imagem ocupa na tela*/
        fundoMenu.setScreenPercent(100,100);

        btnIniciar.setScreenPercent(60,15);
        btnAjuda.setScreenPercent(60, 15);
        btnSobre.setScreenPercent(60, 15);

        SomOff.setScreenPercent(11, 8);
        SomOn.setScreenPercent(11, 8);


        /*Setando a posição onde aquela imagem ficará*/
        fundoMenu.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight/2);

       /* btnIniciar.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, btnIniciar.vrPosition.getY() + 700);
        btnAjuda.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, btnAjuda.vrPosition.getY() + 500);
        btnSobre.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, btnSobre.vrPosition.getY() + 300);*/

        btnIniciar.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight*0.5f);
        btnAjuda.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight*0.3f);
        btnSobre.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight*0.1f);


        btnIniciar.fadeIn(600);
        btnAjuda.fadeIn(800);
        btnSobre.fadeIn(1000);
       /* SomOff.vrPosition.setXY(SomOff.vrPosition.getX() + 600, SomOff.vrPosition.getY() + 1200);
        SomOn.vrPosition.setXY(SomOn.vrPosition.getX() + 500, SomOn.vrPosition.getY() + 1200);*/


           SomOff.vrPosition.setXY(AGScreenManager.iScreenWidth*0.83f, AGScreenManager.iScreenHeight * 0.95f);
           SomOn.vrPosition.setXY(AGScreenManager.iScreenWidth*0.70f, AGScreenManager.iScreenHeight * 0.95f);



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
        if (AGInputManager.vrTouchEvents.screenClicked()) {
            if (btnAjuda.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                this.vrGameManager.setCurrentScene(2);
                return;
            }

            if (btnSobre.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                this.vrGameManager.setCurrentScene(3);
                return;
            }

            if (btnIniciar.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                this.vrGameManager.setCurrentScene(4);
                return;
            }

                if (SomOff.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                    AGSoundManager.vrMusic.stop();
                }

                if (SomOn.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                    AGSoundManager.vrMusic.loadMusic("trilhaSonora.mp3", true);
                    AGSoundManager.vrMusic.play();
                }

        }
    }
}
