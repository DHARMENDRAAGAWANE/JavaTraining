import { Injectable } from '@angular/core';
import { HttpClient,  HttpHeaders  } from '@angular/common/http';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Vehicle } from '../model/vehicle';
import { User } from '../model/user'
import { Configuration } from '../common/app.constants';
import { MessageService } from '../common/message.service';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {
  private actionUrl: string;
  httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
  
      private headers: Headers;
      public userData:Vehicle;
  
  
      constructor(private _http:HttpClient,private _configuration:Configuration ,private messageService: MessageService) {
  
      this.actionUrl = _configuration.ServerWithApiUrl + '/vehicle';
     //     this.actionUrl = 'assets/data/vehical.json';
          this.headers = new Headers();
          this.userData=new Vehicle();
          this.headers.append('Content-Type', 'application/json');
          this.headers.append('Accept', 'application/json');
          
      }
   
   
     
      /*validUserId(user: user):Observable<User> {
          
          return this._http.post(this.actionUrl , user)
          .pipe(            
            );
      }*/
  
  
  
  searchVehicals(user: User): Observable<Vehicle[]> {
    if (!user) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this._http.post<Vehicle[]>(this.actionUrl+'/search', user, this.httpOptions).pipe(
      tap(),
      catchError(this.handleError<Vehicle[]>('searchVehicles'))
    );
  }
  
  
  saveVehicals(vehicle: Vehicle): Observable<Vehicle> {
    
    return this._http.post<Vehicle>(this.actionUrl, vehicle, this.httpOptions).pipe(
      tap(),
      catchError(this.handleError<Vehicle>('saveVehicals'))
    );
  }
  
  
    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    private handleError<T> (operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
  
        // TODO: send the error to remote logging infrastructure
        console.error(error); // log to console instead
  
        // TODO: better job of transforming error for user consumption
        this.log(`${operation} failed: ${error.message}`);
  
        // Let the app keep running by returning an empty result.
        return of(result as T);
      };
    }
  
  
       
   /** Log a HeroService message with the MessageService */
    private log(message: string) {
      this.messageService.add(`UserService: ${message}`);
    }
  
  
   
}
