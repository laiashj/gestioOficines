import { Component, OnInit } from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { FormsModule } from '@angular/forms';

import {FormControl} from '@angular/forms';


@Component({
  selector: 'app-afegir-tecnic',
  templateUrl: './afegir-tecnic.component.html',
  styleUrls: ['./afegir-tecnic.component.css']
})
export class AfegirTecnicComponent implements OnInit {
	clickMessage='';
	onClickMe(){
		this.clickMessage='Tecnic Afegit';
		//Buidar casselles
}
myControl: FormControl = new FormControl();

  options = [
    'Eva Gorbano',
    'Laia Sanahuja',
    'Pepa Flores'
   ];
   
  
  constructor() { }

  ngOnInit() {
  }

}
