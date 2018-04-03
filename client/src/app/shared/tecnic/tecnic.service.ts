import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TecnicService {
	
	public API = '//http://localhost:8080/midiee2/ProjecteOficines/1.0.0';
	public TEC_API= this.API+'/tecnics';
	
  constructor(private http: HttpClient) { 
  }

  getAll(): Observable<any> {
    return this.http.get(this.TEC_API);
  }
  
  get(id: string){
	  return this.http.get(this.TEC_API+ '/' +id);
  }
   save(tecnic: any): Observable<any> {
    let result: Observable<Object>;
    if (tecnic['href']) {
      result = this.http.put(tecnic.href, tecnic);
    } else {
      result = this.http.post(this.TEC_API, tecnic);
    }
    return result;
  }

}
