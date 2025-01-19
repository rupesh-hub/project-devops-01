import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Message} from "../model/message.model";
import {environment} from "../../environments/environment-development";

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private baseURL:string = `${environment.API_URL}/messages`;

  constructor(private _http: HttpClient) { }

  public getMessages = (): Observable<Message[] | HttpErrorResponse> => {
    return this._http.get<Message[] | HttpErrorResponse>(`${this.baseURL}`);
  }
}
