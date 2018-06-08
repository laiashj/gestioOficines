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
	tecnics:Array<Object>;
	
	projecte = {
		_id:"",
		nom:"",
		descripcio:"", 
		color:""
	};
	pro = {};

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
		return this.tecnicService.getProjectesAlta()
		.pipe(
			map(response => response.filter(option => { 
			return option.nom.toLowerCase().indexOf(val.toLowerCase()) === 0
			}))
		)
	}
	
	public onSubmit(){
		this.tecnicService.updateProjecte(this.projecte)
		.subscribe(() => this.cridarF("Projecte modificat correctament"));
	}
	
	public eliminar(){
		this.pro={
			_id: this.id,
			dataBaixa: "avui"
		}
		this.tecnicService.updateProjecte(this.pro)
		.subscribe(() => this.cridarF("projecte eliminat correctament"));
	}
	private cridarF(m:string){
		this.goBack(m);
		this.modificarTecnics();
	};
	private goBack(m: string){
		this.snackBar.open(m, 'X',{
			duration: 3000
		});
		//this.modificarTecnics();
		//this._location.back();
		this.nom = null;
		this.descripcio = null;
		this.color = null;
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
		this.id = id;
	}
	
	public modificarTecnics(){
		this.tecnicService.getTecnicByProjecte(this.nom).subscribe(
		data => {
			this.tecnics= data;
			}
		)
		this.tecnics.forEach((t) =>{
			t.projecte= this.projecte.nom;
			t.color=this.projecte.color;
			this.tecnicService.updateTecnic(t)
			.subscribe(() => this.goBack("tècnics modificats correctament"));
		}); 
	}
	
}
