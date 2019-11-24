import { OrderModel } from "./order";
import { RequestResponse } from "./RequestResponse";

export class Ticket{
    public ticketNumber : number;
    public status : string;
    public date : Date;
    public location : string;
    public order : OrderModel;
    public messages : RequestResponse[]
}