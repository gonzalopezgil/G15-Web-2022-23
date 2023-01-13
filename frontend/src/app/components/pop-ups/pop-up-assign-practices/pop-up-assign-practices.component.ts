import { Component, Inject } from '@angular/core';
import { DialogRef } from '@angular/cdk/dialog';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PracticesService } from 'src/app/services/practices.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-pop-up-assign-practices',
  templateUrl: './pop-up-assign-practices.component.html',
  styleUrls: ['./pop-up-assign-practices.component.scss']
})
export class PopUpAssignPracticesComponent {
  constructor(private dialogRef: MatDialogRef<any>, private practiceService:PracticesService, private router: Router) {}
  ngOnInit(): void {
    this.dialogRef.updateSize('500px');
  }
  aceptar(): void {
    this.router.navigateByUrl("/dashboard-responsable/practice-assigned")
  }
}
