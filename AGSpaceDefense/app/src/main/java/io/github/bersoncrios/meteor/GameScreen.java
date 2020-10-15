package io.github.bersoncrios.meteor;

import java.util.ArrayList;

import io.github.bersoncrios.meteor.AndGraph.AGGameManager;
import io.github.bersoncrios.meteor.AndGraph.AGInputManager;
import io.github.bersoncrios.meteor.AndGraph.AGScene;
import io.github.bersoncrios.meteor.AndGraph.AGScreenManager;
import io.github.bersoncrios.meteor.AndGraph.AGSoundManager;
import io.github.bersoncrios.meteor.AndGraph.AGSprite;
import io.github.bersoncrios.meteor.AndGraph.AGTimer;

/**
 * Created by Berson on 23/11/2017.
 */

public class GameScreen extends AGScene {
    AGSprite cenario = null;
    AGSprite jogador = null;

    AGSprite explosao = null;
    int contaMeteoros = 0;

    ArrayList<AGSprite> listaMeteoros = null;
    ArrayList<AGSprite> listaMisseis = null;

    AGSprite meteoro = null;

    AGTimer tempoReciclagem = null;
    AGTimer tempoGeraMeteoro = null;
    AGTimer tempoTiro = null;
    AGTimer tempoPerdeu = null;
    AGTimer tempoDeJogo = null;
    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    public GameScreen(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {
        cenario = this.createSprite(R.mipmap.background4, 1, 1);
        jogador = this.createSprite(R.mipmap.jogador, 1, 1);

        cenario.setScreenPercent(100, 100);
        jogador.setScreenPercent(20, 12);


        listaMeteoros = new ArrayList<AGSprite>();
        listaMisseis = new ArrayList<AGSprite>();

        cenario.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
        jogador.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, jogador.vrPosition.getY() + 150);


        tempoTiro = new AGTimer(400);
        tempoReciclagem = new AGTimer(1000);
        tempoGeraMeteoro = new AGTimer(1000);
        tempoPerdeu = new AGTimer(800);
        tempoDeJogo = new AGTimer(60000);

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
        geraMeteoro();
        atualizaMeteoro();
        geraTiro();
        atualizaTiro();
        tiroAcerta();
        explode();
        contandoMeteoros();
        moveNave();
        portal();
        voltarMenu();
        perdeu();
        ganhou();
    }

    /*Muda a posição em X do jogador(sprite de nave) pegando a posição atual em X e somando a ela uma
       * aecelaração em X, ou seja, inclinando o celular para a direita a nave vai para a direita, inclinando
       * o celular para a esquerda a nave vai para a esquerda*/
    public void moveNave() {
        jogador.vrPosition.setX(jogador.vrPosition.getX() + AGInputManager.vrAccelerometer.getAccelX());
    }


    /*Se o botão de voltar do Celular for clicado o jogo é fechado*/
    public void voltarMenu() {
        if (AGInputManager.vrTouchEvents.bBackButtonClicked) {
            vrGameManager.vrActivity.finish();
        }
    }


