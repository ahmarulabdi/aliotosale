import {Component, OnInit} from '@angular/core';
import {MobilService} from "../mobil.service";
import {Mobil} from "../mobil";
import {HttpResponse} from "@angular/common/http";
import {AddUpdateMobilComponent} from "../add-update-mobil/add-update-mobil.component";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ToastrService} from "ngx-toastr";
import {filter, map} from "rxjs/operators";
import {TypeService} from "../type.service";
import {MerkService} from "../merk.service";
import {Type} from "../type";
import {Merk} from "../merk";

@Component({
  selector: 'app-table-mobil',
  templateUrl: './table-mobil.component.html',
  styleUrls: ['./table-mobil.component.css']
})
export class TableMobilComponent implements OnInit {
  mobils: Mobil[];
  constructor(
    private mobilService: MobilService,
    private modalService: NgbModal,
    private toastrService: ToastrService,
    private typeService: TypeService,
    private merkService: MerkService
  ) {
    this.getAllMobil();
  }

  ngOnInit() {}


  getAllMobil(): void {
    this.mobils = [];
    this.mobilService.getAllMobil().subscribe(
      (res: HttpResponse<Mobil[]>) => {
        res.body.map(
          mobil => {
            {
              this.typeService.getTypeById(mobil.typeId).subscribe(
                (res: HttpResponse<Type>) => {
                  mobil.typeNama = res.body.nama;
                }
              );
              this.merkService.getMerkById(mobil.merkId).subscribe(
                (res: HttpResponse<Merk>) => {
                  mobil.merkBrand = res.body.brand;
                }
              );
              this.mobils.push(mobil);
            }
          }
        )
      });
  }

  save(mobil: Mobil, id ?: number) {
    if (id) {
      this.mobilService.updateMobilById(id, mobil).subscribe(
        (res: HttpResponse<Mobil>) => {
          this.getAllMobil();
          if (res.status === 200) {
            this.toastrService.success("berhasil perbarui mobil");
          }
        },
        () => this.toastrService.error("koneksi gagal"),
      )
    }
  }

  modaladdOrUpdate(mobil ?: Mobil) {
    const modalRef = this.modalService.open(AddUpdateMobilComponent);
    modalRef.componentInstance.mobil = mobil;
    modalRef.componentInstance.passEntry.subscribe((receiveEntry) =>
      this.save(receiveEntry, mobil.id)
    );
  }
}
