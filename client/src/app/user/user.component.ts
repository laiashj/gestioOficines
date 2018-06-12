import { Component, OnInit, ViewChild, AfterViewInit, ElementRef} from '@angular/core';
import { UserService} from '../user.service';
import { Router } from '@angular/router';
import {HeaderComponent} from '../header/header.component';
import { DragulaService } from 'ng2-dragula/ng2-dragula';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import { DataSource } from '@angular/cdk/collections';
import {startWith} from 'rxjs/operators/startWith';
import { catchError, map, tap, switchMap, debounceTime, distinctUntilChanged, takeWhile, first } from 'rxjs/operators';
import { TecnicService } from '../shared/tecnic/tecnic.service';
import {MatTableDataSource} from '@angular/material';

import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit/*, AfterViewInit*/{
 
	filteredOptions:any;
	assignats: Array<Object>;
	htmlStr:string='<strong>The Tortoise</strong>';
	tec={
		nomCognom:"Laura Castillo",
		dataAlta:"",
		color: "purple"
	};
	
	tec1:string= "<div [style.background-color]=\"tec.color\" > {{tec.nomCognom}}</div>";
	llocs = {
		l1: "", 
		l2: "", 
		l3: "",
		l4: "",
		l5: "", 
		l6: ""
	};
	i : int = 0;
	j : int = 0;
	
	//130 taules
	
	constructor(private user:UserService, private dragulaService: DragulaService, public tecnicService:TecnicService){
		/*dragulaService.setOptions('bag-task1',{removeOnSpill: true});*/
	}
	
	ngOnInit(){
		this.tecnicService.getTecnicsEstat('noAssignat').subscribe(
			data => {
				this.filteredOptions= data;
			}
		);
		
		this.tecnicService.getTecnicsEstat('assignat').subscribe(
			data => {
				this.assignats= data;
			}
		);
		
		this.llocs.l1 = assignats[0];
		this.llocs.l2 = assignats[1];
		this.llocs.l3 = assignats[2];
		this.llocs.l4 = assignats[3];
		this.llocs.l5 = assignats[4];
		this.llocs.l6 = assignats[5];
	}
	
	
	/*public visualitzaTec(){
		this.llocs.forEach((l) =>{
			lloc: int =  +this.assignats[i].lloc;
			if(lloc == j){
				l = this.assignats[i];
				i = i+1;
			}else{
				l = tec;
			}
			j = j+1;
		}); 
	}*/
	
 
}
	
  

