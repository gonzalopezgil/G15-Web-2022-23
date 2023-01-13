import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Tutor } from 'src/app/interfaces/tutor';
import { TutorsService } from 'src/app/services/tutors.service';
import { UsersService } from 'src/app/services/users.service';
import { PopUpPasswordComponent } from '../../pop-ups/pop-up-password/pop-up-password.component';

@Component({
  selector: 'app-tutordata',
  templateUrl: './tutordata.component.html',
  styleUrls: ['./tutordata.component.scss']
})
export class TutordataComponent {
  loadingState: boolean = true;
  tutor: Tutor = this.tutorService.getStubbyTutor();
  constructor(private tutorService: TutorsService, private dialog: MatDialog, private userService:UsersService) { }

  ngOnInit(): void {
    this.tutorService.getTutor().subscribe((tutor_response) => {
      console.log(tutor_response)
      this.tutor.admissionDate = tutor_response.admission_date;
      this.tutor.active = tutor_response.removal_date == null && tutor_response.admission_date != null;
      this.userService.getUser().subscribe((user_response) => {
        this.tutor.username = user_response.username;
        this.tutor.name = user_response.first_name;
        this.tutor.lastname = user_response.last_name;
        this.tutor.nif = user_response.nif;
        this.tutor.email = user_response.email;
        this.loadingState = false;
      });
    });
  }

  changePassword() {
    this.dialog.open(PopUpPasswordComponent, { data: false});
  }
}
