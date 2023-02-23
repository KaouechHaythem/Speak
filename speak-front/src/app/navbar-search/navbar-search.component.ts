import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar-search',
  templateUrl: './navbar-search.component.html',
  styleUrls: ['./navbar-search.component.css']
})
export class NavbarSearchComponent implements OnInit {
  @Input()searchWord:string | undefined;
  constructor() { }

  ngOnInit(): void {
    
  }

}
