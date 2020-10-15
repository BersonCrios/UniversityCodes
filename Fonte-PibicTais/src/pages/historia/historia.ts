import { HistoriaptPage } from './../historiapt/historiapt';
import { HomePage } from './../home/home';
import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { PorLetraPage } from '../por-letra/por-letra';
import { PorPalavraPage } from '../por-palavra/por-palavra';


@IonicPage()
@Component({
  selector: 'page-historia',
  templateUrl: 'historia.html',
})
export class HistoriaPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  entrarNoJogo() {
    // this.navCtrl.push(PorLetraPage);
    this.navCtrl.setRoot(PorPalavraPage);
    // this.navCtrl.push(HomePage);
  }

  mudarLinguagem(){
    this.navCtrl.setRoot(HistoriaptPage);
  }

}
