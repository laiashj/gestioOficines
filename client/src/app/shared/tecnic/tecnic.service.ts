import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TecnicService {

  constructor(private http: HttpClient) { 
  }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:8080/midiee2/ProjecteOficines/1.0.0/tecnics');
  }
}
