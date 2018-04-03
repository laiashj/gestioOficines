import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfegirTecnicComponent } from './afegir-tecnic.component';

describe('AfegirTecnicComponent', () => {
  let component: AfegirTecnicComponent;
  let fixture: ComponentFixture<AfegirTecnicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfegirTecnicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfegirTecnicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
