import { Injectable } from '@angular/core';
import { HttpClient,  HttpHeaders  } from '@angular/common/http';
import { Observable,of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from '../model/user';
import { Trip}  from '../model/Trip';
import { RideDetails}  from '../model/rideDetails';
import { Configuration } from '../common/app.constants';
import { MessageService } from '../common/message.service';

@Injectable({
  providedIn: 'root'
})
export class RiderService {
  private actionUrl: string;
  httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json','Accept' : 'application/json' ,
    "Access-Control-Allow-Origin" : "*"}
  
      )
    };
  
      private headers: Headers;
      public userData:User;
  
  
      constructor(private _http:HttpClient,private _configuration:Configuration ,private messageService: MessageService) {
  
          this.actionUrl = _configuration.ServerWithApiUrl +'/rider/';
         // this.actionUrl = 'assets/data/user.json';
         //this.actionUrl = 'http://localhost:8080/user/';
          this.headers = new Headers();
          this.userData=new User();
          this.headers.append('Content-Type', 'application/json');
          this.headers.append('Accept', 'application/json');
          
      }
   
   
     
      /*validUserId(user: user):Observable<User> {
          
          return this._http.post(this.actionUrl , user)
          .pipe(            
            );
      }*/
  
  
       
      /*return this._http.get<User>(this.actionUrl, this.httpOptions).pipe(
          tap((newUser: User) => this.log(`added user w/ id=${newUser.id}`)),
          catchError(this.handleError<User>('user'))
      );*/
      
      confirmRide(rideDetails: RideDetails): Observable<RideDetails> {
    
        return this._http.post<RideDetails>(this.actionUrl+'reserve', rideDetails, this.httpOptions).pipe(
          tap(),
          catchError(this.handleError<RideDetails>('Confirm Ride'))
        );
      }
  
      cancelTrip(rideDetails: RideDetails): Observable<RideDetails> {
       var cancelURl= this.actionUrl+'cancel/'+rideDetails.trip.id+'/user/'+rideDetails.rider.username;
        return this._http.get<RideDetails>(cancelURl,  this.httpOptions).pipe(
          tap(),
          catchError(this.handleError<RideDetails>('create Trip'))
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
  
  
   
   
      
      // private helper methods
      }
  
