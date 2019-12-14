import {Component, OnInit} from '@angular/core';
import {MobilService} from "../mobil.service";
import {Mobil} from "../mobil";
import {HttpResponse} from "@angular/common/http";
import {UpdateMobilComponent} from "../update-mobil/update-mobil.component";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-table-mobil',
  templateUrl: './table-mobil.component.html',
  styleUrls: ['./table-mobil.component.css']
})
export class TableMobilComponent implements OnInit {
  mobils: Mobil[];

  constructor(
    private mobilService: MobilService,
    private modalService: NgbModal
  ) {
    this.getAllMobil();

  }

  ngOnInit() {
  }


  getAllMobil(): void {
    this.mobilService.getAllMobil().subscribe(
      (res: HttpResponse<Mobil[]>) => {
        this.mobils = res.body;
      }
    );
  }

  modalUpdateMobil(id: number, mobil: Mobil) {
    const modalRef = this.modalService.open(UpdateMobilComponent);
    modalRef.componentInstance.mobil = mobil;
    modalRef.componentInstance.passEntry.subscribe((receiveEntry) => console.log(receiveEntry));
  }
}
