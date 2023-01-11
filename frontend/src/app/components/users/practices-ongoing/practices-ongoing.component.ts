import { Component ,OnInit} from '@angular/core';
import { Offer } from 'src/app/interfaces/offer';
import { PracticesService } from 'src/app/services/practices.service';

@Component({
  selector: 'app-practices-ongoing',
  templateUrl: './practices-ongoing.component.html',
  styleUrls: ['./practices-ongoing.component.scss']
})
export class PracticesOngoingComponent implements OnInit {
    practice: Offer | undefined;
    constructor(private PracticeService: PracticesService) { }
  
    ngOnInit(): void {
      //this.practice = this.PracticeService.getPractice(0);
    }
  
  }