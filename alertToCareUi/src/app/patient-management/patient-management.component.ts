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
      console.log(dataJson.patientId);
      this.dischargePatient(dataJson.patientId);
    });

    
  }

  dischargePatient(patientId){
    var result = window.confirm("Discharge Patient?");
    if(result){
      this.http.delete("/api/patients/" + patientId).subscribe(data =>{
        window.alert("Patient Discharged");
      });
    }
    else{
      window.alert("Could not discharge patient");
    }
  }

  ngOnInit(): void {
    this.getIcuId();
    this.getBedsFromIcu();
  }

}
