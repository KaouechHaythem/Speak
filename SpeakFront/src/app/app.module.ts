import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileMenuComponent } from './profile-menu/profile-menu.component';
import { PostComponent } from './post/post.component';
import { InfoComponent } from './info/info.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PostsComponent } from './posts/posts.component';
import { NewPostComponent } from './new-post/new-post.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfileMenuComponent,
    PostComponent,
    InfoComponent,
    NavbarComponent,
    PostsComponent,
    NewPostComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
