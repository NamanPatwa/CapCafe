import { Injectable } from '@angular/core';
import { CafeDetails } from '../../model/cafedetails.model';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { b } from '@angular/core/src/render3';
import { CafeMenu } from '../../model/cafemenu.model';
import { OrderModel } from '../../model/order';
import { OrderDetailModel } from '../../model/orderdetails';
import { Employee } from '../../model/employee.model';
import { Feedback } from '../../model/Feedback';

@Injectable({
  providedIn: 'root'
})
export class CafedetailsService {

  cafe: CafeDetails[] = [];
  userCafe: CafeDetails;
  menus: CafeMenu[] = [];
  item: CafeMenu[] = [];
  itemfororder: CafeMenu;
  orderDetails: OrderDetailModel[] = [];
  employee: Employee;
  selectedOrder: OrderModel;
  orderedOrder: OrderModel;
  price: number;
  selectedCafe: CafeDetails;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(public http: HttpClient) { }

  saveCafe(cafedetails: CafeDetails) {
    console.log(cafedetails);
    return this.http.post<CafeDetails>("http://localhost:9990/cafefront/add", cafedetails);
  }

  searchCafeById(id: number): Observable<CafeDetails> {
    return this.http.get<CafeDetails>("http://localhost:9990/cafefront/" + id).pipe(retry(1), catchError(this.errorHandler));
  }

  searchCafeByLocation(location: String): Observable<CafeDetails[]> {
    return this.http.get<CafeDetails[]>("http://localhost:9990/cafefront/byLocation/" + location).pipe(retry(1), catchError(this.errorHandler));
  }

  searchCafeByLocationForUsers(location: String): Observable<CafeDetails[]> {
    return this.http.get<CafeDetails[]>("http://localhost:9990/cafefront/byLocation/" + location).pipe(retry(1), catchError(this.errorHandler));
  }

  sortCafeRating(cafedetails: CafeDetails[]) {
    cafedetails.sort((a, b) => a.cafeRating > b.cafeRating ? -1 : ((a.cafeRating < b.cafeRating) ? 1 : 0));
    return cafedetails;
  }

  listCafe(): Observable<CafeDetails[]> {
    return this.http.get<CafeDetails[]>("http://localhost:9990/cafefront/fetchAllCafe");
  }

  listCafeForUsers(): Observable<CafeDetails[]> {
    return this.http.get<CafeDetails[]>("http://localhost:9990/cafefront/fetchAllCafe");
  }

  deleteCafe(id: number): Observable<boolean> {
    return this.http.delete<boolean>("http://localhost:9990/cafefront/remove/" + id);
  }

  updateCafe(cafedetails: CafeDetails) {
    return this.http.put<CafeDetails>("http://localhost:9990/cafefront/update", cafedetails);
  }

  fetchUniqueLocations() {
    console.log(this.http.get<string[]>("http://localhost:9990/cafefront/uniqueLocation"));
    return this.http.get<string[]>("http://localhost:9990/cafefront/uniqueLocation");
  }

  fetchAllCafeMenu() {
    return this.http.get<CafeMenu[]>("http://localhost:9990/cafefront/fetchAllMenu");
  }

  saveCafeDetail(cafe: CafeDetails) {
    console.log(cafe);
    this.userCafe = cafe;
    console.log(this.userCafe);
  }

  saveCafeMenu(cafemenu: CafeMenu[]) {
    console.log(cafemenu);
    this.item = cafemenu;
    console.log(this.item);
  }

  saveOrderDetails(orderdetail: OrderDetailModel[]) {
    this.orderDetails = orderdetail;
    console.log(this.orderDetails);
  }

  saveMenuItem(menuItem: CafeMenu) {
    return this.http.post<CafeMenu>("http://localhost:9990/cafefront/menu/add", menuItem);
  }

  listMenu(): Observable<CafeMenu[]> {
    return this.http.get<CafeMenu[]>("http://localhost:9990/cafefront/fetchAll");
  }

  deleteMenuItem(id: number): Observable<boolean> {
    return this.http.delete<boolean>("http://localhost:9990/cafefront/menu/remove/" + id);
  }

  searchMenuItem(itemName: string): Observable<CafeMenu[]> {
    return this.http.get<CafeMenu[]>("http://localhost:9990/cafefront/name/" + itemName).pipe(retry(1), catchError(this.errorHandler));
  }

