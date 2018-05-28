import { Component} from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import {startWith} from 'rxjs/operators/startWith';
import { Location } from '@angular/common';
import { TecnicService } from '../shared/tecnic/tecnic.service';
import { catchError, map, tap, switchMap, debounceTime, distinctUntilChanged, takeWhile, first } from 'rxjs/operators';
import {MatSnackBar} from '@angular/material';
@Component({
  selector: 'app-modificar-tecnic',
  templateUrl: './modificar-tecnic.component.html',
  styleUrls: ['./modificar-tecnic.component.css']
})
export class ModificarTecnicComponent   {

	myControl = new FormControl();
	myControl2 = new FormControl();
	nom: String = '';
	projecte:String='';
	id:String='';
	tecnics:any[];

	tecnic={
		_id:"",
		nomCognom:"",
		projecte:""
	}
	tec={}

	filteredOptions:Observable<any[]>;
	filteredOptions2:Observable<any[]>;

	constructor(private tecnicService: TecnicService, public snackBar: MatSnackBar, private _location: Location){
		this.filteredOptions = this.myControl.valueChanges
			.pipe(
			  startWith(null),
			  debounceTime(200),
			  distinctUntilChanged(),
			  switchMap(val => {
				return this.filter(val || '')
			  })       
			);
  
		this.filteredOptions2 = this.myControl2.valueChanges
        .pipe(
			startWith(null),
			debounceTime(200),
			distinctUntilChanged(),
			switchMap(val2 => {
				return this.filter2(val2 || '')
			})       
        );
	}
	filter(val: string): Observable<any[]> {
		return this.tecnicService.getAll()
		.pipe(
			map(response => response.filter(option => { 
				return option.nomCognom.toLowerCase().indexOf(val.toLowerCase()) === 0
			}))
		)
	}
	filter2(val2: string): Observable<any[]> {
		return this.tecnicService.getProjectes()
		.pipe(
			map(response => response.filter(option => { 
			return option.nom.toLowerCase().indexOf(val2.toLowerCase()) === 0
		}))
		)
	}

	onSubmit(){
		this.tecnicService.updateTecnic(this.tecnic)
		.subscribe(() => this.goBack());
	}
	
	eliminar(){
		this.tec={
			_id : this.id,
			dataBaixa : "avui"
		};
		this.tecnicService.updateTecnic(this.tec)
		.subscribe(() => this.goBack2());
	}
	
	public goBack(){
		this.snackBar.open('Tecnic Modificat', 'X' {
			duration: 3000
		});
		this._location.back();
	}
	
	public goBack2(){
		this.snackBar.open('Tecnic Eliminat', 'X' {
			duration: 3000
		});

	}
	
	public mostrarNom(nom, projecte, id) {
				
		this.tecnic = {
			_id:id,
			nomCognom:nom,
			projecte:projecte
		};
		this.id = id;
	}
}
 

