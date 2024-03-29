import { MerkService } from "./merk.service";
import { TypeService } from "./type.service";
import {Merk} from "./merk";
import {Type} from "./type";
import {HttpResponse} from "@angular/common/http";

export class Mobil {
  id: number;
  nomorKerangka: number;
  seriWilayah: string;
  nomor: number;
  seri: string;
  merkId: number;
  _merk ?: Merk;
  merkBrand ?: string;
  typeId: number;
  _type ?: Type;
  typeNama ?: string;
  tahun: string;
  craetedAt: string;
  updatedAt: string;
}
