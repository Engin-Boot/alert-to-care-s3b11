import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IcusComponent } from './icus/icus.component'; 

const routes: Routes = [
  {path:"", redirectTo:'icus', pathMatch:'full'},
  {path:"icus", component:IcusComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
