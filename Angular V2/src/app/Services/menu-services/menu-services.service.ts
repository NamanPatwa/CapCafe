import { Injectable } from '@angular/core';
import { throwError, Observable } from 'rxjs';
import { CafeMenu } from '../../model/cafemenu.model';
import { HttpClient } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MenuServicesService {

  menus: CafeMenu[] = [];




  constructor(public http: HttpClient) { }

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
}
