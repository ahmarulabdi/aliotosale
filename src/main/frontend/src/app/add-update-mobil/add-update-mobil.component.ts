import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {Mobil} from "../mobil";
import {MerkService} from "../merk.service";
import {HttpResponse} from "@angular/common/http";
import {Merk} from "../merk";
import {TypeService} from "../type.service";
import {Type} from "../type";
import {FormBuilder} from "@angular/forms";


@Component({
  selector: 'app-update-mobil',
  templateUrl: './add-update-mobil.component.html',
  styleUrls: ['./add-update-mobil.component.css']
})
export class AddUpdateMobilComponent implements OnInit {
  @Input() public mobil ?: Mobil;
  merks: Merk[];
  types: Type[];
  title: string;
  formMobil = this.fb.group({
    id: [],
    nomorKerangka: [],
    seriWilayah: [],
    nomor: [],
    seri: [],
    merkId: [],
    typeId: [],
    tahun: [],
  });


  @Output() passEntry: EventEmitter<any> = new EventEmitter();

  constructor(
    private activeModal: NgbActiveModal,
    private merkService: MerkService,
    private typeService: TypeService,
    private fb: FormBuilder
  ) {

  }

  ngOnInit() {
    if (this.mobil) {
      this.title = "Perbarui Mobil";
      this.formUpdate();
    }else{
      this.title = "Tambah Mobil";
    }

    this.getAllMerk();
    this.getAllType();
  }

  submit() {
    this.passEntry.emit(
      {
        ...new Mobil(),
        id: this.formMobil.get(['id']).value,
        nomorKerangka: this.formMobil.get(['nomorKerangka']).value,
        seriWilayah: this.formMobil.get(['seriWilayah']).value,
        nomor: this.formMobil.get(['nomor']).value,
        seri: this.formMobil.get(['seri']).value,
        merkId: this.formMobil.get(['merkId']).value,
        typeId: this.formMobil.get(['typeId']).value,
        tahun: this.formMobil.get(['tahun']).value,
      }
    );


    this.activeModal.close();
  }

  formUpdate() {
    this.formMobil.patchValue({
      id: this.mobil.id,
      nomorKerangka: this.mobil.nomorKerangka,
      seriWilayah: this.mobil.seriWilayah,
      nomor: this.mobil.nomor,
      seri: this.mobil.seri,
      merkId: this.mobil.merkId,
      typeId: this.mobil.typeId,
      tahun: this.mobil.tahun,
    })
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
