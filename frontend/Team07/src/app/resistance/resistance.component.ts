import { Component, OnInit } from '@angular/core';
import { RedcorduseService } from '../Service/redcorduse.service';  // get Customer by Id
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-resistance',
  templateUrl: './resistance.component.html',
  styleUrls: ['./resistance.component.css']
})
export class ResistanceComponent implements OnInit {
  redcorddruguse: Array<any>;
  redcorddruguseselect = '';

  public API = '//localhost:8080';

  constructor(private http: HttpClient, private redcorduseService: RedcorduseService) { }

  ngOnInit() {
    this.redcorduseService.getRedcorduseAll().subscribe(data => {
      this.redcorddruguse = data;
      console.log(data)
    })
  }

}
