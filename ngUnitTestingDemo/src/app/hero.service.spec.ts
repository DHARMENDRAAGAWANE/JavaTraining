import { TestBed } from "@angular/core/testing"
import { HeroService } from "./hero.service";
import { HttpClientTestingModule} from "@angular/common/http/testing"
import {HttpTestingController} from "@angular/common/http/testing"
import { MessageService } from "./message.service";
import {inject} from "@angular/core/testing"


describe("HeroService", () =>{

    let mockMessageService;
    let httpTestingController : HttpTestingController;
    
    let service: HeroService;
    beforeEach(()=>{
        mockMessageService = jasmine.createSpyObj(['add']);
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [HeroService,
            {provide: MessageService, useValue: mockMessageService}
             ]
            
            });
            httpTestingController = TestBed.get(HttpTestingController);
            service = TestBed.get(HeroService); //(creating instance)
           

    })

    describe('getHero',()=>{


it('should call get with the correct URL',() =>
//inject([HeroService,HttpTestingController],(service: HeroService,controller: HttpTestingController )=> 
{

service.getHero(4).subscribe(()=> {
console.log("fulfilled");
});

const req=httpTestingController.expectOne('api/heroes/4')
req.flush({id: 4, name: 'SuperDude' , strenth: 100});
httpTestingController.verify();
        


        });
    })




})