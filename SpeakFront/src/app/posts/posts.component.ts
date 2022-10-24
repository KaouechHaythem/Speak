import { Component, OnInit } from '@angular/core';
import { Post } from '../Post';
import { PostService } from '../PostService';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
posts : Post[]=[];
  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.postService.getPosts().subscribe((response:Post[])=>{
      this.posts=response;
  });
  }

}
