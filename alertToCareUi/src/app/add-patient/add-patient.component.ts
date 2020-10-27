import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {
  bedId:number

  constructor(private route: ActivatedRoute, private router: Router, private http:HttpClient) { }

  getBedId(){
    this.route.paramMap.subscribe(params => {
      this.bedId = +params.get('bedId');
    })
  }

  admitPatient(details){
    let url = "/api/patients";

    this.http.post(url, {
      name:details.name,
      age:details.age,
      bed:{
        bedId:this.bedId
      }
    }).toPromise().then((data: any) => { })
    
    this.router.navigate([`/icus`]);
  }

  ngOnInit(): void {
    this.getBedId();
  }

}
