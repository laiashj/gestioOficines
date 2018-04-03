import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfegirProjecteComponent } from './afegir-projecte.component';

describe('AfegirProjecteComponent', () => {
  let component: AfegirProjecteComponent;
  let fixture: ComponentFixture<AfegirProjecteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfegirProjecteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfegirProjecteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
