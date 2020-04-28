import { Injectable } from '@angular/core';
 
@Injectable()
export class Configuration {
    public Server: string = "http://rideshareapi-ithackathon15-1-sbx.sbx2apps.paasdev.delta.com";
  //public Server: string = "http://localhost:8080";
  public ApiUrl: string = "";
  public ServerWithApiUrl = this.Server + this.ApiUrl;
}