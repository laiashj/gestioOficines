import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import 'rxjs/Rx';
import { catchError, map, tap,startWith, switchMap, debounceTime, distinctUntilChanged, takeWhile, first } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class TecnicService {
	public API = '//localhost:8080/midiee2/ProjecteOficines/1.0.0';
	public TEC_API= this.API+'/tecnics';
	public PRO_API=this.API+'/projectes';
	tecnic={
		nomCognom:"",	
		projecte:""
	}
  constructor(private http: HttpClient) {}
  
  
	getAll(): Observable<any[]> {
		return this.http.get<any>(this.TEC_API)
	}
	
	addTecnic(tecnic){
		return this.http.post(this.TEC_API,tecnic);//.map;
	}
	
	getProjectes(): Observable<any[]>{
		return this.http.get<any>(this.PRO_API)
	}
	//updateTecnic(id){
	//	return this.http.put(this.TEC_API+'/'+id)
	//}
} 
	  
  
  

