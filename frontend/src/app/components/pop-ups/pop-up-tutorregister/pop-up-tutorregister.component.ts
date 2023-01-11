import { Router } from '@angular/router';
import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-pop-up-tutorregister',
  templateUrl: './pop-up-tutorregister.component.html',
  styleUrls: ['./pop-up-tutorregister.component.scss']
})
export class PopUpTutorregisterComponent {
  seleccioncorrecta:boolean = false;
  text:String = "";
  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private router: Router) {}

  ngOnInit(): void {
    this.seleccioncorrecta = this.data.boolean;
    this.text = this.data.txt;
  }

  backtoLogin(){
    if(this.seleccioncorrecta){
      this.router.navigate(['/login']);
    }
  }
}
