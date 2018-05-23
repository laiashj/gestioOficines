import { Component } from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import {startWith} from 'rxjs/operators/startWith';

import { TecnicService } from '../shared/tecnic/tecnic.service';
import { catchError, map, tap, switchMap, debounceTime, distinctUntilChanged, takeWhile, first } from 'rxjs/operators';

@Component({
  selector: 'app-modificar-projecte',
  templateUrl: './modificar-projecte.component.html',
  styleUrls: ['./modificar-projecte.component.css']
})
export class ModificarProjecteComponent  {

myControl = new FormControl();
nom: String = '';
descripcio: String = '';
color:String = '';
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

  public mostrarNom(nom, descripcio, color) {
		this.nom = nom;
		this.descripcio=descripcio;
		this.color=color;

	}

}
