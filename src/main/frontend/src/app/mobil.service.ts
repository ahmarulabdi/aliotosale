import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Mobil} from "./mobil";
import {HttpClient, HttpResponse} from "@angular/common/http";

type EntityResponseMobil = HttpResponse<Mobil>;
type EntityArrayResponseMobil = HttpResponse<Mobil[]>;

@Injectable({
  providedIn: 'root'
})
export class MobilService {
  private mobilUrl = 'http://localhost:8080/api/mobil';

  constructor(
    protected http: HttpClient
  ) {
  }

  getAllMobil(): Observable<EntityArrayResponseMobil> {
    return this.http.get<Mobil[]>(this.mobilUrl, { observe: 'response'});
  }

  addMobilByMerkIdTypeId(mobil: Mobil): Observable<EntityResponseMobil> {
    return this.http.post<Mobil>(`${this.mobilUrl}/${mobil.merkId}/${mobil.typeId}`,mobil,{ observe: 'response'})
  }

  updateMobilById(id:number, mobil: Mobil): Observable<EntityResponseMobil> {
    return this.http.put<Mobil>(`${this.mobilUrl}/${id}`,mobil,{ observe: 'response'})
  }

  deleteMobilById(id:number): Observable<HttpResponse<Boolean>> {
    return this.http.delete<Boolean>(`${this.mobilUrl}/${id}`,{ observe: 'response'})
  }


}
