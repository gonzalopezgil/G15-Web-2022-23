import data_generator
from faker import Faker

def insert_user(user):
    sql_template = "INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('{}', '{}', '{}', '{}', '{}', '{}');\n"
    return sql_template.format(user['username'], user['password'], user['name'], user['last_name'], user['DNI'], user['email'])

def insert_supervisor(supervisor):
    sql_template = "INSERT INTO responsables (f_alta, f_baja) VALUES ('{}', '{}');\n"
    return sql_template.format(supervisor['start_date'], supervisor['end_date'] if supervisor['end_date'] is not None else 'NULL')
    
def insert_student(student):
    sql_template = "INSERT INTO alumnos(grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('{}', '{}', '{}', '{}', '{}');\n"
    return sql_template.format(student['university_degree'], student['expedient_grade'], student['birth_date'], student['phone'], student['total_hours'])

def insert_company(company):
    sql_template = "INSERT INTO empresas (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES ('{}','{}', '{}', '{}', '{}', '{}', '{}', '{}');\n"
    return sql_template.format(company['id'],company['name'], company['email_suffix'], company['phone'], company['address'], company['city'], company['postal_code'], company['description'])

def insert_tutor(tutor):
    sql_template = "INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('{}', '{}','{}');\n"
    return sql_template.format(tutor['start_date'], tutor['end_date'] if tutor['end_date'] is not None else 'NULL',tutor['company_id'])

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
    print("SQL file created")


fake = Faker("es_ES")
create_sql("devops/load.sql", fake, 10)