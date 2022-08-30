import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AppConstants } from "./app.component.constants";

@Injectable({
    providedIn: 'root'
})
export class AppService {
    constructor(private _httpClient: HttpClient) { }

    getAllPopulationRecords(): Observable<any[]> {
        return this._httpClient.get<any[]>(AppConstants.BaseURL + AppConstants.RelativeURL_GetAllPopulationRecords);
    }

    updatePopulationRecord(premiseId: string, totalCount: number) {
        return this._httpClient.put(AppConstants.BaseURL + AppConstants.RelativeURL_UpdatePopulationRecord 
            + '?premiseId=' + premiseId + '&totalCount=' + totalCount, null);
    }

    getAllMovementRecords() {
        return this._httpClient.get(AppConstants.BaseURL + AppConstants.RelativeURL_GetAllMovementRecords);
    }

    addMovementRecord(payload: any) {
        return this._httpClient.post(AppConstants.BaseURL + AppConstants.RelativeURL_InsertMovementRecord, payload);
    }
}