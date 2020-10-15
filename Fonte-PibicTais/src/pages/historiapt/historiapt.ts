import { HistoriaPage } from './../historia/historia';
import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { PorPalavraPage } from '../por-palavra/por-palavra';

@IonicPage()
@Component({
  selector: 'page-historiapt',
  templateUrl: 'historiapt.html',
})
export class HistoriaptPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  entrarNoJogo() {
    // this.navCtrl.push(PorLetraPage);
    this.navCtrl.setRoot(PorPalavraPage);
    // this.navCtrl.push(HomePage);
  }

  mudarLinguagem(){
    this.navCtrl.setRoot(HistoriaPage);
  }
}
