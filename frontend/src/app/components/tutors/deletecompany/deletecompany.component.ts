import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TutorsService } from 'src/app/services/tutors.service';

@Component({
  selector: 'app-deletecompany',
  templateUrl: './deletecompany.component.html',
  styleUrls: ['./deletecompany.component.scss']
})
export class DeletecompanyComponent {
  
  form: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder,private TutorsService: TutorsService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      empresa: ['', Validators.required]
    });
  }

  get empresa() { return this.form.get('empresa'); }

  clearForm() {
    this.form.reset();
  }

  onSubmit() {
    if(this.form.valid) {
      this.TutorsService.deletePractice(this.form);
    }
  }
}
