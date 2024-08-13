import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentdetailsComponent } from './studentdetails.component';
import { StudentdetailsService } from './studentdetails.service'
import { of, throwError } from 'rxjs';
import { SharedService } from 'src/shared/shared.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { StudentdetailsComponent } from './studentdetails.component';


describe('StudentdetailsComponent', () => {
  let component: StudentdetailsComponent;
  let fixture: ComponentFixture<StudentdetailsComponent>;
  let service: StudentdetailsService;
  let sharedServiceMock = jasmine.createSpyObj('SharedService', ['methodName1', 'methodName2']);
  let httpClient: HttpClientTestingModule;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, 
        FormsModule, ReactiveFormsModule,
      ],
      declarations: [ StudentdetailsComponent ],
      providers: [ StudentdetailsService, 
        { provide: SharedService, useValue: sharedServiceMock},
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentdetailsComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(StudentdetailsService);
    httpClient = TestBed.inject(HttpClient);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // ngOnInit application onload
  it('should set the created_by property with the value from sessionStorage', () => {
    const mockEmail = 'test@example.com';
    spyOn(sessionStorage, 'getItem').and.returnValue(mockEmail);
    component.ngOnInit();

    expect(sessionStorage.getItem).toHaveBeenCalledWith('email');
    expect(component.studentdetails.created_by).toEqual(mockEmail);
    expect(component.studentmarks.created_by).toEqual(mockEmail);
    expect(component.stduentrank.created_by).toEqual(mockEmail);

  });
  


});