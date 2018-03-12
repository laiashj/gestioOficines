import { Component, OnInit } from '@angular/core';
import { TecnicService } from '../shared/tecnic/tecnic.service';

@Component({
  selector: 'app-tecnic-list',
  templateUrl: './tecnic-list.component.html',
  styleUrls: ['./tecnic-list.component.css']
})
export class TecnicListComponent implements OnInit {

	tecnics: Array<any>;
	constructor(private tecnicService: TecnicService) { }

  ngOnInit() {
	   this.tecnicService.getAll().subscribe(data => {
      this.tecnics = data;
    });
  }

}