  saveCafeItem(cafemenu: CafeMenu) {
    this.itemfororder = cafemenu;
    console.log(this.itemfororder);
  }

  // saveItem(cafemenu:CafeMenu) {
  //   this.item=cafemenu;
  //   console.log(this.item);
  // }

  saveOrder(ordermodel: OrderModel) {
    return this.http.post<number>("http://localhost:9990/cafefront/order/add", ordermodel);
  }

  errorHandler(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) { //client side error
      errorMessage = `Error: ${error.error.message}`;
    }
    else { //server side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.error}`;
    }
    window.alert(errorMessage);
    return throwError(error.error)
  }

  listOrder(): Observable<OrderModel[]> {
    return this.http.get<OrderModel[]>("http://localhost:9990/cafefront/order/AllOrders");
  }

  viewOrderDetails(id: number): Observable<OrderDetailModel[]> {
    return this.http.get<OrderDetailModel[]>("http://localhost:9990/cafefront/order/item/" + id);
  }


  ///////authentication - part/////////////
  role() {
    return sessionStorage.getItem('role');
  }

  saveEmployee(emp: Employee) {
    console.log(emp);
    this.employee = emp;
    console.log(this.employee);
  }

  ///////////////// 

  signup(emp: Employee) {
    return this.http.post<Employee>("http://localhost:9990/cafefront/auth/add", emp);
  }

  login(empId: string, password: string): Observable<Employee> {
    return this.http.get<Employee>("http://localhost:9990/cafefront/auth/login/" + empId + "/" + password);
  }

  resetPassword(empId: string, prevpass: string, newpass: string) {
    return this.http.put<boolean>("http://localhost:9990/cafefront/auth/chng/" + empId + "/" + prevpass + "/" + newpass, newpass);
  }

  getQuestion(empId: string): Observable<string> {
    return this.http.get("http://localhost:9990/cafefront/auth/question/" + empId, { responseType: 'text' });
  }

  forgotPassword(empId: string, answer: string, newpass: string) {
    return this.http.put<boolean>("http://localhost:9990/cafefront/auth/forgotpass/" + empId + "/" + answer + "/" + newpass, newpass);
  }

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>("http://localhost:9990/cafefront/auth/all");
  }

  profile() {
    console.log(this.employee);
    return this.employee;
  }
  ////////////////////////////////

  listCafeReviewById(cafeId: number): Observable<String[]> {
    console.log(cafeId);
    return this.http.get<String[]>("http://localhost:9990/cafefront/getReviewByCafeId/" + cafeId);

  }

  searchCafeAverageRating(id: number) {
    return this.http.get<number>("http://localhost:9990/cafefront/getCafeAverageRating/" + id);
  }

  saveItemRating(userId: string, itemId: String, feedbackType: String, rating: number): Observable<Feedback> {
    return this.http.post<Feedback>("http://localhost:9990/cafefront/addItemRating/" + userId + "/" + itemId + "/" + feedbackType + "/" + rating, null);
  }

  saveCafeRating(userId: string, cafeId: String, feedbackType: String, rating: number): Observable<Feedback> {
    return this.http.post<Feedback>("http://localhost:9990/cafefront/addCafeRating/" + userId + "/" + cafeId + "/" + feedbackType + "/" + rating, null);
  }

  saveItemReview(userId: string, itemId: String, feedbackType: String, review: String): Observable<Feedback> {
    return this.http.post<Feedback>("http://localhost:9990/cafefront/addItemReview/" + userId + "/" + itemId + "/" + feedbackType + "/" + review, null);
  }
  saveCafeReview(userId: string, cafeId: String, feedbackType: String, review: String): Observable<Feedback> {
    return this.http.post<Feedback>("http://localhost:9990/cafefront/addCafeReview/" + userId + "/" + cafeId + "/" + feedbackType + "/" + review, null);
  }

  listItemReviewById(itemId: number): Observable<Feedback[]> {
    return this.http.get<Feedback[]>("http://localhost:9990/cafefront/getReviewByItemId/" + itemId);
  }

  searchItemAverageRating(itemId: number) {
    return this.http.get<number>("http://localhost:9990/cafefront/getItemAverageRating/" + itemId);
  }

  getOrdersByEmployeeId(employeeId: string) {
    return this.http.get<OrderModel[]>("http://localhost:9990/cafefront/order/byid/" + employeeId);
  }

}
