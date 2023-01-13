import { ChangeDetectorRef, Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, MatPaginatorIntl } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Company } from 'src/app/interfaces/company';
import { Offers } from 'src/app/interfaces/offers';
import { PracticaUser } from 'src/app/interfaces/practica-user';
import { User } from 'src/app/interfaces/user';
import { EmpresaService } from 'src/app/services/empresa.service';
import { OfferService } from 'src/app/services/offer.service';
import { PracticesService } from 'src/app/services/practices.service';
import { UsersService } from 'src/app/services/users.service';
import {UnassignedPractice} from 'src/app/interfaces/unassigned-practice'
import { PopUpAssignPracticesComponent } from '../../pop-ups/pop-up-assign-practices/pop-up-assign-practices.component';
import { SolicitudService } from 'src/app/services/solicitud.service';
import { Solicitud } from 'src/app/interfaces/solicitud';
import { Student } from 'src/app/interfaces/student';

@Component({
  selector: 'app-practice-assigned',
  templateUrl: './practice-assigned.component.html',
  styleUrls: ['./practice-assigned.component.scss']
})
export class PracticeAssignedComponent {
  displayedColumns: string[] = [ 'name', 'company','position', 'f_inicio' ];
  dataSource = new MatTableDataSource<UnassignedPractice>();
  @Output() messageEvent = new EventEmitter<UnassignedPractice[]>();
  @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);;
  solicitudes: Solicitud[] = [];
  practica: PracticaUser = {
    end_date: '',
    id: -1,
    mark: -1,
    offer_id: -1,
    report: '',
    start_date: new Date(),
    student_id: -1
  }
  data: UnassignedPractice[] = [];
  alumno: Student = {
    id: -1,
    first_name: '',
    username: '',
    last_name: '',
    nif: '',
    email: '',
    degree: '',
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
  private solicitudService: SolicitudService, private empresaService:EmpresaService, private offerService:OfferService,
  private practiceService: PracticesService){ }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;

  }
  ngOnInit(): void{

    this.solicitudService.getSolicitudes().subscribe(
      (solicitudes) => {
        this.solicitudes = solicitudes;
        for(let i = 0; i<this.solicitudes.length; i++){
          console.log(solicitudes[i].student_id)
          this.userService.getStudentBy(this.solicitudes[i].student_id).subscribe(
            (alumno) => {
              this.alumno = alumno;
              this.practiceService.getPracticeById(this.solicitudes[i].practices_id).subscribe(
                (practica) => {
                  this.practica = practica;
                  this.offerService.getOfferById(practica.offer_id).subscribe(
                    (oferta) =>{
                      this.oferta = oferta;
                          this.empresaService.getCompanyById(this.oferta.company_id).subscribe(
                            (empresa) => {
                              this.empresa = empresa;
                              this.data[i]= { name : alumno.first_name + " " + alumno.last_name, companyName : empresa.name, position: oferta.position, start_date : new Date(oferta.start_date)}
                              console.log(this.dataSource.data)
                              this.dataSource._updateChangeSubscription();
                            }
                          )
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
  generatePdf(): void {
    this.practiceService.getReport().subscribe(
      (data) =>{
        const file = new Blob([data], { type: 'application/pdf' });
        const fileURL = URL.createObjectURL(file);
        window.open(fileURL);
      }
    )
  }
}
