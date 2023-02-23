import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';

import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Post } from "./Post";
@Injectable({
    providedIn:'root'
})
export class PostService{
    private apiServerUrl=environment.apiBaseUrl;
    constructor(private http: HttpClient){}
    public getPosts():Observable<Post[]>{
        return this.http.get<Post[]>(`${this.apiServerUrl}/api/v1/search/`);
    }
    public post(data:FormData):Observable<void>{
        return this.http.post<void>(`${this.apiServerUrl}/api/v1/postgresql/download`,data);
    }
    
 
}