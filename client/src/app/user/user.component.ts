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

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
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
		nomCognom:"",
		dataAlta:"",
		color: "white"
	};
	
	tec1:string= "<div [style.background-color]=\"tec.color\" > {{tec.nomCognom}}</div>";
	lloc : Array<Object>;
	i : int = 0;
	j : int = 0;
	tec={};
	tec2={};
	id:Array<any>;
	id_source:Array<any>;
	
	//130 taules
	
	constructor(private user:UserService, private dragulaService: DragulaService, public tecnicService:TecnicService){
		/*dragulaService.setOptions('bag-task1',{removeOnSpill: true});*/
		dragulaService.drop.subscribe(value => {
			 let [bagName, el, target, source] = value;
			 //console.log('id target: '+target.getAttribute('id')
			// console.log('id el: '+el.getAttribute('item-id')
			 this.id=target.getAttribute('id').split(",");
			 this.id_source=source.getAttribute('id').split(",");
			 if((this.id_source==="divAssignat")&&(this.id==="divAssignat")){
				 this.tec{ //Tecnic del source
					 _id : el.getAttribute('item-id'),										
					lloc:this.id[1]
					};
				this.tec2{
					 _id : el.getAttribute('item-id'),										
					lloc:this.id_source[1]
					};
				 this.tecnicService.updateTecnic(this.tec).subscribe();	
				 this.tecnicService.updateTecnic(this.tec2).subscribe();	
				this.tec={};
				this.tec2={};
			 }
			 
			 if(this.id[0]==="divNoAssignats"){
				//Modificar valor a noAssignat i buidar array lloc	
					
				this.tec={
					_id : el.getAttribute('item-id'),					
					estat: "noAssignat",
					lloc:""
					};
				this.tecnicService.updateTecnic(this.tec).subscribe();	
				this.tec={};
			 }
			 if(this.id[0]==="divAssignat"){
				 if((this.id[1]>=0) &&(this.id[1]<=9)){
				 this.tec={
					 _id : el.getAttribute('item-id'),					
					estat: "assignat",
					lloc:  '00'+this.id[1];
					};
				 }
				  if((this.id[1]>=10) &&(this.id[1]<=99)){
				 this.tec={
					 _id : el.getAttribute('item-id'),					
					estat: "assignat",
					lloc:  '0'+this.id[1];
					};
				 }
				 if((this.id[1]>=100) &&(this.id[1]<=129)){
				 this.tec={
					 _id : el.getAttribute('item-id'),					
					estat: "assignat",
					lloc:  +this.id[1];
					};
				 }
				this.tecnicService.updateTecnic(this.tec).subscribe();	
				this.tec={};
			 }
			 
		});
				 
		
		
	}
	
	ngOnInit(){
		
		this.tecnicService.getTecnicsEstat('noAssignat').subscribe(
			data => {
				this.filteredOptions= data;
			}
		);
		
		this.tecnicService.getTecnicsEstatOrder('assignat').subscribe(
			data => {
				this.assignats= data;
				this.visualitzaTec();
			}
		);
		
		
		
		
	
	}
	
	public visualitzaTec(){
		
		this.lloc = [];
		
		for (var _i = 0; _i < 130; _i++) {
			let loc =  +this.assignats[this.j].lloc;
			if(loc == _i){
				this.lloc[_i] = this.assignats[this.j];
				this.j++;
			}else{
				this.lloc[_i] = this.tec;
			}
		}
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
	
  

