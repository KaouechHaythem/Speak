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
 owner:string="Haythem";
typePhoto() {
this.type="photo";
this.document.getElementById('cancelButton')?.click();
console.log(this.type);
}
  type:string="post";
  public createFile(event: any) {
    this.addFile = event.target.files[0];
  }
  public addFile: File | undefined;

onAddPhoto(form: NgForm) {
  this.type="photo"
throw new Error('Method not implemented.');
}
onSubmit(form:NgForm){
  throw new Error('Method not implemented.');
}
public onAddFile(addForm:NgForm):void{
  this.document.getElementById('cancelButton')?.click();

  if (this.addFile) {

   

    const formData = new FormData();
if(this.type!="post"){formData.append("file", this.addFile);}
formData.append("description", addForm.value.description);
formData.append("owner", this.owner);
    formData.append("type", this.type);
    
    this.type="post"
    console.log(formData);
    this.postService.post(formData);
    

    
     
    
}
}

  constructor(@Inject(DOCUMENT) private document: Document,private postService:PostService) { }

  ngOnInit(): void {
  }
  

}
