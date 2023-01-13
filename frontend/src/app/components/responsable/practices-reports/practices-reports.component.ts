import { practiceReport } from 'src/app/interfaces/practiceReport';
import { ChangeDetectorRef, Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, MatPaginatorIntl } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Solicitud } from 'src/app/interfaces/solicitud';
import { SolicitudService } from 'src/app/services/solicitud.service';
import { PopUpAssignPracticesComponent } from '../../pop-ups/pop-up-assign-practices/pop-up-assign-practices.component';
import { Token } from '@angular/compiler';
import { User } from 'src/app/interfaces/user';
import { Company } from 'src/app/interfaces/company';
import { Offers } from 'src/app/interfaces/offers';
import { PracticaUser } from 'src/app/interfaces/practica-user';
import { UsersService } from 'src/app/services/users.service';
import { EmpresaService } from 'src/app/services/empresa.service';
import { OfferService } from 'src/app/services/offer.service';
import { PracticesService } from 'src/app/services/practices.service';
import { delay } from 'rxjs';
@Component({
  selector: 'app-practices-reports',
  templateUrl: './practices-reports.component.html',
  styleUrls: ['./practices-reports.component.scss']
})
export class PracticesReportsComponent {
  displayedColumns: string[] = [ 'name','lastname','grade', 'company','hours', 'mark' ];
  dataSource = new MatTableDataSource<practiceReport>();
  @Output() messageEvent = new EventEmitter<practiceReport[]>();
  @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);;
  practicas: PracticaUser[] = [];
  data: practiceReport[] = [];
  alumno: User = {
    first_name: '',
    username: '',
    last_name: '',
    dni: '',
    mail: '',
    degree: '',
    dob: '',
    phone: '',
    total_hours: 0,
  };
  empresa: Company =
   {
    id: 0,
    name: '',
    mail_suffix: '',
    phone: '',
    address: '',
    city: '',
    postal_code: 0,
    description: '',
  };
  oferta: Offers = {
    address: '',
    category: '',
    company_id: 0,
    description: '',
    id: 0,
    position: '',
    requirements: '',
    salary: 0,
    schedule: '',
    start_date: '',
    vacancies: 0,
    weeks: 0
  };
  constructor(private dialog : MatDialog, private userService:UsersService,
    private practicesService: PracticesService, private empresaService:EmpresaService, private offerService:OfferService){ }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;

  }
  ngOnInit(): void{

    this.practicesService.getPracticesResponsable().subscribe(
      (practicas) => {
        this.practicas = practicas;
        for(let i = 0; i<this.practicas.length; i++){
          this.userService.getUserById(this.practicas[i].student_id).subscribe(
            (alumno) => {
              this.alumno = alumno;
              this.offerService.getOfferById(this.practicas[i].offer_id).subscribe(
                (oferta) => {
                  this.oferta = oferta;
                  this.empresaService.getCompanyById(this.oferta.company_id).subscribe(
                    (empresa) => {
                      this.empresa = empresa;
                      this.data[i]= { nameUser : alumno.first_name, lastnameUser : alumno.last_name, gradeUser : alumno.degree, companyName : empresa.name, hours : alumno.total_hours, mark : practicas[i].mark}
                      console.log(this.dataSource.data)
                      this.dataSource._updateChangeSubscription();
                    }
                  )
                }
              )
            }
          )
        }
      }
    )
    console.log(this.data);
    this.dataSource.data = this.data
  }
  aceptar():void{
    this.dialog.open(PopUpAssignPracticesComponent);
  }

}
