import { SimpleOffer } from "./simple_offer";

export interface Offer extends SimpleOffer{
    pos: number;
    company_name: string;
}
