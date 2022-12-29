import { Component ,Inject,OnInit} from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Practica } from 'src/app/interfaces/practica';

@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.scss']
})
export class PopUpComponent implements OnInit{
  practicas : Practica[] = [];
  seleccioncorrecta:boolean = false;

  constructor(@Inject(MAT_DIALOG_DATA) public data: Practica[]) {
    this.practicas = data;
  }
  ngOnInit(): void {
    if (this.practicas.length < 10 && this.practicas.length >= 1) {
      this.seleccioncorrecta = true;
    }
  }
}
