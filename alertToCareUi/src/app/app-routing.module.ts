import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IcusComponent } from './icus/icus.component';
import { PatientManagementComponent } from './patient-management/patient-management.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { VitalsCheckComponent } from './vitals-check/vitals-check.component';

const routes: Routes = [
  {path:"", redirectTo:'icus', pathMatch:'full'},
  {path:"icus", component : IcusComponent},
  {path:"examine/:icuId", component : PatientManagementComponent},
  {path:"add-patient/:bedId", component : AddPatientComponent},
  {path:"vitals-check/:deviceId", component : VitalsCheckComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponents = [ IcusComponent, PatientManagementComponent, AddPatientComponent, VitalsCheckComponent]
