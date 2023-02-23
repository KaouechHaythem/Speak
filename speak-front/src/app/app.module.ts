import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NewPostComponent } from './new-post/new-post.component';

import { PostsComponent } from './posts/posts.component';

import { ProfileMenuComponent } from './profile-menu/profile-menu.component';
import { HttpClientModule } from '@angular/common/http';
import { ActualitiesComponent } from './actualities/actualities.component';
import { FormsModule } from '@angular/forms';
import { SafeUrlPipe } from './safe-url.pipe';
import { SearchResultComponent } from './search-result/search-result.component';
import { RouterModule } from '@angular/router';
import { ROUTING } from './app-routing.module';
import { NavbarSearchComponent } from './navbar-search/navbar-search.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NewPostComponent,
   
    PostsComponent,
    
    ProfileMenuComponent,
    ActualitiesComponent,
    SafeUrlPipe,
    SearchResultComponent,
    NavbarSearchComponent
  ],
  imports: [
    ROUTING,
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
