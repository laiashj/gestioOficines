import { Component} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {MatSnackBar} from '@angular/material';
import { TecnicService } from '../shared/tecnic/tecnic.service';
import { catchError, map, tap, switchMap, debounceTime, distinctUntilChanged, takeWhile, first } from 'rxjs/operators';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-afegir-projecte',
  templateUrl: './afegir-projecte.component.html',
  styleUrls: ['./afegir-projecte.component.css']
})
export class AfegirProjecteComponent {

  projectes: any[];
  projecte={
	nom: '',
	color:'',
	descripcio: '',
	dataAlta: ''
  }
  blanc:String='';
  mis: string='Projecte afegit correctament';
  
  constructor(private tecnicService: TecnicService, public snackBar: MatSnackBar) {}

	
	onSubmit(){
		
		this.tecnicService.addProjecte(this.projecte).subscribe(projecte=>{
			this.projectes.unshift(this.projecte);
		})		
		this.blanc=null;
		this.snackBar.open(this.mis);
		
		
	}
}
