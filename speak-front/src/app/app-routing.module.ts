import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualitiesComponent } from './actualities/actualities.component';
import { SearchResultComponent } from './search-result/search-result.component';

const APP_ROUTING: Routes = [{ path: '', component:ActualitiesComponent  },
{ path: 'search/:search/:type', component: SearchResultComponent },];

export const ROUTING = RouterModule.forRoot(APP_ROUTING);
