import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TutorsService } from 'src/app/services/tutors.service';

@Component({
  selector: 'app-registercompany',
  templateUrl: './registercompany.component.html',
  styleUrls: ['./registercompany.component.scss']
})
export class RegistercompanyComponent {
  form: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder,private tutorService: TutorsService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      name: ['', Validators.required],
      mail_suffix: ['', Validators.required],
      phone:  ['', Validators.required ],
      address: ['', Validators.required],
      city: ['', Validators.required],
      postal_code: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  get name() { return this.form.get('name'); }
  get mail_suffix() { return this.form.get('mail_suffix'); }
  get phone() { return this.form.get('phone'); }
  get address() { return this.form.get('address'); }
  get city() { return this.form.get('city'); }
  get postal_code() { return this.form.get('postal_code'); }
  get description() { return this.form.get('description'); }

  clearForm() {
    this.form.reset();
  }

  onSubmit() {
    if(this.form.valid) {
      this.tutorService.registerCompany(this.form).subscribe(
        (res) => {
          console.log(res);
        });
    }
  }

}
