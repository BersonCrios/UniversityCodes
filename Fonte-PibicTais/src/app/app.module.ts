import { MenuPage } from './../pages/menu/menu';
import { WinPage } from './../pages/win/win';
import { ScreenOrientation } from '@ionic-native/screen-orientation';
import { PorPalavraPage } from './../pages/por-palavra/por-palavra';
import { PorLetraPage } from './../pages/por-letra/por-letra';
import { HistoriaPage } from './../pages/historia/historia';
import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { DadosJogoProvider } from '../providers/dados-jogo/dados-jogo';
import { SobrePage } from '../pages/sobre/sobre';
import { HistoriaptPage } from '../pages/historiapt/historiapt';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    HistoriaPage,
    PorLetraPage,
    PorPalavraPage,
    WinPage,
    MenuPage,
    SobrePage,
    HistoriaptPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    HistoriaPage,
    PorLetraPage,
    PorPalavraPage,
    WinPage,
    MenuPage,
    SobrePage,
    HistoriaptPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    DadosJogoProvider,
    ScreenOrientation
  ]
})
export class AppModule {}
