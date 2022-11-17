import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {error} from "@angular/compiler-cli/src/transformers/util";
import * as fs from 'file-saver';
import {Workbook} from "exceljs";
import {style} from "@angular/animations";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class DownloadExcelService {

  constructor(private http: HttpClient) {
  }



  getAllUser() {
    return this.http.get(`http://localhost:8080/downloadXls`);
  }

  generateExcel(data: any []) {
    // Excel Title , Header , Data
    const title = ' List of Movies ';
    const header = ["FullName", "Email","Roles",
      ,"Expertise","Active", "PhoneNumber","Date Of Birth",];
    // Create workbook and worksheet
    let workbook = new Workbook();
    let worksheet = workbook.addWorksheet(' Movie Data ');
    // Add Header Row
    let headerRow = worksheet.addRow(header);
    // Cell Style : Fill and Border
    headerRow.eachCell((cell, number) => {
      cell.fill = {
        type: 'pattern',
        pattern: 'solid',
        fgColor: {argb: ' FFFFFF00'},
        bgColor: {argb: ' FF0000FF '}
      }
      cell.border = {top: {style: 'thin'}, left: {style: 'thin'}, bottom: {style: 'thin'}, right: {style: 'thin'}}
    });
    worksheet.addRows(data);
    workbook.xlsx.writeBuffer().then((data) => {
      let blob = new Blob([data], {type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'});
      fs.saveAs(blob, 'Users.xlsx') ;
    })

  }

  download(file: string | undefined): Observable<Blob> {
    return this.http.get(`${environment.baseUrl}/files/${file}`, {
      responseType: 'blob'
    });
    }
}
