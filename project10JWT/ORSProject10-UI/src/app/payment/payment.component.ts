import { Component, OnInit } from '@angular/core';
import { ActivatedRoute , Route, Router, RouterModule} from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  
  form:any ={
    id:null,
    customerName:'',
    paymentMode:'',
    paymentStatus:'',
    loginId:'',
    password:''
  }
  inputerror: any={};

  constructor(private route:ActivatedRoute,private router:Router,private httpService:HttpClient) { 
   

  }

  ngOnInit(): void {

    this.getId();
    if(this.form.id && this.form.id>0){
      this.display();
    }

    
  }

  getId(): void {

    this.route.snapshot.params['id'];

    this.route.params.subscribe(params => {
      this.form.id = params['id'];
    });

  } 

display(){
  var self = this;
  this.httpService.get('http://localhost:8084/Payment/get/' + this.form.id).subscribe((res:any)=>{
    self.form = res.result.data;
  //  console.log(res.result.data);
  });
}



  update(){
    var self = this
    this.httpService.post('http://localhost:8084/Payment/update',this.form).subscribe((res:any)=>{
  
    });
  }

  save(){
    var self = this
    this.httpService.post('http://localhost:8084/Payment/signup',this.form).subscribe((res:any)=>{
    //  this.form.id = res.result.data;
    if (res.result.message) {
      self.form.message = res.result.message;
     
    }if (res.success) {
        self.form.data = res.result.data;
    }
     if (res.result.inputerror) {
      self.inputerror = res.result.inputerror;

    }
    if (res.result.data) {
      this.form.id = res.result.data;
  }

  })   

}

}
