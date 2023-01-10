import { Component ,OnInit} from '@angular/core';
import { Practica } from 'src/app/interfaces/practica';
import { PracticesService } from 'src/app/services/practices.service';

@Component({
  selector: 'app-practices-ongoing',
  templateUrl: './practices-ongoing.component.html',
  styleUrls: ['./practices-ongoing.component.scss']
})
export class PracticesOngoingComponent implements OnInit {
    practice: Practica | undefined;
    constructor(private PracticeService: PracticesService) { }
  
    ngOnInit(): void {
      this.practice = this.PracticeService.getPractice(0);
    }
  
  }