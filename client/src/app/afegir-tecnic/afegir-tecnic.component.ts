import { Component } from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { startWith } from 'rxjs/operators/startWith';
import { MatSnackBar } from '@angular/material';
import { Location } from '@angular/common';
import { TecnicService } from '../shared/tecnic/tecnic.service';
import { catchError, map, tap, switchMap, debounceTime, distinctUntilChanged, takeWhile, first } from 'rxjs/operators';

@Component({
	selector: 'app-afegir-tecnic',
	templateUrl: './afegir-tecnic.component.html',
	styleUrls: ['./afegir-tecnic.component.css']
})
export class AfegirTecnicComponent {
	blanc:String='';
	tecnics: any[];
	nom: String = '';
	mis: string='Tècnic afegit correctament';
	tecnic={
		nomCognom:"",
		dataAlta:"",
		projecte:this.nom,
		color: ""
	}
	projecte: Object;
	color: String='';
	
	myControl = new FormControl();

	filteredOptions:Observable<any[]>;
	public agafarNom(nom) {
		this.nom = nom;
		this.tecnic.projecte= nom;
		this.tecnicService.getProjecteByNom(nom).subscribe(
		data => {
			this.projecte = data;
			}
		);
		//this.color = this.projecte.color;
	}

	constructor(private tecnicService: TecnicService, public snackBar: MatSnackBar, private _location: Location) { 
		this.filteredOptions = this.myControl.valueChanges
			.pipe(
				startWith(null),
				debounceTime(200),
				distinctUntilChanged(),
				switchMap(val => {
            return this.filter(val || '')})       
        );
	}
	
	filter(val: string): Observable<any[]> {
		return this.tecnicService.getProjectesAlta()
		.pipe(
			map(response => response.filter(option => { 
			return option.nom.toLowerCase().indexOf(val.toLowerCase()) === 0
			}))
		)
	}
	
	onSubmit(){
		this.tecnic.color = this.projecte.color;
		this.tecnicService.addTecnic(this.tecnic)
		.subscribe( ()=> this.goBack());
		
	}
	
	public goBack(){
		this.snackBar.open('Tècnic afegit', 'X', {
			duration: 3000
		});
		this.blanc = null;
		this.nom = null;
		this.projecte = null;
		this.color = null;
		this.tecnic={
			nomCognom:"",
			dataAlta:"",
			projecte:"",
			color: ""
		}
		//this._location.back();
	}
}
 

  


