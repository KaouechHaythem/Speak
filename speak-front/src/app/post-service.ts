import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';

import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Post } from "./Post";
@Injectable({
    providedIn:'root'
})
export class PostService{
    public search(motSearch: string, type: string):Observable<Post[]> {
        return this.http.get<Post[]>(`http://localhost:8081/api/v1/post/search/${motSearch}/${type}`);
    }
    private apiServerUrl=environment.apiBaseUrl;
    constructor(private http: HttpClient){}
    public getPosts():Observable<Post[]>{
        return this.http.get<Post[]>(`${this.apiServerUrl}/api/v1/search/`);
    }
    public post(data:FormData):Observable<void>{
        return this.http.post<void>(`${this.apiServerUrl}/api/v1/pub/download`,data);
    }
    public post_text(data:FormData):Observable<void>{
        return this.http.post<void>(`${this.apiServerUrl}/api/v1/pub/post`,data);
    }
    
    
 
}