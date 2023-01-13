import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PracticesService } from 'src/app/services/practices.service';
import { TutorsService } from 'src/app/services/tutors.service';

@Component({
  selector: 'app-pop-up-add-offer',
  templateUrl: './pop-up-add-offer.component.html',
  styleUrls: ['./pop-up-add-offer.component.scss']
})
export class PopUpAddOfferComponent {
  form: FormGroup = new FormGroup({});

  constructor(@Inject(MAT_DIALOG_DATA) public data: boolean,
              private fb: FormBuilder,
              private practiceService: PracticesService,
              private tutorService: TutorsService,
              private dialogRef: MatDialogRef<any>) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      position: ['',Validators.required],
      vacancies: ['',Validators.required],
      category: ['',Validators.required],
      schedule: ['',Validators.required],
      salary: ['',Validators.required],
      requirements: ['',Validators.required],
      start_date: ['',Validators.required],
      weeks: ['',Validators.required],
      description: ['',Validators.required]
    });
  }

  get position() {return this.form.get('position');}
  get vacancies() {return this.form.get('vacancies');}
  get category() {return this.form.get('category');}
  get schedule() {return this.form.get('schedule');}
  get salary() {return this.form.get('salary');}
  get start_date() {return this.form.get('start_date');}
  get weeks() {return this.form.get('weeks');}
  get requirements() {return this.form.get('requirements');}
  get description() {return this.form.get('description');}

  onSubmit(){
    let offer = {
      position: this.form.value.position,
      vacancies: this.form.value.vacancies,
      category: this.form.value.category,
      schedule: this.form.value.schedule,
      salary: this.form.value.salary,
      start_date: this.form.value.start_date,
      weeks: this.form.value.weeks,
      requirements: this.form.value.requirements,
      description: this.form.value.description,
      company_id: -1,
      id: 0
    }

    this.tutorService.getTutor().subscribe((tutor) => {
      offer.company_id = tutor.company_id;
      this.practiceService.saveOffer(offer).subscribe(() => {
        this.dialogRef.close();
      });
    });
  }

  onCancel(){
    this.dialogRef.close();
  }
}
