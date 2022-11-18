# Generador de datos para la carga inicial de la base de datos
from faker import Faker
from random import choice, randrange
from datetime import datetime

# Generador de alumnos
def generate_user(fake):
    user = fake.unique
    first_name, last_name = user.name().split(' ', 1)
    username = first_name.lower().replace(" ","") + "." + last_name.lower().replace(" ",".")
    user = {
        # Campos comunes para usuarios
        'name': first_name,
        'last_name': last_name,
        'username': username,
        'password': user.password(),
        'DNI': user.nif(),
    }
    return user

def generate_students(fake, n):
    students = []
    degrees=['Ingeniería informática','Ingeniería de telecomunicaciones','Ingeniería de sistemas','Ingeniería de computadores','Ingeniería de software','Ingeniería de computadores y sistemas','Ingeniería de computadores y software','Ingeniería de telecomunicaciones y sistemas','Ingeniería de telecomunicaciones y software','Ingeniería de sistemas y software']

    for i in range(n):
        student = generate_user(fake)
        # Campos específicos para alumnos
        student['email'] = student['username'] + '@edu.uah.es'
        student['birth_date'] = fake.date_of_birth(None, 18, 25).strftime('%Y-%m-%d')
        student['phone'] = fake.phone_number()
        student['university_degree'] = choice(degrees)
        student['expedient_grade'] = randrange(0, 10)
        student['total_hours'] = choice([300, 350])
        students.append(student)
    return students

def generate_companies(fake, n):
    companies = []
    for i in range(n):
        address,city_postal_code = fake.address().splitlines()
        city,postal_code = city_postal_code.split(' ',1)
        company_name = fake.unique.company()
        company = {
            'id': i,
            'name': company_name,
            'email_suffix': company_name.lower().replace(" ","-").replace(",","") + ".es",
            'phone': fake.phone_number(),
            'address': address,
            'city': city,
            'postal_code': postal_code,
            'description': fake.text(),
            'tutor_ids': []
        }
        companies.append(company)
    return companies

def get_company_without_active_tutor(companies,tutors):
    for company in companies:
        # Check if any tutor in the company has end_date = None
        if not any(tutors[tutor]['end_date'] is None for tutor in company['tutor_ids']):
            return company
    return None

def generate_tutor(fake, active, company):
    tutor = generate_user(fake)
    start_date = fake.date_between(start_date='-2y', end_date='today')
    
    # Campos específicos para tutores
    tutor['email'] = tutor['username'] + "@" + company['email_suffix']
    tutor['start_date'] = start_date.strftime('%Y-%m-%d')

    # Añadir fecha de fin de contrato o nulo si no ha finalizado
    tutor['end_date'] = fake.date_between(start_date=start_date, end_date='today').strftime('%Y-%m-%d') if not active else None 

    return tutor

def generate_tutors(fake, n, companies):
    tutors = []

    # Generar tutores activos
    for i in range(len(companies)):
        tutor = generate_tutor(fake, True, companies[i])
        tutor['id'] = i
        tutor['company_id'] = companies[i]['id']
        tutors.append(tutor)
        companies[i]['tutor_ids'].append(i)

    for i in range(len(companies),n):
        company = choice(companies)
        tutor = generate_tutor(fake, False, company)
        tutor['id'] = i
        tutor['company_id'] = company['id']
        tutors.append(tutor)
        company['tutor_ids'].append(i)
        

    return tutors

def generate_supervisor(fake, active):
    supervisor = generate_user(fake)
    start_date = fake.date_between(start_date='-2y', end_date='today')
    # Campos específicos para tutores
    supervisor['email'] = supervisor['username'] + '@uah.es'
    supervisor['start_date'] = start_date.strftime('%Y-%m-%d')
    # Añadir fecha de fin de contrato o nulo si no ha finalizado
    supervisor['end_date'] = fake.date_between(start_date=start_date, end_date='today').strftime('%Y-%m-%d') if not active else None 
    return supervisor

def generate_supervisors(fake, n):
    supervisors = []

    # Generar un tutor activo
    supervisor = generate_supervisor(fake, True)
    supervisor['id'] = 0
    supervisors.append(supervisor)    

    # Generar tutores inactivos
    for i in range(1,n):
        supervisor = generate_supervisor(fake, False)
        supervisor['id'] = i
        supervisors.append(supervisor)

    return supervisors

def generate_offer(fake, n):
    pass


if __name__ == '__main__':
    fake = Faker("es_ES")
    students = generate_students(fake, 5)
    companies = generate_companies(fake, 2)
    tutors = generate_tutors(fake, 5, companies)
    supervisors = generate_supervisors(fake, 3)

    print(f"Alumnos: \n{students}")
    print(f"Empresas: \n{companies}")
    print(f"Tutores: \n{tutors}")
    print(f"Supervisores: \n{supervisors}")