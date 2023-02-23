import { Component, Inject, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DOCUMENT } from '@angular/common';
import { PostService } from '../post-service';

@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.css']
})

export class NewPostComponent implements OnInit {
  owner: string = "Haythem";
  type: string = "post";
  typePhoto() {
    this.type = "photo";
    this.document.getElementById('cancelButtonImg')?.click();
    console.log(this.type);
  }
  typeVideo() {
    this.type = "video";
    this.document.getElementById('cancelButtonVid')?.click();
    console.log(this.type);
  }

  public createFile(event: any) {
    this.addFile = event.target.files[0];
  }
  public addFile: File | undefined;



  public onAddFile(addForm: NgForm): void {
    this.document.getElementById('cancelButton')?.click();
    
      const formData = new FormData();
      if (this.addFile) {
      if (this.type != "post") { formData.append("file", this.addFile); }}
      
      formData.append("description", addForm.value.description);
      formData.append("owner", this.owner);
      formData.append("type", this.type);
      
      console.log("hello")
      if (this.type != "post") { this.postService.post(formData).subscribe(
        () => { window.location.reload() }
      ); }
      else{
        this.postService.post_text(formData).subscribe(
          () => { window.location.reload() }
        );
      }
      this.type = "post";
      
      





    
  }

  constructor(@Inject(DOCUMENT) private document: Document, private postService: PostService) { }

  ngOnInit(): void {
  }


}
