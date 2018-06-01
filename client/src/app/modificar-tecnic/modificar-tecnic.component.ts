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
	projecteNou: Object;
	tecnic={
		_id:"",
		nomCognom:"",
		projecte:"", 
		color:""
	}
	tec={}

	filteredOptions:Observable<any[]>;
	filteredOptions2:Observable<any[]>;

	constructor(private tecnicService: TecnicService, public snackBar: MatSnackBar, private _location: Location){
		this.inicialitza();
	}
	//metode de filtratge de tècnics per nomCognom
	public filter(val: string): Observable<any[]> {
		return this.tecnicService.getTecnicsAlta()
		.pipe(
			map(response => response.filter(option => { 
				return option.nomCognom.toLowerCase().indexOf(val.toLowerCase()) === 0
			}))
		)
	}
	//metode de filtratge de projectes per nom
	public filter2(val2: string): Observable<any[]> {
		return this.tecnicService.getProjectes()
		.pipe(
			map(response => response.filter(option => { 
			return option.nom.toLowerCase().indexOf(val2.toLowerCase()) === 0
		}))
		)
	}
	//metode del botó modificar
	public onSubmit(){
		//agafa el color del projecte nou i el posa al tècnic
		this.tecnic.color = this.projecteNou.color;
		this.tecnicService.updateTecnic(this.tecnic)
		.subscribe(() => this.goBack("Tècnic modificat correctament"));
	}
	//mètode del botó eliminar
	public eliminar(){
		this.tec={
			_id : this.id,
			dataBaixa : "avui",
			estat: "eliminat",
			projecte:""
		};
		this.tecnicService.updateTecnic(this.tec)
		.subscribe(() => this.goBack("Tècnic eliminat correctament"));
	}
	//mètode que buida les caselles després de l'eliminar o modificar i que mostra la SnackBar
	public goBack(m : string){
		this.snackBar.open(m, 'X', {
			duration: 3000
		});
		this.nom = null;
		this.projecte = null;
		
		//this._location.back();
		
	}
	//mètode que agafa el nom del tècnic seleccionat i omple les caselles amb les dades actuals del tècnic
	public mostrarNom(nom, projecte, id) {
		this.tecnic = {
			_id:id,
			nomCognom:nom,
			projecte:projecte
		};
		this.id = id;
	}
	//mèode que busca el projecte nou i selecciona el seu color per modificar-lo al tècnic per mantenir la integritat de la base de dades
	public buscarProjecte(nomProjecte){
		this.tecnicService.getProjecteByNom(nomProjecte).subscribe(
		data => {
			this.projecteNou = data;
			}
		);
	}
	//mètode que torna a carregar els arrays de tecnics i projectes per poder filtrar-ne els resultats
	public inicialitza(){
		//tècnics
		this.filteredOptions = this.myControl.valueChanges
			.pipe(
			  startWith(null),
			  debounceTime(200),
			  distinctUntilChanged(),
			  switchMap(val => {
				return this.filter(val || '')
			  })       
			);
		//projectes
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
}
 

