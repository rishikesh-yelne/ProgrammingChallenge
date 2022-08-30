import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { AgGridAngular } from 'ag-grid-angular';
import { ColDef, GridReadyEvent } from 'ag-grid-community';

@Component({
  selector: 'population-subapp',
  templateUrl: './population.component.html',
  styleUrls: ['./population.component.scss']
})
export class PopulationComponent implements OnInit {
  @Input() populationData: any;
  // Each Column Definition results in one Column.
  public columnDefs: ColDef[] = [
    { field: 'premiseId', headerTooltip: 'Premise Id', tooltipField: 'premiseId' },
    { field: 'totalAnimalCount', headerTooltip: 'Total Animal Count', tooltipField: 'totalAnimalCount' },
    { field: 'name', headerTooltip: 'Name', tooltipField: 'name' },
    { field: 'address', headerTooltip: 'Address', tooltipField: 'address' },
    { field: 'city', headerTooltip: 'City', tooltipField: 'city' },
    { field: 'state', headerTooltip: 'State', tooltipField: 'state' },
    { field: 'postalCode', headerTooltip: 'Postal Code', tooltipField: 'postalCode' },
    { field: 'latitude', headerTooltip: 'Latitude', tooltipField: 'latitude' },
    { field: 'longitude', headerTooltip: 'Longitude', tooltipField: 'longitude' }
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

  constructor() { }

  ngOnInit(): void {
  }

  // Example load data from sever
  onGridReady(params: GridReadyEvent) {
    params.api.setRowData(this.populationData);
    params.api.sizeColumnsToFit();
  }
}
