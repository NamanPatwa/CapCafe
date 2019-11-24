import { Ticket } from "./Ticket";

export class RequestResponse{
    public messageId : number;
    public query : Ticket;
    public message : string;
    public timestamp : Date;
    public type : string
}