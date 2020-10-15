import { SobrePage } from './../sobre/sobre';
import { HistoriaPage } from './../historia/historia';
import { Component } from "@angular/core";
import { IonicPage, NavController, NavParams } from "ionic-angular";

@IonicPage()
@Component({
  selector: "page-menu",
  templateUrl: "menu.html"
})
export class MenuPage {
  constructor(public navCtrl: NavController, public navParams: NavParams) {}

  vaiParaHsitoria(){
    this.navCtrl.setRoot(HistoriaPage);
  }

  vaiParaSobre(){
    this.navCtrl.push(SobrePage);
  }
}
