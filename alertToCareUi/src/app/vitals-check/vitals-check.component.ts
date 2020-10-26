import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vitals-check',
  templateUrl: './vitals-check.component.html',
  styleUrls: ['./vitals-check.component.css']
})
export class VitalsCheckComponent implements OnInit {
  deviceId:number
  url:string

  constructor(
    private route : ActivatedRoute,
    private http : HttpClient
  ) { }

  getDeviceId(){
    this.route.paramMap.subscribe(params => {
      this.deviceId = +params.get('deviceId');
      console.log(this.deviceId);
    })
  }

  checkVitals(formData){
    console.log(formData);
    this.url = `/api/alerts/${this.deviceId}`;

    this.http.post(this.url, {
      spo2 : formData.spo2,
      respRate : formData.respRate,
      bpm : formData.bpm
    }).toPromise().then((data : any) => {
      let flag = false;
      data.forEach((value, index) => {
        var str = value.errorMessage.split(" ");
        if(str[2] != "normal"){
          flag = true;
          window.alert("Alert the doctor : " + value.errorMessage);
        }
      });
      if(!flag){
        window.alert("All vitals are normal");
      }
      
    })
  }

  ngOnInit(): void {
    this.getDeviceId();
  }

}
