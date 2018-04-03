import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificarLlocComponent } from './modificar-lloc.component';

describe('ModificarLlocComponent', () => {
  let component: ModificarLlocComponent;
  let fixture: ComponentFixture<ModificarLlocComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModificarLlocComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModificarLlocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
