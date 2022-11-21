import data_generator
from faker import Faker

def insert_user(user):
    sql_template = "INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('{}', '{}', '{}', '{}', '{}', '{}');\n"
    return sql_template.format(user['username'], user['password'], user['name'], user['last_name'], user['DNI'], user['email'])

def insert_supervisor(supervisor):
    sql_template = "INSERT INTO responsables (f_alta, f_baja) VALUES ('{}', '{}');\n"
    return sql_template.format(supervisor['start_date'], supervisor['end_date'] if supervisor['end_date'] is not None else 'NULL')
    
def insert_student(student):
    sql_template = "INSERT INTO alumnos(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('{}', '{}', '{}', '{}', '{}');\n"
    return sql_template.format(student['university_degree'], student['expedient_grade'], student['birth_date'], student['phone'], student['total_hours'])

def insert_company(company):
    sql_template = "INSERT INTO empresas (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES ('{}','{}', '{}', '{}', '{}', '{}', '{}', '{}');\n"
    return sql_template.format(company['id'],company['name'], company['email_suffix'], company['phone'], company['address'], company['city'], company['postal_code'], company['description'])

def insert_tutor(tutor):
    sql_template = "INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('{}', '{}','{}');\n"
    return sql_template.format(tutor['start_date'], tutor['end_date'] if tutor['end_date'] is not None else 'NULL',tutor['company_id'])

def insert_offer(offer):
    sql_template = "INSERT INTO ofertas (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES ('{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}');\n"
    return sql_template.format(offer['id'], offer['title'], offer['category'], offer['company_id'], offer['address'], offer['requirements'], offer['description'], offer['schedule'], offer['weeks'], offer['salary'], offer['vacants'])

def insert_applications(application):
    sql_template = "INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('{}', '{}', '{}');\n"
    return sql_template.format(application['student_id'], application['offer_id'], application['preference'])

def insert_contracts(contracts):
    sql_template = "INSERT INTO practica(id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES ('{}', '{}', '{}', '{}', '{}', '{}');\n"
    return sql_template.format(contracts['student_id'], contracts['offer_id'], contracts['grade'], contracts['report'], contracts['start_date'], contracts['end_date'] if contracts['end_date'] is not None else 'NULL')

def create_sql(file_name, fake, n_sep):
    # Create a SQL file to load the data
    with open(file_name, "w") as file:
        # Insert supervisor data
        supervisors = data_generator.generate_supervisors(fake, 1)
        file.write("--"*n_sep + "RESPONSABLES" + "--"*n_sep + "\n")
        for supervisor in supervisors:
            file.write(insert_user(supervisor) + insert_supervisor(supervisor) + "\n")

        # Insert student data
        students = data_generator.generate_students(fake, 5)
        file.write("--"*n_sep + "ALUMNOS" + "--"*n_sep + "\n")
        for student in students:
            file.write(insert_user(student) + insert_student(student) + "\n")

        # Insert company data
        companies = data_generator.generate_companies(fake, 2)
        file.write("--"*n_sep + "EMPRESAS" + "--"*n_sep + "\n")
        for company in companies:
            file.write(insert_company(company) + "\n")

        # Insert tutor data
        tutors = data_generator.generate_tutors(fake, 5, companies)
        file.write("--"*n_sep + "TUTORES" + "--"*n_sep + "\n")
        for tutor in tutors:
            file.write(insert_user(tutor) + insert_tutor(tutor) + "\n")

        # Insert offer data
        offers = data_generator.generate_offers(fake, 5, companies)
        file.write("--"*n_sep + "OFERTAS" + "--"*n_sep + "\n")
        for offer in offers:
            file.write(insert_offer(offer) + "\n")
        
        # Insert applications data
        applications = data_generator.generate_applications(fake, 5, students, offers)
        file.write("--"*n_sep + "OFERTA_SELECCIONADA" + "--"*n_sep + "\n")
        for application in applications:
            file.write(insert_applications(application) + "\n")

        # Insert contracts data
        contracts = data_generator.generate_contracts(fake, 5, applications, students)
        file.write("--"*n_sep + "PRACTICA" + "--"*n_sep + "\n")
        for contract in contracts:
            file.write(insert_contracts(contract) + "\n")
    print("SQL file created")


fake = Faker("es_ES")
create_sql("devops/load.sql", fake, 10)