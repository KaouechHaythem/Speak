import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  searchWord:String="";
  path:string="";
  constructor(private router:Router) { }
  public search(addForm:NgForm):void
  {
    this.searchWord=addForm.value.searchWord;
    this.path = "/search/"+this.searchWord+"/video"
    this.router.navigate([this.path]).then(() => {
      window.location.reload();
    });;
    
  }
  ngOnInit(): void {
  }

}
