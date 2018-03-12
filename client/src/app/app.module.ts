import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { TecnicService } from './shared/tecnic/tecnic.service';
import { HttpClientModule } from '@angular/common/http';
import { TecnicListComponent } from './tecnic-list/tecnic-list.component';


import { AppComponent } from './app.component';


@NgModule({
  declarations: [
	TecnicListComponent,
    AppComponent
  ],
  imports: [
    BrowserModule,
	HttpClientModule
  ],
  providers: [TecnicService],
  bootstrap: [AppComponent]
})
export class AppModule { }
