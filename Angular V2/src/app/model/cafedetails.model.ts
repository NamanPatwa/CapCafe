import { CafeMenu } from "./cafemenu.model";

export class CafeDetails {
    constructor (
        public cafeId:number=null,
        public cafeName:String="",
        public cafeLocation:String="",
        public cafeOwner:String="",
        public cafeRating:number=null,
        public cafeImagePath:String="",
        public menus:CafeMenu[]=[]
    ) {}

    public getCafeID() {
        return this.cafeId;
    }
}