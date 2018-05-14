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
	
	tecnics: any[];
	tecnic={
		nomCognom:"",
		dataAlta:"",
		projecte:""
	}
	
	constructor(public tecnicService: TecnicService) { 
	}
	
	onSubmit(){
		this.tecnicService.addTecnic(this.tecnic).subscribe(tecnic=>{
			this.tecnics.unshift(this.tecnic);
		})
	}
  ngOnInit() {}
}
  


