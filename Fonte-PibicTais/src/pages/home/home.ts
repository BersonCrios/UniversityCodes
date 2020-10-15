import { WinPage } from './../win/win';
import { Component, OnInit } from '@angular/core';
import { NavController, AlertController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage implements OnInit{

  public dicionario = [
    {nome:"Onça Macho", descricao: "Quem salvou o menino e o ensinou a caçar?"},
    {nome:"Onça Fêmea", descricao: "Quem queria devorar o menino?"},
    {nome:"Tio", descricao: "Quem leva o menino para caçar e o deixa na floresta?"},
    {nome:"Fogo", descricao: "O que o menino leva como última oferenda para aldeia?"},
    {nome:"Árvore", descricao: "Onde o menino sobe para se refugiar da onça femea"},
    {nome:"Raio", descricao: "O que atinge a onça fêmea?"},
  ]

  public palavraSorteada:string;
  public descricao:string;
  public tamanhoDaPalavra:number = 0;
  public posicao:number;
  public entradaDoUsuario:string;
  public pontuacao:number = 0;
  public vidas:number = 3;

  constructor(public navCtrl: NavController,public alertCtrl: AlertController) {}

  ngOnInit(): void {
    console.log(this.dicionario);
    this.escolheUmaPalavra();
  }

  public sorteiaPosicao(){
    this.winner();
    this.posicao = Math.floor(Math.random() * 6);
  }

  public escolheUmaPalavra(){
    this.sorteiaPosicao();
    this.palavraSorteada = this.dicionario[this.posicao].nome;
    this.descricao = this.dicionario[this.posicao].descricao;
    this.tamanhoDaPalavra = this.palavraSorteada.length;
  }

  public verificaResposta(){
    if(this.entradaDoUsuario.toLowerCase() == this.palavraSorteada.toLowerCase()){
      //this.showAlert("Parabéns", "Você acertou !");
      this.escolheUmaPalavra();
      this.limpaCampoEntrada();
      this.pontuacao++;
    }
    else{
      //this.showAlert("Que triste", "Você errou, tente novamente !");
      this.limpaCampoEntrada();
      this.vidas--;

      if (this.vidas == 2) {
        document.getElementById("oncaUm").style.visibility = "hidden";
        document.getElementById("oncaDois").style.visibility = "visible";
      }
      if (this.vidas == 1) {
        document.getElementById("oncaDois").style.visibility = "hidden";
        document.getElementById("oncaTres").style.visibility = "visible";
        //document.getElementById("rugido").style.visibility = "visible";
      }
      if (this.vidas == 0) {
        document.getElementById("rugido").style.visibility = "visible";
        setTimeout( () => {
          this.showAlert("Que triste", "Você perdeu!");
          this.remontaJogo();
       }, 1000);
      }
    }
  }

  private remontaJogo() {
    this.vidas = 3;
    this.pontuacao = 0;
    this.escolheUmaPalavra();
    document.getElementById("oncaUm").style.visibility = "visible";
    document.getElementById("oncaTres").style.visibility = "hidden";
    document.getElementById("rugido").style.visibility = "hidden";
  }

  public winner() {
    if (this.pontuacao == 9) {
      this.navCtrl.push(WinPage);
    }
  }

  private limpaCampoEntrada(){
    this.entradaDoUsuario = "";
  }

  public showAlert(titulo: string, subtitulo: string) {
    let alert = this.alertCtrl.create({
      title: titulo,
      subTitle: subtitulo,
      buttons: ["OK"]
    });
    alert.present();
  }
}
