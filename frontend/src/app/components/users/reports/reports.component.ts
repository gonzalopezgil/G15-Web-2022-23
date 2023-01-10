import { Component ,OnInit} from '@angular/core';
import { Offer } from 'src/app/interfaces/offer';
import { User } from 'src/app/interfaces/user';
import { Tutor } from 'src/app/interfaces/tutor';
import { UsersService } from 'src/app/services/users.service';
import { TutorsService } from 'src/app/services/tutors.service';
import { PracticesService } from 'src/app/services/practices.service';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss']
})
export class ReportsComponent implements OnInit {
  practice: Offer | undefined;
  user: User | undefined;
  tutor: Tutor | undefined;
  constructor(private UserService: UsersService,private TutorService: TutorsService,private PracticeService: PracticesService) { }

  ngOnInit(): void {
    this.user = this.UserService.getUser();
    this.tutor = this.TutorService.getTutor();
    this.practice = this.PracticeService.getPractice(0);
  }

}
