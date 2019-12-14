import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {Mobil} from "../mobil";
import {MerkService} from "../merk.service";
import {Observable} from "rxjs";
import {HttpResponse} from "@angular/common/http";
import {Merk} from "../merk";



@Component({
  selector: 'app-update-mobil',
  templateUrl: './update-mobil.component.html',
  styleUrls: ['./update-mobil.component.css']
})
export class UpdateMobilComponent implements OnInit {
  @Input() public mobil: Mobil;
  merks : Merk[];
  @Output() passEntry: EventEmitter<any> = new EventEmitter();
  constructor(
    private activeModal: NgbActiveModal,
    private merkService: MerkService
  ) {


  }

  ngOnInit() {
    console.log(this.mobil);

  }

  passBack() {
    this.passEntry.emit(this.mobil);
    this.activeModal.close();
  }

  getAllMerk(){
    this.merkService.getAllMerk().subscribe(
      (res: HttpResponse<Merk[]>) => {
        this.merks = res.body;
      }
    );
  }


}
