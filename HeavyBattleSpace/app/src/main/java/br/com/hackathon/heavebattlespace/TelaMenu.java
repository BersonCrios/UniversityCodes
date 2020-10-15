package br.com.hackathon.heavebattlespace;

import br.com.hackathon.heavebattlespace.AndGraph.AGGameManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGInputManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGScene;
import br.com.hackathon.heavebattlespace.AndGraph.AGScreenManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGSoundManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGSprite;

public class TelaMenu extends AGScene {


    AGSprite btnIniciar = null;
    AGSprite btnAjuda = null;
    AGSprite btnSobre = null;

    AGSprite fundoMenu = null;

    AGSprite SomOn = null;
    AGSprite SomOff = null;

    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    public TelaMenu(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {

        fundoMenu = this.createSprite(R.mipmap.menu,1,1);

        btnIniciar = this.createSprite(R.mipmap.jagar, 1, 1);
        btnSobre = this.createSprite(R.mipmap.btnsobre, 1, 1);
        btnAjuda = this.createSprite(R.mipmap.btnajuda, 1, 1);

        SomOff = this.createSprite(R.mipmap.semsom, 1, 1);
        SomOn = this.createSprite(R.mipmap.comsom, 1, 1);

        fundoMenu.setScreenPercent(100,100);

        btnIniciar.setScreenPercent(60,12);
        btnSobre.setScreenPercent(60, 12);
        btnAjuda.setScreenPercent(60, 12);
        SomOff.setScreenPercent(11, 6);
        SomOn.setScreenPercent(11, 6);

        fundoMenu.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight/2);

        btnIniciar.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight*0.47f);
        btnSobre.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight*0.35f);
        btnAjuda.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight*0.23f);

        btnIniciar.fadeIn(600);
        btnSobre.fadeIn(1000);
        btnAjuda.fadeIn(800);

        SomOff.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.9f, AGScreenManager.iScreenHeight * 0.95f);
        SomOn.vrPosition.setXY(AGScreenManager.iScreenWidth * 0.75f, AGScreenManager.iScreenHeight * 0.95f);

        AGSoundManager.vrMusic.loadMusic("trilha1.mp3",true);
        AGSoundManager.vrMusic.play();

        setSceneBackgroundColor(0, 0, 0);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        if (btnSobre.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
            this.vrGameManager.setCurrentScene(2);
            return;
        }

        if (AGInputManager.vrTouchEvents.screenClicked()) {
            if (btnAjuda.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
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
                AGSoundManager.vrMusic.loadMusic("trilha1.mp3", true);
                AGSoundManager.vrMusic.play();
            }
        }
    }
}
