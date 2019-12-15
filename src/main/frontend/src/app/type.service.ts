import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Type} from './type';
import {Observable} from "rxjs";
import {Merk} from "./merk";

type EntityResponseType = HttpResponse<Type>;
type EntityArrayResponseType = HttpResponse<Type[]>;

@Injectable({
  providedIn: 'root'
})


export class TypeService {
  private typeUrl = "http://localhost:8080/api/type";

  constructor(
    protected http: HttpClient
  ) {
  }

  getAllType(): Observable<EntityArrayResponseType> {
    return this.http.get<Type[]>(this.typeUrl, {observe: "response"})
  }
  getTypeById(id: number): Observable<EntityResponseType> {
    return this.http.get<Type>(`${this.typeUrl}/${id}`, { observe: 'response'})
  }
}
