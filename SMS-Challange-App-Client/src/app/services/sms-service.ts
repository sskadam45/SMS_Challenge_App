import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SMSEntity } from '../model/SMSEntity';
@Injectable({
    providedIn:'root'
})
export class SMSService{
    serverUrl:string='http://localhost:8082/sms/get';

    inMemoryApi = 'api/data'; //use this api in case server url is not working

constructor(private http:HttpClient){

}
getAllData():Observable<SMSEntity[]> {
    return this.http.get<SMSEntity[]>(this.inMemoryApi );
}

}
