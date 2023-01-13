import { Component } from '@angular/core';
import { Company } from 'src/app/interfaces/company';
import { AuthService } from 'src/app/services/auth.service';
import { TutorsService } from 'src/app/services/tutors.service';

@Component({
  selector: 'app-company-view',
  templateUrl: './company-view.component.html',
  styleUrls: ['./company-view.component.scss']
})
export class CompanyViewComponent {

  company: Company = {
    id: -1,
    name: '',
    mail_suffix: '',
    phone: '',
    address: '',
    city: '',
    postal_code: -1,
    description: ''
  };

  constructor(private authService:AuthService, private tutorService: TutorsService) { }

  ngOnInit(): void {
    this.tutorService.getTutor().subscribe((tutor_response) => {
      let company_id = tutor_response.company_id;
      this.tutorService.getCompany(company_id).subscribe((company_response) => {
        this.company = company_response;
      });
    });
  }


}
