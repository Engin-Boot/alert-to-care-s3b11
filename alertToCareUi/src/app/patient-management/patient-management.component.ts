import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-patient-management',
  templateUrl: './patient-management.component.html',
  styleUrls: ['./patient-management.component.css']
})
export class PatientManagementComponent implements OnInit {

  icuId:number
  url:string
  items = [];
  patientDischarge = [];

  constructor(private route: ActivatedRoute, private router: Router, private http:HttpClient) { }

  getIcuId(){
    this.route.paramMap.subscribe(params => {
      this.icuId = +params.get('icuId');
      this.url = `/api/beds/icu/${this.icuId}`;
    })
  }

  getBedsFromIcu(){
    this.http.get(this.url).toPromise().then(data => {
      for(let key in data){
        this.items.push(data[key]);
      }
    });
  }

  getPatientId(value){
    this.http.get(`/api/patients/patientId/${value}`).toPromise().then(data => {
      let dataJson = JSON.parse(JSON.stringify(data));
      this.dischargePatient(dataJson.patientId);
      console.log(dataJson.patientId);
    });

    
  }

  dischargePatient(patientId){
    this.http.delete("/api/patients/" + patientId).subscribe(data =>{
      console.log(data);
      this.router.onSameUrlNavigation = 'reload';
    });
  }

  ngOnInit(): void {
    this.getIcuId();
    this.getBedsFromIcu();
  }

}
