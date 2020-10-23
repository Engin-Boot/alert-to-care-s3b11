import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IcusComponent } from './icus.component';

describe('IcusComponent', () => {
  let component: IcusComponent;
  let fixture: ComponentFixture<IcusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IcusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IcusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
