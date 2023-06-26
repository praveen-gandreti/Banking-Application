import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DipositComponent } from './diposit.component';

describe('DipositComponent', () => {
  let component: DipositComponent;
  let fixture: ComponentFixture<DipositComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DipositComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DipositComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
