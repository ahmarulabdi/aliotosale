import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Merk} from "./merk";

type EntityResponseMerk = HttpResponse<Merk>;
type EntityArrayResponseMerk = HttpResponse<Merk[]>;
@Injectable({
  providedIn: 'root'
})
export class MerkService {

  private merkUrl = 'http://localhost:8080/api/merk';

  constructor(
    protected http: HttpClient
  ) {
  }

  getAllMerk(): Observable<EntityArrayResponseMerk> {
    return this.http.get<Merk[]>(this.merkUrl, { observe: 'response'});
  }

  getMerkById(id: number): Observable<EntityResponseMerk> {
    return this.http.get<Merk>(`${this.merkUrl}/${id}`, { observe: 'response'})
  }
}
