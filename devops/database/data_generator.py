# Generador de datos para la carga inicial de la base de datos
from faker import Faker
from random import *
from datetime import datetime

class Data_Generator:
    def __init__(self):
        self._user_id_counter = 1

    # Generador de alumnos
    def generate_user(self, fake):
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

    def generate_students(self, fake, n):
        students = []
        degrees=['Ingeniería informática','Ingeniería de telecomunicaciones','Ingeniería de sistemas','Ingeniería de computadores','Ingeniería de software','Ingeniería de computadores y sistemas','Ingeniería de computadores y software','Ingeniería de telecomunicaciones y sistemas','Ingeniería de telecomunicaciones y software','Ingeniería de sistemas y software']

        for i in range(n):
            student = self.generate_user(fake)
            # Campos específicos para alumnos
            student['id'] = self._user_id_counter
            self._user_id_counter += 1
            student['email'] = student['username'] + '@edu.uah.es'
            student['birth_date'] = fake.date_of_birth(None, 18, 25).strftime('%Y-%m-%d')
            student['phone'] = fake.phone_number()
            student['university_degree'] = choice(degrees)
            student['expedient_grade'] = randrange(0, 10)
            student['total_hours'] = choice([300, 350])
            students.append(student)
        return students

    def generate_companies(self, fake, n):
        companies = []
        for i in range(n):
            address,city_postal_code = fake.address().splitlines()
            city,postal_code = city_postal_code.split(' ',1)
            company_name = fake.unique.company()
            company = {
                'id': i+1,
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

    def get_company_without_active_tutor(self, companies,tutors):
        for company in companies:
            # Comprobar si la compañía tiene un tutor activo
            if not any(tutors[tutor]['end_date'] is None for tutor in company['tutor_ids']):
                return company
        return None

    def generate_tutor(self, fake, active, company):
        tutor = self.generate_user(fake)
        start_date = fake.date_between(start_date='-2y', end_date='today')
        
        # Campos específicos para tutores
        tutor['email'] = tutor['username'] + "@" + company['email_suffix']
        tutor['start_date'] = start_date.strftime('%Y-%m-%d')

        # Añadir fecha de fin de contrato o nulo si no ha finalizado
        tutor['end_date'] = fake.date_between(start_date=start_date, end_date='today').strftime('%Y-%m-%d') if not active else None 

        return tutor

    def generate_tutors(self, fake, n, companies):
        tutors = []

        # Generar tutores activos
        for i in range(len(companies)):
            tutor = self.generate_tutor(fake, True, companies[i])
            tutor['id'] = self._user_id_counter
            self._user_id_counter += 1
            tutor['company_id'] = companies[i]['id']
            tutors.append(tutor)
            companies[i]['tutor_ids'].append(tutor['id'])

        for i in range(len(companies),n):
            company = choice(companies)
            tutor = self.generate_tutor(fake, False, company)
            tutor['id'] = self._user_id_counter
            self._user_id_counter += 1
            tutor['company_id'] = company['id']
            tutors.append(tutor)
            company['tutor_ids'].append(tutor['id'])
            
        return tutors

    def generate_supervisor(self, fake, active):
        supervisor = self.generate_user(fake)
        start_date = fake.date_between(start_date='-2y', end_date='today')

        # Campos específicos para tutores
        supervisor['email'] = supervisor['username'] + '@uah.es'
        supervisor['start_date'] = start_date.strftime('%Y-%m-%d')

        # Añadir fecha de fin de contrato o nulo si no ha finalizado
        supervisor['end_date'] = fake.date_between(start_date=start_date, end_date='today').strftime('%Y-%m-%d') if not active else None 
        return supervisor

    def generate_supervisors(self, fake, n):
        supervisors = []

        # Generar un tutor activo
        supervisor = self.generate_supervisor(fake, True)
        supervisor['id'] = self._user_id_counter
        self._user_id_counter += 1
        supervisors.append(supervisor)    

        # Generar tutores inactivos
        for i in range(n-1):
            supervisor = self.generate_supervisor(fake, False)
            supervisor['id'] = self._user_id_counter
            self._user_id_counter += 1
            supervisors.append(supervisor)

        return supervisors

    def generate_offers(self, fake, n, companies):
        offers = []
        categories = ["Software Developer", "Data Scientist", "Data Engineer", "Machine Learning Engineer", "Data Analyst", "Data Architect", "Business Intelligence Analyst", "Data Visualization Engineer", "Data Quality Analyst", "Data Security Analyst", "Data Warehouse Engineer", "Database Administrator", "Database Architect", "Database Developer", "Database Manager", "Database Security Administrator", "Database Systems Administrator", "Database Systems Developer", "Database Systems Engineer"]
        
        for i in range(n):
            company = choice(companies)
            offer = {
                'id': i+1,
                'title': fake.job(),
                'category': choice(categories),
                'company_id': company['id'],
                'address': company['address'],
                'requirements': fake.text(),
                'description': fake.text(),
                'schedule': "{}-{} 5 days a week".format(randrange(8, 10), randrange(18, 20)),
                'weeks': randrange(4, 12),
                'salary': randrange(300, 1200),
                'vacants': randrange(1, 10)
            }
            offers.append(offer)
        return offers

    def generate_applications(self, fake, n, students, offers):
        # Cada estudiante puede aplicar a un máximo de 10 ofertas, con una preferencia
        applications = []
        for student in students:
            student['offer_ids'] = []
            available_offers = offers.copy()
            i = 0
            while i < randint(1,10) and len(available_offers) > 0:
                offer = choice(available_offers)
                student['offer_ids'].append(offer['id'])
                available_offers.remove(offer)
                application = {
                    'student_id': student['id'],
                    'offer_id': offer['id'],
                    'preference': i+1
                }
                applications.append(application)
                i += 1
        return applications

    def search_by_id(self, id, students):
        for i in range(len(students)):
            if students[i]['id'] == id:
                return i
        return None

    def generate_contracts(self, fake, n, applications, students):
        contracts = []
        users_applied_to_offer = {}
        
        # Collect all the users that applied to each offer 
        for application in applications:
            if application['offer_id'] not in users_applied_to_offer:
                users_applied_to_offer[application['offer_id']] = []
            users_applied_to_offer[application['offer_id']].append(application['student_id'])
        
        # Generate contracts for each offer
        for offer_id in users_applied_to_offer:
            # Sort the users by expedient_grade
            users_applied_to_offer[offer_id].sort(key=lambda x: students[self.search_by_id(x, students)]['expedient_grade']
                , reverse=True)

            # Generate contracts until offers are full or there are no more applicants
            while(len(users_applied_to_offer[offer_id]) > 0 and len(contracts) < n):
                student_id = users_applied_to_offer[offer_id].pop(0)
                start_date = fake.date_between(start_date='-2y', end_date='today')
                contract = {
                    'student_id': student_id,
                    'offer_id': offer_id,
                    'grade': randrange(0, 100,1)/10,
                    'report': fake.text(),
                    'start_date': start_date.strftime('%Y-%m-%d'),
                    # TODO: Arreglar fecha de fin de contrato
                    'end_date': fake.date_between(start_date=start_date, end_date='+0y3m').strftime('%Y-%m-%d') if random() > .5 else None
                }
                contracts.append(contract)
        return contracts

if __name__ == '__main__':
    fake = Faker("es_ES")
    generator = Data_Generator()
    students = generator.generate_students(fake, 5)
    companies = generator.generate_companies(fake, 2)
    tutors = generator.generate_tutors(fake, 5, companies)
    supervisors = generator.generate_supervisors(fake, 3)
    offers = generator.generate_offers(fake, 5, companies)
    applications = generator.generate_applications(fake, 5, students, offers)
    contracts = generator.generate_contracts(fake, 5, applications, students)

    print(f"Alumnos: \n{students}")
    print(f"Empresas: \n{companies}")
    print(f"Tutores: \n{tutors}")
    print(f"Supervisores: \n{supervisors}")
    print(f"Ofertas: \n{offers}")
    print(f"Solicitudes: \n{applications}")
    print(f"Prácticas: \n{contracts}")