package br.com.hackathon.heavebattlespace;

import java.util.ArrayList;

import br.com.hackathon.heavebattlespace.AndGraph.AGGameManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGInputManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGScene;
import br.com.hackathon.heavebattlespace.AndGraph.AGScreenManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGSoundManager;
import br.com.hackathon.heavebattlespace.AndGraph.AGSprite;
import br.com.hackathon.heavebattlespace.AndGraph.AGTimer;

public class TelaGame2 extends AGScene {
    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/

    AGSprite cenario = null;
    AGSprite jogador = null;

    int contaMeteoros = 0;
    int contaMeteorosPassados = 0;

    AGSprite meteoro = null;


    ArrayList<AGSprite> listaMeteoros = null;
    ArrayList<AGSprite> listaMisseis = null;


    AGTimer tempoReciclagem = null;
    AGTimer tempoGeraMeteoro = null;
    AGTimer tempoTiro = null;
    AGTimer tempoPerdeu = null;
    AGTimer tempoDeJogo = null;

    int tiroEfeito = 0;

    public TelaGame2(AGGameManager pManager) {
        super(pManager);
    }
    @Override
    public void init() {
        cenario = this.createSprite(R.mipmap.cenario2, 1, 1);
        jogador = this.createSprite(R.mipmap.player1, 1, 1);

        cenario.setScreenPercent(100, 100);
        jogador.setScreenPercent(20, 12);

        listaMeteoros = new ArrayList<AGSprite>();
        listaMisseis = new ArrayList<AGSprite>();

        cenario.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
        jogador.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight*0.07f);

        int randomgeraMeteoro = 1000 + (int)(Math.random() * (2000 - 1000));

        tempoTiro = new AGTimer(400);
        tempoReciclagem = new AGTimer(1000);
        tempoGeraMeteoro = new AGTimer(randomgeraMeteoro);
        tempoPerdeu = new AGTimer(800);
        tempoDeJogo = new AGTimer(60000);

        tiroEfeito = AGSoundManager.vrSoundEffects.loadSoundEffect("tiro3.wav");

        createSprite(R.mipmap.tiro1, 1, 1).bVisible = false;

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
        geraMeteoro();
        atualizaMeteoro();
        geraTiro();
        atualizaTiro();
        tiroAcerta();
        explode();
        contandoMeteorosPassados();
        moveNave();
        travaLaterais();
        proximaFase();
        perdeu();
    }


    public void moveNave() {
        jogador.vrPosition.setX(jogador.vrPosition.getX() + AGInputManager.vrAccelerometer.getAccelX()*9);
    }

    public void geraMeteoro (){
        tempoGeraMeteoro.update();
        for (AGSprite meteorRecycled : listaMeteoros) {
            if (meteorRecycled.bRecycled && meteorRecycled.bVisible) {
                meteorRecycled.vrPosition.setXY(100 + (int) (Math.random() * (AGScreenManager.iScreenWidth - 100)),
                        AGScreenManager.iScreenHeight);
                meteorRecycled.bRecycled = false;
                return;
            }
        }
        if (tempoGeraMeteoro.isTimeEnded()) {
            meteoro = createSprite(R.mipmap.inimigolvl2, 1, 1);
            meteoro.setScreenPercent(13, 9);
            meteoro.vrPosition.setXY(100 + (int) (Math.random() * (AGScreenManager.iScreenWidth - 100)),
                    AGScreenManager.iScreenHeight);
            meteoro.bRecycled = false;
            listaMeteoros.add(meteoro);
            tempoGeraMeteoro.restart();
        }
    }

    public void atualizaMeteoro(){
        int randomNum = 0 + (int)(Math.random() * (15 - 0));
        for (AGSprite meteor:listaMeteoros){
            meteor.vrPosition.setY(meteor.vrPosition.getY() -7);
            meteor.fAngle += randomNum;
            if (meteor.vrPosition.getY() < 0){
                meteor.bRecycled = true;
            }
        }
    }

    public int contandoMeteorosPassados(){
        for (AGSprite meteor:listaMeteoros){
            if (meteor.vrPosition.getY() < 0 && meteor.bVisible == true){
                contaMeteorosPassados++;
            }
        }
        return contaMeteorosPassados;
    }


    public void explode() {
        for (AGSprite m : listaMeteoros) {
            if (m.collide(jogador) && m.bVisible){
                jogador.bVisible = false;
                m.bVisible = false;
                return;
            }
        }
    }

    public void proximaFase(){
        if (contaMeteoros == 30){
            contaMeteoros = 0;
            this.vrGameManager.setCurrentScene(6);
            return;
        }
    }

    public void perdeu(){
        if (contaMeteorosPassados == 3 || !jogador.bVisible){
            contaMeteorosPassados = 0;
            this.vrGameManager.setCurrentScene(8);
            return;
        }
    }

    public int tiroAcerta() {
        for (AGSprite m : listaMeteoros) {
            for (AGSprite t : listaMisseis) {
                if (t.collide(m) && t.bVisible && m.bVisible) {
                    contaMeteoros++;
                    m.bVisible = false;
                    t.bVisible = false;
                }
            }
        }
        return contaMeteoros;
    }


    public void geraTiro(){

        tempoTiro.update();

        if (!tempoTiro.isTimeEnded())
            return;

        if (AGInputManager.vrTouchEvents.screenClicked()){
            for (AGSprite misselRecycled : listaMisseis) {
                if (misselRecycled.bRecycled && misselRecycled.bVisible) {
                    misselRecycled.vrPosition.setXY(jogador.vrPosition.getX(),
                            jogador.vrPosition.getY() + jogador.getSpriteHeight()/2 + misselRecycled.getSpriteHeight() / 2);
                    AGSoundManager.vrSoundEffects.play(tiroEfeito);
                    misselRecycled.bRecycled = false;
                    tempoTiro.restart();
                    return;
                }
            }
            AGSprite missel = this.createSprite(R.mipmap.tiro1, 1, 1);
            missel.setScreenPercent(4, 8);
            missel.vrPosition.setXY(jogador.vrPosition.getX(),
                    jogador.vrPosition.getY() + jogador.getSpriteHeight()/2 + missel.getSpriteHeight() / 2);
            listaMisseis.add(missel);
            AGSoundManager.vrSoundEffects.play(tiroEfeito);
            tempoTiro.restart();
        }
    }

    public void atualizaTiro(){
        for (AGSprite tiro : listaMisseis) {
            if(tiro.bRecycled && tiro.bVisible) {
                continue;
            }
            tiro.vrPosition.setY(tiro.vrPosition.getY() + 10);
            if (tiro.vrPosition.getY() > AGScreenManager.iScreenHeight + tiro.getSpriteHeight()/2) {
                tiro.bRecycled = true;
            }
        }
    }

    public void travaLaterais(){
        if (jogador.vrPosition.getX() < 0 + jogador.getSpriteWidth()/2){
            jogador.vrPosition.setX(0 + jogador.getSpriteWidth()/2);
        }
        if (jogador.vrPosition.getX() > AGScreenManager.iScreenWidth - jogador.getSpriteWidth()/2){
            jogador.vrPosition.setX(AGScreenManager.iScreenWidth - jogador.getSpriteWidth()/2);
        }
    }

}
