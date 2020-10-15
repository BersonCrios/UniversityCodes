import { DadosJogoProvider } from "./../../providers/dados-jogo/dados-jogo";
import { Component } from "@angular/core";
import {
  IonicPage,
  NavController,
  NavParams,
  AlertController
} from "ionic-angular";
import { HomePage } from "../home/home";
import { ScreenOrientation } from "@ionic-native/screen-orientation";

@IonicPage()
@Component({
  selector: "page-por-palavra",
  templateUrl: "por-palavra.html"
})
export class PorPalavraPage {
  public palavras = [
    { palavraAkwe: "Huku", palavraPortugues: "Onça" },
    { palavraAkwe: "Kunmã", palavraPortugues: "Fogo" },
    { palavraAkwe: "Wakrowdê", palavraPortugues: "Arco" },
    { palavraAkwe: "Wdê", palavraPortugues: "Árvore" },
    { palavraAkwe: "Tãi Wapsa", palavraPortugues: "Raio" },
    { palavraAkwe: "Tã", palavraPortugues: "Chuva" },
    { palavraAkwe: "Sasari", palavraPortugues: "Caçar" },
    { palavraAkwe: "Tki", palavraPortugues: "Flecha" },
    { palavraAkwe: "Kmãdâkâ", palavraPortugues: "Cuidar" },
    { palavraAkwe: "Kra Wapte", palavraPortugues: "Sobrinho" },
    { palavraAkwe: "mmã", palavraPortugues: "Tio" },
    { palavraAkwe: "Zakru", palavraPortugues: "Aldeia" },
    { palavraAkwe: "Siwaprosi", palavraPortugues: "Sozinho" },
    { palavraAkwe: "Rowahutu", palavraPortugues: "Ensinar" },
    { palavraAkwe: "Rowahdu", palavraPortugues: "Ensino" }
  ];
  public palavraSorteada: string;
  public palavraAkwe: string;
  public posicao: number;
  public entradaDoUsuario: string;
  public pontuacao: number = this.DadosJogoProvider.pontos;
  public vidas: number = this.DadosJogoProvider.vidas;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public alertCtrl: AlertController,
    public DadosJogoProvider: DadosJogoProvider,
    private screenOrientation: ScreenOrientation
  ) {}

  ngOnInit(): void {
    console.log(this.palavras);
    this.escolheUmaPalavra();
  }

  public sorteiaPosicao() {
    this.mudaFase();
    this.posicao = Math.floor(Math.random() * 15);
  }

  public escolheUmaPalavra() {
    this.sorteiaPosicao();
    this.palavraSorteada = this.palavras[this.posicao].palavraPortugues;
    this.palavraAkwe = this.palavras[this.posicao].palavraAkwe;
  }

  public chuta() {
    if (
      this.entradaDoUsuario.toLowerCase() == this.palavraSorteada.toLowerCase()
    ) {
      this.limpaCampoEntrada();
      this.escolheUmaPalavra();
      this.pontuacao++;
    } else {
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

  public mudaFase() {
    if (this.pontuacao == 9) {
      this.navCtrl.push(HomePage);
    }
  }

  private limpaCampoEntrada() {
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
