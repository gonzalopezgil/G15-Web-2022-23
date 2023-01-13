import { Component ,OnInit} from '@angular/core';
import { Practica } from 'src/app/interfaces/practica';
import { PracticesService } from 'src/app/services/practices.service';
import { AuthService } from 'src/app/services/auth.service';
import { Offer } from 'src/app/interfaces/offer';
import { Company } from 'src/app/interfaces/company';

@Component({
  selector: 'app-practices-ongoing',
  templateUrl: './practices-ongoing.component.html',
  styleUrls: ['./practices-ongoing.component.scss']
})
export class PracticesOngoingComponent implements OnInit {
    practices: Practica[] = [];
    offer_id:Number = -1;
    offers: Offer[] = [];
    offer: Offer = {
      id: -1,
      pos: -1,
      company_id: -1,
      position: "",
      vacancies: -1,
      category: "",
      schedule: "",
      weeks: -1,
      start_date: new Date(),
      company_name: "",
    }
    companyName: string = "";

    constructor(private PracticeService: PracticesService,private authService: AuthService) { }

    ngOnInit(): void {
      let id = this.authService.getId();
      this.PracticeService.getPractices().subscribe(
        (data) => {
          this.practices = data;
          for (let i = 0; i < this.practices.length; i++) {
            if(this.practices[i].student_id == id && this.practices[i].end_date == null){
              this.offer_id = this.practices[i].offer_id;
              break;
            }
          }
          this.PracticeService.getOffers().subscribe(
            (data) => {
              this.offers = data;
              for (let i = 0; i < data.length; i++) {
                if(data[i].id == this.offer_id){
                  this.offer = this.offers[i];
                  this.PracticeService.getCompanyName(data[i].company_id).subscribe((company:Company) => {
                    this.companyName = company.name;
                  });
                  break;
                }

              }
            });

        });
    }

  }
