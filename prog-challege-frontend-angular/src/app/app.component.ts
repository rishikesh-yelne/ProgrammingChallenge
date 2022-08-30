import { Component } from '@angular/core';
import { AppService } from './app.component.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'prog-challege-frontend-angular';
  isPopulationClicked: boolean = false;
  isMovementsClicked:boolean = false;
  populationMasterData: any;
  movementMasterData: any;

  constructor(private _appService: AppService) {}

  onPopulationTabClick() {
    this._appService.getAllPopulationRecords().subscribe((data) => {
      this.populationMasterData = data;
      this.isPopulationClicked = true;
      this.isMovementsClicked = false;
    })
  }

  onMovementsTabClick() {
    this._appService.getAllMovementRecords().subscribe((data) => {
      this.movementMasterData = data;
      this.isPopulationClicked = false;
      this.isMovementsClicked = true;
    })
  }
}
