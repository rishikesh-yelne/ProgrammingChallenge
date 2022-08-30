import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { AgGridAngular } from 'ag-grid-angular';
import { ColDef, GridReadyEvent, stringToArray } from 'ag-grid-community';
import { AppService } from '../app.component.service';
import { IMovementRecord } from './movement.interface';

@Component({
  selector: 'movement-subapp',
  templateUrl: './movement.component.html',
  styleUrls: ['./movement.component.scss']
})
export class MovementComponent implements OnInit {
  @Input() movementData: any;
  modalDisplayStyle = "none";
  isValid: boolean = true;
  movementRecord: IMovementRecord = {
    companyName: '',
    species: '',
    reason: '',
    movedCount: 0,
    startDate: new Date(),
    originPremiseId: '',
    destinationPremiseId: ''
  }
  errorMessage: string = 'Please provide all details'

  // Each Column Definition results in one Column.
  public columnDefs: ColDef[] = [
    { field: 'companyName', width: 140, headerTooltip: 'Company Name', tooltipField: 'companyName' },
    { field: 'reason', width: 160, headerTooltip: 'Reason', tooltipField: 'reason' },
    { field: 'species', width: 90, headerTooltip: 'Species', tooltipField: 'species' },
    { field: 'movedCount', width: 90, headerTooltip: 'Moved Count', tooltipField: 'movedCount' },
    { field: 'startDate', width: 110, headerTooltip: 'Start Date', tooltipField: 'startDate' },
    { field: 'originPremiseId', width: 120, headerTooltip: 'Origin Premise Id', tooltipField: 'originPremiseId' },
    { field: 'destinationPremiseId', width: 120, headerTooltip: 'Destination Premise Id', tooltipField: 'destinationPremiseId' }
  ];

  // DefaultColDef sets props common to all Columns
  public defaultColDef: ColDef = {
    minWidth: 70,
    sortable: false,
    filter: false,
    resizable: true,
    wrapHeaderText: true,
    autoHeaderHeight: true,
  };

  // Data that gets displayed in the grid
  public rowData: any;

  // Tooltip delay
  public tooltipShowDelay = 500;

  // For accessing the Grid's API
  @ViewChild(AgGridAngular) agGrid!: AgGridAngular;

  gridParams: any;
  gridData: any[] = [];

  constructor(
    private _appService: AppService
  ) { }

  ngOnInit(): void {
    
  }

  // Example load data from sever
  onGridReady(params: GridReadyEvent) {
    this.gridParams = params;
    this.gridData = this.massageData();
    params.api.setRowData(this.gridData);
    params.api.sizeColumnsToFit();
  }

  massageData(): any[] {
    let data: any[] = [];
    this.movementData.forEach((ele: IMovementRecord) => {
      data.push(this.massageSingleRecord(ele));
    });
    return data;
  }

  massageSingleRecord(ele: IMovementRecord) {
    let record = {
      companyName: ele.companyName,
      reason: ele.reason,
      species: ele.species,
      movedCount: ele.movedCount,
      startDate: ele.startDate,
      originPremiseId: ele.originPremiseId,
      destinationPremiseId: ele.destinationPremiseId
    }
    return record;
  }

  openPopup() {
    this.modalDisplayStyle = "block";
  }

  closePopup() {
    this.modalDisplayStyle = "none";
  }

  addMovementRecord() {
    if (this.validateForm()) {
      this._appService.addMovementRecord(this.movementRecord).subscribe((response) => {
        if (response != null && response != -1) {
          this.isValid = true;
          this.gridData.splice(0, 0, this.massageSingleRecord(this.movementRecord));
          this.gridParams.api.setRowData(this.gridData);
          this.closePopup();    
        } else {
          this.errorMessage = 'Something went wrong';
          this.isValid = false;    
        }
      }, (err) => {
        this.errorMessage = 'Something went wrong';
        this.isValid = false;  
        console.log(err);
      })
    } else {
      this.errorMessage = 'Please provide all details';
      this.isValid = false;
    }
  }

  validateForm(): boolean {
    if (this.movementRecord.companyName == ''
      || this.movementRecord.reason == ''
      || this.movementRecord.species == ''
      || this.movementRecord.movedCount == 0 || this.movementRecord.movedCount == NaN
      || this.movementRecord.startDate == undefined
      || this.movementRecord.originPremiseId == ''
      || this.movementRecord.destinationPremiseId == ''
      )
      return false;
    return true;
  }
}
