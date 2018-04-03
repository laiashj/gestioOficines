import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificarTecnicComponent } from './modificar-tecnic.component';

describe('ModificarTecnicComponent', () => {
  let component: ModificarTecnicComponent;
  let fixture: ComponentFixture<ModificarTecnicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModificarTecnicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModificarTecnicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
