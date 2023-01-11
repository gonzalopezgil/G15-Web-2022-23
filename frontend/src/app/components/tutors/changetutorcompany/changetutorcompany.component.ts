import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TutorsService } from 'src/app/services/tutors.service';

@Component({
  selector: 'app-changetutorcompany',
  templateUrl: './changetutorcompany.component.html',
  styleUrls: ['./changetutorcompany.component.scss']
})
export class ChangetutorcompanyComponent {
  
  form: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder,private TutorsService: TutorsService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      company: ['', Validators.required],
      newtutor: ['', Validators.required],
    });
  }

  get company() {
    return this.form.get('company');
  }

  get newtutor() {
    return this.form.get('newtutor');
  }

  clearForm() {
    this.form.reset();
  }

  onSubmit() {
    if(this.form.valid) {
      this.TutorsService.changeTutor(this.form);
    }
  }
}
