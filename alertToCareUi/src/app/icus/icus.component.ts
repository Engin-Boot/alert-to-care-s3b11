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

  constructor(private http: HttpClient) {
    this.http.get(this.url).toPromise().then(data => {
      for(let key in data){
        console.log(data[key])
        this.items.push(data[key]);
      }

    });
   }

  ngOnInit(): void {
  }

}
