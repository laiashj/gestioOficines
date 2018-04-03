import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificarProjecteComponent } from './modificar-projecte.component';

describe('ModificarProjecteComponent', () => {
  let component: ModificarProjecteComponent;
  let fixture: ComponentFixture<ModificarProjecteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModificarProjecteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModificarProjecteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
