import {Component, OnInit} from '@angular/core';
import {MobilService} from "../mobil.service";
import {Mobil} from "../mobil";
import {HttpResponse} from "@angular/common/http";
import {AddUpdateMobilComponent} from "../add-update-mobil/add-update-mobil.component";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ToastrService} from "ngx-toastr";

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
    private toastrService: ToastrService
  ) {
    this.getAllMobil();

  }

  ngOnInit() {
  }


  getAllMobil(): void {
    this.mobilService.getAllMobil().subscribe(
      (res: HttpResponse<Mobil[]>) => {
        this.mobils = res.body;
      },() => this.toastrService.error("koneksi gagal")
    );
  }

  save(mobil: Mobil, id ?: number) {
    if (id) {
      this.mobilService.updateMobilById(id, mobil).subscribe(
        (res: HttpResponse<Mobil>) => {
          this.getAllMobil();
          if(res.status === 200){
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
      this.save(receiveEntry,mobil.id)
    );
  }
}
