import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NewPostComponent } from './new-post/new-post.component';
import { PostComponent } from './post/post.component';
import { PostsComponent } from './posts/posts.component';
import { InfoComponent } from './info/info.component';
import { ProfileMenuComponent } from './profile-menu/profile-menu.component';
import { HttpClientModule } from '@angular/common/http';
import { ActualitiesComponent } from './actualities/actualities.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NewPostComponent,
    PostComponent,
    PostsComponent,
    InfoComponent,
    ProfileMenuComponent,
    ActualitiesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
