import { Component ,Inject,OnInit} from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Offer } from 'src/app/interfaces/offer';
import { PracticesService } from 'src/app/services/practices.service';

@Component({
  selector: 'app-pop-up-practices',
  templateUrl: './pop-up-practices.component.html',
  styleUrls: ['./pop-up-practices.component.scss']
})
export class PopUpPracticesComponent implements OnInit{
  practicas : Offer[] = [];
  seleccioncorrecta:boolean = false;

  constructor(@Inject(MAT_DIALOG_DATA) public data: Offer[],private practiceServices: PracticesService,private router: Router) {
    this.practicas = data;
  }
  ngOnInit(): void {
    if (this.practicas.length < 10 && this.practicas.length >= 1) {
      this.seleccioncorrecta = true;
    }
  }

  seleccionarPracticas(){
    this.practiceServices.selectPractices(this.practicas);
    this.router.navigate(['/dashboard-users']);
  }
}
