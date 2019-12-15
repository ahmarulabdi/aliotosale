import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {Mobil} from "../mobil";
import {MerkService} from "../merk.service";
import {HttpResponse} from "@angular/common/http";
import {Merk} from "../merk";
import {TypeService} from "../type.service";
import {Type} from "../type";
import {ToastrService} from "ngx-toastr";
import {MobilService} from "../mobil.service";


@Component({
  selector: 'app-update-mobil',
  templateUrl: './add-update-mobil.component.html',
  styleUrls: ['./add-update-mobil.component.css']
})
export class AddUpdateMobilComponent implements OnInit {
  @Input() public mobil: Mobil;
  merks: Merk[];
  types: Type[];
  @Output() passEntry: EventEmitter<any> = new EventEmitter();

  constructor(
    private activeModal: NgbActiveModal,
    private merkService: MerkService,
    private typeService: TypeService,
  ) {
  }

  ngOnInit() {
    this.getAllMerk();
    this.getAllType();
  }

  passBack() {
    this.passEntry.emit(this.mobil);
    this.activeModal.close();

  }



  getAllMerk() {
    this.merkService.getAllMerk().subscribe(
      (res: HttpResponse<Merk[]>) => {
        this.merks = res.body;
      }
    );
  }

  getAllType() {
    this.typeService.getAllType().subscribe(
      (res: HttpResponse<Type[]>) => {
        this.types = res.body;
      }
    )
  }

}
