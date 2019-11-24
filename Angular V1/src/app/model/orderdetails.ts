export class OrderDetailModel{
    constructor( 
        public id:number=null,
        public itemId:number=null,
        public quantity:number=null,
        public itemPrice:number=null,
        public itemType:String="",
        public itemName:String="",
        public itemTotal:number=null
    )
    {}
    
}