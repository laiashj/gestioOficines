import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map'
import 'rxjs/Rx';
import { catchError, retry, map, tap,startWith, switchMap, debounceTime, distinctUntilChanged, takeWhile, first } from 'rxjs/operators';



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
		return this.http.get<any>(this.TEC_API);
	}
	
	getTecnicsAlta():Observable<any[]> {
		return this.http.get<any>(this.TEC_API+'/alta/alta');
	}
	
	getTecnicsEstat(estat):Observable<any[]>{
		return this.http.get<any>(this.TEC_API+'/estat/' + estat);
	}
	
	getTecnicByProjecte(nomProjecte):Observable<any[]>{
		return this.http.get<any>(this.TEC_API+'/projecte/'+nomProjecte);
	}
	
	addTecnic(tecnic){
		return this.http.post(this.TEC_API,tecnic);//.map;
	}
	
	updateTecnic(tecnic):Observable<any>{
		return this.http.put<any>(this.TEC_API+'/'+tecnic._id, tecnic) 
		.pipe();
	}
	addProjecte(projecte){
		return this.http.post(this.PRO_API,projecte);//.map;
	}
	
	getProjectes(): Observable<any[]>{
		return this.http.get<any>(this.PRO_API);
	}
	
	getProjectesAlta(): Observable<any[]>{
		return this.http.get<any>(this.PRO_API+'/alta/alta');
	}
	
	updateProjecte(projecte):Observable<any>{
		return this.http.put<any>(this.PRO_API+'/'+projecte._id, projecte)
		.pipe();
	}
	getProjecteByNom(nom){
		return this.http.get(this.PRO_API+'/findByNom/'+nom);
	}
} 
	  
  
  