    /*método que cria os meteóros de forma aleatórias na tela*/
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
                meteoro = createSprite(R.mipmap.spacemeteors1, 1, 1);
                meteoro.setScreenPercent(13, 8);
                meteoro.vrPosition.setXY(100 + (int) (Math.random() * (AGScreenManager.iScreenWidth - 100)),
                        AGScreenManager.iScreenHeight);
                meteoro.bRecycled = false;
                listaMeteoros.add(meteoro);
                tempoGeraMeteoro.restart();
            }
    }

    /*Metodo que atualiza o meteóro na tela e o seta como reciclado*/
    public void atualizaMeteoro(){
        for (AGSprite meteor:listaMeteoros){
            meteor.vrPosition.setY(meteor.vrPosition.getY() -7);
            meteor.fAngle += 6;
            if (meteor.vrPosition.getY() < 0){
                meteor.bRecycled = true;
            }
        }
    }


    /*Método que contabiliza os meteóros que passarem sem ser destruidos*/
    public int contandoMeteoros(){
        for (AGSprite meteor:listaMeteoros){
            if (meteor.vrPosition.getY() < 0 && meteor.bVisible == true){
                contaMeteoros++;
            }
        }
        return contaMeteoros;
    }

    public void ganhou(){
        tempoDeJogo.update();
        if(tempoDeJogo.isTimeEnded()){
            this.vrGameManager.setCurrentScene(6);
        }
    }


    /*Método que gera a explosãoe deixa o jogador e o meteoro que bateu nele invisivel*/
    public void explode() {
        for (AGSprite m : listaMeteoros) {
                if (m.collide(jogador) && m.bVisible){
                    AGSoundManager.vrMusic.loadMusic("explosion.mp3", false);
                    AGSoundManager.vrMusic.play();
                    explosao = this.createSprite(R.mipmap.explosjon3, 4, 4);
                    explosao.setScreenPercent(30, 30);
                    explosao.addAnimation(20, false, 0, 15);
                    explosao.vrPosition.setXY(jogador.vrPosition.getX(), jogador.vrPosition.getY());
                    jogador.bVisible = false;
                    m.bVisible = false;
                    return;
                }
        }
    }

    /*Método que detecta se ousuário perdeu - Se passar três meteóros ou ele for atingido*/
    public void perdeu(){
        if (contaMeteoros == 3 || !jogador.bVisible){
            contaMeteoros = 0;
            this.vrGameManager.setCurrentScene(5);
            return;
        }
    }

    /*Método que verifica se o tiro acertou o meteóro, se isso ococrreu
    * os dois tem sua visibilidade setada como false
    * Isso ocorre primeiramente com a verificação de colisão entre algum elemento da lista de tiro com um da lista de
    * meteoros, depois verifica se eles estão visiveis em seguida deixando-sos invisives */
        public void tiroAcerta() {
            for (AGSprite m : listaMeteoros) {
                for (AGSprite t : listaMisseis) {
                    if (t.collide(m) && t.bVisible && m.bVisible) {
                        m.bVisible = false;
                        t.bVisible = false;
                        return;
                    }
                }
            }
        }

    /*Método que gera o tiro ao clique da tela, verificando se ele já existe para poder
    * fazer a reciclagem caso já exista, para não sobrecarregar a memória do dispositivo*/
    public void geraTiro(){
        tempoTiro.update();
        if (AGInputManager.vrTouchEvents.screenClicked()){
        for (AGSprite misselRecycled : listaMisseis) {
            if (misselRecycled.bRecycled && misselRecycled.bVisible) {
                misselRecycled.vrPosition.setXY(jogador.vrPosition.getX(),
                        jogador.vrPosition.getY() + jogador.getSpriteHeight()/2 + misselRecycled.getSpriteHeight() / 2);
                AGSoundManager.vrMusic.loadMusic("laser2.ogg", false);
                AGSoundManager.vrMusic.play();
                misselRecycled.bRecycled = false;
                return;
            }
        }

                AGSprite missel = this.createSprite(R.mipmap.tiro, 1, 1);
                missel.setScreenPercent(4, 8);
                missel.vrPosition.setXY(jogador.vrPosition.getX(),
                        jogador.vrPosition.getY() + jogador.getSpriteHeight()/2 + missel.getSpriteHeight() / 2);
                listaMisseis.add(missel);
                AGSoundManager.vrMusic.loadMusic("laser2.ogg", false);
                AGSoundManager.vrMusic.play();
                tempoTiro.restart();

        }
    }

    /*Método que atualizará o tiro reciclado, e tambem fará ele subir como se estivesse sendo sisparado
    * antes verificando na lista de tiro se o mesmo é reciclado e está visível*/
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

    /*Método que ira verificar se a nave passou da tela em x e ira setar sua posição como se estuvesse saindo
    * no lado oposto*/
    public void portal(){
        if(jogador.vrPosition.getX() > AGScreenManager.iScreenWidth + jogador.getSpriteWidth()/2){
            jogador.vrPosition.setX(0);
        }

        if (jogador.vrPosition.getX() < 0){
            jogador.vrPosition.setX(AGScreenManager.iScreenWidth + jogador.getSpriteWidth()/2);
        }
    }
}