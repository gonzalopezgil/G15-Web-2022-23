import { TutorsService } from 'src/app/services/tutors.service';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-registercompany',
  templateUrl: './registercompany.component.html',
  styleUrls: ['./registercompany.component.scss']
})
export class RegistercompanyComponent {
  form: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder,private TutorsService: TutorsService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      titulo: ['', Validators.required],
      empresa: ['', Validators.required],
      plazas:  ['', Validators.required],
      horario: ['', Validators.required],
      dias: ['', Validators.required],
      semanas: ['', Validators.required]
    });
  }

  get titulo() { return this.form.get('titulo'); }
  get empresa() { return this.form.get('empresa'); }
  get plazas() { return this.form.get('plazas'); }
  get horario() { return this.form.get('horario'); }
  get dias() { return this.form.get('dias'); }
  get semanas() { return this.form.get('semanas'); }

  clearForm() {
    this.form.reset();
  }

  onSubmit() {
    if(this.form.valid) {
      this.TutorsService.registerPractice(this.form);
    }
  }

}
