import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-icus',
  templateUrl: './icus.component.html',
  styleUrls: ['./icus.component.css']
})
export class IcusComponent implements OnInit {

  url = `/api/icus`;
  items = [];

  constructor(private http: HttpClient) {}

  getIcuData(){
    this.http.get(this.url).toPromise().then(data => {
      for(let key in data){
        this.items.push(data[key]);
      }
    });
  }

  ngOnInit(): void {
    this.getIcuData();
  }

}
