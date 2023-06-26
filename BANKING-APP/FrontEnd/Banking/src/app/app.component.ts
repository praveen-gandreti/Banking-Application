import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Banking';
  constructor(private toster:ToastrService)
  {

  }
  send()
  {
    this.toster.success("SUCCESSFULLY DONE")
  }
}
