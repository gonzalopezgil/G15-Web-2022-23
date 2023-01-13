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
  data: UnassignedPractice[] = [];
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
          this.userService.getUserById(this.solicitudes[i].aplicante).subscribe(
            (alumno) => {
              this.alumno = alumno;
              this.empresaService.getCompanyById(this.solicitudes[i].empresa).subscribe(
                (empresa) => {
                  this.empresa = empresa;
                  this.practiceService.getPracticesResponsable().subscribe(
                    (practicas) =>{
                      for (let i = 0; i<practicas.length;i++){
                        if(this.solicitudes[i].aplicante == practicas[i].student_id)
                          this.offerService.getOfferById(this.oferta.company_id).subscribe(
                            (oferta) => {
                            this.oferta = oferta;
                            this.data[i]= { name : alumno.first_name + " " + alumno.last_name, companyName : empresa.name, position: oferta.position, f_inicio : oferta.start_date}
                            console.log(this.dataSource.data)
                            this.dataSource._updateChangeSubscription();
                          }
                        )
                      }
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
      (data: any) =>{
        const file = new Blob([data], { type: 'application/pdf' });
        const fileURL = URL.createObjectURL(file);
        window.open(fileURL);
      }
    )
  }
}
