import { Component, OnInit } from '@angular/core';
import {LoginserviceService} from "../services/loginservice.service";
import {UserServiceService} from "../services/user-service.service";
import { Chart, registerables } from 'chart.js';
import {ChartInService} from "../services/chart-in.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  uid: any;
  expertise:any;
  barStats:any={};
  charts:any={};
  constructor(private loginService:LoginserviceService,private chart:ChartInService) {
    Chart.register(...registerables);

  }

  ngOnInit(): void {
    this.chart.expertises().subscribe(
      res=>{
        this.expertise=res;
        for (let index2 of this.expertise) {
          if(this.barStats[index2.expertise]!=undefined){
            this.barStats[index2.expertise]+=1;
          }
          else{
            this.barStats[index2.expertise]=1;
          }
        }
        console.log(this.barStats);
        const labels = Object.keys(this.barStats)
        const data = {
          labels: labels,
          datasets: [{
            label: 'Expertise Present in Our Group',
            data: Object.values(this.barStats),
            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(255, 159, 64, 0.2)',
              'rgba(255, 205, 86, 0.2)',
              'rgba(75, 192, 192, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              'rgba(153, 102, 255, 0.2)',
              'rgba(201, 203, 207, 0.2)'
            ],
            borderColor: [
              'rgb(255, 99, 132)',
              'rgb(255, 159, 64)',
              'rgb(255, 205, 86)',
              'rgb(75, 192, 192)',
              'rgb(218,18,18)',
              'rgb(153, 102, 255)',
              'rgb(201, 203, 207)'
            ],
            borderWidth: 1
          }]
        };
        this.charts=new Chart(
          "MyChart",
          {
            type: 'bar',
            data:data
          }
        )
      }

    )
  }

  logoutUser(){
    this.loginService.logOut();
    location.reload();
  }

}
