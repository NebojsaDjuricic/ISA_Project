import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Administrator} from '../../../../model/administrator';
import {AdminServiceService} from '../../../../services/admin-service.service';
import {AuthServiceService} from '../../../../services/auth-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {

  admin: Observable<Administrator>;
  admins: Administrator[] = [];

  constructor(private adminService: AdminServiceService,
              private auth: AuthServiceService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.adminService.getAdmins()
      .subscribe(
        res => {
          this.admins = res;
          // console.log(JSON.stringify(this.admins));
        }
      );
  }

}
