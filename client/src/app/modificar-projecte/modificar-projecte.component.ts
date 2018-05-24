import { Component } from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { Location } from '@angular/common';
import { startWith } from 'rxjs/operators/startWith';
import { TecnicService } from '../shared/tecnic/tecnic.service';
import { catchError, map, tap, switchMap, debounceTime, distinctUntilChanged, takeWhile, first } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-modificar-projecte',
  templateUrl: './modificar-projecte.component.html',
  styleUrls: ['./modificar-projecte.component.css']
})
export class ModificarProjecteComponent  {

	myControl = new FormControl();
	nom: String = '';
	descripcio: String = '';
	id:String='';
	color:String = '';
	filteredOptions:Observable<any[]>;
	
	projecte = {
		_id:"",
		nom:"",
		descripcio:"", 
		color:""
	};

	constructor(private tecnicService: TecnicService, public snackBar: MatSnackBar, private _location: Location) { 
		this.filteredOptions = this.myControl.valueChanges
        .pipe(
          startWith(null),
          debounceTime(200),
          distinctUntilChanged(),
          switchMap(val => {
            return this.filter(val || '')
          })       
        );
	}
		
	filter(val: string): Observable<any[]> {
		return this.tecnicService.getProjectes()
		.pipe(
			map(response => response.filter(option => { 
			return option.nom.toLowerCase().indexOf(val.toLowerCase()) === 0
			}))
		)
	}
	
	onSubmit(){
		this.tecnicService.updateProjecte(this.projecte)
		.subscribe(() => this.goBack());
	}
	
	public goBack(){
		this.snackBar.open('Projecte Modificat', 'X' {
			duration: 3000
		});
		this._location.back();
	}

	public mostrarNom(id, nom, descripcio, color ) {
		this.projecte={
			_id: id,
			nom: nom, 
			descripcio: descripcio, 
			color: color
		}
		this.nom= nom;
		this.descripcio = descripcio;
		this.color = color;

	}
	
	
}
