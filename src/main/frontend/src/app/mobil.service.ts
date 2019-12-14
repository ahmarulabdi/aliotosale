import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Mobil} from "./mobil";
import {HttpClient, HttpResponse} from "@angular/common/http";

type EntityResponseType = HttpResponse<Mobil>;
type EntityArrayResponseType = HttpResponse<Mobil[]>;

@Injectable({
  providedIn: 'root'
})
export class MobilService {
  private mobilUrl = 'http://localhost:8080/api/mobil';

  constructor(
    protected http: HttpClient
  ) {
  }

  getAllMobil(): Observable<EntityArrayResponseType> {
    return this.http.get<Mobil[]>(this.mobilUrl, { observe: 'response'});
  }

}
