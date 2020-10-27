import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VitalsCheckComponent } from './vitals-check.component';

describe('VitalsCheckComponent', () => {
  let component: VitalsCheckComponent;
  let fixture: ComponentFixture<VitalsCheckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VitalsCheckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VitalsCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
