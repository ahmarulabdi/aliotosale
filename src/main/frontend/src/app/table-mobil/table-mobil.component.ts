import {Component, OnInit} from '@angular/core';
import {MobilService} from "../mobil.service";
import {Mobil} from "../mobil";
import {HttpResponse} from "@angular/common/http";
import {AddUpdateMobilComponent} from "../add-update-mobil/add-update-mobil.component";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ToastrService} from "ngx-toastr";
import {TypeService} from "../type.service";
import {MerkService} from "../merk.service";
import {Type} from "../type";
import {Merk} from "../merk";
import {faSearch} from "@fortawesome/free-solid-svg-icons";
import {FormBuilder} from "@angular/forms";
import {ConfirmDialogService} from "../confirm-dialog/confirm-dialog";

@Component({
  selector: 'app-table-mobil',
  templateUrl: './table-mobil.component.html',
  styleUrls: ['./table-mobil.component.css']
})
export class TableMobilComponent implements OnInit {
  mobils: Mobil[];
  faSearch = faSearch;
  criteria: number;
  criteriaValue: string;

  constructor(
    private mobilService: MobilService,
    private modalService: NgbModal,
    private toastrService: ToastrService,
    private typeService: TypeService,
    private merkService: MerkService,
    private fb: FormBuilder,
    private confirmDialogService: ConfirmDialogService
  ) {
    this.criteria = 0;
    this.getAllMobil();
  }

  ngOnInit() {
  }

  searchCriteria() {
    if (this.criteria == 0) {
      this.getAllMobil();
    }

    if (this.criteria == 1) {
      this.getMobilByBrand(this.criteriaValue);
    }
    if (this.criteria == 2) {
      this.getMobilByTypeNama(this.criteriaValue);
    }
  }

  getMobilByBrand(brand): void {
    this.mobilService.getMobilByBrand(brand).subscribe(
      (res: HttpResponse<Mobil[]>) => {
        this.mobils = [];
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
        );
      }, () => this.toastrService.error("gagal"),
    )
  }

  getMobilByTypeNama(typeNama): void {
    this.mobilService.getMobilByTypeNama(typeNama).subscribe(
      (res: HttpResponse<Mobil[]>) => {
        this.mobils = [];
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
        );
      }, () => this.toastrService.error("gagal"),
    )
  }

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
        );
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
    } else {
      this.mobilService.addMobilByMerkIdTypeId(mobil).subscribe(
        (res: HttpResponse<Mobil>) => {
          this.getAllMobil();
          if (res.status === 200) {
            this.toastrService.success("berhasil tambah mobil");
          }
        },
        () => this.toastrService.error("koneksi gagal"),
      )
    }
  }

  modaladdOrUpdate(mobil ?: Mobil) {
    const modalRef = this.modalService.open(AddUpdateMobilComponent);
    if (mobil) {
      modalRef.componentInstance.mobil = mobil;
    }
    modalRef.componentInstance.passEntry.subscribe((receiveEntry) => {
        if (mobil) {
          this.save(receiveEntry, mobil.id);
        } else {
          this.save(receiveEntry);
        }
      }
    );
  }

  modalDelete(id: number) {
    this.confirmDialogService.confirm('Konfirmasi Hapus ..', 'Apakah yakin ingin hapus mobil ini ?')
      .then((confirmed) => {
          if (confirmed) {
            this.mobilService.deleteMobilById(id).subscribe(
              (res: HttpResponse<Boolean>) => {
                this.getAllMobil();
                if (res.status === 200) {
                  this.toastrService.success("berhasil hapus mobil");
                }
              },
              () => this.toastrService.error("koneksi gagal"))
          }
        }
      ).catch(() => {});

  }
}
