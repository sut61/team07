import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  data: any = {}
  Select: any = {
    stateselect: ''
  }
  states: string[] = [
    ' กรุงเทพมหานคร ', 'กระบี่  ', 'กาญจนบุรี ', 'กาฬสินธุ์ ', 'กำแพงเพชร', 'ขอนแก่น', ' จันทบุรี ', 'ฉะเชิงเทรา ',
    'ชลบุรี', 'ชัยนาท ', 'ชัยภูมิ ', 'ชุมพร', 'เชียงราย', 'เชียงใหม่', 'ตรัง', 'ตราด', ' ตาก ',
    'นครนายก ', 'นครปฐม ', 'นครพนม ', 'นครราชสีมา ', 'นครศรีธรรมราช ', 'นครสวรรค์ ', 'นนทบุรี ',
    'นราธิวาส ', 'น่าน ', 'บึงกาฬ ', 'บุรีรัมย์ ', 'ปทุมธานี ', 'ประจวบคีรีขันธ์ ', 'ปราจีนบุรี ',
    'ปัตตานี ', 'พระนครศรีอยุธยา ', ' พังงา', 'พัทลุง ', 'พิจิตร ', 'พิษณุโลก ', 'เพชรบุรี ',
    'เพชรบูรณ์ ', 'แพร่ ', 'พะเยา ', 'ภูเก็ต ', 'มหาสารคาม ', 'มุกดาหาร ', 'แม่ฮ่องสอน ',
    'ยะลา ', 'ยโสธร ', 'ร้อยเอ็ด ', 'ระนอง ', 'ระยอง ', 'ราชบุรี  ', ' ลพบุรี ',
    'ลำปาง  ', 'ลำพูน  ', 'เลย ', 'ศรีสะเกษ ', 'สกลนคร ', 'สงขลา', 'สตูล ', 'สมุทรปราการ',
    'สมุทรสงคราม ', 'สมุทรสาคร ', ' สระแก้ว ', 'สระบุรี ', 'สิงห์บุรี ', 'สุโขทัย ', 'สุพรรณบุรี', 'สุราษฎร์ธานี',
    ' สุรินทร์  ', 'หนองคาย  ', 'หนองบัวลำภู ', 'อ่างทอง  ', 'อุดรธานี ', 'อุทัยธานี', 'อุตรดิตถ์ ', 'อุบลราชธานี ', 'อำนาจเจริญ'
  ];




  selected = '';
  showdatainput() {
    console.log(this.data)
    console.log(this.states)


  }
  constructor(private router:Router) { }

  ngOnInit() {
  }

  SubmitdData(){
    console.log(this.data)
    const data  = this.data
    this.router.navigate(['/register-show',{Firstname:data.Firstname,last:data.last}])
  }



}



