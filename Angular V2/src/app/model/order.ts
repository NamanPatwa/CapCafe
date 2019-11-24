import { OrderDetailModel } from "./orderdetails";


export class OrderModel{
    constructor( 
        public orderId:number=null,
        public employeeId:string=null,
        public employeeName:String="",
        public employeeAddress:String="",
        public employeeMail:String="",
        public employeePhone:String="",
        public totalAmount:number=null,
        public location:String="",
        public paymentType:String="",
        public orderDetails:OrderDetailModel[]=[]
    )
    {}
    
}