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
  public user = {
    name: 'Izzat Nadiri',
    age: 26
  };
  constructor(
    private mobilService: MobilService,
    private modalService: NgbModal
  ) {
  }

  ngOnInit() {
    this.getAllMobil();
    console.log(this.user);
  }


  getAllMobil(): void {
      this.mobilService.getAllMobil().subscribe(
        (res: HttpResponse<Mobil[]>) => {
          this.mobils = res.body;
        }
      )
  }

  modalUpdateMobil(id: number) {
    const modalRef = this.modalService.open(UpdateMobilComponent);
    modalRef.componentInstance.id = id;
    modalRef.componentInstance.passEntry.subscribe((receiveEntry) => console.log(receiveEntry));
  }
}
