import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { responsable } from 'src/app/interfaces/responsable';
import { ResponsableService } from 'src/app/services/responsable.service';
import { PopUpPasswordComponent } from '../../pop-ups/pop-up-password/pop-up-password.component';

@Component({
  selector: 'app-responsabledata',
  templateUrl: './responsabledata.component.html',
  styleUrls: ['./responsabledata.component.scss']
})

export class ResponsabledataComponent {
  responsable: responsable | undefined;
  constructor(private responsableService: ResponsableService,private dialog: MatDialog) { }

  ngOnInit(): void {
    this.responsableService.getResponsable().subscribe(
      (data) => {
        this.responsable = data
      }
    );
  }

  changePassword() {
    this.dialog.open(PopUpPasswordComponent);
  }
}
