import { Employee } from "./employee.model";
import { CafeMenu } from "./cafemenu.model";
import { CafeDetails } from "./cafedetails.model";

export class Feedback {
    constructor (
        public ratingId:number=null,
        public review:String="",
        public rating:String="",
        public item:CafeMenu = null,
        public users:Employee = null,
        public date: Date = null,
        public cafe: CafeDetails = null
       
    ) {}
    public getRatingId() {
        return this.ratingId;
    }
}