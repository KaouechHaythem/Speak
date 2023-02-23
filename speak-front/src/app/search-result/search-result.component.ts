import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../Post';
import { PostService } from '../post-service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {
  posts : Post[]=[] ;
  motSearch:string="";
  type:string="";
  isEmpty:boolean=true;
  constructor(private router:ActivatedRoute,private postService: PostService) { 
     router.params.subscribe(params=>{this.motSearch=params['search'];
     this.type=params['type'];})
  }

  ngOnInit(): void {
    this.postService.search(this.motSearch,this.type).subscribe(
      (response: Post[]) => {
        this.posts = response;
        this.isEmpty=(this.posts.length==0);
      }
    );
    
    console.log(this.posts.length)
  }

}
