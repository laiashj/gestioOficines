import { Component } from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import {startWith} from 'rxjs/operators/startWith';

import { TecnicService } from '../shared/tecnic/tecnic.service';
import { catchError, map, tap, switchMap, debounceTime, distinctUntilChanged, takeWhile, first } from 'rxjs/operators';

@Component({
  selector: 'app-afegir-tecnic',
  templateUrl: './afegir-tecnic.component.html',
  styleUrls: ['./afegir-tecnic.component.css']
})
export class AfegirTecnicComponent {
	
	tecnics: any[];
	tecnic={
		nomCognom:"",
		dataAlta:"",
		projecte:""
	}
	
myControl = new FormControl();

filteredOptions:Observable<any[]>;

	constructor(private tecnicService: TecnicService) { 
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
		
		this.tecnicService.addTecnic(this.tecnic).subscribe(tecnic=>{
			this.tecnics.unshift(this.tecnic);
		})
	}
  
}
  


