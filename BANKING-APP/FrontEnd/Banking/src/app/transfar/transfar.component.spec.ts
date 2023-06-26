import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransfarComponent } from './transfar.component';

describe('TransfarComponent', () => {
  let component: TransfarComponent;
  let fixture: ComponentFixture<TransfarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransfarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransfarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
