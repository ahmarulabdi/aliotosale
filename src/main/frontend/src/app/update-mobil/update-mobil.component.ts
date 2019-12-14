import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";


@Component({
  selector: 'app-update-mobil',
  templateUrl: './update-mobil.component.html',
  styleUrls: ['./update-mobil.component.css']
})
export class UpdateMobilComponent implements OnInit {
  @Input() public id;
  @Output() passEntry: EventEmitter<any> = new EventEmitter();
  constructor(
    private activeModal: NgbActiveModal
  ) {}

  ngOnInit() {
    console.log(this.id);
  }

  passBack() {
    this.passEntry.emit(this.id);
    this.activeModal.close();
  }


}
