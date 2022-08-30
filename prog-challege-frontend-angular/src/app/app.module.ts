import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AgGridModule } from 'ag-grid-angular';

import { AppComponent } from './app.component';
import { AppService } from './app.component.service';
import { MovementComponent } from './movement/movement.component';
import { PopulationComponent } from './population/population.component';

@NgModule({
  declarations: [
    AppComponent,
    PopulationComponent,
    MovementComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AgGridModule,
    FormsModule
  ],
  providers: [
    AppService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
