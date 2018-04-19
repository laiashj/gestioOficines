import { Component, OnInit } from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { FormsModule } from '@angular/forms';

import {FormControl} from '@angular/forms';
import { TecnicService } from '../shared/tecnic/tecnic.service';


@Component({
  selector: 'app-afegir-tecnic',
  templateUrl: './afegir-tecnic.component.html',
  styleUrls: ['./afegir-tecnic.component.css']
})
export class AfegirTecnicComponent implements OnInit {
	constructor(private tecnicService: TecnicService) { }
	
	
	onClickMe(nom: string, date: string, projecte: string){
		this.tecnicService.addTecnic(nom, date, projecte) 
		.subscribe ( data => {
			this.refreshData());
		
}
myControl: FormControl = new FormControl();

  options = [
    'Eva Gorbano',
    'Laia Sanahuja',
    'Pepa Flores'
   ];
   
  
  

  ngOnInit() {
  }
  
  

}
