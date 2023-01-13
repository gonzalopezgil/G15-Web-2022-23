import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { responsable } from 'src/app/interfaces/responsable';
import { ResponsableService } from 'src/app/services/responsable.service';
import { UsersService } from 'src/app/services/users.service';
import { PopUpPasswordComponent } from '../../pop-ups/pop-up-password/pop-up-password.component';

@Component({
  selector: 'app-responsabledata',
  templateUrl: './responsabledata.component.html',
  styleUrls: ['./responsabledata.component.scss']
})

export class ResponsabledataComponent {
  responsable: responsable = {
    user_id: -1,
    name: '',
    lastname: '',
    dni: '',
    mail: '',
    username: '',
    admission_date: new Date(),
    removal_date: new Date(),
  };

  constructor(private responsableService: ResponsableService, private userService: UsersService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.responsableService.getResponsable().subscribe(
      (data) => {
        this.userService.getUserById(data.user_id).subscribe(
          (user_data) => {
            this.responsable.name = user_data.first_name;
            this.responsable.lastname = user_data.last_name;
            this.responsable.dni = user_data.nif;
            this.responsable.mail = user_data.email;
            this.responsable.username = user_data.username;
            this.responsable.admission_date = new Date(data.admission_date);
            this.responsable.removal_date = new Date(data.removal_date);
          }
        );
      }
    );
  }

  changePassword() {
    this.dialog.open(PopUpPasswordComponent);
  }
}
