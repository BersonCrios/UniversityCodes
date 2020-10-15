import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { PorPalavraPage } from './por-palavra';

@NgModule({
  declarations: [
    PorPalavraPage,
  ],
  imports: [
    IonicPageModule.forChild(PorPalavraPage),
  ],
})
export class PorPalavraPageModule {}
