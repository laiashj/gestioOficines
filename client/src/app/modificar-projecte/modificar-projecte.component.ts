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
	tecnics:Array<Object> = new Array();
	
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
	/**Mètode que filtra els tècnics d'alta per text val = text introduit ala caixa del nom*/	
	filter(val: string): Observable<any[]> {
		return this.tecnicService.getProjectesAlta()
		.pipe(
			map(response => response.filter(option => { 
			return option.nom.toLowerCase().indexOf(val.toLowerCase()) === 0
			}))
		)
	}
	/**Mètode del botó modificar */
	public onSubmit(){
		this.tecnicService.updateProjecte(this.projecte)
		.subscribe(() => this.cridarModificar("Projecte modificat correctament"));
	}
	/**Mètode del botó eliminar*/
	public eliminar(){
		this.pro={
			_id: this.id,
			dataBaixa: "avui"
		}
		this.tecnicService.updateProjecte(this.pro)
		.subscribe(() => this.cridarEliminar("projecte eliminat correctament"));
	}
	/**Mètode que crida les funcions que son necessaries després de modificar projecte*/
	private cridarModificar(m:string){
		this.getTecnicsProjecte();
		this.goBack(m);	
	};
	
	private cridarEliminar(m:string){
		this.getTecnicsProjecteEliminar();
		this.goBack(m);	
	};
	/**Mètode que buida les caselles i mostra l'snackBar*/
	private goBack(m: string){
		this.snackBar.open(m, 'X',{
			duration: 3000
		});
		this.nom = null;
		this.descripcio = null;
		this.color = null;
	}
	/**Mètode que agafa les dades de l'objecte projecte seleccionat i les mostra a les caixes de text Arguments id, nom, descripció, color del projecte a modificar*/
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
	
	/**Mètode que recupera els tècnics que estan assignats al projecte que s'està modificant*/
	public getTecnicsProjecte(){
		this.tecnicService.getTecnicByProjecte(this.nom).subscribe(
		data => {
			this.tecnics= data;
			this.modificarTecnics();
			}
		)
	};
	
	public getTecnicsProjecteEliminar(){
		this.tecnicService.getTecnicByProjecte(this.nom).subscribe(
		data => {
			this.tecnics= data;
			this.eliminarProjecteTecnics();
			}
		)
	};
	/**Mètode que modifica els tècnics que estan assignats al projecte modificat*/
	public modificarTecnics(){
		
		this.tecnics.forEach((t) =>{
			t.projecte= this.projecte.nom;
			t.color=this.projecte.color;
			this.tecnicService.updateTecnic(t)
			.subscribe(() => this.goBack("tècnics modificats correctament"));
		}); 
	}
	/**Mètode que modifica els tècnics que estan assignats al projecte modificat*/
	public eliminarProjecteTecnics(){
		this.tecnics.forEach((t) =>{
			t.projecte= "";
			t.color = "";
			this.tecnicService.updateTecnic(t)
			.subscribe(() => this.goBack("tècnics modificats correctament"));
		}); 
	}
	
}
