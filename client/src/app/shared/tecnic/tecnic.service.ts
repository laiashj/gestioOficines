import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import 'rxjs/Rx';
import { catchError, map, tap,startWith, switchMap, debounceTime, distinctUntilChanged, takeWhile, first } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class TecnicService {
	const httpOptions ={
		headers: new HttpHeaders({
			'Content-Type': 'application/json',
			'Authorization': 'my-auth-token'
		})
	};
	public API = '//localhost:8080/midiee2/ProjecteOficines/1.0.0';
	public TEC_API= this.API+'/tecnics';
	
  constructor(private http: HttpClient) {}
  
  
	getAll(): Observable<any[]> {
		return this.http.get<any>(this.TEC_API)
	}
	addTecnic(nom: string, data:string, projecte: string){
		this.http.post(this.TEC_API+"/",
		{
			"dataAlta": data,
			"dataBaixa": "null",
			"estat": "noAssignat",
			"idTecnic": "",
			"lloc": "null",
			"nomCognom": nom,
			"projecte": projecte
		}, httpOptions)
		.subscribe(
		(val) => {
			console.log("POST call successful value returned in body", val);
		},
		response => {
			console.log("POST call in error", response);
		},
		() => {
			console.log("The POST observable is now completed.");
		});
}
	  
  }
  

