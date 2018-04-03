import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfegirLlocComponent } from './afegir-lloc.component';

describe('AfegirLlocComponent', () => {
  let component: AfegirLlocComponent;
  let fixture: ComponentFixture<AfegirLlocComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfegirLlocComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfegirLlocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
