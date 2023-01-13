import { Component, OnInit } from '@angular/core';
import { Offer } from 'src/app/interfaces/offer';
import { UsersService } from 'src/app/services/users.service';
import { TutorsService } from 'src/app/services/tutors.service';
import { AuthService } from 'src/app/services/auth.service';
import { PracticesService } from 'src/app/services/practices.service';
import { Practica } from 'src/app/interfaces/practica';
import { Company } from 'src/app/interfaces/company';
import { Student } from 'src/app/interfaces/student';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss']
})
export class ReportsComponent implements OnInit {
  student: Student= {
    id: -1,
    first_name: '',
    username: '',
    last_name: '',
    nif: '',
    email: '',
    degree: '',
    total_hours: -1,
  }
  offer_id:Number = -1;
  practices: Practica[] = [];
  offers: Offer[] = [];
  offer: Offer = {
    id: -1,
    pos: -1,
    company_id: -1,
    position: "",
    vacancies: -1,
    schedule: "",
    category: "",
    weeks: -1,
    company_name: "",
    start_date: new Date(),
  }
  companyName: string = "";
  constructor(private UserService: UsersService, private TutorService: TutorsService, private PracticeService: PracticesService,private authService: AuthService) { }

  ngOnInit(): void {
    let id = this.authService.getId();

    this.PracticeService.getPractices().subscribe(
      (data) => {
        this.practices = data;
        for (let i = 0; i < this.practices.length; i++) {
          if (this.practices[i].student_id == id && this.practices[i].end_date != null) {
            this.offer_id = this.practices[i].offer_id;
            break;
          }
        }
        this.PracticeService.getOffers().subscribe(
          (data) => {
            this.offers = data;
            for (let i = 0; i < data.length; i++) {
              if (data[i].id == this.offer_id) {
                this.offer = this.offers[i];
                this.PracticeService.getCompanyName(data[i].company_id).subscribe((company: Company) => {
                  this.companyName = company.name;
                });
                break;
              }
            }
          });
        this.UserService.getStudent().subscribe((student: Student) => {
          this.student = student;
        });
      });
  }
}
