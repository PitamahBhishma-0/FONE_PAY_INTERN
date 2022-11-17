import {Component, OnInit} from '@angular/core';
import {LoginserviceService} from "../services/loginservice.service";
import {ChartInService} from "../services/chart-in.service";
import {Chart, registerables} from 'chart.js';
import {DownloadExcelService} from "../services/download-excel.service";


@Component({
  selector: 'home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})

export class HomePageComponent implements OnInit {
  logged:any;
  expertise:any;
  barStats:any={};
  charts:any={};

  constructor(
    public LoginService:LoginserviceService,
    private chart:ChartInService,
    private downloadExcelService:DownloadExcelService
  ) {
    Chart.register(...registerables);
  }

  ngOnInit(): void {
  this.logged=this.LoginService.isLoggedIn();

       this.logged=this.LoginService.isLoggedIn();
        console.log(this.logged);
    }


}





