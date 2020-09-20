import { Component, OnInit } from '@angular/core';
import { SMSService } from './services/sms-service';
import { SMSEntity } from './model/SMSEntity';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'SMS-Challange-App';
  allSMSData: SMSEntity[] = [];
  allSMSDataCopy: SMSEntity[];
  sortOrder:boolean=true;
  currentSortedSelection:string;
  model: any ={};
  constructor(private smsService: SMSService) {
  }

  ngOnInit() {
    this.smsService.getAllData().subscribe((resp) => {
      this.allSMSData = resp;
      this.allSMSDataCopy = resp;
    });
    this.allSMSDataCopy = this.allSMSData;
  }

  onSubmit() {
    let dates:SMSEntity=JSON.parse(JSON.stringify(this.model));
    let startDate=new Date(dates.start_date);
    let endDate=new Date(dates.end_date);
    this.allSMSDataCopy=this.allSMSData.filter(resp=>{
    let current_Start_datetime= new Date(resp.start_date);
    let current_End_datetime= new Date(resp.end_date);

    //converted into same input format
    let formatted_start_date =  current_Start_datetime.getFullYear()+"-" + (current_Start_datetime.getMonth() + 1) + "-" +current_Start_datetime.getDate() ;
    let formatted_end_date =  current_End_datetime.getFullYear()+ "-" + (current_End_datetime.getMonth() + 1) + "-" +current_End_datetime.getDate();
     return  new Date(formatted_start_date) >= startDate && new Date(formatted_end_date) <= endDate;
    })
  }

  sortByType(type: any) {
    console.log(type);
      SMSEntity.sortOrder = !SMSEntity.sortOrder;
      this.sortOrder =  SMSEntity.sortOrder;
      this.currentSortedSelection = SMSEntity.currentSortSelection;
      SMSEntity.currentSortSelection = type;
      this.allSMSDataCopy = this.allSMSData.sort(this.sortByTypeAndOrder);

  }
  sortByTypeAndOrder(d1: SMSEntity, d2: SMSEntity) {
    let switchAscOrDscOrder;
    if ( SMSEntity.currentSortSelection === 'id' ) {
      switchAscOrDscOrder = SMSEntity.sortOrder ? d1.id > d2.id : d1.id < d2.id;
      if ( switchAscOrDscOrder )
        return 1;
      else if (d1.id === d2.id)
        return 0
      else return -1
    }
    if ( SMSEntity.currentSortSelection === 'start_date' ) {
      switchAscOrDscOrder = SMSEntity.sortOrder ?  new Date(d1.start_date) >  new Date(d2.start_date) : new Date(d1.start_date) < new Date(d2.start_date);
      if ( switchAscOrDscOrder )
        return 1
      else if (new Date(d1.start_date) === new Date(d2.start_date))
        return 0
      else return -1
    }
    if ( SMSEntity.currentSortSelection === 'end_date' ) {
      switchAscOrDscOrder = SMSEntity.sortOrder ? new Date(d1.end_date) > new Date(d2.end_date) : new Date(d1.end_date) < new Date(d2.end_date);
      if (switchAscOrDscOrder)
        return 1
      else if ( new Date(d1.end_date) === new Date(d2.end_date) )
        return 0
      else return -1
    }

    if ( SMSEntity.currentSortSelection === 'city' ) {
      switchAscOrDscOrder = SMSEntity.sortOrder ? d1.city.toLowerCase() > d2.city.toLowerCase() : d1.city.toLowerCase() < d2.city.toLowerCase();
      if ( switchAscOrDscOrder )
        return 1
      else if (d1.city.toLowerCase() === d2.city.toLowerCase())
        return 0
      else return -1
    }
    if ( SMSEntity.currentSortSelection === 'status' ) {
      switchAscOrDscOrder = SMSEntity.sortOrder ? d1.status.toLowerCase() > d2.status.toLowerCase() : d1.status.toLowerCase() < d2.status.toLowerCase();
      if ( switchAscOrDscOrder )
        return 1
      else if (d1.status.toLowerCase() === d2.status.toLowerCase())
        return 0
      else return -1
    }
    if (SMSEntity.currentSortSelection === 'color') {
      switchAscOrDscOrder = SMSEntity.sortOrder ? d1.color.toLowerCase() > d2.color.toLowerCase() : d1.color.toLowerCase() < d2.color.toLowerCase();
      if (switchAscOrDscOrder)
        return 1
      else if (d1.color.toLowerCase() === d2.color.toLowerCase())
        return 0
      else return -1
    }
    if (SMSEntity.currentSortSelection === 'price') {
      switchAscOrDscOrder = SMSEntity.sortOrder ? +d1.price > +d2.price : +d1.price < +d2.price;
      if (switchAscOrDscOrder)
        return 1
      else if ( +d1.price === +d2.price )
        return 0
      else return -1
    }
  }

}
