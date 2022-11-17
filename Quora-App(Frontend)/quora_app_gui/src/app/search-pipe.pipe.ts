import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchPipe'
})
export class SearchPipePipe implements PipeTransform {

  transform(value: any, searchTerm: any): any {
    return value.filter(function(search:any){
      return search.email.indexOf(searchTerm)>-1
    });
  }

}
