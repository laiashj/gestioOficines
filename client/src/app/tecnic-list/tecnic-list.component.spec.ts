import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TecnicListComponent } from './tecnic-list.component';

describe('TecnicListComponent', () => {
  let component: TecnicListComponent;
  let fixture: ComponentFixture<TecnicListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TecnicListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TecnicListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
