import { Component, OnInit } from '@angular/core';
import { RedcorduseService } from '../Service/redcorduse.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from "@angular/router";

@Component({
  selector: 'app-resistance',
  templateUrl: './resistance.component.html',
  styleUrls: ['./resistance.component.css']
})
export class ResistanceComponent implements OnInit {
  displayedColumns: string[] = ['position', 'customername', 'symptom', 'result'];

  redcorddruguse: Array<any>;
  redcorddruguseselect = '';

  resist: Array<any>;
  resistselect = '';

  public API = '//localhost:8080';

  constructor(private http: HttpClient, private redcorduseService: RedcorduseService) { }

  ngOnInit() {
    this.redcorduseService.getRedcorduseAll().subscribe(data => {
      this.redcorddruguse = data;
      console.log(data)
    })
  }

}
