import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-patient-management',
  templateUrl: './patient-management.component.html',
  styleUrls: ['./patient-management.component.css']
})
export class PatientManagementComponent implements OnInit {

  icuId:number
  url:string
  items = [];

  constructor(private route: ActivatedRoute, private http:HttpClient) { }

  getIcuId(){
    this.route.paramMap.subscribe(params => {
      this.icuId = +params.get('icuId');
      this.url = `/api/beds/icu/${this.icuId}`;
    })
  }

  getBedsFromIcu(){
    this.http.get(this.url).toPromise().then(data => {
      for(let key in data){
        console.log(data[key]);
        this.items.push(data[key]);
      }
    });
  }

  ngOnInit(): void {
    this.getIcuId();
    this.getBedsFromIcu();
  }

}
