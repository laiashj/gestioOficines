import { Component} from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import {startWith} from 'rxjs/operators/startWith';
import {map} from 'rxjs/operators/map';



@Component({
  selector: 'app-modificar-tecnic',
  templateUrl: './modificar-tecnic.component.html',
  styleUrls: ['./modificar-tecnic.component.css']
})
export class ModificarTecnicComponent  {

tecnic: any={};
constructor() {}
			
  myControl : FormControl= new FormControl();
  

  options = [
    'Eva Gorbano',
    'Laia Sanahuja',
    'Pepa Flores'
   ];
  
 clickMessage='';
	tecnicMod(){
		this.clickMessage='Tecnic Modificar';
		//Buidar casselles
}
}
 

