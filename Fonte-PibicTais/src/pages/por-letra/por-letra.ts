import { DadosJogoProvider } from './../../providers/dados-jogo/dados-jogo';
import { PorPalavraPage } from './../por-palavra/por-palavra';
import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';
import { HomePage } from '../home/home';

@IonicPage()
@Component({
  selector: 'page-por-letra',
  templateUrl: 'por-letra.html',
})
export class PorLetraPage {
  public letra = [
    {imagem:"https://s3.amazonaws.com/img.cdm/letra-decorativa-preto-mdf-19x19-cm-Carro-de-Mola-0oFPJ.jpg", letra: "a"},
    {imagem:"https://s3.amazonaws.com/img.cdm/letra-r-decorativa-preto-mdf-19x185-cm-Carro-de-Mola-0Dh8a.jpg", letra: "r"},
    {imagem:"http://www.significadodossonhos.inf.br/wp-content/uploads/2018/01/letra-p-1.jpg", letra: "p"},
    {imagem:"http://1.bp.blogspot.com/_9SRYbcjPuNo/TJQVO02DUeI/AAAAAAAAAcI/4NwTqrkwq1Q/s1600/E.png", letra: "e"},
    {imagem:"http://www.folhas.com.br/produtos/letras_de_eva/img_g_letras_de_eva_grande_i.jpg", letra: "i"},
  ]


  public letraSorteada:string;
  public imagem:string;
  public posicao:number;
  public entradaDoUsuario:string;
  public pontuacao:number = this.DadosJogoProvider.pontos;
  public vidas:number = this.DadosJogoProvider.vidas;

  constructor(public navCtrl: NavController, public navParams: NavParams,public alertCtrl: AlertController, public DadosJogoProvider:DadosJogoProvider) {
  }

  ngOnInit(): void {
    this.escolheUmaLetra();
  }

  public sorteiaPosicao(){
    this.mudaFase();
    this.posicao = Math.floor(Math.random() * 5);
  }

  public escolheUmaLetra(){
    this.sorteiaPosicao();
    this.letraSorteada = this.letra[this.posicao].letra;
    this.imagem = this.letra[this.posicao].imagem;
  }

  public chuta(){
    if(this.entradaDoUsuario.toLowerCase() == this.letraSorteada.toLowerCase()){
      this.limpaCampoEntrada();
      this.escolheUmaLetra();
      this.pontuacao++;
    }

    else{
      this.limpaCampoEntrada();
      this.vidas--;
      if(this.vidas == 0){
        this.showAlert("Que triste", "Você perdeu!");
        this.vidas = 3;
        this.pontuacao = 0;
        this.escolheUmaLetra();
      }
    }
  }

  public mudaFase(){
      if(this.pontuacao == 10){
        this.navCtrl.push(PorPalavraPage)
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
