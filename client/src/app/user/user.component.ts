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
  projectes:any;
  htmlStr:string='<strong>The Tortoise</strong>';
  
	constructor(private user:UserService, private dragulaService: DragulaService, public tecnicService:TecnicService
	){
	//dragulaService.setOptions('bag-task1', {
     // removeOnSpill: true
    //});
	
	
	}
	
	ngOnInit(){
		this.tecnicService.getTecnicsNoAssignats().subscribe(
		data => {
			this.filteredOptions= data;
			}
		)
		
	
	}
 /* setStyleProjecte(tecnic){
	//  this.tecnicService.getProjecteByNom(tecnic.nom).subscribe(
 // data => this.projectes=data);
		
		let styles={  
			'background-color': tecnic.color;	  
  }
	  return styles;
  }*/
  
  }
	
  

