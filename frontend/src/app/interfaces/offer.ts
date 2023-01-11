import { Company } from "./company";

export interface Offer{
    id: number;
    positiontable: number;
    company_id: number;
    position: string;
    empresa: string;
    vacancies: number;
    schedule: string;
    weeks: number;
    company: Company
  }
