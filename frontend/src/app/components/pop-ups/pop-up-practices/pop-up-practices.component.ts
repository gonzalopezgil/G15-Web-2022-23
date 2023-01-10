import { Component ,Inject,OnInit} from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Offer } from 'src/app/interfaces/offer';

@Component({
  selector: 'app-pop-up-practices',
  templateUrl: './pop-up-practices.component.html',
  styleUrls: ['./pop-up-practices.component.scss']
})
export class PopUpPracticesComponent implements OnInit{
  practicas : Offer[] = [];
  seleccioncorrecta:boolean = false;

  constructor(@Inject(MAT_DIALOG_DATA) public data: Offer[]) {
    this.practicas = data;
  }
  ngOnInit(): void {
    if (this.practicas.length < 10 && this.practicas.length >= 1) {
      this.seleccioncorrecta = true;
    }
  }
}
