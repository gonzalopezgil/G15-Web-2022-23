import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Tutor } from 'src/app/interfaces/tutor';
import { TutorsService } from 'src/app/services/tutors.service';
import { PopUpPasswordComponent } from '../../pop-ups/pop-up-password/pop-up-password.component';

@Component({
  selector: 'app-tutordata',
  templateUrl: './tutordata.component.html',
  styleUrls: ['./tutordata.component.scss']
})
export class TutordataComponent {
  tutor: Tutor | undefined;
  constructor(private tutorService: TutorsService,private dialog: MatDialog) { }

  ngOnInit(): void {
    this.tutorService.getTutor().subscribe((tutor) => {
      this.tutor = tutor;
    });
  }

  changePassword() {
    this.dialog.open(PopUpPasswordComponent, { data: false});
  }
}
