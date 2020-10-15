import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { WinPage } from './win';

@NgModule({
  declarations: [
    WinPage,
  ],
  imports: [
    IonicPageModule.forChild(WinPage),
  ],
})
export class WinPageModule {}
