import { Component, OnInit, ViewChildren } from '@angular/core';
import { Router} from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-paymentlist',
  templateUrl: './paymentlist.component.html',
  styleUrls: ['./paymentlist.component.css']
})
export class PaymentlistComponent implements OnInit {

  @ViewChildren("Checkboxes") checkboxes:any
  deleteRecordList:any=[];
  isMasterSel:boolean = false;
  
  
    form:any ={
  
      pageNo:0,
      list:[],
      searchParams:{},
      deleteParams:{},
      message:[],
      
      
  
    }
  
  
    constructor(private router:Router, private httpService:HttpClient) { }
  
    ngOnInit(): void {
  
      this.search();
    }
  
    search(){
      var self = this;
      console.log("customername>>>>>>",this.form.searchParams)
      this.httpService.post('http://localhost:8084/Payment/search/' + this.form.pageNo, this.form.searchParams).subscribe((res:any) => {
        self.form.list = res.result.data;
    //  console.log(res.result.data.customerName);
      })
    }
  
  onCheckboxChange(paymentId:number){
  
    console.log('Checkbox with ID',paymentId,'is checked/unchecked');
    this.form.deleteParams.id = paymentId;
  
  }
  
  delete(){
    var self = this;
   this.httpService.get('http://localhost:8084/Payment/delete/'+ this.form.deleteParams.id).subscribe((res:any) =>{
  
     self.form.pageNo = 0;
    self.search();
  
    });
  }
  
  edit(page:any){
    this.router.navigateByUrl(page);
  }
  
  
  next() {
    this.form.pageNo++;
    this.search();
  }

  previous() {
    this.form.pageNo--;
    this.search();
  }
  
  }
  